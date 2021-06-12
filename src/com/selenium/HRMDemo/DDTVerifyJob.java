package com.selenium.HRMDemo;

import org.openqa.selenium.By;

public class DDTVerifyJob extends Main{
	
	VerifyPageNavigation navigation = new VerifyPageNavigation();
	
	public String getJobtt(String[] jobTitle, String[] jobDesc, String[] jobNote) {
		
		String objective = "Verify the user can add a new \"Job Title\" :";
		String status = "Pass";
		
		for(int i=0;i<jobTitle.length;i++) {//Assuming all the arrays have same length

			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle[i]); //Will map with the setter later
			driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc[i]);
			driver.findElement(By.id("jobTitle_note")).sendKeys(jobNote[i]);
			driver.findElement(By.id("btnSave")).click();
			//Job specification will be added later.
			
			navigation.Wait();
			
		}
		
		return objective.concat(status);
		
	}
	

	
//	VerifyPageNavigation navigation = new VerifyPageNavigation();
	

//	for(int i=0;i<arr.length;i++) {
//		
//	}
//	
	
//	public String getJob() {
//		
//		String objective = "Verify the user can add a new \"Job Title\" :";
//		String status = "Pass";
//		
//		driver.findElement(By.id("btnAdd")).click();
//		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("ttttt"); //Will map with the setter later
//		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("ddddddd");
//		driver.findElement(By.id("jobTitle_note")).sendKeys("nnnn");
//		driver.findElement(By.id("btnSave")).click();
//		//Job specification will be added later.
//		
//		navigation.Wait();
//		return objective.concat(status);
//	}

}