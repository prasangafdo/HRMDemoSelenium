package com.selenium.HRMDemoTestNG;

import org.openqa.selenium.By;

public class VerifyPageNavigation extends BackgroundWorker{
		
	public void navigateToUserManagement() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}
	public void navigateToAddUser() {
		driver.findElement(By.id("btnAdd")).click();
	}
}
