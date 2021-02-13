package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Utility.Constant;
import com.qa.Factory.DriverFactory;
import com.qa.Utility.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	ReportUtility reportUtility;
	
	
	@Before(order = 0)
	public void getProperty(){
		configReader = new ConfigReader();
		prop = configReader.init_prop(Constant.CONFIG_FILEPATH);
	}
	
	@Before(order = 1)
	public void lunchBrowser(){
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserName);
		reportUtility = new ReportUtility(driver);
		
	}
	
	@After(order = 0)
	public void quitBrowser(){
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			//take screenshot
			reportUtility.CaptureScreenShot(scenario);
		}
	}
}
