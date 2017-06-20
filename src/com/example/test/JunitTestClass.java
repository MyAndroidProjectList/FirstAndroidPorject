package com.example.test;

import android.test.AndroidTestCase;

import com.example.service.TestService;

import junit.framework.Assert;

public class JunitTestClass extends AndroidTestCase {

	public void testSave() throws Exception{
		TestService testService = new TestService();
		testService.save(null);
	}
	public void testAdd() throws Exception{
		TestService testService = new TestService();
		int result = testService.add(3,2);
		Assert.assertEquals(5, result);
	}
}
