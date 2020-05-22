package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
//screenshots,alerts,frames,windows ,sync issues
	
	public static void capturescreenshots(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(src,new File("./Screenshots/FreeCRM"+getCurrentDateTime()+".png"));
			System.out.println("screenshot captured");
		} catch (IOException e) {
			System.out.println("unable to capture screenshots   "+e.getMessage());
		}
	}
	public static String getCurrentDateTime() {
		DateFormat formater=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		
		return formater.format(date);
	}
}
