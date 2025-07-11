package week2.Marathon2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataLibraryMarathon {

	public static String[][] readData(String strFilePath, String strSheetName) throws IOException {
		// System.out.println(strFilePath + strSheetName);

		XSSFWorkbook wb = new XSSFWorkbook("./ExcelData/" + strFilePath + ".xlsx");

		XSSFSheet sheet = wb.getSheet(strSheetName);

		XSSFRow row = sheet.getRow(1);

		int lastRowNum = wb.getSheet(strSheetName).getLastRowNum(); // 3
		int lastcolNum = wb.getSheet(strSheetName).getRow(1).getLastCellNum();// 3+1 = 4

		String[][] data;
		data = new String[lastRowNum][lastcolNum];

		for (int i = 1; i <= lastRowNum; i++) {

			for (int j = 0; j < lastcolNum; j++) {

				String stringCellValue = wb.getSheet(strSheetName).getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = stringCellValue;

			}

		}
		System.out.println(data);
		wb.close();
		return data;

	}
}
