package com.TestScripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadExcelOnRowCondition {

	@Test
	public void readExcel() throws Throwable {
		FileInputStream fis1 = new FileInputStream("C:\\Users\\manug\\OneDrive\\Desktop\\VTiger\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet1");
		String rowCond="FB";
		
		int row_num=sh.getPhysicalNumberOfRows();
		//int cell_num=sh.getRow(0).getPhysicalNumberOfCells();
		
		
		for(int i=1;i<row_num;i++) {
			String rowData="null";
			String orgType="null";
			Row row=sh.getRow(i);
			rowData=row.getCell(0).toString();
			if(rowCond.equals(rowData)) {
				orgType=row.getCell(1).toString();
				System.out.println(rowData+"\t"+orgType);
			}
			
			
				
			
		}
		
		
		
	}
}
