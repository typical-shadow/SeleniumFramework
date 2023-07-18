package rahualshetty.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//		driver.get("https://rahulshettyacademy.com/client");
//		//sparrow@gmail.com / Javed@1234
//		
//		//Login page
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("sparrow@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Javed@1234");
//		driver.findElement(By.id("login")).click();
//		//Explicit Wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("mb-3")));
//		List<WebElement> productList = driver.findElements(By.className("mb-3"));
//
//		//ZARA COAT 3, IPHONE 13 PRO
//		
//		for(WebElement element : productList) {
//			
//			String productName = element.findElement(By.tagName("b")).getText();
//			if(productName.equalsIgnoreCase("IPHONE 13 PRO")) {
//				element.findElement(By.cssSelector("button:last-of-type")).click();
//			}
//			
//		}
//		
//		
//		
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
//		String productAddedMessage = driver.findElement(By.id("toast-container")).getText();
//		System.out.println(productAddedMessage);
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		
//		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
//		
//		
//		//Cart page
//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
//		List<WebElement> CountryList =  driver.findElements(By.cssSelector("section .list-group button"));
//		
//		String CountryName = "India";
//		for(int i = 0; i< CountryList.size() - 1; i++) {
//			String country = CountryList.get(i).getText();
//			if(country.equalsIgnoreCase(CountryName)) {
//				CountryList.get(i).click();
//			}
//		}
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,200)");
//		driver.findElement(By.xpath("//div[@class='actions']/a")).click();
//		String confirmationMessage = "Thankyou for the order.";
//		Assert.assertEquals(confirmationMessage.toUpperCase(), driver.findElement(By.className("hero-primary")).getText());
		

	}

}
