package com.konakart.Helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.konakart.config.Constants;

/**
 * This will open and close the browser.
 * 
 * @author indira.saravanan
 *
 */

public class TestBase {

	protected static LogReport log = new LogReport();
	public static WebDriver driver;
	public static Helper helper = new Helper();
	protected static ValidationPage page = new ValidationPage();
	static WebElement element;
	public static Actions action;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	public static WebDriverWait wait;

	// To open the browser.
	@SuppressWarnings("unused")
	public void startBrowser() throws Exception {
		try {
			String browser = System.getProperty("BROWSER");
			if (browser == null) {
				if (browser != null) {
				} else {
					throw new MyException(browser + "Not Launched");
				}
			}
			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				break;
			}
			log.info(browser + " Launched");
		} catch (MyException ex) {
			log.error(ex.getMessage());
		}
		// Launch the application.
		driver.get(ReadProperties.properties("url", Constants.CONFIG_PATH));

		// To maximize the window.
		driver.manage().window().maximize();
	}

	// To close the browser.
	public void closeBrowser() {
		driver.quit();
	}

}
