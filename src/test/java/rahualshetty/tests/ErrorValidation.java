package rahualshetty.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahualshetty.TestComponents.BaseTest;
import rahualshetty.pageboject.ProductCatlogue;


public class ErrorValidation extends BaseTest{

	@Test(groups = {"ErrorValidationGroup"})
	public void loginErrorValidation() throws IOException{

				
		//Login Page
		ProductCatlogue productList = loginPage.loginInfo(getGlobalProperty("userEmailid2"), getGlobalProperty("userPassword2"));
						
		//Login Error Message Validation
		Assert.assertEquals("Incorrect email orpassword.", loginPage.loginErrorvalidation());
		

	}

}
