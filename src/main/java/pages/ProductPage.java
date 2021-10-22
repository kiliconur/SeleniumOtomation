package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends PageBase 
{   
	public static String initialprice = "";
    public ProductPage(WebDriver driver) {
       super(driver);
    }
    private static final By RANDOMSIZE = By.xpath("//*[contains(@size,'') and contains(@data-tracking-label,'BedenSecenekleri')]");
    private static final By ADDCART = By.linkText("SEPETE EKLE");
    private static final By GOCART = By.xpath("//*[contains(@data-tracking-label,'Sepetim')]");
    private static final By PRICE = By.className("price");
	
    public ProductPage price() {
    	List<WebElement> price = findElements(PRICE);
    	initialprice = price.get(price.size()-1).getText();
    	setPrice(initialprice);
    	return this;
    }
	public ProductPage clickRandomSize() {
    	click(randomSizeElement(RANDOMSIZE));
    	
    	return this;
    }
    public ProductPage addtoCart() {
    	click(ADDCART);
    	
    	return this;
    }
    public ProductPage goCart() {
    	click(GOCART);
    	
    	return this;
    }
    public String getPrice()
    {
  	  return initialprice;
    }
    private static void setPrice(String initialprice)
    {
  	  ProductPage.initialprice=initialprice;
    }
    
}