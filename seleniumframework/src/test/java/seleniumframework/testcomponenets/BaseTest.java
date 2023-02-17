package seleniumframework.testcomponenets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumframework.pagemodel.landingpage;

public class BaseTest {
	public WebDriver driver;

	public WebDriver initializedriver() throws IOException {

		// to get properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\seleniumframework\\resources\\GlobalData.Properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
				
			}
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {

			// firefox
			if (browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {

				// edge
			}

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

	public String getscreenshot(String testcasename, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports" + testcasename + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports" + testcasename + ".png";
	}

	@BeforeMethod
	public landingpage launchingApplication() throws IOException {
		WebDriver driver = initializedriver();
		landingpage landingpage = new landingpage(driver);
		landingpage.goTo();
		return landingpage;
	}
}
