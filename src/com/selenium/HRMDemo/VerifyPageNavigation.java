package com.selenium.HRMDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
//	
	
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
	
	public void navigateToUserManagement() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}
	public void navigateToAddUser() {
		driver.findElement(By.id("btnAdd")).click();
	}
	
	public void closeBrowser() {
		try {
			Thread.sleep(5000);//Waiting 5 seconds before closing the browser
			driver.close();
			System.out.println("Browser closed successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Wait() {
		try {
			Thread.sleep(2000);
			System.out.println("Waiting 2 seconds...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMouseOverOnJob() {
		WebElement item = driver.findElement(By.xpath("//*[@id=\"mainMenuFirstLevelUnorderedList\"]/li[1]/ul/li[2]")); //Selenium mouse over
		Actions action = new Actions(driver);
		action.moveToElement(item).perform();
	}
	
	public void selectJobTitles() {
		setMouseOverOnJob();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		
	}
	
	public void selectPayGrades() {
		setMouseOverOnJob();
		driver.findElement(By.id("menu_admin_viewPayGrades")).click();
		
	}

	public void selectEmpStatus() {
		setMouseOverOnJob();
		driver.findElement(By.id("menu_admin_employmentStatus")).click();
		
	}
	
	public void selectJobCategories() {
		setMouseOverOnJob();
		driver.findElement(By.id("menu_admin_jobCategory")).click();
	}
	
	

}
