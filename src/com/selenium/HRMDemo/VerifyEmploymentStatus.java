/**
 * 
 */
package com.selenium.HRMDemo;

import org.openqa.selenium.By;

/**
 * @author Prasanga Fernando
 *
 */
public class VerifyEmploymentStatus extends Main{
	
	String testingObjective = "Verify the user can add Employment Status: ";
	String status = "Fail";
	
	public void setEmploymentStatus(String[] employmentStatus) {

		for(int i=0;i<employmentStatus.length;i++) {
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("empStatus_name")).sendKeys(employmentStatus[i]);
			driver.findElement(By.id("btnSave")).click();
		}
		
		String expectedResult ="Successfully Saved";
		String actualResult = driver.findElement(By.xpath("//*[@id=\"frmList_ohrmListComponent\"]/div[2]")).getText();
		
		if(expectedResult.equals(actualResult)) {
			status = "Pass";
		}
	}
	
	public String getEmploymentStatus() {
		return testingObjective+status;
		
	}
	
	
}
