package seleniumframework.abstratComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumframework.pagemodel.CartPage;
import seleniumframework.pagemodel.OrderPage;

public class abstractComponenets {
	WebDriver driver;

	public abstractComponenets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='/dashboard/cart']")
	WebElement carts;

	@FindBy(css = "[routerlink*='/myorders']")
	WebElement order;

	public void waitforelemettoappear(By findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

	public void waitforwebelemettoappear(WebElement findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}

	public void waitforelementtodisappear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findby)));
	}

	public void gotocart() {
		carts.click();

	}
	public OrderPage gotoOrderPage() {
		
		order.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}

}
