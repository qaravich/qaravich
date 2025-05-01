package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

	// Class variables and which will be available in any of the function
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	// when ever we instantiate a class with new keyword the constructor will load .
	// this constructor it will not have no return type .
	// with same name which will use to get the pathname and sheet name .

	public ExcelUtils(String excelfilepath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelfilepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get the sheet name from the excel using sheetname
		XSSFSheet sheet = workbook.getSheet(sheetName);

	}

	// getPhysialNumberofRows will tell you haw many rows has the data
	public static void getRownumber() {

		int row_Count = sheet.getPhysicalNumberOfRows();
	}

	public static void getCelldata(int rowNum, int cellNum) {

		int col_Count = sheet.getRow(0).getPhysicalNumberOfCells();
		
		/* DataFormatter i used to get the cell values as it is .		 
		  this will return the cell value as it is . so i am storing it in Object
		*/
		
		 DataFormatter formatter = new DataFormatter();
		 Object cellvalue = formatter.getDefaultFormat(sheet.getRow(rowNum).getCell(cellNum));
	}

}

/*
 * 
 * 
 * 
 * // DataFormatter i used to get the cell values as it is .
 * 
 * // DataFormatter formatter = new DataFormatter();
 * 
 * // this will return the cell value as it is . so i am storning it in Object
 * // Object cellvalue = formatter.getDefaultFormat(sheet.getRow(0).getCell(0));
 * 
 * 
 * data = new Object[row_Count - 1][col_Count];
 * 
 * for (int i = 1; i < row_Count; i++) {
 * 
 * Row row = sheet.getRow(i);
 * 
 * for (int j = 0; j < col_Count; j++) {
 * 
 * Cell cell = row.getCell(j);
 * 
 * data[i - 1][j] = getCellValue(cell);
 * 
 * }
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * System.err.println("Error reading Excel file: " + e.getMessage());
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * return data;
 * 
 * }
 * 
 * 
 * 
 * }
 */
