package com.TestScripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ToWriteBackExcel {

	@Test
	public void writeExcel() throws Throwable {
		FileInputStream fis1 = new FileInputStream("C:\\Users\\manug\\OneDrive\\Desktop\\VTiger\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(1);
		Cell cell=row.createCell(2);
		cell.setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\manug\\OneDrive\\Desktop\\VTiger\\TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Executed");
		
}
}

