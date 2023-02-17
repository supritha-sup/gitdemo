package seleniumframework.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import seleniumframework.abstratComponents.abstractComponenets;

public class CheckOutPage extends abstractComponenets  {

	WebDriver driver;
	
	public  CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}   
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//section/button[2]")
	WebElement selectCountry;
	
	@FindBy(css="[class*=' action__submit']")
	WebElement submit;
	
	By result= By.cssSelector(".ta-item ");
	
	public void selectCountry(String countryname) {

        Actions a= new Actions(driver);
        a.sendKeys(country,countryname).build().perform();
        waitforelemettoappear(result);
        selectCountry.click();
        
	}
	public  ConfirmPage submitorder() {
		 submit.click();
		 return new ConfirmPage(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
