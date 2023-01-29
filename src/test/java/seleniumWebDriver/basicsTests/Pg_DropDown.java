package seleniumWebDriver.basicsTests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.BrowserOperations;

public class Pg_DropDown extends BrowserOperations {
	static Pg_DropDown dropDown = new Pg_DropDown();
	
	/**
	 * For select type drop-down.
	 * @throws InterruptedException
	 */
	void DropDown_SelectType() throws InterruptedException {
		dropDown.LaunchBrowser_Drivers();
		
		try {
			WebElement widgetsSection = driver.findElement(By.xpath("//div[@class='card-body']/descendant::*[text()='Widgets']"));
			//scroll till element is visible
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", widgetsSection);
			widgetsSection.click();
			
			WebElement widgetsHdr = driver.findElement(By.xpath("//div[@class='main-header']"));
			String hdrText = widgetsHdr.getText();
			if (hdrText.equals("Widgets")) {
				System.out.println("Widgets page displayed.");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Widgets section not found.");
		}
		
		WebElement selectMenu = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Select Menu']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", selectMenu);
		selectMenu.click();
		
		WebElement selectDDown = driver.findElement(By.id("oldSelectMenu"));
		js.executeScript("arguments[0].scrollIntoView();", selectDDown);
		
		Select select = new Select(selectDDown);
		System.out.println("First selected option: "+select.getFirstSelectedOption().getText());
		
		select.selectByIndex(1);
		select.selectByValue("6");
		select.selectByVisibleText("Magenta");
		Wait();
		
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for (WebElement webElement : selectedOptions) {
			System.out.println(webElement.getText());
		}
		
		driver.close();
	}
	
	void DropDown_Multiselect() throws InterruptedException {
		dropDown.LaunchBrowser_Drivers();
		
		try {
			WebElement widgetsSection = driver.findElement(By.xpath("//div[@class='card-body']/descendant::*[text()='Widgets']"));
			//scroll till element is visible
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", widgetsSection);
			widgetsSection.click();
			
			WebElement widgetsHdr = driver.findElement(By.xpath("//div[@class='main-header']"));
			String hdrText = widgetsHdr.getText();
			if (hdrText.equals("Widgets")) {
				System.out.println("Widgets page displayed.");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Widgets section not found.");
		}
		
		WebElement selectMenu = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Select Menu']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", selectMenu);
		selectMenu.click();
		
		WebElement multiSelect_DD = driver.findElement(By.name("cars"));
		js.executeScript("arguments[0].scrollIntoView();", multiSelect_DD);
		Select select = new Select(multiSelect_DD);
		select.selectByIndex(0);
		select.selectByValue("opel");
		select.selectByVisibleText("Audi");
		List<WebElement> selecteddOptions = select.getAllSelectedOptions();
		for (Iterator iterator = selecteddOptions.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());
		}
		System.out.println("Total selected options: "+selecteddOptions.size());
		Wait();
		select.deselectAll();
		Wait();
		dropDown.CloseBrowser();
 	}
	
	public static void main(String[] args) throws InterruptedException{
		dropDown.DropDown_SelectType();
		dropDown.DropDown_Multiselect();
	}

}
