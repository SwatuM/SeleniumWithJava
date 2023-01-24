package seleniumWebDriver.basicsTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.BrowserOperations;

public class HandleDropDown extends BrowserOperations {
	static HandleDropDown dropDown = new HandleDropDown();
	
	/**
	 * For select type drop-down.
	 * @throws InterruptedException
	 */
	void DropDown_SelectType() throws InterruptedException {
		dropDown.LaunchBrowser_Drivers();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		
		WebElement ddown = driver.findElement(By.name("awareness_source_c"));
		Select select = new Select(ddown);
		
		System.out.println("**********************************************");
		System.out.println(select.getFirstSelectedOption().getText());
		System.out.println("**********************************************");
		
		select.selectByValue("Event");
		Thread.sleep(2000);
		
		select.selectByIndex(2);
		Thread.sleep(2000);
		
		select.selectByVisibleText("YouTube");
		Thread.sleep(2000);
		System.out.println("**********************************************");
		
		List<WebElement> dDownOptionsElements = select.getOptions();
		for (WebElement dd : dDownOptionsElements) {
			System.out.println(dd.getText());
		}
		System.out.println("**********************************************");
		
		driver.close();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException{
		dropDown.DropDown_SelectType();
		
	}

}
