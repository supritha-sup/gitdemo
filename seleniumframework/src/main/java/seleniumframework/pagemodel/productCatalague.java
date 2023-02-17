package seleniumframework.pagemodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstratComponents.abstractComponenets;

public class productCatalague extends abstractComponenets {

WebDriver driver;
	
	public productCatalague(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsby = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg = By.id("toast-container");
	By loading = By.cssSelector(".ng-animating");
	
	
	public List<WebElement> getproductlists() {
		 waitforelemettoappear(productsby);
		return products;
	}
public WebElement getproductname(String productname) {
		
		WebElement prod = products.stream().filter(product->
        product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
public void addproducttocart(String productname) {
	
	WebElement prod = getproductname( productname);
	prod.findElement(addtocart).click();
	waitforelemettoappear(toastmsg);
	waitforelementtodisappear(loading);
	
    
	
}
}



