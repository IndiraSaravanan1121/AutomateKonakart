package com.konakart.Helper;

import org.testng.Assert;

/**
 * validation class
 * 
 * @author indira.saravanan
 *
 */

public class Validation extends TestBase {

	// This will compare expected and actual value equal or not
	public static void validationAssertEquals(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
			log.logReport("Expected and Actual value are Matched");
		} catch (Exception e) {
			log.logReport("Expected and Actual value are not Matched");
		}
	}
}
