package rahualshetty.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahualshetty.TestComponents.BaseTest;
import rahualshetty.pageboject.CartPage;
import rahualshetty.pageboject.OrderConfirmationPage;
import rahualshetty.pageboject.OrderHistory;
import rahualshetty.pageboject.PaymentPage;
import rahualshetty.pageboject.ProductCatlogue;

public class DataFlowByHashMap extends BaseTest {

	

	@Test(dataProvider = "userData", groups="PurchaseMap")
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

	
	//By Oject Creation
	@DataProvider(name="userData")
	public Object[][] getData() throws IOException {
		
		HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put("email", getGlobalProperty("userEmailid"));
		hashmap.put("password", getGlobalProperty("userPassword"));
		hashmap.put("product", getGlobalProperty("product1"));
		
		HashMap<String, String> hashmap2 = new HashMap<>();
		hashmap2.put("email", getGlobalProperty("userEmailid3"));
		hashmap2.put("password", getGlobalProperty("userPassword3"));
		hashmap2.put("product", getGlobalProperty("product3"));
		
		//By Object Creation
		return new Object[][] {{hashmap},{hashmap2}};
	}

}
