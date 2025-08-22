package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHelperDependsOn {
	@Test
	public void create() {
		Assert.fail();
		System.out.println("====Create====");
	}
	@Test(dependsOnMethods = "create")
	public void delete() {
		System.out.println("====Delete====");
	}

}
