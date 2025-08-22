package practice;

import org.testng.annotations.Test;

public class HelperTestPriority {
	@Test(priority = 1)
	public void create() {
		System.out.println("========Create======");
	}
	@Test(priority = 3)
	public void modify() {
		System.out.println("========Modify======");
	}
	@Test(priority = 2)
	public void delete() {
		System.out.println("========delete======");
	}

}
