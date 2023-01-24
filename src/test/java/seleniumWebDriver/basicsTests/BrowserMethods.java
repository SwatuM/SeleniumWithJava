package seleniumWebDriver.basicsTests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserOperations;

/**
 * These BrowserMethods are also known as WebDriver methods. 
 * Methods belong to WebDriver Interface but executed via ChromeDriver class.
 * @author IC0N
 *
 */
public class BrowserMethods extends BrowserOperations{
	static BrowserMethods browserMethods = new BrowserMethods();
	
	void BrowserCommands() throws InterruptedException {
		browserMethods.LaunchBrowser_Drivers();
		String URL = "https://demoqa.com/browser-windows/";
		
		driver.get(URL);
		String actualURL = driver.getCurrentUrl();
		if (URL.equals(actualURL)) {
			System.out.println("URL matched.");
			System.out.println(actualURL);
		}else {
			System.out.println("URL mismatched.");
			System.out.println(URL);
			System.out.println(actualURL);
		}
		
		String expectedTitle = "ToolsQA";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Title matched.");
			System.out.println(actualTitle);
		}else {
			System.out.println("Title mismatched.");
			System.out.println(expectedTitle);
			System.out.println(actualTitle);
		}
		System.out.println("*********************************************");
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		System.out.println("*********************************************");
		
		WebElement newTab = driver.findElement(By.id("tabButton"));
		newTab.click();
		
		System.out.println(driver.getWindowHandle());
		Set<String> winHandles = driver.getWindowHandles();
		for (Iterator iterator = winHandles.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		driver.close();
		Wait();
		
		driver.quit();
	}
	
	void BrowserNavigations() {
		browserMethods.LaunchBrowser_Drivers();
		driver.get("https://demoqa.com/");
		WebElement elements = driver.findElement(By.xpath("//div[@class='card-body']/child::h5[text()='Elements']/ancestor::div[3]"));
		elements.click();
		System.out.println(driver.getCurrentUrl());
		//navigate back
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		//navigate forward
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		//refresh
		driver.navigate().refresh();
		//navigate to new URL
		driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		browserMethods.BrowserCommands();
		browserMethods.BrowserNavigations();
	}

}
