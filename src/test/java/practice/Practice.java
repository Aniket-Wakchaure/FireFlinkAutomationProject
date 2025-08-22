package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import ninzaCRM.ObjectRepo.AddProductPage;
//import ninzaCRM.ObjectRepo.CampaignPage;
import ninzaCRM.ObjectRepo.CampaignsPage;
import ninzaCRM.ObjectRepo.CreateCampaignsPage;
import ninzaCRM.ObjectRepo.DashBoardPage;
import ninzaCRM.ObjectRepo.LoginPage;
import ninzaCRM.ObjectRepo.ProductPage;
import ninzaCRM.genericUtilities.FileUtility;

public class Practice {
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
			 WebElement succ = wd.findElement(By.xpath("//div[contains(text(), 'Successfully')]"));
			
			 db.getProducts().click();
			 ProductPage pg=new ProductPage(wd);
			 Thread.sleep(7);
			 pg.getAddToProduct().click();
			 
			 String quantity  = fu.readDataFromExcelSheet("sheet1", 40, 0);
			 String productname  = fu.readDataFromExcelSheet("sheet1", 40, 1);
			 String  priseperunit= fu.readDataFromExcelSheet("sheet1", 40, 2);
			 String categary  = fu.readDataFromExcelSheet("sheet1", 40, 3);
			 String vendor = fu.readDataFromExcelSheet("sheet1", 40, 4);
			 
			 AddProductPage apg=new AddProductPage(wd);
			 apg.AddProduct(quantity, productname,priseperunit , categary, vendor);
			 wd.close();
			 
			 
	}

}
