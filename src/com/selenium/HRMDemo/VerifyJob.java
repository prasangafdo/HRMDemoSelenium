package com.selenium.HRMDemo;

import org.openqa.selenium.By;

public class VerifyJob extends Main{
	
	private String[] jobDetails = new String[3];// Since Java doesn't support returning multiple values, I'm using an array to overcome that issue.
	
	VerifyPageNavigation navigation = new VerifyPageNavigation();
	
	public void setJob(String title, String description, String note) {//Original method without DDT
		this.jobDetails[0] = title;
		this.jobDetails[1] = description;
		this.jobDetails[2] = note;
		
	/*	for(String a:jobDetails) { //For each loop, just for debugging
			System.out.println(a);
		} */
	}
	
	
	
	public String getJob() {
		
		String objective = "Verify the user can add a new \"Job Title\" :";
		String status = "Pass";
		
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("ttttt"); //Will map with the setter later
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("ddddddd");
		driver.findElement(By.id("jobTitle_note")).sendKeys("nnnn");
		driver.findElement(By.id("btnSave")).click();
		//Job specification will be added later.
		
		navigation.Wait();
		return objective.concat(status);
	}
}