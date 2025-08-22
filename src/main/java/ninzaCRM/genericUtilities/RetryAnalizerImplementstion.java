package ninzaCRM.genericUtilities;

import org.testng.ITestResult;
/*
 * Thos class provide for retry interface
 */
public class RetryAnalizerImplementstion {

	int count=0;
	int retrycount=3;//Manual Analysis
	public boolean retry(ITestResult result) {
		
		while(count<retrycount) {
			count++;
			return true;//retry//retry.....
		}
		return false;//Stop retry
		
	}
}
