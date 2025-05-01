package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.io.File;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

//	public static void main(String[] args) throws IOException {
//
//		ExcelUtility.excelData("C://Users//ravi//Desktop//TestData.xlsx", "Sheet1");
//	}

	public static Object[][] excelData(String filePath, String sheetName) throws IOException {

		Object data[][] = null;

		try (FileInputStream fileStream = new FileInputStream(new File(filePath));

				XSSFWorkbook workbook = new XSSFWorkbook(fileStream)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("rownumber is -->" + rowcount);

			int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(" colcount is -->" + colcount);

			data = new Object[rowcount - 1][colcount];

			for (int i = 1; i < rowcount; i++) {

				XSSFRow row = sheet.getRow(i);

				for (int j = 0; j < colcount; j++) {

					XSSFCell cell = row.getCell(j);

					// DataFormatter formatter = new DataFormatter();
					// System.out.println(formatter.getDefaultFormat(sheet.getRow(i).getCell(j)));

					data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();

					System.out.println("return values are " + data[i - 1][j]);

				}

			}

		} catch (Exception e) {

			System.err.println("Error reading Excel file: " + e.getMessage());

			e.printStackTrace();

		}

		return data;

	}

}
