package com.selenium.HRMDemo;

import org.openqa.selenium.By;

public class VerifyUserManagementPage extends Main{
	
	private String EmployeeName, Username, Password;
	
	public void setUser(String EmployeeName, String UserName, String Password) {
		this.EmployeeName = EmployeeName;
		this.Username = UserName;
		this.Password = Password;
	}
	
	public String verifyAddUser() {
		String objective, status = null;
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(EmployeeName);
		driver.findElement(By.id("systemUser_userName")).sendKeys(Username);
		driver.findElement(By.id("systemUser_password")).sendKeys(Password);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(Password);
		
		status = "User added";
		return status;
		
	}


}
