package ninzaCRM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import ninzaCRM.genericUtilities.SeleniumUtility;
//import ninzaCRM.genericUtilities.WebDriverUtility;

public class DashBoardPage {
@FindBy (xpath = "//a[.='Campaigns']") private WebElement campaigns;
@FindBy (xpath = "//a[.='Contacts']") private WebElement contact;
@FindBy (xpath = "//a[.='Leads']") private WebElement lead;
@FindBy (xpath = "//a[.='Opportunities']") private WebElement opportunities;
@FindBy (xpath = "//a[.='Products']") private WebElement products;
@FindBy (xpath = "//a[.='Quotes']") private WebElement quotes;
@FindBy (xpath = "//a[.='Purchase Order']") private WebElement purchaseorder;
@FindBy (xpath = "//a[.='Sales Order']") private WebElement salesorder;
@FindBy (xpath = "//a[.='Invoice']") private WebElement invoice;
@FindBy (xpath = "Admin Console") private WebElement adminconsole;
@FindBy(xpath = "//div[@class='user-icon']")private WebElement usericon;
@FindBy(xpath = "//div[@class='dropdown-item logout']")private WebElement logoutbtn;
public WebElement getUsericon() {
	return usericon;
}

public WebElement getLogoutbtn() {
	return logoutbtn;
}

public DashBoardPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getCampaigns() {
	return campaigns;
}

public WebElement getContact() {
	return contact;
}

public WebElement getLead() {
	return lead;
}

public WebElement getOpportunities() {
	return opportunities;
}

public WebElement getProducts() {
	return products;
}

public WebElement getQuotes() {
	return quotes;
}

public WebElement getPurchaseorder() {
	return purchaseorder;
}

public WebElement getSalesorder() {
	return salesorder;
}

public WebElement getInvoice() {
	return invoice;
}

public WebElement getAdminconsole() {
	return adminconsole;
}
public void doLogout(WebDriver driver) throws InterruptedException {
	//SeleniumUtility su=new SeleniumUtility();
	Thread.sleep(6000);
	//su.moveToElementAction(driver, usericon);
	usericon.click();
	getLogoutbtn().click();
}

}

