package seleniumframework.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumframework.pagemodel.landingpage;
import seleniumframework.testcomponenets.BaseTest;

public class ErrorValidation extends BaseTest {

		@Test(groups="Errorhandling")
		public void SubmitOrder() throws IOException,InterruptedException {
		String productname = "ADIDAS ORIGINAL";
		landingpage landingpage = launchingApplication();
		seleniumframework.pagemodel.landingpage.loginApplication("suppunayak9@gmail.com", "Suppi@@123");
		AssertJUnit.assertEquals("Incorrect email or password.",landingpage.geterrormsg());
		
		}
}