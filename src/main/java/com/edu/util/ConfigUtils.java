package com.edu.util;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Iterator;
import java.util.Properties;

/**
 * config文件工具类
 *
 */
public class ConfigUtils {
	private static final Log log = LogFactory.getLog(ConfigUtils.class);

	private static ConfigUtils instance = new ConfigUtils();
	private Properties properties = null;

	private ConfigUtils() {
		if (properties == null) {
			properties = new Properties();
			initProperties();
		}

	}

	public static ConfigUtils getInstance() {
		return instance;
	}

	public String getProperty(String key) {
		String value = properties.getProperty(key);
		return value == null ? null : value.trim();
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * 是否是集群部署
	 *
	 * @return
	 *
	 * @version v1.0
	 * @author xugaobo
	 * @date 2018年3月30日 上午11:26:24
	 */
	public boolean isClustered() {
		String isClustered = ConfigUtils.getInstance().getProperty("isClustered", "false");
		if ("true".equals(isClustered)) {
			return true;
		} else {
			return false;
		}
	}

	public String getProperty(String key, String defaultValue) {
		String value = properties.getProperty(key);
		if (value == null) {
			value = defaultValue;
		}
		return value.trim();
	}

	public Boolean getPropertyBoolean(String key, Boolean defaultValue) {
		String value = properties.getProperty(key);
		if (value == null) {
			return defaultValue;
		}
		return Boolean.valueOf(value.trim());
	}

	public Integer getPropertyInteger(String key, String defaultValue) {
		String value = properties.getProperty(key);
		if (value == null) {
			value = defaultValue;
		}
		return Integer.parseInt(value);
	}

	private void initProperties() {

		try {

			// log.debug(
			// "config.properties=" +
			// this.getClass().getClassLoader().getResource("config.properties").getPath());

			PropertiesConfiguration pcfg = PropertiesUtils.load("config.properties");

			properties = new Properties();
			// 自动把config中的配置写入prop
			Iterator<String> it = pcfg.getKeys();
			while (it.hasNext()) {
				String key = it.next();
				properties.put(key, pcfg.getString(key));
			}

		} catch (Exception e) {
			log.error(e);
		} finally {

		}
	}
}
