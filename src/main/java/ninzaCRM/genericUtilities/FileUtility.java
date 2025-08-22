package ninzaCRM.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	/**
	 * @author Wakchaure Aniket 
	 *This class consists of generic method related to
	 * File Operation like property file,excel File
	 * @throws IOException 
	 */

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommenData.properties");
		Properties  p=new Properties();
		p.load(fis);
		String value = p.getProperty( key);
		return value;
	}
	
	public String readDataFromExcelSheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String stringCellValue = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return stringCellValue;
}
//	public String readAllRowDataFromExcel(String sheet,int row , int lastcell) throws EncryptedDocumentException, IOException {
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb= WorkbookFactory.create(fis);
//		Row row2 = wb.getSheet(sheet).getRow(row);
//		for(int i=0;i<=lastcell;i++);}
//		
//	}
}
