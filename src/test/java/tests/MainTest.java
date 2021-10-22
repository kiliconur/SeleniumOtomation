package tests;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import org.junit.Before;
import java.util.regex.Pattern;
import log4j.Log4j;
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
	protected static String userInformationScreen = "https://www.lcwaikiki.com/tr-TR/TR/uyelik/kisisel-bilgiler";
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
		Log4j.info("Test Başladı.");
		System.out.println("Test Başladı.");
		mainPage.login();
		loginPage.writeEmail().writePassword().submitButton();
		getWebDriver().navigate().to(userInformationScreen);
		if(Pattern.matches(userInformationScreen,webDriver.getCurrentUrl()))
		{
			Log4j.info("Login olduğumuz doğrulandı.");
			System.out.println("Login olduğumuz doğrulandı.");
		}
		else
		{
			Log4j.info("Login olduğumuz doğrulanmadı.");
			System.out.println("Login olduğumuz doğrulanmadı.");
		}
		getWebDriver().navigate().to(baseUrl);
		mainPage.search();
		searchPage.scrollDown().loadMore().clickRandom();
		productPage.price();
		price1 = productPage.getPrice();
		productPage.clickRandomSize();
		productPage.addtoCart();
		productPage.goCart();
		shoppingCartPage.price();
		price2 = shoppingCartPage.getPrice();
		boolean isEqual = Pattern.matches("\n"+price1,price2);
		if(isEqual)
		{
			Log4j.info("Ürün fiyatı Sepet fiyatı ile aynı");
			System.out.println("Ürün fiyatı Sepet fiyatı ile aynı");
		}
		else
		{
			Log4j.info("Ürün fiyatı Sepet fiyatından farklı");
			System.out.println("Ürün fiyatı Sepet fiyatından farklı");
		}	
		shoppingCartPage.addQuantitiy();
		if(shoppingCartPage.isQuantityCorrect()==true)
		{
			Log4j.info("Ürün adedinin 2 olduğu doğrudur.");
			System.out.println("Ürün adedinin 2 olduğu doğrudur.");
		}
		else
		{
			Log4j.info("Ürün adedini 2 değildir.");
			System.out.println("Ürün adedini 2 değildir.");
		}
		
		shoppingCartPage.removeCart();
		
		if(shoppingCartPage.isQuantityZero()==true)
		{
			Log4j.info("Sepetteki ürünlerin silindiği doğrulandı.");
			System.out.println("Sepetteki ürünlerin silindiği doğrulandı.");
		}
		else
		{
			Log4j.info("Sepette hala ürün var.");
			System.out.println("Sepette hala ürün var.");
		}
		
		
		

	}
	@After
	public void after()
	{
		Log4j.endLog("Test Bitti");
		System.out.println("Test Bitti");
		//tearDown();
	}
	
	
}
