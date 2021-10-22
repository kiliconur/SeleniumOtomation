package tests;

import static org.testng.Assert.assertEquals;
import log4j.Log4j;
import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
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
    	    PropertyConfigurator.configure("D://log4j.properties");
    	    Log4j.startLog("Test Başlıyor...");
    	    System.out.println("Test Başlıyor...");
    	    assertEquals(webDriver.getCurrentUrl(),baseUrl);
    	    Log4j.info("Anasayfanın açıldığı doğrulandı.");
    	    System.out.println("Anasayfanın açıldığı doğrulandı.");
    	    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	    webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
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