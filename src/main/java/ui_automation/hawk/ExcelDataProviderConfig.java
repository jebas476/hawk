package ui_automation.hawk;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProviderConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ExcelDataProviderConfig(String excelPath) {
        try {
            File src=new File(excelPath);
            
            FileInputStream fis=new FileInputStream(src);
            
            wb=new XSSFWorkbook(fis);
             
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }

	public String getData(int sheetNumber, int row, int column) {
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();

		return data;
	}

	public int getRowCount() {
		int rowCount = sheet1.getLastRowNum() + 1;
		return rowCount;
	}

	public int getColumnCount() {
		int columnCount = sheet1.getRow(0).getLastCellNum();
		return columnCount;
	}
}
