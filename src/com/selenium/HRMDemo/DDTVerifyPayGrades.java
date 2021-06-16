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
	/*
	 * Extract data from excel sheet - done
	 * save data temporary in an array - done
	 * sendkeys to "payGrade_name" text field - done
	 * Click on "btnSave" button - done
	 * Verify the banner - done
	 */
	
	
	public String addPayGrade(String[] name, String[] currency, String minSalary[], String[] maxSalary ) {
		String testObjective = "Verify the user can add a job :";
		String status = "Fail";
		
		VerifyPageNavigation navigation = new VerifyPageNavigation();
		for(int i=0;i<name.length;i++) {//Assuming all the arrays have same length

		//	int minSal = Integer.parseInt(minSalary[i]);// 
		//	int maxSal = Integer.parseInt(maxSalary[i]);
			
			driver.findElement(By.id("btnAdd")).click();
			
			driver.findElement(By.id("payGrade_name")).sendKeys(name[i]);//Sending values from the array
			driver.findElement(By.id("btnSave")).click();
			
			driver.findElement(By.id("btnAddCurrency")).click();
			driver.findElement(By.id("payGradeCurrency_currencyName")).sendKeys(currency[i]);
			driver.findElement(By.xpath("/html/body/div[4]/ul/li")).click(); //Selecting the first value from the drop down
			driver.findElement(By.id("payGradeCurrency_minSalary")).sendKeys(minSalary[i]);
			driver.findElement(By.id("payGradeCurrency_maxSalary")).sendKeys(maxSalary[i]);
			driver.findElement(By.id("btnSaveCurrency")).click();
			
			String actualMessage = driver.findElement(By.xpath("//*[@id=\"currency\"]/div[2]/div")).getText();
			String expectedMessage = "Successfully Saved";
			//System.out.println(actualMessage);
			if(actualMessage.contains(expectedMessage)) {//To avoid white spaces in "Successfully Saved"
				status = "Pass"; //
			}
			navigation.navigateToUserManagement();//User should be navigated to the user management page at first
			navigation.setMouseOverOnJob();
			navigation.selectPayGrades();				
		}//End of the for loop

		
		return testObjective+status;
	}
	
	

}
