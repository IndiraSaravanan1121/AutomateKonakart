package com.konakart.TestScript;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.konakart.Helper.ReadProperties;
import com.konakart.Helper.TestBase;
import com.konakart.config.Constants;

public class saucelabs extends TestBase {

	@BeforeTest
	public void openBrowser() throws Exception {
		startBrowser();
	}

	@Test
	public void saucelabs() throws Exception {
		helper.click(ReadProperties.properties("loc_heroimage_img", Constants.SAUCE_PATH));
	      }

}
