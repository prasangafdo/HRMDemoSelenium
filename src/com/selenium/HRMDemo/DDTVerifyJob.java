package com.selenium.HRMDemo;

import org.openqa.selenium.By;

public class DDTVerifyJob extends Main{
	
	VerifyPageNavigation navigation = new VerifyPageNavigation();
	
	public String getJobtt(String[] jobTitle, String[] jobDesc, String[] jobNote) {
		
		String objective = "Verify the user can add a new \"Job Title\" :";
		String status = "Pass";
		
		for(int i=0;i<jobTitle.length;i++) {//Assuming all the arrays have same length

//			driver.findElement(By.id("btnAdd")).click();
//			driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle[i]); //Entering data extracted from the excel sheet
//			driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc[i]);
//			driver.findElement(By.id("jobTitle_note")).sendKeys(jobNote[i]);
//			driver.findElement(By.id("btnSave")).click();
			//Job specification will be added later.
			
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle[i]); //Entering data extracted from the excel sheet
			driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc[i]);
			driver.findElement(By.id("jobTitle_note")).sendKeys(jobNote[i]);
			driver.findElement(By.id("btnSave")).click();
			
			
			navigation.Wait();
			try {
				Thread.sleep(500);
				
				System.out.println( driver.findElement(By.xpath("//*[@id=\"frmList_ohrmListComponent\"]/div[2]")).getText());
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		
		return objective.concat(status);
		
	}
	
	//verify the user is in job title screen.
	//https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList
	
//get lement by id	ohrmList_chkSelectRecord_26
	
//checkbox and delete
		
		//delete button id btnDelete
		
		//After adding each element, we get below message, need to verify that
		/*
		 * <div class="message success fadable">
			Successfully Saved   
    		<a href="#" class="messageCloseButton">Close</a>
			</div>
		 */
}