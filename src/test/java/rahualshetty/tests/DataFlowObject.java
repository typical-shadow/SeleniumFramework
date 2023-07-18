package rahualshetty.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahualshetty.TestComponents.BaseTest;
import rahualshetty.pageboject.CartPage;
import rahualshetty.pageboject.OrderConfirmationPage;
import rahualshetty.pageboject.OrderHistory;
import rahualshetty.pageboject.PaymentPage;
import rahualshetty.pageboject.ProductCatlogue;

public class DataFlowObject extends BaseTest {

	

	@Test(dataProvider = "userData", groups="Purchase")
	public void orderPlaceComplete(String userEmailid, String userPassword, String productName) throws IOException {

		// Login Page
		ProductCatlogue productList = loginPage.loginInfo(userEmailid,userPassword);

		// Product Page
		productList.addProductToCart(productName);
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
		
		
		//By Object Creation
		return new Object[][] {{getGlobalProperty("userEmailid"),getGlobalProperty("userPassword"),getGlobalProperty("product1")},
			{getGlobalProperty("userEmailid3"),getGlobalProperty("userPassword3"),getGlobalProperty("product3")}};
	}

}
