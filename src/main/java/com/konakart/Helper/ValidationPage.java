package com.konakart.Helper;

public class ValidationPage extends TestBase {
	
	public void validateProductDetails(String expectedDescription, String expectedSpecification) throws Exception {
		String description = helper
				.getText(ReadProperties.properties("loc_description_txt", Constants.PRODUCTDETAIL_PATH));
		System.out.println("" + description);
		Validation.validationAssertEquals(description, expectedDescription);
		log.logReport("Description validated");
		helper.explicitWaitToVisible(ReadProperties.properties("loc_specification_tab", Constants.PRODUCTDETAIL_PATH));
		helper.explicitWaitToClick(ReadProperties.properties("loc_specification_tab", Constants.PRODUCTDETAIL_PATH));
		helper.click(ReadProperties.properties("loc_specification_tab", Constants.PRODUCTDETAIL_PATH));
		String specification=helper.getText(ReadProperties.properties("loc_specification_txt", Constants.PRODUCTDETAIL_PATH));
		Validation.validationAssertEquals(specification, expectedSpecification);
		log.logReport("Specification validated");	
		helper.click(ReadProperties.properties("loc_customerreview_tab", Constants.PRODUCTDETAIL_PATH));
		
	}
}
