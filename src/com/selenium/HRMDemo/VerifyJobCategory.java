package com.selenium.HRMDemo;

import org.openqa.selenium.By;

public class VerifyJobCategory extends Main{
	/*
	 * Navigate to job category - done
	 * Click on add button (btnAdd) - done
	 * Get Value from excel sheet - done
	 * Send value to jobCategory_name
	 * Click on save button (btnSave)
	 */
	
	private String testObjective = "Verify the user can add new Job Category: ";
	private String status = "Fail";
	
	public void setJobCategory(String[] jobCategory) {
		for(int i=0;i<jobCategory.length;i++) {
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("jobCategory_name")).sendKeys(jobCategory[i]);
			driver.findElement(By.id("btnSave")).click();
			
			String expectedResult = "Successfully Saved";
			String actualResult = driver.findElement(By.xpath("//*[@id=\"frmList_ohrmListComponent\"]/div[2]")).getText();
			
			if(actualResult.equals(expectedResult)) {
				status = "Pass";
			}
			else
				status = "Fail";
		}
	}
	
	public String getJobCategoryStatus() {
		return testObjective.concat(status);
	}

}
