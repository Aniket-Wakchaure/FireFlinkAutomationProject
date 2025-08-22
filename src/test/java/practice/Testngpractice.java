package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepo.CampaignsPage;
import ninzaCRM.ObjectRepo.CreateCampaignsPage;
import ninzaCRM.ObjectRepo.DashBoardPage;
import ninzaCRM.ObjectRepo.LoginPage;
import ninzaCRM.genericUtilities.FileUtility;

public class Testngpractice {
	@Test
	public void sampleTest() throws EncryptedDocumentException, IOException{
		System.out.println("hiii");
		FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFrameWork\\src\\test\\resources\\CommenData.properties");
		Properties p= new Properties();
		p.load(fis);
		String url = p.getProperty("url");
	String un = p.getProperty("username");
	String pass = p.getProperty("password");
	String browser = p.getProperty("browser");

WebDriver wd=null;
	 if(browser.equals("Edge")) {
		 wd=new EdgeDriver();
	 }else {
		 wd=new ChromeDriver();
	 }
	 wd.manage().window().maximize();
	 wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 wd.get(url);
	 
	 
		LoginPage lp=new LoginPage(wd);
		lp.logintoApp(un, pass);
		
		DashBoardPage db=new DashBoardPage(wd);
		db.getCampaigns().click();
		
		CampaignsPage cp=new CampaignsPage(wd)	;
		cp.createCampaign();
		
		CreateCampaignsPage ccp=new CreateCampaignsPage(wd);
		
		 FileUtility fu=new FileUtility();
		 String date = fu.readDataFromExcelSheet("sheet1", 34, 0);
		 String name = fu.readDataFromExcelSheet("sheet1", 34, 1);
		 String size = fu.readDataFromExcelSheet("sheet1", 34, 5);
		 ccp.fillData(date, name, size);
		 
		 ccp.getCreateCampaignButton().click();;
	}

}
