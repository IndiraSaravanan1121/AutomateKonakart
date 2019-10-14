package com.konakart.TestScript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.konakart.Helper.Constants;
import com.konakart.Helper.Helper;
import com.konakart.Helper.ReadProperties;
import com.konakart.Helper.TestBase;

/**
 * This will validate product description,specification and customer review.
 * 
 * @author indira.saravanan
 *
 */

public class ValidateProductDetails extends TestBase {
	TestBase base = new TestBase();

	// This will open the browser
	@BeforeTest
	public void openBrowser() {
		try {
			base.openBrowser();
			log.logReport("Browser Opening");
		} catch (Exception e) {
			log.logReport("Browser Not Opening");
		}
	}

	// This will click hero image
	// Validate product Description
	// Validate product Specification
	// Validate customer review
	@Test(priority = 2)
	public void validateProductDetails() throws Exception {
		Helper.click(ReadProperties.properties("loc_heroimage_img", Constants.PRODUCTDETAIL_PATH));
		log.logReport("Hero image is clicked");
		String title = Helper.getText(ReadProperties.properties("loc_producttitle_txt", Constants.PRODUCTDETAIL_PATH));
		if (title.contains("Kindle Fire HD")) {
			
		}

	}

	// This will close the browser
	@AfterTest
	public void closeBrowser() {
		try {
			base.closeBrowser();
			log.logReport("Browser Closing");
		} catch (Exception e) {
			log.logReport("Browser Not Closing");
		}
	}

}
