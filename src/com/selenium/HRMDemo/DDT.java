package com.selenium.HRMDemo;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DDT {
	
	private String[] jobTitle = new String[4];
	private String[] jobDesc = new String[4];
	private String[] jobNote = new String[4];
	
	private String[] gradeName = new String[5];
	private String[] gradeCurrency = new String[5];
	private String[] gradeMinSalary = new String[5];	
	private String[] gradeMaxSalary = new String[5];
	
	String fileLocation= "C:/Users/Prasanga Fernando/Documents/Eclipse/DataDrivenTesting/Book1.xls"; //Since I want to access these details from many methods, I'm making it global.
	File file = new File(fileLocation);
	String value = null;
	
	
	public void getJobData_Excel() throws BiffException, IOException {
		
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sheet = wb.getSheet(1); //Selecting the second sheet
		int rowsCount = sheet.getRows();
		int columnsCount = sheet.getColumns();
		
		for(int i=0;i<rowsCount;i++) {
			for (int j=0;j<columnsCount;j++) {
				Cell cell = sheet.getCell(j,i);
				value = cell.getContents();
				if(j==0) {
					//System.out.println("This is first column");
						jobTitle[i] = value;
					}
				else {
					if (j==1)
					//	System.out.println("This is sec column");
						jobDesc[i] = value;
					}
					if (j==2) {
				//		System.out.println("This is 3 column");
						jobNote[i] = value;
					}					
			}
			
		}
		for (int i=0;i<=jobTitle.length-1;i++) {
			System.out.println(jobTitle[i]);
			System.out.println(jobDesc[i]);
			System.out.println(jobNote[i]);
			System.out.println();
		}
		
		DDTVerifyJob job = new DDTVerifyJob();
		job.getJobtt(jobTitle, jobDesc, jobNote);
	}
	
	/*
	 * Modify DDT class
	 * ================
	 * Create a new method to read data from 3rd excel sheet and save data into a temporary array - done
	 * Send those data to "addPayGrade" method
	 * 
	 */
	
	public void getPayGradeData_Excel() throws BiffException, IOException {
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sheet = wb.getSheet(2);
		int rowsCount = sheet.getRows();
		int columnsCount = sheet.getColumns();
		
		//System.out.println(rowsCount +" "+columnsCount);  //For debugging only
		
		for(int i=1; i<rowsCount;i++) {
			for(int j=0;j<columnsCount;j++) {
				Cell cell = sheet.getCell(j,i);
				String value =	cell.getContents();
				//System.out.println(value);
				
					if(j==0) {
					//System.out.println("This is first column");
						gradeName[i-1] = value; //Removing first row as the heading
					}
					if (j==1)
					//	System.out.println("This is sec column");
						gradeCurrency[i-1] = value;
					//	System.out.println(value);
					if (j==2) {
				//		System.out.println("This is 3 column");
						gradeMinSalary[i-1] = value;
					}	
					if (j==3) {
						//		System.out.println("This is 4 column");
						gradeMaxSalary[i-1] = value;
					}
			}
		}
		
		DDTVerifyPayGrades payGrade = new DDTVerifyPayGrades();
		System.out.println(payGrade.addPayGrade(gradeName, gradeCurrency, gradeMinSalary, gradeMaxSalary));
		
	}
	
	
		
	}
