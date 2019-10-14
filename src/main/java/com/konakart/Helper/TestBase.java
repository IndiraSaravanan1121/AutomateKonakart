package com.konakart.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * This will open and close the browser.
 * 
 * @author indira.saravanan
 *
 */

public class TestBase {
	
	protected static LogReport log = new LogReport();
	public static WebDriver driver;
	
	// To open the browser.
	public void openBrowser() throws Exception {
		String browser = System.getProperty("BROWSER");
		if (browser == null) {
			browser = System.getenv("BROWSER");
			if (browser == null) {
				browser = "ie";
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
		default:
			driver = new ChromeDriver();
			break;
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
