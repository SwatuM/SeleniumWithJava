package basicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserOperations;

import java.time.Duration;

public class Pg_AutoSuggestion extends BrowserOperations {
    static  Pg_AutoSuggestion object = new Pg_AutoSuggestion();

    /**
     * This methods handles drop-downs with auto-suggestion.
     * @throws InterruptedException
     */
    void Handle_AutoSuggestDropDown() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IC0N\\eclipse-workspace\\MySelenium\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement fromCity = driver.findElement(By.xpath("//label[@for='fromCity']"));
        fromCity.click();
        WebElement fromTextField = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromTextField.sendKeys("Geneva");
        Wait();
        fromTextField.sendKeys(Keys.ARROW_DOWN);
        Wait();
        fromTextField.sendKeys(Keys.ENTER);
        Wait();
        System.out.println("From city selected: " + driver.findElement(By.xpath("//input[@id='fromCity']")).getAttribute("value"));
        System.out.println("To city selected: " + driver.findElement(By.xpath("//input[@id='toCity']")).getAttribute("value"));
        object.CloseBrowser();
    }

    public static void main(String[] args) throws InterruptedException {
        object.Handle_AutoSuggestDropDown();
    }
}
