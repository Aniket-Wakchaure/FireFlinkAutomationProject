package ninzaCRM.genericUtilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



import ninzaCRM.ObjectRepo.DashBoardPage;
import ninzaCRM.ObjectRepo.LoginPage;

public class BaseClass {
	public WebDriver wd;
	//for listeners as creating objrct of base class is not allowed and listners class dont extends the base class 
	public static WebDriver sdriver;
 public FileUtility fu=new  FileUtility();

 
	@BeforeSuite(alwaysRun = true)
	public void dbconnection(){
		System.out.println("=======DB Connected Succesfully======");
	}
	//this is for cross browser
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	//this is for cross browser
	//public void bcConfiguration(String browser) throws IOException {
	public void bcConfiguration() throws IOException {
		//this is for cross browser just comment it
		String browser = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		if(browser.equals("Edge")) {
			 wd=new EdgeDriver();
		 }else if (browser.equals("chrome")) {
			 wd=new ChromeDriver();
		}
		 else if (browser.equals("firefox")) {
			 wd=new FirefoxDriver();
		}
		 else {
			wd=new ChromeDriver();
		} 
			
		 
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 wd.get(URL);
		 //for Listeners
		sdriver=wd;
		System.out.println("=====App Launched======");
		
	}
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		String un = fu.readDataFromPropertyFile("username");
		String pass = fu.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(wd);
		lp.logintoApp(un, pass);
	}
	@AfterMethod(alwaysRun = true)
	public void logout() throws InterruptedException {
		 DashBoardPage dbp= new DashBoardPage(wd);
		 dbp.doLogout(wd);
	}
	
	@AfterClass(alwaysRun = true)
	public void  bcClose() {
		wd.close();
		System.out.println("=========");
	}
	@AfterSuite(alwaysRun = true)
	public void dbClose() {
		System.out.println("====== DB CLOSED======");
	}
	

}
