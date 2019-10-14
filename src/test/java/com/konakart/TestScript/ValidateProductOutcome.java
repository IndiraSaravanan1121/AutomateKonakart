package com.konakart.TestScript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.konakart.Helper.Constants;
import com.konakart.Helper.ExcelReader;
import com.konakart.Helper.Helper;
import com.konakart.Helper.ReadProperties;
import com.konakart.Helper.TestBase;
import com.konakart.Helper.Validation;

/**
 * Validate product outcome in both positive and negative cases. Data
 * provider:To read test data from excel and pass value as parameter.
 * 
 * @author indira.saravanan
 *
 */

public class ValidateProductOutcome extends TestBase {
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

	// This will read positive test data from excel and pass value as parameter to validatePositiveOutcome.
	@DataProvider
	public Object[][] positiveValues() throws Exception {
		Object data[][] = ExcelReader.ReadWriteExcel("positivesearchcase", Constants.EXCELTESTDATA_PATH);
		return data;
	}

	// This will validate product outcome in positive case
	@Test(dataProvider = "positiveValues", priority = 0)
	public void validatePositiveOutcome(String categories, String product) throws Exception {
		Helper.selectByVisibleText(ReadProperties.properties("loc_categories_ddn", Constants.PRODUCTOUTCOME_PATH),
				categories);
		Helper.sendKeys(ReadProperties.properties("loc_searchitem_txtbox", Constants.PRODUCTOUTCOME_PATH), product);
		Helper.click(ReadProperties.properties("loc_search_btn", Constants.PRODUCTOUTCOME_PATH));
		String productTitle = Helper
				.getText(ReadProperties.properties("loc_producttitle_txt", Constants.PRODUCTOUTCOME_PATH));
		Validation.validationAssertEquals(productTitle, product);
	}

	// This will read negative test data from excel and pass value as parameter to validateNegativeOutcome.
	@DataProvider
	public Object[][] negativeValues() throws Exception {
		Object data[][] = ExcelReader.ReadWriteExcel("negativesearchcase", Constants.EXCELTESTDATA_PATH);
		return data;
	}

	// This will validate product outcome in negative case
	@Test(dataProvider = "negativeValues", priority = 1)
	public void validateNegativeOutcome(String categories, String product) throws Exception {
		Helper.selectByVisibleText(ReadProperties.properties("loc_categories_ddn", Constants.PRODUCTOUTCOME_PATH),
				categories);
		Helper.sendKeys(ReadProperties.properties("loc_searchitem_txtbox", Constants.PRODUCTOUTCOME_PATH), product);
		Helper.click(ReadProperties.properties("loc_search_btn", Constants.PRODUCTOUTCOME_PATH));
		String productTitle = Helper
				.getText(ReadProperties.properties("loc_searchresultmessage_txt", Constants.PRODUCTOUTCOME_PATH));
		Validation.validationAssertEquals(productTitle, "There are no available products.");
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