package Reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {

	public Excelreader(String filePath, String sheetName) {
		super();
		this.filePath = filePath;
		this.sheetName = sheetName;
	}

	String filePath;
	String sheetName;

	public int rowCount() {
		int i = 0;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(filePath);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			i = worksheet.getPhysicalNumberOfRows();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int colCount() {
		int j= 0;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(filePath);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			j = worksheet.getRow(0).getPhysicalNumberOfCells();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
	}

	public String getData(int row, int col) {
		String data = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(filePath);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			data = worksheet.getRow(row).getCell(col).getStringCellValue();
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
	}

}
