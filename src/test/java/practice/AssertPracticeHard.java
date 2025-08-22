package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertPracticeHard {
	@Test
	public static void sampleTest() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(1, 2);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
	}

}
