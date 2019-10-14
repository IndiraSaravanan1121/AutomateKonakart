package com.konakart.Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Read test data from excel file.
 * 
 * @author indira.saravanan
 *
 */

public class ExcelReader extends TestBase {

	static FileInputStream fileReader;
	static Workbook book;
	static Sheet sheet;
	static Properties properties = new Properties();

	public static Object[][] ReadWriteExcel(String sheetName, String path)// sheet name to fetch data from particular
																			// sheet
	{
		FileInputStream file = null;
		try {
			fileReader = new FileInputStream(path);// set test data excel file as testData_path in
													// constants class
		} catch (FileNotFoundException e) {
			log.logReport("File Not Found");
		}
		try {
			book = WorkbookFactory.create(fileReader);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		// Read Every rows,columns and pass value to data provider
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
