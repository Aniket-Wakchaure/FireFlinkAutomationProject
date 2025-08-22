package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPracticeSoft {
	@Test
	public static void sampleTest() {
		//Object for Soft Assert as it has only non Static method
		
		SoftAssert sa=new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(1, 2);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertAll();
	}


}
