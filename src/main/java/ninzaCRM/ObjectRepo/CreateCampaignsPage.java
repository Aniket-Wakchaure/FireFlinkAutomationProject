package ninzaCRM.ObjectRepo;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CreateCampaignsPage {

	    @FindBy(name = "expectedCloseDate")
	    private WebElement dateInput;

	    @FindBy(name = "campaignName")
	    private WebElement campaignNameInput;

	    @FindBy(name = "targetAudience")
	    private WebElement targetAudienceInput;

	    @FindBy(name = "campaignStatus")
	    private WebElement campaignStatusInput;

	    @FindBy(name = "description")
	    private WebElement descriptionInput;

	    @FindBy(name = "targetSize")
	    private WebElement targetSizeInput;

	    @FindBy(xpath = "//button[contains(.,'Create')]")
	    private WebElement createCampaignButton;

	    // Constructor and initialization
	    public CreateCampaignsPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);

	    }

	    public WebElement getDateInput() {
	        return dateInput;
	    }

	    public WebElement getCampaignNameInput() {
	        return campaignNameInput;
	    }

	    public WebElement getTargetAudienceInput() {
	        return targetAudienceInput;
	    }

	    public WebElement getCampaignStatusInput() {
	        return campaignStatusInput;
	    }

	    public WebElement getDescriptionInput() {
	        return descriptionInput;
	    }

	    public WebElement getTargetSizeInput() {
	        return targetSizeInput;
	    }

	    public WebElement getCreateCampaignButton() {
	        return createCampaignButton;
	    }

	    public void fillData(String Date,String campaignname,String targetsize ) {
	    	dateInput.sendKeys(Date);
	    	campaignNameInput.sendKeys(campaignname);
	    	targetSizeInput.sendKeys(targetsize);
	        
	    }
	}


