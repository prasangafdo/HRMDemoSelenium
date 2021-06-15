/**
 * 
 */
package com.selenium.HRMDemo;

import org.openqa.selenium.By;

/**
 * @author Prasanga Fernando
 *
 */
public class DDTVerifyPayGrades extends Main{
	
	public String addPayGrade(String[] name, String[] currency, String minSalary[], String[] maxSalary ) {
		String status = "Fail";
		
		for(int i=0;i<name.length;i++) {//Assuming all the arrays have same length

			int minSal = Integer.parseInt(minSalary[i]);//Converting value of the array string to integer
			int maxSal = Integer.parseInt(maxSalary[i]);
			
			driver.findElement(By.id("btnAdd")).click();
//			driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle[i]); //Entering data extracted from the excel sheet
//			driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc[i]);
//			driver.findElement(By.id("jobTitle_note")).sendKeys(jobNote[i]);
//			driver.findElement(By.id("btnSave")).click();
			
			System.out.println(minSal);
			System.out.println(maxSal);
	
		
		
		
	
		/*
		 * Cast string to integer on min and max salary - done
		 * Modify DDT class
		 * 
		 * Click on "btnAdd"
		 * Verify the user is navigated to https://opensource-demo.orangehrmlive.com/index.php/admin/payGrade
		 * Extract data from excel sheet
		 * save data temporary in an array
		 * sendkeys to "payGrade_name" text field
		 * Click on "btnSave" button
		 * Verify the banner
		 * 
		 */
			

		}
		return status;
	}
	
	

}
