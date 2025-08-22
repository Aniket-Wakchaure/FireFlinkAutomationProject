package ninza.CRMLeadsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepo.CampaignsPage;
import ninzaCRM.ObjectRepo.CreateCampaignsPage;
import ninzaCRM.ObjectRepo.DashBoardPage;
import ninzaCRM.genericUtilities.BaseClass;
//import ninzaCRM.genericUtilities.FileUtility;

public class LeadTest extends BaseClass {
	@Test(groups = "SmokeSuit")
	public void createCampaign() throws EncryptedDocumentException, IOException {
		DashBoardPage db=new DashBoardPage(wd);
		db.getCampaigns().click();
		CampaignsPage cp=new CampaignsPage(wd);
		cp.createCampaign();
		CreateCampaignsPage ccp=new CreateCampaignsPage(wd);
		
		 String date = fu.readDataFromExcelSheet("sheet1", 34, 0);
		 String name = fu.readDataFromExcelSheet("sheet1", 34, 1);
		 String size = fu.readDataFromExcelSheet("sheet1", 34, 5);
		 ccp.fillData(date, name, size);
		 ccp.getCreateCampaignButton().click();;
		
		
	}
	

}
