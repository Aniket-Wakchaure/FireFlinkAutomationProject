package ninzaCRM.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*
 * This class give implementation for the ITestListener Interface
 * author-Aniket
 */

public class ListenersImplimentation  implements ITestListener{

	JavaUtility j=new JavaUtility();
	ExtentReports report;
	ExtentTest test; 
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("========Suit Execution Started===========");
		        //To  creaete Advanse Repotrt
				//Extend Report Cofiguration
				ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentsReport\\"+j.getsystemDate()+".html");
			    esr.config().setTheme(Theme.DARK);
		        esr.config().setDocumentTitle("Ninza CRM");
		        esr.config().setReportName("Web Automation Execution Report");

		        report = new ExtentReports();
		        report.attachReporter(esr);
		        report.setSystemInfo("Base Browser", "Microsoft Edge");
		        report.setSystemInfo("Base Platform", "Windows");
		        report.setSystemInfo("Base URL", "Test Environment");
		        report.setSystemInfo("Reporter Name", "Aniket");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("========@Test Execution Started===========");
		//Intimate extent reports for @Test start
				test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("========@Test Execution Successfull===========");
		//Log the status OF @Test as PASS in extent report
				test.log(Status.PASS, methodName+"------Test Execution PASS------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("========@Test Execution Fail===========");
		

		//Log the status as Fail in Extent reports
				test.log(Status.FAIL, methodName+"------Test Execution FAIL------");
		
		//Capture the exeption
		System.out.println(result.getThrowable());
		//Log the exception in extent reports
				test.log(Status.WARNING, result.getThrowable());
				
		
		//capture the  Screenshot
		SeleniumUtility s=new SeleniumUtility();
		//ss name -method name +dfate and time
		String ScreenShort =methodName+j.getsystemDate();
		
		try {
          String path = s.captureScreenShort(BaseClass.sdriver, ScreenShort);
			//Attach screenshot to report
			test.addScreenCaptureFromPath(path);
			s.captureScreenShort(BaseClass.sdriver, ScreenShort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("========@Test Execution Skipped===========");
		//Capture the exeption
				System.out.println(result.getThrowable());
				//Log the SKIP status
				test.log(Status.SKIP, methodName+"------Test Execution SKIP------");
				
				//Capture the Exception
				System.out.println(result.getThrowable());
				
				//log the exception
				test.log(Status.WARNING, result.getThrowable());
	}


	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("========Suit Execution Ended===========");
		
		//Report Generation
		//so That this method will tell All the execution is completed flush
		report.flush();
		
		
		
	}	
	
	
	
}
