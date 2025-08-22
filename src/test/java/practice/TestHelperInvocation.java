package practice;

import org.testng.annotations.Test;

public class TestHelperInvocation {
	@Test(invocationCount = 1)
	public void create() {
		System.out.println("========Create======");
	}
	@Test(invocationCount = 2)
	public void modify() {
		System.out.println("========Modify======");
	}
	@Test(invocationCount = 1)
	public void delete() {
		System.out.println("========delete======");
	}

}

