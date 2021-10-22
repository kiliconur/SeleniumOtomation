package tests;

import java.time.Duration;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class TestPage {
      protected static WebDriver webDriver =null;
      protected static String ChromePath = "C:\\chromedriver_win32\\chromedriver.exe";
      protected static String baseUrl = "https://www.lcwaikiki.com/tr-TR/TR";
      
      @Before
      public void Setup(){
    	    System.setProperty("webdriver.chrome.driver", ChromePath);  
    	    ChromeOptions options = new ChromeOptions();
    	    options.addArguments("start-maximized");
    	    options.addArguments("enable-notifications");
    	    options.addArguments("enable-popup-blocking");
    	    setWebDriver(new ChromeDriver(options));
    	    getWebDriver().navigate().to(baseUrl); 
    	    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  
       }
      public static WebDriver getWebDriver()
      {
    	  return webDriver;
      }
      public static void setWebDriver(WebDriver webDriver)
      {
    	  TestPage.webDriver=webDriver;
      }
      public void tearDown()
      {
    	  getWebDriver().quit();
      }
}