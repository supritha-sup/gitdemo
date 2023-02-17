package seleniumframework.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstratComponents.abstractComponenets;

public class landingpage extends abstractComponenets{

	static WebDriver driver;
	
	public landingpage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	static
	WebElement userEmail;
			
	@FindBy(id="userPassword")
	static
	WebElement userPassword;
	
	@FindBy(id="login")
	static
	WebElement login;
	

	@FindBy(css="[class*='FlyInOut']")
	WebElement errormsg;
	
	public static productCatalague loginApplication(String email,String passward) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(passward);
		login.click();
		return new productCatalague(driver);
		}
	public  WebElement geterrormsg() {
		waitforwebelemettoappear(errormsg);
		errormsg.getText();
		return errormsg;
	}
	public void goTo() {
		 driver.get("https://rahulshettyacademy.com/client");
	}
}

