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
