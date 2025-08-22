package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPurchaseOrderWithUpdatedProduct {
	static WebDriver wd=null;
	public static void Check(String path,String msg) {
		WebDriverWait wait=new WebDriverWait(wd,Duration.ofSeconds(10));
		try {
			 WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			 if(until.isDisplayed()) {
				 System.out.println("Passed "+msg+ " is displayed");
			 }
			 
		} catch (Exception e) {
			System.out.println("failed "+msg+ " is not displayed");
		}
	}
public static void main(String[] args) throws IOException {
	FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFrameWork\\src\\test\\resources\\CommenData.properties");
	Properties p= new Properties();
	p.load(fis);
	String url = p.getProperty("url");
String un = p.getProperty("username");
String pass = p.getProperty("password");
String browser = p.getProperty("browser");


 if(browser.equals("Edge")) {
	 wd=new EdgeDriver();
 }else {
	 wd=new ChromeDriver();
 }
 wd.manage().window().maximize();
 wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
 wd.get(url);
 String windowHandle = wd.getWindowHandle();
 WebElement username = wd.findElement(By.id("username"));

 username.sendKeys(un);
 
 WebElement password = wd.findElement(By.id("inputPassword"));
 password.sendKeys(pass);
 
 wd.findElement(By.xpath("//button[.='Sign In']")).click();
 Check("//b[.='Campaigns']","Campaign");
  WebDriverWait wait =new WebDriverWait(wd,Duration.ofSeconds(10));
 WebElement Purchase = wd.findElement(By.xpath("//a[.='Purchase Order']"));
 wait.until(ExpectedConditions.elementToBeClickable(Purchase));
 Purchase.click();
 Check("//b[.='Purchase Orders']", "Purchase Orders Page");
 
 WebElement createOrder = wd.findElement(By.xpath("//span[.='Create Order']"));
 wait.until(ExpectedConditions.elementToBeClickable(createOrder));
 createOrder.click();
 Check("//h3[.='Create Purchase-Order']","Create Purchase Order Page");
 
 //Due Date	Subject	ContactName	ProductName	PricePerUnit
 FileInputStream Exel=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
 Workbook wb = WorkbookFactory.create(Exel);
 Sheet sheet = wb.getSheet("Sheet1");
 Row r = sheet.getRow(7);
   String duedate = r.getCell(2).getStringCellValue();
   String Subject = r.getCell(3).getStringCellValue();
   String Contactname = r.getCell(4).getStringCellValue();
   String Productname = r.getCell(5).getStringCellValue();
   String Priseperunit = r.getCell(6).getStringCellValue();
   //Address	Postbox	city	state	postalcode	country
   String address = r.getCell(7).toString();
   String poBox = r.getCell(8).toString();
   String city = r.getCell(9).toString();
   String state = r.getCell(10).toString();
   String postalCode = r.getCell(11).toString();
   String country = r.getCell(12).toString();
 
 wd.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(duedate);
 wd.findElement(By.xpath("//input[@name='subject']")).sendKeys(Subject);
 wd.findElement(By.xpath("(//button[@type='button'])[2]")).click();
 Set<String> windowHandles2 = wd.getWindowHandles();
 for(String w2:windowHandles2) {
	 if(!w2.equals(windowHandle)) {
		 wd.switchTo().window(w2);
	 }
 }
Check("//h3[.='Select a Contact']", "select Contact Page");
 //wd.findElement(By.id("search-input")).sendKeys(organization);
 wd.findElement(By.xpath("//button[@class='select-btn']")).click();
  wd.switchTo().window(windowHandle);
  
  wd.findElement(By.xpath("(//textarea[@name='address'])[1]")).sendKeys(address);
  wd.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(address);
  wd.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(poBox);
  wd.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(poBox);
  wd.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(city);
  wd.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(city);
  wd.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(state);
  wd.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(state);
  wd.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(postalCode);
  wd.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(postalCode);
  wd.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(country);
  wd.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(country);
  
  Actions act=new Actions(wd); 
  WebElement AddP = wd.findElement(By.xpath("(//button[@class='action-button'])[last()]"));
act.scrollToElement(AddP).perform();
AddP.click();

Set<String> w3 = wd.getWindowHandles();
for(String win:w3) {
	if(!win.equals(windowHandle)) {
	wd.switchTo().window(win);
	}
}
Check("//h3[.='Select a Product']","select page ");
WebElement select = wd.findElement(By.id("search-criteria"));


Select s=new Select(select);
s.selectByContainsVisibleText("Product Name");
wd.findElement(By.id("search-input")).sendKeys("RAmSung");
wd.findElement(By.xpath("//button[@class='select-btn']")).click();

wd.switchTo().window(windowHandle);
wd.findElement(By.xpath("//button[.='Create Purchase Order']")).click();

Check("//div[contains(text(),'Purchase-Order')]", "Purchase Order Added");

wd.findElement(By.xpath("//a[.='Products']")).click();
WebElement sel = wd.findElement(By.xpath("//select[@class='form-control']"));
Select s2=new Select(sel);
s2.selectByContainsVisibleText("Search by Product Name");
wd.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("RAmsung");
Check("//td[.='RAmSung']","product is avalable");

wd.findElement(By.xpath("//i[@title='Edit']")).click();
wd.findElement(By.xpath("//input[@name='price']")).sendKeys(Keys.CLEAR);

WebElement user = wd.findElement(By.xpath("//div[@class='user-icon']"));
act.moveToElement(user).perform();


}
}
