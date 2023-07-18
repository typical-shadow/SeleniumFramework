package rahualshetty.pageboject;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahualshetty.AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".form-group input")
	WebElement CountrySelectElement;

	@FindBy(css = "section .list-group button")
	List<WebElement> CountryList;
	
	@FindBy(xpath = "//div[@class='actions']/a")
	WebElement placeOrderBtn;
	

	public void selectCountry(String CountryName) {
		CountrySelectElement.sendKeys("ind");
		for (int i = 0; i < CountryList.size() - 1; i++) {
			String country = CountryList.get(i).getText();
			if (country.equalsIgnoreCase(CountryName)) {
				CountryList.get(i).click();
			}
		}
	}

	public OrderConfirmationPage placeOrder() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		placeOrderBtn.click();		
		return new OrderConfirmationPage(driver);
	}

}
