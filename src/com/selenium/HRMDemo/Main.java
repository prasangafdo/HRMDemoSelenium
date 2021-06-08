/**
 * 
 */
package com.selenium.HRMDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		navigation.navigateToAddUser();
		VerifyUserManagementPage usermgt = new VerifyUserManagementPage();
		usermgt.setUserType("Admin");
		usermgt.setUserStatus("Enabled");
		
		usermgt.setUser("Odis", "testusername2", "prasanga123");
		System.out.println(usermgt.verifyAddUser());
		
		navigation.closeBrowser();//This will close the browser
		
		//WebElement dropdown = driver.findElement(By.className("main-menu-first-level-list-item"));
		//dropdown.click(); 
		//dropdown.findElement(By.cssSelector("li[value=" + value + "]")).click();
		
		//driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		
		
	}
	

	

	

	
	
	

}
