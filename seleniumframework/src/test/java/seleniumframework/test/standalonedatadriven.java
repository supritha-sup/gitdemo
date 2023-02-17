package seleniumframework.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumframework.pagemodel.CartPage;
import seleniumframework.pagemodel.CheckOutPage;
import seleniumframework.pagemodel.ConfirmPage;
import seleniumframework.pagemodel.OrderPage;
import seleniumframework.pagemodel.landingpage;
import seleniumframework.pagemodel.productCatalague;
import seleniumframework.testcomponenets.BaseTest;

public class standalonedatadriven extends BaseTest {
	//String productname = "ADIDAS ORIGINAL";
	
		@Test(dataProvider="getData",groups={"purchase"})
		public void SubmitOrder(String email,String passward,String productname) throws IOException,InterruptedException {
		landingpage landingpage = launchingApplication();
		productCatalague productCatalague = seleniumframework.pagemodel.landingpage.loginApplication(email, passward);
		List<WebElement> products = productCatalague.getproductlists();
		productCatalague.addproducttocart(productname);
		productCatalague.gotocart();
		CartPage cartpage = new CartPage(driver);
		Boolean match = cartpage.toverifycartproducts(productname);
		Assert.assertTrue(match);
		cartpage.checkout();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.selectCountry("india");
		ConfirmPage confirmpage = checkoutpage.submitorder();
		String confirm = confirmpage.getconfirmmessage();

		Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

	}



		@Test(dependsOnMethods= {"SubmitOrder"})
		public void orderHistoryTest(String productname) {
			productCatalague productCatalague = landingpage.loginApplication("suppunayak9@gmail.com", "Suppi@123");
			OrderPage orderpage = productCatalague.gotoOrderPage();
			Assert.assertTrue(orderpage.toverifyorderproducts(productname));
		}
	
	@DataProvider
	public  Object[][] getData() {
		
		return new Object[][] { {"suppunayak9@gmail.com", "Suppi@123","ADIDAS ORIGINAL"},{"suprith.ssk@gmail.com", "Gunda@123","ADIDAS ORIGINAL"} };
	}
}
