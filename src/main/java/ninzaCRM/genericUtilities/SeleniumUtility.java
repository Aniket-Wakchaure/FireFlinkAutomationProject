package ninzaCRM.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contain utility method related to Selenium
 * 
 * @author Abhinav Mishra
 */

public class SeleniumUtility {
	/*
	 * This method will maximize the window
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/*
	 * This method will minimize the window
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/*
	 * This method will make window as full screen
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	/**
	 * This method is used to create a implicit wait of 10 sec
	 * 
	 * @param driver
	 */
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is used to create a implicit wait on given seconds
	 * 
	 * @param driver
	 */
	public void implicitwait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * This method will create a explicit wait and check condition that element is
	 * present on the DOM of a page, is visible.
	 * 
	 * @param driver
	 * @param seconds
	 * @param element
	 */

	public void explicitWait(WebDriver driver, int seconds, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will create a explicit wait and check condition on element
	 * 
	 * @param driver
	 * @param seconds
	 * @param element
	 */

	public void explicitWait(WebDriver driver, int seconds, ExpectedCondition<?> condition) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(condition);
	}

	/**
	 * This method allow you to select option by index
	 * 
	 * @param element
	 * @param index
	 */

	public void handleDropdown(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	/**
	 * This method allow you to select option by value attribute
	 * 
	 * @param element
	 * @param value
	 */

	public void handleDropdown(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	/**
	 * This method allow you to select option by visible
	 * 
	 * @param element
	 * @param text
	 */
	public void handleDropdownByText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * This method will perform the click action using Actions class
	 * 
	 * @param driver
	 * @param element
	 */

	public void clickAction(WebDriver driver, WebElement element) {
		new Actions(driver).click(element).perform();
	}

	/**
	 * This method will perform the double click action using Actions class
	 * 
	 * @param driver
	 * @param element
	 */

	public void doubleClickAction(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	/**
	 * This method will perform the right click action using Actions class
	 * 
	 * @param driver
	 * @param element
	 */

	public void contextClickAction(WebDriver driver, WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}

	/**
	 * This method will perform the drag and drop action using Actions class
	 * 
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */

	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElement) {
		new Actions(driver).dragAndDrop(srcElement, targetElement).perform();
	}

	/**
	 * This method will perform the Click and Hold action using Actions class
	 * 
	 * @param driver
	 * @param element
	 */

	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		new Actions(driver).clickAndHold(element).perform();
	}

	/**
	 * This method will perform the release action using Actions class
	 * 
	 * @param driver
	 * @param element
	 */

	public void releaseAction(WebDriver driver, WebElement element) {
		new Actions(driver).release(element).perform();
	}

	/**
	 * This method will send the string value to input or textfield
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 */

	public void sendKeys(WebDriver driver, WebElement element, String text) {
		new Actions(driver).sendKeys(text).perform();
	}

	/**
	 * This method will click and send the string value to input or textfield
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 */

	public void clickAndSendKeys(WebDriver driver, WebElement element, String text) {
		new Actions(driver).click(element).sendKeys(text).perform();
	}

	/**
	 * This method will move the cursor to particular element
	 * 
	 * @param driver
	 * @param element
	 */

	public void moveToElementAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element);
	}

	/**
	 * This method will move the cursor by offset
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */

	public void moveByOffset(WebDriver driver, WebElement element, int x, int y) {
		new Actions(driver).moveByOffset(x, y);
	}

	/**
	 * This method will scroll cursor to particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver, WebElement element) {
		new Actions(driver).scrollToElement(element);
	}

	/**
	 * This method will scroll the cursor by given amount(int x, int y)
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */

	public void scrollByAmount(WebDriver driver, WebElement element, int x, int y) {
		new Actions(driver).scrollByAmount(x, y);
	}

	/**
	 * This method will move cursor to frame based on index
	 * 
	 * @param driver
	 * @param index
	 */

	public void moveToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will move cursor to frame based on string value i.e window Handle
	 * 
	 * @param driver
	 * @param value
	 */

	public void moveToFrame(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}

	/**
	 * This method will move cursor to frame based on WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will move cursor to parent frame
	 * 
	 * @param driver
	 */

	public void moveTopParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will move cursor to top frame
	 * 
	 * @param driver
	 */

	public void moveToTopFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will accept the alert
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will dismiss the alert
	 * 
	 * @param driver
	 */

	public void declineAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will send keys alert
	 * 
	 * @param driver
	 * @param value
	 */

	public void sendKeysToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/**
	 * This method will get text from the alert
	 * 
	 * @param driver
	 * @param value
	 */

	public void getTextFromAlert(WebDriver driver, String value) {
		driver.switchTo().alert().getText();
	}

	/**
	 * This method will be used to switch from one window to second window
	 * 
	 * @param driver
	 */

	public void switchWindow(WebDriver driver) {
		String winId = driver.getWindowHandle();
		Set<String> winIds = driver.getWindowHandles();
		for (String winHandle : winIds) {
			if (!(winId.equals(winHandle))) {
				driver.switchTo().window(winHandle);
				break;
			}
		}
	}

	/**
	 * This method will be used to switch from one window to differ window
	 * 
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindow(WebDriver driver, String expectedTitle) {
		Set<String> winIds = driver.getWindowHandles();
		for (String winId : winIds) {
			driver.switchTo().window(winId);
			String actualTitle = driver.getTitle();
			if (actualTitle.toLowerCase().contains(expectedTitle.toLowerCase())) {
				break;
			}
		}
	}
	public String captureScreenShort(WebDriver driver ,String ScreenShort) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dist = new File(".\\TakeSS\\"+ScreenShort+".png");
		org.openqa.selenium.io.FileHandler.copy(src, dist);
			 
		return dist.getAbsolutePath();// for extend Reports
	}


}
