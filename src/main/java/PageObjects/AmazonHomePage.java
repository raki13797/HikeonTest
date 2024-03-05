package PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseTest;

public class AmazonHomePage extends BaseTest{
	WebDriver driver;

	// Constructor
	public AmazonHomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//LOCATORS

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(xpath = "(//span[@id='submit.add-to-cart'])[2]")
	private WebElement addtocartcta;

	@FindBy(id = "attach-accessory-cart-total-string")
	private WebElement Carticon;

	@FindBy(id="outOfStock")
	private WebElement outofstocknoti;


	//Actions

	public void searchProduct(String productName) throws Throwable{
		try {
			searchBox.sendKeys(productName);
			searchButton.click();
			// Find all the product result elements
			List<WebElement> productResults = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

			// Check if there are any product results
			if (productResults.size() > 0) {
				System.out.println("Product results are present.");
			} else {
				System.out.println("No product results found.");
			}


			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}
	public void addtocart() {
		try {
			//Please comment line 67 based on the test Run
			//Product in stock
			driver.get(prop.getProperty("stockurl"));
			//Product out of stock
//			driver.get(prop.getProperty("outofstockurl"));

			// Check if the product is out of stock
			if (addtocartcta.isDisplayed()) {
				// Product is in stock, so add it to the cart
				addtocartcta.click();
				System.out.println("The selected product added to cart.");
			} else {
				// Product is out of stock, trigger alert
				System.out.println("Failed to add a Product to the cart");

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("The selected product is currently out of stock. We'll notify you once it's restocked.");
			e.printStackTrace();
			throw(e);
		}

	}
}
