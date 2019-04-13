package com.perye.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * sql字段转java
 *
 * @Author: Perye
 * @Date: 2019-04-13
 */
public class ColUtil {

    /**
     * 转换mysql数据类型为java数据类型
     *
     * @param type
     * @return
     */
    public static String cloToJava(String type) {
        Configuration config = getConfig();
        return config.getString(type, "unknowType");
    }

    /**
     * 获取配置信息
     */
    public static PropertiesConfiguration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
