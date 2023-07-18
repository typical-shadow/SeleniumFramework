package rahualshetty.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahualshetty.pageboject.OrderHistory;

public class AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartLink;
	
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement orderHistoryElement;
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	}
	
	public void waitForElemntDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void cartLinkHome() {
		cartLink.click();
	}
	
	public OrderHistory orderHistoryHeader() {
		orderHistoryElement.click();
		return new OrderHistory(driver);
		
	}
	
}
