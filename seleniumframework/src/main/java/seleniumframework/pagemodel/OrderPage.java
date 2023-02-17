package seleniumframework.pagemodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstratComponents.abstractComponenets;

public class OrderPage  extends abstractComponenets{

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;

	 public Boolean toverifyorderproducts(String Productname) {
    	 Boolean match =   productNames.stream().anyMatch(productName->productName.getText().equalsIgnoreCase(Productname));
    	 return match;
   
     }
}
