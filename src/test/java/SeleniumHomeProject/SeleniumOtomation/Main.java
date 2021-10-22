package SeleniumHomeProject.SeleniumOtomation;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {

    public String baseUrl = "https://www.lcwaikiki.com/tr-TR/TR";  
    public String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";  
    public String kullaniciadi = "onur.ce.ytu@gmail.com";
    public String sifre = "projetest1";
    //static Logger log = Logger.getLogger(Main.class);

    public WebDriver driver ;   
    @Test             
    public void test() throws InterruptedException {    
    	System.out.println("a");
    // set the system property for Chrome driver      
    	PropertyConfigurator.configure("D://log4j.properties");
    	
    System.setProperty("webdriver.chrome.driver", driverPath);  
    // Create driver object for CHROME browser  
    driver = new ChromeDriver();  
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  
    driver.manage().window().maximize();  
    driver.get(baseUrl);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    // get the current URL of the page  
    //log.info(driver.getCurrentUrl().toString());   
    //get the title of the page  
    String title = driver.getTitle(); 
    //log.info("Open browserstack");
    System.out.println(title);  
    Thread.sleep(3000);
    //WebElement userSection = driver.findElement(By.linkText("Giriş Yap"));
    WebElement userName = driver.findElement(By.xpath("//input[@name='LoginEmail']"));
    //System.out.println(userName.getCssValue("LoginEmail"));
    //WebElement userName = driver.findElement(By.id("loginEmail"));
    WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
    

    userName.sendKeys(kullaniciadi);

    password.sendKeys(sifre);
    WebElement login= driver.findElement(By.id("loginLink"));
    System.out.println(login.toString());
    System.out.println(password.toString());
    //System.out.println(userSection.toString());
    login.click();
    WebElement SearchBox = driver.findElement(By.id("search_input"));
    WebElement SearchIcon = driver.findElement(By.className("searchButton"));
    SearchBox.click();
    SearchBox.sendKeys("pantolan");
    SearchIcon.click();
    Thread.sleep(3000);
    js.executeScript("window.scrollTo(0,10000)");
    WebElement loadButton = driver.findElement(By.className("lazy-load-button"));
    loadButton.click();
    Thread.sleep(2000);
    List<WebElement> randomPantalons = driver.findElements(By.className("a_model_item"));
    System.out.println(randomPantalons.size());
    int number = (int) (Math.random()*randomPantalons.size());
    System.out.println(number);
    randomPantalons.get(number).click();

    	List<WebElement> prices = driver.findElements(By.className("price"));
        String fiyat = prices.get(2).getText();
        System.out.println(prices.get(2).getText());
        //List<WebElement> bedenler = driver.findElements(By.xpath("//*[contains(@data-tracking-label,'BedenSecenekleri')]"));
        List<WebElement> bedenler = driver.findElements(By.xpath("//*[contains(@size,'') and contains(@data-tracking-label,'BedenSecenekleri')]"));
        System.out.println(bedenler.size());//input[@data-tracking-category='UrunDetay']
        //WebElement ak = driver.findElement()
        int number2 = (int) (Math.random()*(bedenler.size()/2));
        System.out.println(bedenler.get(0).getText());
        System.out.println(bedenler.get(1).getText());
        System.out.println(bedenler.get(2).getText());
        System.out.println(bedenler.get(3).getText());
        System.out.println(bedenler.get(4).getText());
        System.out.println(number2);
        bedenler.get(number2).click();
        WebElement sepeteEkle = driver.findElement(By.linkText("SEPETE EKLE"));
        sepeteEkle.click();
    
    WebElement sepetim = driver.findElement(By.xpath("//*[contains(@data-tracking-label,'Sepetim')]"));
    sepetim.click();
    Thread.sleep(1000);
    List<WebElement> cartitemId = driver.findElements(By.xpath("//*[contains(@cartitemid,'')]"));
    for(int i=0;i<cartitemId.size();i++)
    {
    String aa = cartitemId.get(i).getAttribute("cartitemid");
    System.out.println("as"+i+"aha"+cartitemId.get(i).getText());
    }
    //WebElement miktar = driver.findElement(By.className("op-up plus"));
    //miktar.click();
    //WebElement cartfiyat = driver.findElement(By.className("rd-cart-item-price mb-15"));
    //String sepetfiyat = cartfiyat.getText();
    //System.out.println(sepetfiyat);
    }     
    @BeforeTest  
    public void beforeTest() {    
    System.out.println("before test");  
    }     
    @AfterTest  
    public void afterTest() {  
      
    System.out.println("after test");  
    }         
	
}
/*package tests;
import pages.LoginPage;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
public class LoginPageTest extends TestPage {
	LoginPage loginPage;
	
	@Before
	public void before()
	{
		loginPage = new LoginPage(getWebDriver());
	}
	@Test
	public void test()
	{
		loginPage.writeEmail().writePassword().submitButton();
	}
	@After
	public void after()
	{
		//tearDown();
	}
	
	
}*/