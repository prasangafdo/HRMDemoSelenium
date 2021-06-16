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
			
			//use if and compare value whether it needed to be redirected or not
			String actualMessage = driver.findElement(By.xpath("//*[@id=\"currency\"]/div[2]/div/text()")).getText();
			String expectedMessage = "Successfully Saved";
			System.out.println(actualMessage);

			navigation.navigateToUserManagement();//User should be navigated to the user management page at first
			navigation.setMouseOverOnJob();
			navigation.selectPayGrades();
			
			
			//*[@id="currency"]/div[2]/div
			//*[@id="currency"]/div[2]/div/text()
			/*
			 * Get value from //*[@id="currency"]/div[2]/div and compare it with use contains method in Java string to avoid white spaces "Successfully Saved"
			 */
			//end if
			
			


		/*
		 * Cast string to integer on min and max salary - done
		 * Click on "btnAdd" - done
		 * Verify the user is navigated to https://opensource-demo.orangehrmlive.com/index.php/admin/payGrade - done
		 * Extract data from excel sheet - done
		 * save data temporary in an array - done
		 * sendkeys to "payGrade_name" text field - done
		 * Click on "btnSave" button - done
		 * Verify the banner
		 * 
		 */
			
		}//End of the for loop
		
//		for(String s:name) {
//			System.out.println(s);
//		}
//		System.out.println();
//		for(String s:currency) {
//			System.out.println(s);
//		}	
//		System.out.println();
//		for(String s:minSalary) {
//			System.out.println(s);
//		}
//		System.out.println();
//		for(String s:maxSalary) {
//			System.out.println(s);
//		}
		status = "pass"; //Add a verification point
		return status;
	}
	
	

}
