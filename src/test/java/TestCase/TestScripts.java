package TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Base.BaseTest;
import PageObjects.AmazonHomePage;
import PageObjects.Signuppage;

public class TestScripts extends BaseTest{
	WebDriver driver;
	@Test()
	public void Signupamazon() {
		Signuppage Amazon = new Signuppage(BaseTest.driver);
		Amazon.signin();
	}

	@Test
	public void Searchproduct() throws Throwable {
		AmazonHomePage product = new AmazonHomePage(BaseTest.driver);
		//change the Search Input in properties file as Required
		product.searchProduct(prop.getProperty("searchinput"));

	}

	@Test
	public void AddtoCart() throws Throwable {
		AmazonHomePage product = new AmazonHomePage(BaseTest.driver);
		product.addtocart();

	}

}
