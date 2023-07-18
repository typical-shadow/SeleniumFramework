package rahualshetty.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahualshetty.TestComponents.BaseTest;
import rahualshetty.pageboject.CartPage;
import rahualshetty.pageboject.OrderConfirmationPage;
import rahualshetty.pageboject.OrderHistory;
import rahualshetty.pageboject.PaymentPage;
import rahualshetty.pageboject.ProductCatlogue;

public class PlaceOrderFlow extends BaseTest {

	

	@Test(dataProvider = "userData", groups="Purchase")
	public void orderPlaceComplete(HashMap<String, String> map) throws IOException {

		// Login Page
		ProductCatlogue productList = loginPage.loginInfo(map.get("email"),map.get("password"));

		// Product Page
		productList.addProductToCart(map.get("product"));
		productList.waitForSpinner();
		CartPage cartPage = productList.clickOnCart();

		// Cart Page
		PaymentPage paymentPage = cartPage.checkoutOrder();

		// Payment Page
		paymentPage.selectCountry(getGlobalProperty("country"));
		OrderConfirmationPage confirmationPage = paymentPage.placeOrder();

		// OrderConfirmation Page
		Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmationPage.orderMessage());

	}

	@Test(dependsOnMethods = "orderPlaceComplete")
	public void orderHistory() throws IOException {
		// Login Page
		ProductCatlogue productList = loginPage.loginInfo(getGlobalProperty("userEmailid"),
				getGlobalProperty("userPassword"));
		OrderHistory orderHistory = productList.orderHistoryHeader();
		orderHistory.verifyProductPresent(getGlobalProperty("product1"));
		
	}
	
	//By JsonData
	@DataProvider(name="userData")
	public Object[][] getData() throws IOException {
				
		//By Json Data
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") +"\\src\\test\\java\\rahualshettty\\data\\PurchaseOrderr.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	


}
