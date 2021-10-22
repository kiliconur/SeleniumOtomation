package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PageBase {     
	 WebDriver driver = null;
     WebDriverWait wait = null;
     public PageBase (WebDriver driver){
         this.driver = driver;
         this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
     }
     public WebElement findElement (By by) {
         wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
         return driver.findElement(by);
     }
     public List<WebElement> findElements (By by) {
         wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
         return driver.findElements(by);
     }
     public void click (By by) {
         wait.until(ExpectedConditions.elementToBeClickable(by));
         findElement(by).click();
     }
     public void click (WebElement wb) {
         wait.until(ExpectedConditions.elementToBeClickable(wb));
         wb.click();
     }
     public void sendKeys (By by, String text) {
         findElement(by).sendKeys(text);
     }
     public void sendKeys (WebElement wb, String text) {
         wb.sendKeys(text);
     }
     public String getText(By by){
    	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    	 return findElement(by).getText();
     }
     public WebElement randomElement(By by) {
    	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    	 int random = (int) (Math.random()*driver.findElements(by).size());
    	 return driver.findElements(by).get(random);
     }
     public WebElement randomSizeElement(By by) {
    	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    	 int random = (int) (Math.random()*(driver.findElements(by).size()/2));
    	 return driver.findElements(by).get(random);
     }
}