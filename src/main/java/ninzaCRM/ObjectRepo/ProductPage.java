package ninzaCRM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(xpath = "//span[.='Add Product']") private WebElement addToProduct;
@FindBy(xpath = "//select[@class='form-control']")private WebElement SelectBy ;
@FindBy(xpath = "//input[@placeholder='Search by product Id']")private WebElement SelectProduct ;

public ProductPage(WebDriver driver) {
PageFactory.initElements(driver, this);
}

public WebElement getAddToProduct() {
	return addToProduct;
}

public WebElement getSelectBy() {
	return SelectBy;
}

public WebElement getSelectProduct() {
	return SelectProduct;
}

}
