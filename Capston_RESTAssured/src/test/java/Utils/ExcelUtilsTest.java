package Utils;

public class ExcelUtilsTest {
	
	public static void main(String[] args) {
		
		String excelfilepath = "./data/TestData.xlsx";
		String sheetName   = "sheet1";
		ExcelUtils excel = new ExcelUtils(excelfilepath , sheetName);
		
		excel.getRownumber();
		excel.getCelldata(0, 0);
	}

}
