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
	

	public String getJob() {
		return null;
	}
	/* 	Add the ddt code - done
		Store ddt values in a private array separately- done
		Get data from the private array and send to public void setJob method in verifyjob class	- todo
	 */
	
	
	public void getJobData_Excel() throws BiffException, IOException {
		
		String fileLocation= "C:/Users/Prasanga Fernando/Documents/Eclipse/DataDrivenTesting/Book1.xls";
		File file = new File(fileLocation);
		String value = null;
		Workbook wb = Workbook.getWorkbook(file);
		
		Sheet sheet = wb.getSheet(1); //Selecting the second sheet
		int rowsCount = sheet.getRows();
		int columnsCount = sheet.getColumns();
		
		//System.out.println(rowsCount);
		//System.out.println(columnsCount);
		
		for(int i=0;i<rowsCount;i++) {
			for (int j=0;j<columnsCount;j++) {
				Cell cell = sheet.getCell(j,i);
				//System.out.println(cell.getContents());
				value = cell.getContents();
				if(j==0) {
					//System.out.println("This is first column");
						jobTitle[i] = value;
					//System.out.println(value);
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
				
				//jobTitle[i] = value;
					
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
	
	
		
	}
