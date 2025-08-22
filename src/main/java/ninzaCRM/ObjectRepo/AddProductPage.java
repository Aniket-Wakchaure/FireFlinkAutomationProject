package ninzaCRM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	@FindBy(xpath = "//input[@name='quantity']") private WebElement pQuantity;
	@FindBy(xpath = "//input[@name='productName']") private WebElement productName;
	@FindBy(xpath = "//input[@name='price']") private WebElement pPrise;
	@FindBy(xpath = "//select[@name='productCategory']") private WebElement selectProductcategory;
	@FindBy(xpath = "//select[@name='vendorId']")private WebElement selectVendor;
	@FindBy(xpath = "//button[.='Add']") private WebElement addProduct;
	
	public AddProductPage(WebDriver driver ){
		PageFactory.initElements(driver, this);
	}

	public WebElement getpQuantity() {
		return pQuantity;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getpPrise() {
		return pPrise;
	}

	public WebElement getSelectProductcategory() {
		return selectProductcategory;
	}

	public WebElement getSelectVendor() {
		return selectVendor;
	}

	public WebElement getAddProduct() {
		return addProduct;
	}//kk
public void AddProduct(String quantity,String productname, String prise,String productCatogory,String vendor ) {
	pQuantity.sendKeys(quantity);
	productName.sendKeys(productname);
	pPrise.sendKeys(prise);
	selectProductcategory.sendKeys(productCatogory);
	selectVendor.sendKeys(vendor);
	addProduct.click();
}
}
