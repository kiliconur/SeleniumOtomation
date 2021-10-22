package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends PageBase 
{   
    public LoginPage(WebDriver driver) {
       super(driver);
    }
	private static final By EMAIL = By.xpath("//input[@name='LoginEmail']");
	private static final By PASSWORD = By.xpath("//input[@name='Password']");
	private static final By SUBMIT = By.id("loginLink");

    public LoginPage writeEmail() {
    	
    sendKeys(EMAIL,"onur.ce.ytu@gmail.com");     return this;
    }
    public LoginPage writePassword() {
    	
    sendKeys(PASSWORD,"projetest1");     return this;
    }
    public LoginPage submitButton() {
    	click(SUBMIT); return this;
    }

}