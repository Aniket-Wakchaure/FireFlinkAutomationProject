package ninza.CRMCampaignsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.slf4j.helpers.Reporter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepo.CampaignsPage;
import ninzaCRM.ObjectRepo.CreateCampaignsPage;
import ninzaCRM.ObjectRepo.DashBoardPage;
import ninzaCRM.genericUtilities.BaseClass;
import ninzaCRM.genericUtilities.ListenersImplimentation;

//import ninzaCRM.genericUtilities.FileUtility;
@Listeners(ListenersImplimentation.class)

public class CampaignsTest extends BaseClass {
	@Test(groups = "SmokeSuit")

	public void createCampaign() throws EncryptedDocumentException, IOException {
		DashBoardPage db = new DashBoardPage(wd);
		db.getCampaigns().click();
		//this reporter will print this in report
		org.testng.Reporter.log("Clicked on DashBoard",true);
		CampaignsPage cp = new CampaignsPage(wd);
		cp.createCampaign();
		CreateCampaignsPage ccp = new CreateCampaignsPage(wd);

		String date = fu.readDataFromExcelSheet("sheet1", 34, 0);
		String name = fu.readDataFromExcelSheet("sheet1", 34, 1);
		//Assert.fail();
		String size = fu.readDataFromExcelSheet("sheet1", 34, 5);
		ccp.fillData(date, name, size);
		ccp.getCreateCampaignButton().click();
		

	}

}
