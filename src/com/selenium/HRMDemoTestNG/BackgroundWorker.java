package com.selenium.HRMDemoTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Prasanga Fernando
 *
 */


public class BackgroundWorker {

	static {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Prasanga Fernando/Documents/Eclipse/TestNG_PageTitle/chromedriver/chromedriver.exe");
	}
	public static WebDriver driver = new ChromeDriver();

	

}
