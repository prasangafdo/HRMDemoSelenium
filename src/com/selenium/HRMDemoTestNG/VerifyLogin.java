package com.selenium.HRMDemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLogin{

	
private String Username = "Admin";
private String Password = "admin123";

	static {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Prasanga Fernando/Documents/Eclipse/TestNG_PageTitle/chromedriver/chromedriver.exe");
			}
	 WebDriver driver = new ChromeDriver();
	 
	@Test
	public void verifyLoginWithCorrectCredentials() {
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		 driver.findElement(By.id("txtUsername")).sendKeys(Username);
		 driver.findElement(By.id("txtPassword")).sendKeys(Password);	
		 driver.findElement(By.name("Submit")).click();
		 
		String expected = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actual =driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}
	
	
	public String verifyLoginErrorMessage() {//Copied from old class. Need to change to a TestNG Test
		String status = "Verify login error message: ";
		String errorMessage = driver.findElement(By.id("spanMessage")).getText();
		//System.out.println(errorMessage);
		
		if(errorMessage.equals("Invalid credentials")) {
			status = status.concat("Pass");
		}
		return status;
	}
}
