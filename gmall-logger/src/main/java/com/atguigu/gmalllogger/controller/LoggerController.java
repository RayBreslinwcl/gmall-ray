package com.atguigu.gmalllogger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.constants.GmallConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

//@Controller+@ResponseBody
@RestController
@Slf4j
public class LoggerController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    //测试方法
//    @RequestMapping(value = "test")
//    @ResponseBody
    @GetMapping("test")
    public String getTest(@RequestParam("aa") String str) {

        System.out.println("11111111111111111");
        return str;
    }

    @PostMapping("log")
    public String logger(@RequestParam("logString") String logStr) {

        //0 添加时间戳
        JSONObject jsonObject = JSON.parseObject(logStr);
        jsonObject.put("ts", System.currentTimeMillis());

        //1  打印到控制台并输出至文件
        String tsLogStr = jsonObject.toString();
        log.info(tsLogStr);

        //2 发送至Kafka，判断发送至哪个主题
        if ("startup".equals(jsonObject.getString("type"))) {
            kafkaTemplate.send(GmallConstants.GMALL_START_TOPIC, tsLogStr);
        } else {
            kafkaTemplate.send(GmallConstants.GMALL_EVENT_TOPIC, tsLogStr);
        }

        return "success";
    }


}
