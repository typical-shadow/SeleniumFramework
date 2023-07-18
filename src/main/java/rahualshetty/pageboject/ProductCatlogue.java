package rahualshetty.pageboject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahualshetty.AbstractComponents.AbstractComponents;

public class ProductCatlogue extends AbstractComponents {

	
	//ZARA COAT 3, IPHONE 13 PRO
	
	WebDriver driver;

	public ProductCatlogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "mb-3")
	List<WebElement> productList;
	
	@FindBy(css = ".ng-animating")
	WebElement spinnerElement;
	
	
	By productContainer = By.className("mb-3");

	By prodElement = By.tagName("b");

	By addToCartBtn = By.cssSelector("button:last-of-type");
	
	By toastContainer = By.cssSelector("#toast-container");

	public void addProductToCart(String product) {
		waitForElementAppear(productContainer);
		searchProduct(product);
	}

	private void searchProduct(String product) {
		for (WebElement element : productList) {
			String productName = element.findElement(prodElement).getText();
			if (productName.equalsIgnoreCase(product)) {
				element.findElement(addToCartBtn).click();
			}
		}
	}

	public void waitForSpinner() {
		waitForElementAppear(toastContainer);
		waitForElemntDisappear(spinnerElement);		
	}

	public CartPage clickOnCart() {
		cartLinkHome();
		return new CartPage(driver);
	}

}
