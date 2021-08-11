package com.sdet1718.test;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdet1718.util.Baseclass;

@Listeners(com.sdet1718.util.ListenerIMP.class)
public class TestCase3 extends Baseclass{
	@Test
	public void Testcase3() {
		System.out.println("Testcase3 exceuted");
		throw new SkipException("Testcase 3 skipped");
	}

}
