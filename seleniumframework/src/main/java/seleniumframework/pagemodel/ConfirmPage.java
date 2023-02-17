package seleniumframework.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumframework.abstratComponents.abstractComponenets;

public class ConfirmPage extends abstractComponenets {

		WebDriver driver;
		
		public  ConfirmPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);	
		}   
		
		@FindBy(className="hero-primary")
		WebElement confirm;
		
		
		public  String getconfirmmessage() {
			
			return confirm.getText();
		}
		
		
		
		
}
