package com.atguigu.constants;

public class GmallConstants {

    //Kafka主题：启动日志主题
    public static final String GMALL_START_TOPIC = "GMALL_START";

    //Kafka主题：事件日志主题
    public static final String GMALL_EVENT_TOPIC = "GMALL_EVENT";

    //Kafka主题：订单数据主题
    public static final String GMALL_ORDER_TOPIC = "GMALL_ORDER_INFO";

    //============================================================
    //Kafka主题：启动日志主题
    public static final String KAFKA_TOPIC_STARTUP="GMALL_STARTUP";
    //Kafka主题：事件日志主题
    public static final String KAFKA_TOPIC_EVENT="GMALL_EVENT";

    public static final String KAFKA_TOPIC_NEW_ORDER="GMALL_NEW_ORDER";
    public static final String KAFKA_TOPIC_ORDER_DETAIL="GMALL_ORDER_DETAIL";

    public static final String ES_INDEX_DAU="gmall2019_dau";
    public static final String ES_INDEX_NEW_MID="gmall2019_new_mid";
    public static final String ES_INDEX_NEW_ORDER="gmall2019_new_order";
    public static final String ES_INDEX_SALE_DETAIL="gmall2019_sale_detail";
}
