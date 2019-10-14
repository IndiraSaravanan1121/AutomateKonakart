package com.konakart.Helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Helper class
 * 
 * @author indira.saravanan
 *
 */

public class Helper extends TestBase {

	static WebElement element;
	static Actions action = new Actions(driver);
	static JavascriptExecutor js = (JavascriptExecutor) driver;

	// This will find element by locator type
	public static WebElement matchLocator(String locatorType) {

		String[] locator = locatorType.split(":");

		switch (locator[0]) {
		case "id":
			element = driver.findElement(By.id(locator[1]));
			break;
		case "name":
			element = driver.findElement(By.name(locator[1]));
			break;
		case "className":
			element = driver.findElement(By.className(locator[1]));
			break;
		case "linkText":
			element = driver.findElement(By.linkText(locator[1]));
			break;
		case "partialLinkText":
			element = driver.findElement(By.partialLinkText(locator[1]));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(locator[1]));
			break;
		case "cssSelector":
			element = driver.findElement(By.cssSelector(locator[1]));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locator[1]));
			break;

		}
		return element;
	}

	// This will click
	public static void click(String webElement) {
		try {
			element = matchLocator(webElement);
			element.click();
		} catch (Exception e) {
			log.logReport("Element not clicked");
		}
	}

	// This will get text
	public static String getText(String webElement) {
		try {
			element = matchLocator(webElement);
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}
		return element.getText();
	}

	// This will send value.
	public static void sendKeys(String webElement, String value) {
		try {
			element = matchLocator(webElement);
			element.sendKeys(value);
		} catch (Exception e) {
			log.logReport("Value not sended");
		}
	}

	// This will mouse over to web element
	public static void mouseOver(String webElement) {
		try {
			element = matchLocator(webElement);
			action.moveToElement(element);
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}
	}
	
	// This will check specified element present or not
	public static void isDisplayed(String webElement) {
		try {
			element = matchLocator(webElement);
			element.isDisplayed();
			log.logReport("Element Is Dispalyed");
		} catch (Exception e) {
			log.logReport("Element Not Dispalyed");
		}
	}
	
	// This will check check box is checked or not
	public static void isSelected(String webElement) {
		try {
			element = matchLocator(webElement);
			element.isSelected();
			log.logReport("Element Is Selected");
		} catch (Exception e) {
			log.logReport("Element Not Selected");
		}
	}
	
	// This will check specified element is enable or not
	public static void isEnabled(String webElement) {
		try {
			element = matchLocator(webElement);
			element.isEnabled();
			log.logReport("Element Is Enabled");
		} catch (Exception e) {
			log.logReport("Element Not Enabled");
		}
	}
	// javascriptexecutor
	// This will scroll down the page by pixel vertical
	public static void scrollDown(String webElement, String pixel) {
		try {
			element = matchLocator(webElement);
			js.executeScript("window.scrollBy(0,pixel)");
		} catch (Exception e) {
			log.logReport("Element Not Found,Unable to scroll");
		}
	}

	// This will scroll up the page by pixel vertical
	public static void scrollUp(String webElement, String pixel) {
		try {
			element = matchLocator(webElement);
			js.executeScript("window.scrollBy(0,-pixel)");
		} catch (Exception e) {
			log.logReport("Element Not Found,Unable to scroll");
		}
	}

	// This will scroll left the page by pixel vertical
	public static void scrollLeft(String WebElement, String pixel) {
		try {
			js.executeScript("window.scrollBy(pixel,0)");
		} catch (Exception e) {
			log.logReport("Element Not Found,Unable to scroll");
		}
	}

	// This will scroll right the page by pixel vertical
	public static void scrollRight(String webElement, String pixel) {
		try {
			js.executeScript("window.scrollBy(-pixel,0)");
		} catch (Exception e) {
			log.logReport("Element Not Found,Unable to scroll");
		}
	}

	// This will scroll the specified element into visible area
	public static void scrollIntoView(String webElement) {
		try {
			element = matchLocator(webElement);
			js.executeScript("arguments[0].scrollIntoView()");
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}
	}

	// This will wait certain amount time
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	// This will click specified element in pop-up menu.
	public static void contextClick(String webElement) {
		try {
			element = matchLocator(webElement);
			action.contextClick(element).perform();
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}
	}

	// This will right click the element
	public static void doubleClick(String webElement) {
		try {
			element = matchLocator(webElement);
			action.doubleClick(element).perform();
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}
	}

	// This will press enter key
	public static void pressEnter(String webElement) {
		try {
			element = matchLocator(webElement);
			element.sendKeys(Keys.ENTER);
			log.logReport("Enter is Clicked");
		} catch (Exception e) {
			log.logReport("Enter Not Clicked");
		}
	}

	// This will press Tab key
	public static void pressTab(String webElement) {
		try {
			element = matchLocator(webElement);
			element.sendKeys(Keys.TAB);
			log.logReport("Tab is Clicked");
		} catch (Exception e) {
			log.logReport("Tab Not Found");
		}
	}

	// This will select element by index
	public static void selectByIndex(String webElement,int index) {
		try {
			element = matchLocator(webElement);
			Select select = new Select(element);
			select.selectByIndex(index);
			log.logReport(index+" is Clicked");
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}		
	}
	
	// This will select element by value
	public static void selectByValue(String webElement,String value) {
		try {
			element = matchLocator(webElement);
			Select select = new Select(element);
			select.selectByValue(value);
			log.logReport(value+" is Clicked");
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}		
	}
	
	// This will select element by visible text
	public static void selectByVisibleText(String webElement,String visibleText) {
		try {
			element = matchLocator(webElement);
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
			log.logReport(visibleText+" is Clicked");
		} catch (Exception e) {
			log.logReport("Element Not Found");
		}		
	}
}

