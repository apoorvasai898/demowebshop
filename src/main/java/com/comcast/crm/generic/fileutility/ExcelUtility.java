package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheet,int row_num,int col_num) throws EncryptedDocumentException, IOException
	{
		String result="";
		FileInputStream fis = new FileInputStream(".\\testData\\demoWebShopAssignment.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(row_num);
		Cell cel = row.getCell(col_num);
		result = cel.getStringCellValue();
		wb.close();
		return result; 
	}
	public void setDataBackToExcel(String sheet,int row_num,int col_num,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\testData\\demoWebShopAssignment.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(row_num);
		if(row == null)
		{
			row = sh.createRow(row_num);
		}
		
		Cell cel = row.getCell(col_num);
		if(cel == null)
		{
			cel = row.createCell(col_num);
		}
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(".\\testData\\demoWebShopAssignment.xlsx");
		wb.write(fos);
		fos.close();
		wb.close();
		fis.close();
	}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		int result =0;
		FileInputStream fis = new FileInputStream(".\\testData\\demoWebShopAssignment.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		result = sh.getLastRowNum();
		wb.close();
		return result;
		
	}
}

