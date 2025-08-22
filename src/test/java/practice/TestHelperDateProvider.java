package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ninzaCRM.genericUtilities.FileUtility;

public class TestHelperDateProvider {
	@Test(dataProvider = "CostInfo")
	public void create(String name, String id) {
		System.out.println("======="+"Name:" + name + " id:" + id+"========");

	}

	@DataProvider(name = "CostInfo")

	public Object[][] getData() throws EncryptedDocumentException, IOException {

		Object[][] data = new Object[4][2];

		FileUtility fu = new FileUtility();

		
		data[0][0] = fu.readDataFromExcelSheet("Sheet1", 43, 0);
		data[0][1] = fu.readDataFromExcelSheet("Sheet1", 43, 1);

		data[1][0] =fu.readDataFromExcelSheet("Sheet1", 44, 0);
		data[1][1] = fu.readDataFromExcelSheet("Sheet1", 44, 1);

		data[2][0] = fu.readDataFromExcelSheet("Sheet1", 45, 1);
		data[2][1] = fu.readDataFromExcelSheet("Sheet1", 45, 1);

		data[3][0] = fu.readDataFromExcelSheet("Sheet1", 46, 1);
		data[3][1] = fu.readDataFromExcelSheet("Sheet1", 46, 1);
		
		return data;

	}
}
