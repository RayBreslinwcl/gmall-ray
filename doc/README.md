



# 一、项目结构

## 1.gmall-common

公共模块，作用是存放公共类。

## 2.gmall-mocker

模拟数据类，作用是向服务器发送模拟http请求，切记：最终是在服务器生产日志，这个只是向服务器发送请求。

## 3.gmall-logger

模拟服务器，当接收到请求的时候，将请求写入KAFKA.





# 十、有用模块

## 10.1 读取资源文件的属性的工具类

```java
package com.atguigu.utils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取属性类
 */
public class PropertyLoadUtil {

//    private static final Logger logger = LoggerFactory.getLogger(PropertyLoadUtil.class);
    private static Properties props;
    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        String propertiesName = "application.properties";
        props = new Properties();
        InputStream in = null;
        try {
            //        <!--通过类加载器进行获取properties文件流-->
            in = PropertyLoadUtil.class.getClassLoader().getResourceAsStream(propertiesName);
            props.load(in);
        } catch (FileNotFoundException e) {
//            logger.error(propertiesName + "common.properties文件未找到");
        } catch (IOException e) {
//            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
//                logger.error(propertiesName + "文件流关闭出现异常");
            }
        }
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}

```











