package rahualshetty.pageboject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahualshetty.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[type='email']")
	WebElement emailInput;
	
	@FindBy(id = "userPassword")
	WebElement passwordInput;
	
	@FindBy(id = "login")
	WebElement loginBtn;
	
	@FindBy(css = "div[class*='flyInOut']")
	WebElement loginError;
	
	public void goTo(String url) {
		driver.get(url);
	}

	public ProductCatlogue loginInfo(String username, String password) {
		emailInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginBtn.click();
		return new ProductCatlogue(driver);
	}
	
	public String loginErrorvalidation() {
		return loginError.getText();
		
	}
	
	
	
}
