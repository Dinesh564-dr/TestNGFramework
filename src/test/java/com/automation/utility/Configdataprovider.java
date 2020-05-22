package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configdataprovider {
	Properties pro;

	public Configdataprovider() {
		File file = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			System.out.println("not able to load config file" + e.getMessage());
		}
	}

	public String getDatafromconfig(String keytosearch) {
		return pro.getProperty(keytosearch);

	}

	public String getBrowser() {
		return pro.getProperty("Browser");

	}

	public String getStagingURL() {
		return pro.getProperty("qaURL");
		

	}
}
