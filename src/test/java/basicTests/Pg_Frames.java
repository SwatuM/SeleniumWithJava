package basicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.BrowserOperations;

import java.util.List;

public class Pg_Frames extends BrowserOperations {
    static Pg_Frames objFW = new Pg_Frames();
    static JavascriptExecutor js;
    public static void SwitchToFrame(int frameNum){
        String frameXpath = "//div[@id='framesWrapper']/div[@id='frame"+frameNum+"Wrapper']/iframe";
        WebElement frameToBeSwitched = driver.findElement(By.xpath(frameXpath));
        js.executeScript("arguments[0].scrollIntoView();", frameToBeSwitched);
        //using frame web-element
        //driver.switchTo().frame(frameToBeSwitched);
        //using frame index. index starts with 0
        //driver.switchTo().frame(frameNum-1);
        //using frame id/name
        driver.switchTo().frame("frame"+frameNum);
        System.out.println("Frame switched.");
    }
    void HandleFrames(){
        objFW.LaunchBrowser_Drivers();
        js = (JavascriptExecutor) driver;
        try {
            WebElement framesAndWindowsSection = driver.findElement(By.xpath("//div[@class='card-body']/descendant::*[text()='Alerts, Frame & Windows']"));
            //scroll till element is visible
            js.executeScript("arguments[0].scrollIntoView();", framesAndWindowsSection);
            framesAndWindowsSection.click();

            WebElement elementsHdr = driver.findElement(By.xpath("//div[@class='main-header']"));
            String hdrText = elementsHdr.getText();
            if (hdrText.equals("Alerts, Frame & Windows")) {
                System.out.println("Alerts, Frame & Windows page displayed.");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Alerts, Frame & Windows section not found.");
        }

        WebElement framesEle = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Frames']"));
        js.executeScript("arguments[0].scrollIntoView();", framesEle);
        framesEle.click();

        WebElement frames = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Frames']"));
        js.executeScript("arguments[0].scrollIntoView();", frames);
        frames.click();

        List<WebElement> framesList = driver.findElements(By.xpath("//iframe"));
        System.out.println("Total frames in webpage: " + framesList.size());

        SwitchToFrame(1);
        WebElement heading1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(heading1.getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());

        SwitchToFrame(2);
        WebElement heading2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(heading2.getText());

        objFW.CloseBrowser();
    }
    public static void main(String[] args) {
        objFW.HandleFrames();
    }
}
