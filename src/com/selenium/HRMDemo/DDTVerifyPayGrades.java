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
			
			/* Send keys "payGrade_name"
			 * Click on "btnSave"
			 * Click on btnAddCurrency to add currency information
			 * Send keys to payGradeCurrency_currencyName
			 * Send keys to payGradeCurrency_minSalary
			 * Send keys to payGradeCurrency_maxSalary
			 * 
			 */
			
			driver.findElement(By.id("payGrade_name")).sendKeys(name[i]);//Sending values from the array
			driver.findElement(By.id("btnSave")).click();
			
			driver.findElement(By.id("btnAddCurrency")).click();
			driver.findElement(By.id("payGradeCurrency_currencyName")).sendKeys(currency[i]);
			driver.findElement(By.xpath("/html/body/div[4]/ul/li")).click(); //Selecting the first value from the drop down
			driver.findElement(By.id("payGradeCurrency_minSalary")).sendKeys(minSalary[i]);
			driver.findElement(By.id("payGradeCurrency_maxSalary")).sendKeys(maxSalary[i]);
			
//			driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle[i]); //Entering data extracted from the excel sheet
//			driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc[i]);
//			driver.findElement(By.id("jobTitle_note")).sendKeys(jobNote[i]);
//			driver.findElement(By.id("btnSave")).click();
			
			
	
		
		
		
	
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
			
		}//End of the for loop
		
		for(String s:name) {
			System.out.println(s);
		}
		System.out.println();
		for(String s:currency) {
			System.out.println(s);
		}	
		System.out.println();
		for(String s:minSalary) {
			System.out.println(s);
		}
		System.out.println();
		for(String s:maxSalary) {
			System.out.println(s);
		}
		status = "pass"; //Add a verification point
		return status;
	}
	
	

}
