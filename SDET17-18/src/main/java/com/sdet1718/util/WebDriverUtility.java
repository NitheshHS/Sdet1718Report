package com.sdet1718.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public static String takeScreenShot(WebDriver driver, String testcaseName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String screenShotPath="./screenshot/"+testcaseName+".PNG";
		File dest=new File(screenShotPath);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return screenShotPath;
	}

}
