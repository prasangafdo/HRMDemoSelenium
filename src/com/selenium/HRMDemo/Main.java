/**
 * 
 */
package com.selenium.HRMDemo;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;

/**
 * @author Prasanga Fernando
 * Note: This script is not written with TestNG, but with raw Selenium using Java.
 * For this project I'm planning to use multiple classes. So I can pass messages with classes and increase cohesion
 */
public class Main{

	static {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Prasanga Fernando/Documents/Eclipse/TestNG_PageTitle/chromedriver/chromedriver.exe");
	}
	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {

		//Main obj = new Main();
		//System.out.println(obj.verifyLogin("Admin", "admin123"));
	
		VerifyPageNavigation navigation = new VerifyPageNavigation(); //Creating class object
		navigation.setURL("https://www.google.lk/");
		
		System.out.println(navigation.navigateToLogin());//Add an enhancement: user should be able to change the url from here.
		
		VerifyLoginScreen login = new VerifyLoginScreen();
		login.setUsername("Admin");
		login.setPassword("admin123");
		System.out.println(login.verifyLogin());
		
		navigation.navigateToUserManagement();
	/*			navigation.navigateToAddUser();
		
	
		//Add new user
		VerifyUserManagementPage usermgt = new VerifyUserManagementPage();
		
		usermgt.setUserType("Admin");
		usermgt.setUserStatus("Enabled");
		usermgt.setUser("Odis", "testusername5", "prasanga123");
		System.out.println(usermgt.verifyAddUser());
		
		navigation.Wait();
		navigation.navigateToAddUser();
		usermgt.setUserType("ESS");
		usermgt.setUserStatus("Enabled");
		usermgt.setUser("Odis", "testusername6", "prasanga123"); //Hard coding details for now
		System.out.println(usermgt.verifyAddUser()); 

		*/
		navigation.selectJobTitles();
		DDT ddt = new DDT();
		try {
			ddt.getJobData_Excel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		/*
		
		
		VerifyJob job = new VerifyJob();
		job.setJob("This is title", "desc", "note");
		System.out.println(job.getJob());
		*/
	}
	

	

	

	
	
	

}
