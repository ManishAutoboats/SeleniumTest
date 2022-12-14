package Page;






import org.openqa.selenium.By;

import Helper.WebDriverHelper;

public class LoginPage extends WebDriverHelper {

	public By EMAIL_INPUTBOX = By.cssSelector("input#email");
	public By PASSWORD_INPUTBOX = By.cssSelector("input#pas");
	public By SIGNIN_BUTTON = By.cssSelector("button.action.login.primary");
	public By Error_Message=By.cssSelector("div.message-error.error.message");

	public void userLogin(String uname, String pass) {
		waitForExpectedElement(EMAIL_INPUTBOX, 10).sendKeys((prop.getProperty(uname)));
		waitForExpectedElement(PASSWORD_INPUTBOX, 10).sendKeys((prop.getProperty(pass)));
		clickUsingJS(SIGNIN_BUTTON);
		

	}
	public void userLoginValidation() {
		String ActulTitle = driver.getTitle();
		String ExpectedTitle = prop.getProperty("LoginPageTitle");
		//assertEquals(ExpectedTitle, ActulTitle);
	}
	
	public void userInvalidLoginValidation() {
		waitForExpectedElement(Error_Message, 20).isDisplayed();
		
	}
}