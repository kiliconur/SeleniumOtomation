package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends PageBase 
{   
    public LoginPage(WebDriver driver) {
       super(driver);
    }
	public static final By EMAIL = By.xpath("//input[@name='LoginEmail']");
	public static final By PASSWORD = By.xpath("//input[@name='Password']");
	public static final By SUBMIT = By.id("loginLink");

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