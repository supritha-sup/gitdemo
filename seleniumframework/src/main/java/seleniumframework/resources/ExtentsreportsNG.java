package seleniumframework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsreportsNG {

	public static ExtentReports getReport() {
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		System.out.println("sd-"+path );
		//ExtentSparkReporter //ExtentReport
		ExtentSparkReporter Reporter = new ExtentSparkReporter(path);
		Reporter.config().setReportName("web automaton");
		Reporter.config().setDocumentTitle("Test results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Tester", "supreetha");
		return extent;
		
	}
	
}
