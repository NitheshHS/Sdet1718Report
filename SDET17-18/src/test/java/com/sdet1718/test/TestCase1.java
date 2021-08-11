package com.sdet1718.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdet1718.util.Baseclass;

@Listeners(com.sdet1718.util.ListenerIMP.class)
public class TestCase1 extends Baseclass{
	@Test
	public void Testcase1() {
		System.out.println("Testcase1 exceuted");
	}

}
