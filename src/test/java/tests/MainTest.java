package tests;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import org.junit.Before;

import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Test;
public class MainTest extends TestPage {
	LoginPage loginPage;
	MainPage mainPage;
	SearchPage searchPage;
	ProductPage productPage;
	ShoppingCartPage shoppingCartPage;
	private String price1 = "";
	private String price2 = "";
	@Before
	public void before()
	{
		loginPage = new LoginPage(getWebDriver());
		mainPage = new MainPage(getWebDriver());
		searchPage = new SearchPage(getWebDriver());
		productPage = new ProductPage(getWebDriver());
		shoppingCartPage = new ShoppingCartPage(getWebDriver());
	}
	@Test
	public void test()
	{
		mainPage.login();
		loginPage.writeEmail().writePassword().submitButton();
		mainPage.search();
		searchPage.scrollDown();
		searchPage.loadMore();
		searchPage.clickRandom();
		productPage.price();
		price1 = productPage.getPrice();
		productPage.clickRandomSize();
		productPage.addtoCart();
		productPage.goCart();
		shoppingCartPage.price();
		price2 = shoppingCartPage.getPrice();
		boolean isequal = Pattern.matches("\n"+price1,price2);
		shoppingCartPage.addQuantitiy();
		shoppingCartPage.removeCart();

	}
	@After
	public void after()
	{
		//tearDown();
	}
	
	
}
