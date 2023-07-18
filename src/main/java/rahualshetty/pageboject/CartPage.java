package rahualshetty.pageboject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahualshetty.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css= ".totalRow button")
	WebElement checkoutBtn;
	
	public PaymentPage checkoutOrder() {
		checkoutBtn.click();
		return new PaymentPage(driver);
	}

	
}
