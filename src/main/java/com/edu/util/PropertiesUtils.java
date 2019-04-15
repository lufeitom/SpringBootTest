
package com.edu.util;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class PropertiesUtils {
	private static final Logger log = LoggerFactory.getLogger(PropertiesUtils.class);

	public static void main(String[] args) throws Exception {

	}

	public static PropertiesConfiguration load(String filename) throws Exception {
		PropertiesConfiguration pcfg = new PropertiesConfiguration();
		// 首先判断在tomcat下的config目录
		String path = System.getProperty("catalina.home");
		String configPath = path + File.separator + "config" + File.separator + filename;
		// log.debug("configPath1=" + configPath);
		File file = new File(configPath);
		if (!file.exists()) {
			// 查询classes目录下的文件
			configPath = PropertiesUtils.class.getResource("/").toURI().getPath() + File.separator + filename;
			// log.debug("configPath2=" + configPath);
		}
		configPath = java.net.URLDecoder.decode(configPath, "utf-8");
		// String ecoding = EncodingDetect.getJavaEncode(configPath);
		// pcfg.setEncoding(ecoding);
		pcfg.load(new File(configPath));
		// log.debug(pcfg.getPath());
		return pcfg;
	}
}
