package daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	

	public static void main(String args[]) throws IOException {
		File out = new File("excel.xlsx");
		InputStream file = new FileInputStream(out);
		XSSFWorkbook worksheet = new XSSFWorkbook(file);
		XSSFSheet mysheet = worksheet.getSheetAt(0);
		int firstrow = mysheet.getFirstRowNum();
		int lastrow = mysheet.getLastRowNum();
		for(int row = firstrow; row<lastrow; row++) {
			Row r = mysheet.getRow(row);
			int column = r.getLastCellNum();
			for(int col = 0; col<column;col++) {
				System.out.println(r.getCell(col));
			}
		}
		file.close();
		System.out.println("Create Excel file susseccfully"+out.exists());
	}
}	
