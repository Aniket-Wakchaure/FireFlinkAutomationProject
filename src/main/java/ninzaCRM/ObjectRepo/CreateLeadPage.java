package ninzaCRM.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.genericUtilities.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility {

	@FindBy(name = "leadStatus")
	private WebElement leadStatusInput;

	@FindBy(name = "name")
	private WebElement leadNameInput;

	@FindBy(name = "rating")
	private WebElement ratingInput;

	@FindBy(name = "company")
	private WebElement companyInput;

	@FindBy(name = "assignedTo")
	private WebElement assignedToInput;

	@FindBy(name = "leadSource")
	private WebElement leadSourceInput;

	@FindBy(name = "industry")
	private WebElement industryInput;

	@FindBy(name = "annualRevenue")
	private WebElement annualRevenueInput;

	@FindBy(name = "address")
	private WebElement addressInput;

	@FindBy(name = "city")
	private WebElement cityInput;

	@FindBy(name = "noOfEmployees")
	private WebElement noOfEmployeesInput;

	@FindBy(name = "country")
	private WebElement countryInput;

	@FindBy(name = "postalCode")
	private WebElement postalCodeInput;

	@FindBy(name = "phone")
	private WebElement phoneInput;

	@FindBy(name = "website")
	private WebElement websiteInput;

	@FindBy(name = "email")
	private WebElement emailInput;

	@FindBy(name = "secondaryEmail")
	private WebElement secondaryEmailInput;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionInput;

	@FindBy(xpath = "//label[contains(.,'Campaign')]//following-sibling::div//button")
	private WebElement selectCampaignBtn;

	@FindBy(xpath = "//button[contains(.,'Create')]")
	private WebElement createLeadBtn;

	@FindBy(xpath = "//h3[contains(.,'')]")
	private WebElement childPageHeading;

	// =======================Doubt========================

	@FindBy(xpath = "//select[@id='search-criteria']")
	private List<WebElement> childPageSelectDropdown;

	@FindBy(xpath = "//input[@id='search-input']")
	private WebElement childPageSerachInput;

	@FindBy(xpath = "//td[contains(.,'Select')]")
	private WebElement childPageSelectOption;

	@FindBy(xpath = "//button[@id='prev-btn']")
	private WebElement childPagePreviousBtn;

	@FindBy(xpath = "//button[@id='next-btn']")
	private WebElement childPageNextBtn;

	public CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadStatusInput() {
		return leadStatusInput;
	}

	public WebElement getLeadNameInput() {
		return leadNameInput;
	}

	public WebElement getRatingInput() {
		return ratingInput;
	}

	public WebElement getCompanyInput() {
		return companyInput;
	}

	public WebElement getAssignedToInput() {
		return assignedToInput;
	}

	public WebElement getLeadSourceInput() {
		return leadSourceInput;
	}

	public WebElement getIndustryInput() {
		return industryInput;
	}

	public WebElement getAnnualRevenueInput() {
		return annualRevenueInput;
	}

	public WebElement getAddressInput() {
		return addressInput;
	}

	public WebElement getCityInput() {
		return cityInput;
	}

	public WebElement getNoOfEmployeesInput() {
		return noOfEmployeesInput;
	}

	public WebElement getCountryInput() {
		return countryInput;
	}

	public WebElement getPostalCodeInput() {
		return postalCodeInput;
	}

	public WebElement getPhoneInput() {
		return phoneInput;
	}

	public WebElement getWebsiteInput() {
		return websiteInput;
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getSecondaryEmailInput() {
		return secondaryEmailInput;
	}

	public WebElement getDescriptionInput() {
		return descriptionInput;
	}

	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getChildPageHeading() {
		return childPageHeading;
	}

	public List<WebElement> getChildPageSelect() {
		return childPageSelectDropdown;
	}

	public WebElement getChildPageSerachInput() {
		return childPageSerachInput;
	}

	public WebElement getChildPageSelectOption() {
		return childPageSelectOption;
	}

	public WebElement getChildPagePreviousBtn() {
		return childPagePreviousBtn;
	}

	public WebElement getChildPageNextBtn() {
		return childPageNextBtn;
	}

	public void fillData(WebDriver driver, String status, String name, String rating, String company, String assignedTo,
			String source, String address, String industry, String city, String annual, String country, String num,
			String postalCode, String phone, String website, String email, String semail, String desc) {
		leadStatusInput.sendKeys(status);
		leadNameInput.sendKeys(name);
		ratingInput.sendKeys(rating);
		companyInput.sendKeys(company);
		assignedToInput.sendKeys(assignedTo);
		leadSourceInput.sendKeys(source);
		addressInput.sendKeys(address);
		industryInput.sendKeys(industry);
		cityInput.sendKeys(city);
		annualRevenueInput.sendKeys(annual);
		countryInput.sendKeys(country);
		noOfEmployeesInput.sendKeys(num);
		postalCodeInput.sendKeys(postalCode);
		phoneInput.sendKeys(phone);
		websiteInput.sendKeys(website);
		emailInput.sendKeys(email);
		secondaryEmailInput.sendKeys(semail);
		descriptionInput.sendKeys(desc);
		selectCampaignBtn.click();
		

	}

}
 