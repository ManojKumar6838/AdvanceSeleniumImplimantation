package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	public String readExcel(String sheetName, int rowIndex, int cellIndex) throws Throwable {
		FileInputStream fis=new FileInputStream("./testResource/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowIndex);
		Cell cell=row.getCell(cellIndex);
		String data=cell.getStringCellValue();
		return data;
	}
	
	public String writebackExcel(String sheetName, int rowIndex, int cellIndex)throws Throwable {
		FileInputStream fis=new FileInputStream("./testResource/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowIndex);
		Cell cell=row.createCell(cellIndex);
		cell.setCellValue("Fail");
		
		FileOutputStream fos=new FileOutputStream("./testResource/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		return "Written in Excel";
		
	}
}
