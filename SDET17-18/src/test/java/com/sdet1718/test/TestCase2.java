package com.sdet1718.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdet1718.util.Baseclass;

@Listeners(com.sdet1718.util.ListenerIMP.class)
public class TestCase2 extends Baseclass{
	@Test
	public void Testcase2() {
		driver.get("https://google.com");
		System.out.println("Testcase2 exceuted");
		Assert.assertTrue(false);
	}

}
