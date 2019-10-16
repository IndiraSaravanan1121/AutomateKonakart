package com.konakart.TestScript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.konakart.Helper.ExcelReader;
import com.konakart.Helper.Helper;
import com.konakart.Helper.ReadProperties;
import com.konakart.Helper.TestBase;
import com.konakart.Helper.ValidationPage;
import com.konakart.config.Constants;

/**
 * This will validate product description,specification and customer review.
 * 
 * @author indira.saravanan
 *
 */

public class ValidateProductDetails extends TestBase {

	// This will open the browser
	@BeforeTest
	public void openBrowser() throws Exception {
		startBrowser();
	}

	@DataProvider
	public Object[][] productDetails() throws Exception {
		Object data[][] = ExcelReader.ReadWriteExcel("productdetail", Constants.EXCELTESTDATA_PATH);
		return data;
	}

	// This will click hero image
	// Validate product Description
	// Validate product Specification
	// Validate customer review
	@Test(dataProvider = "productDetails")
	public void validateProductDetails(String kindleDescription, String specification, String coffeeMachineDescription)
			throws Exception {
		helper.click(ReadProperties.properties("loc_heroimage_img", Constants.PRODUCTDETAIL_PATH));
		log.info("Hero image is clicked");
		String title = helper.getText(ReadProperties.properties("loc_producttitle_txt", Constants.PRODUCTDETAIL_PATH));
		helper.scrollUp(ReadProperties.properties("loc_description_tab", Constants.PRODUCTDETAIL_PATH), "-50");
		if (title.contains("Kindle Fire HD")) {
			page.validateProductDetails(kindleDescription, specification);// This will validate KindleFireHd product
		} else {
			page.validateProductDetails(coffeeMachineDescription, specification);// This will validate CoffeeMachine
																					// product
		}
	}

	// This will close the browser
	@AfterTest
	public void closeBrowser() {
		closeBrowser();

	}
}
