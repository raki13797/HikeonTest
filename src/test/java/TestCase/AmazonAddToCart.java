package TestCase;

	import java.util.Set;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class AmazonAddToCart {
	    public static void main(String[] args) {
	        // Set the path to ChromeDriver executable
//	        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");

	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Navigate to Amazon.com
	        driver.get("https://www.amazon.in");
	        driver.manage().deleteAllCookies();

	        // Find the search input field and enter the product name to search
	        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
	        searchInput.sendKeys("Iphone 13");

	        // Find the search button and click on it
	        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
	        searchButton.click();

	        // Click on the first product link
	        WebElement productLink = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
	        productLink.click();

	        // Switch to the new window
	        String currentWindow = driver.getWindowHandle();
	        Set<String> windows = driver.getWindowHandles();
	        for (String window : windows) {
	            if (!window.equals(currentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        // Click on the 'Add to Cart' button
	        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
	        addToCartButton.click();

	        // Close the browser
	        driver.quit();
	    }
	}


