package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseTest;

public class Signuppage extends BaseTest{
	WebDriver driver;

	// Constructor
	public Signuppage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//LOCATORS
	//locators For Signup page

	@FindBy(id = "nav-link-accountList")
	private WebElement signinbutton;

	@FindBy(id = "createAccountSubmit")
	private WebElement createnewaccountbtn;

	@FindBy(id = "ap_customer_name")
	private WebElement nameInput;

	@FindBy(id = "ap_phone_number")
	private WebElement phoneInput;

	@FindBy(id = "ap_password")
	private WebElement passwordInput;

	@FindBy(id = "continue")
	private WebElement continueButton;


	//Actions performed on signup page

	public void signin() {
		try {
			signinbutton.click();
			createnewaccountbtn.click();
			nameInput.click();
			nameInput.sendKeys(prop.getProperty("FnLn"));
			phoneInput.click();
			phoneInput.sendKeys(prop.getProperty("phoneno"));
			passwordInput.click();
			passwordInput.sendKeys(prop.getProperty("password"));
			continueButton.click();
			System.out.println("Signup Sucessfull with Dummy Data.....");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Signup failed with Dummy Data.....");
			e.printStackTrace();
			throw(e);
		}

	}


}
