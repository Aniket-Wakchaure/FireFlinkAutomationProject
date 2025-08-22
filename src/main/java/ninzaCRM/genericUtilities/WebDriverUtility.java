package ninzaCRM.genericUtilities;

import org.openqa.selenium.WebDriver;

/**
 * @author Wakchaure Aniket 
 * This class consists of generic methods releted to WebDriver
 */



public class WebDriverUtility {
//maximize minimize fullscr
	
	/**
	 * this method will maximize the window
	 */
	public void MaximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * this method will minimize the window
	 */
	public void MinimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	/**
	 * this method will FullScreen the window
	 */
	public void FullScreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
}
