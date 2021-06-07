package com.selenium.HRMDemo;

import org.openqa.selenium.By;

public class VerifyPageNavigation extends Main{
	
	private String url;
	

	public void setURL(String URL) {
		this.url = URL;	
	}
	
	public String getURL() {
		return url;
	}
	
//	public String setNavigationToAdminUserManagement() { //Not developed yet
//		
//		//Verify the user can navigate to user management page.
//		//Verify the user can navigate to user management page.
//		
//		String status = "";
//		//Main.driver.findElement(By.id("menu_admin_viewAdminModule")).click();
//		System.out.println("This is page2");
//	return status;
//	}
	
	
	public String navigateToLogin() {
		String objective = "Verify the user can search and navigate to the login screen: ";
		String status = null;
		driver.get(getURL());
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Orange HRM Demo");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
		driver.findElement(By.tagName("H3")).click();
		
		String pageTitle = driver.getTitle();
		
		if(pageTitle.equals("OrangeHRM")) {
			status = objective.concat("Pass");
			return status;
		}
		else
			status = objective.concat("Fail");
			return status;
	}
	
	public void closeBrowser() {
		try {
			Thread.sleep(3000);
			driver.close();
			System.out.println("Browser closed successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
