package StepDefination;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Helper.WebDriverHelper;
import Page.HomePage;
import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageSteps extends WebDriverHelper {
	HomePage page = new HomePage();
	
	@Before
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			ChromeOptions option= new ChromeOptions();
			  option.addArguments("--incognito");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			System.out.println("Browser has started ");

		} else if (browserName.equals("ff")) {
			FirefoxOptions option= new FirefoxOptions();
			  option.addArguments("--incognito");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);

		} else if (browserName.equals("edge")) {
			EdgeOptions option=new EdgeOptions();
			  option.addArguments("InPrivate");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option);
		} else {
			System.out.println("browser is not mentioned in the list");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	@After
	public void tearDown(io.cucumber.java.Scenario scenario) {
		if(scenario.isFailed()) {
			takeScreenshot();
		}
		
		driver.quit();
	}


	@And("user launch site URL")
	public void useLaunchSiteURL() {
		initialization1();

	}

	@And("select allow all from cookie popup and select over 18 age confirmation option")
	public void selectCookieAndAgeGate() {
		page.selectCookieAndAgeGate();
		page.clickOnPersonIcon();

	}
	  @And("^user navigates to Cart page and empty basket$")
	    public void userNavigatesToCartPageAndEmptyBasket() throws InterruptedException {
	        page.emptyBasket();
	    }

}
