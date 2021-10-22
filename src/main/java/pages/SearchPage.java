package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase 
{   
	
    public SearchPage(WebDriver driver) {
       super(driver);
    }
	public static final By LOADMORE = By.className("lazy-load-button");
	public static final By RANDOM = By.className("a_model_item");
	JavascriptExecutor js = (JavascriptExecutor) driver;

    public SearchPage scrollDown() {
    	js.executeScript("window.scrollTo(0,20000)");
    	return this;
    }
    public SearchPage loadMore() {
    	click(LOADMORE);
    	return this;
    }
    public SearchPage clickRandom() {
    	click(randomElement(RANDOM));
    	return this;
    }
    
}