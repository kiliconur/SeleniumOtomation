package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends PageBase 
{   
    public static String cartprice = "";
    public ShoppingCartPage(WebDriver driver) {
       super(driver);
    }
    private static final By SHOPPINGPRICE = By.className("products-area");
    private static final By QUANTITY = By.cssSelector("a[class='oq-up plus']");
    private static final By REMOVE = By.className("cart-square-link");
    private static final By CONFIRMREMOVE = By.linkText("Sil");
    private static final By QUANTITYCONTROL = By.xpath("//*[contains(@data-quantity,'2')]");
    private static final By QUANTITYZERO = By.linkText("ALIŞVERİŞE BAŞLA");
	public ShoppingCartPage price() {
    	List<WebElement> cartinfo = findElements(SHOPPINGPRICE);
    	String cartprice = cartinfo.get(cartinfo.size()-1).getText().substring(cartinfo.get(cartinfo.size()-1).getText().lastIndexOf("\n"));
    	cartprice.trim();
    	setPrice(cartprice);
    	return this;
    }
    public ShoppingCartPage addQuantitiy() {
    	click(QUANTITY);
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(REMOVE));
    	return this;
    }
    public ShoppingCartPage removeCart() {
    	click(REMOVE);
    	new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(CONFIRMREMOVE));
    	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CONFIRMREMOVE));
    	click(CONFIRMREMOVE);
    	return this;
    }
    public String getPrice()
    {
  	  return cartprice;
    }
    private static void setPrice(String cartprice)
    {
    	ShoppingCartPage.cartprice=cartprice;
    }
    public boolean isQuantityCorrect()
    {
    	try
    	{
        	if(findElements(QUANTITYCONTROL).isEmpty()==false)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    public boolean isQuantityZero()
    {
    	try
    	{
        	if(findElements(QUANTITYZERO).isEmpty()==false)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    
}