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

		//Verify login
		VerifyPageNavigation navigation = new VerifyPageNavigation(); //Creating class object
		navigation.setURL("https://www.google.lk/");
		
		System.out.println(navigation.navigateToLogin());//Add an enhancement: user should be able to change the url from here.
		
		VerifyLoginScreen login = new VerifyLoginScreen();
		login.setUsername("Admin");
		login.setPassword("admin123");
		System.out.println(login.verifyLogin());
		//End of verify login
		
		
//		navigation.navigateToUserManagement();
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
//		navigation.selectJobTitles();  //Working code oof DDT
//		DDT ddt = new DDT();
//		try {
//			ddt.getJobData_Excel();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		/*
		
		
		VerifyJob job = new VerifyJob();
		System.out.println(job.getJob());
		*/
	//	navigation.selectPayGrades();

		//Verify pay Grade
		/* Steps-
		 * Navigate to Pay grade screen
		 * Locate 
		 * 
		 */
		
		//-- Beginning pay grade
		/*
		navigation.Wait();
		navigation.navigateToUserManagement();//User should be navigated to the user management page at first
		navigation.setMouseOverOnJob();
		navigation.selectPayGrades();

		
		DDT ddt = new DDT();
		
		try {
			ddt.getPayGradeData_Excel();//There's a high dependency, need to fix that
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		//--End verify pay grade
		
		
		//Beginning Employment Status
		navigation.Wait();
		navigation.navigateToUserManagement();//User should be navigated to the user management page at first
		navigation.setMouseOverOnJob();
		navigation.selectEmpStatus();

		
		DDT ddt = new DDT();
		
		try {
			ddt.setEmpStatus_Excel();//There's a high dependency, need to fix that
			String empData[] = ddt.getEmpStatus_Excel();
			VerifyEmploymentStatus empStatus = new VerifyEmploymentStatus();
			empStatus.setEmploymentStatus(empData);
			System.out.println(empStatus.getEmploymentStatus());

			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--End Employment Status
		
	}
	



	

	
	
	

}
