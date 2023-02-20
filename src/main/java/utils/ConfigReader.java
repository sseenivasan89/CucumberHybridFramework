package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public Properties intializeProperties() {
		
		prop = new Properties();
		File proFile = new File("src\\test\\resources\\config\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

	public String getBrowserName() {
		String browserName = prop.getProperty("browserName");
		return browserName;
	}
	
	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	
}
