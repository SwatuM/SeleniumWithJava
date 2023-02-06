package basicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserOperations;

import java.time.Duration;

public class Pg_HandleCheckbox extends BrowserOperations {

    static Pg_HandleCheckbox checkbox = new Pg_HandleCheckbox();

    /**
     * handling check-boxes demo.
     * @throws InterruptedException
     */
    void HandleCheckBox() throws InterruptedException {
        checkbox.LaunchBrowser_Drivers();

        try {
            WebElement elementsSection = driver.findElement(By.xpath("//div[@class='card-body']/descendant::*[text()='Elements']"));
            //scroll till element is visible
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", elementsSection);
            elementsSection.click();

            WebElement elementsHdr = driver.findElement(By.xpath("//div[@class='main-header']"));
            String hdrText = elementsHdr.getText();
            if (hdrText.equals("Elements")) {
                System.out.println("Elements page displayed.");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Elements section not found.");
        }

        WebElement checkBoxEle = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Check Box']"));
        checkBoxEle.click();

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement homeCheckBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='tree-node-home' and @type='checkbox']/parent::label/descendant::span[text()='Home']"))));
        homeCheckBox.click();
        System.out.println(homeCheckBox.isSelected());

        WebElement result = driver.findElement(By.xpath("//div[@id='result']"));
        String resultText = result.getText();
        System.out.print(resultText);
        Wait();

        homeCheckBox.click();
        System.out.println(homeCheckBox.isSelected());

        checkbox.CloseBrowser();
    }

    public static void main(String[] args) throws InterruptedException {
        checkbox.HandleCheckBox();
    }
}
