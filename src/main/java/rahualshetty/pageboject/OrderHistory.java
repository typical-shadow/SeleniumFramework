package rahualshetty.pageboject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahualshetty.AbstractComponents.AbstractComponents;

public class OrderHistory extends AbstractComponents {

	WebDriver driver;

	public OrderHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNameList;

	public Boolean verifyProductPresent(String productName) {

//		Boolean match = productNameList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));

		for (WebElement element : productNameList) {
			String product = element.getText();
			if (productName.equalsIgnoreCase(product)) {
				return true;
			}
		}
		return false;
	}

}
