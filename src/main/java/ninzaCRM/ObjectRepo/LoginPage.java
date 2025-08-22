package ninzaCRM.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Rule no 2 create web element
	
	@FindBy (id = "username") private WebElement  usernameTF;
@FindBy (id = "inputPassword") private WebElement  passwordTF;
@FindBy(xpath = "//button[.='Sign In']") private WebElement  loginbtn;
 
//Rule no 3 create public constructor and initialize them

public LoginPage(WebDriver Driver) {
	PageFactory.initElements(Driver, this);
}

public WebElement getUsernameTF() {
	return usernameTF;
}

public WebElement getPasswordTF() {
	return passwordTF;
}

public WebElement getLoginbtn() {
	return loginbtn;
}

//Business Library
public void logintoApp(String username,String password) {
	usernameTF.sendKeys(username);
	passwordTF.sendKeys(password);
	loginbtn.click();
}

}
