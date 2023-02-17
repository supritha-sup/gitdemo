package seleniumframework.pagemodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstratComponents.abstractComponenets;


public class CartPage extends abstractComponenets {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	  
    
     @FindBy(css=".cartSection h3")
     List<WebElement>  cartnames;
     
     @FindBy(xpath="//li/button[@type='button']")
     WebElement checkout;
     
     public Boolean toverifycartproducts(String Productname) {
    	 Boolean match =   cartnames.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(Productname));
    	 return match;
   
     }
	 public   void checkout() {
		 
		 checkout.click();
		
	 }
	
	
	
	
	
	
	
	
	
	
	
}
