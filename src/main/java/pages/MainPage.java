package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageBase 
{   
	
    public MainPage(WebDriver driver) {
       super(driver);
    }
    private static final By LOGIN = By.linkText("Giriş Yap");
    private static final By SEARCHWORD = By.id("search_input");
    private static final By SEARCH = By.className("searchButton");
    public MainPage login() {
    	
    click(LOGIN);     return this;
    }
    public MainPage search() {
    	click(SEARCHWORD);
    	sendKeys(SEARCHWORD,"pantolan");
    	click(SEARCH);
    	
    	return this;
    }
    
}