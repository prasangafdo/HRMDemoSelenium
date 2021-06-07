package com.selenium.HRMDemo;

import org.openqa.selenium.By;

public class VerifyLoginScreen extends Main{
	
	private String Username, Password;
	
	public void setUsername(String Username) {
		this.Username = Username;	
	}
	public String getUsername() {
		return Username;
	}
	public void setPassword(String Password) {
		this.Password = Password;	
	}
	public String getPassword() {
		return Password;
	}
	
	public String verifyLogin() {
		String status = "Verify the user can login to the dashboard: ";
		 driver.findElement(By.id("txtUsername")).sendKeys(Username);
		 driver.findElement(By.id("txtPassword")).sendKeys(Password);	
		 driver.findElement(By.name("Submit")).click();
		 
		 if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")){
				status = status.concat("Pass");
				}
		else {
			status = status.concat("Fail");
			System.out.println(verifyLoginErrorMessage());
			
			}
		return status;
	}
	
	public String verifyLoginErrorMessage() {
		String status = "Verify login error message: ";
		String errorMessage = driver.findElement(By.id("spanMessage")).getText();
		//System.out.println(errorMessage);
		
		if(errorMessage.equals("Invalid credentials")) {
			status = status.concat("Pass");
		}
		return status;
	}

}
