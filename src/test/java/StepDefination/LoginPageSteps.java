package StepDefination;

import static org.junit.Assert.assertTrue;

import Helper.WebDriverHelper;
import Page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageSteps extends WebDriverHelper {
	
	LoginPage login=new LoginPage();
	
	
	@Given("^user signs in to the site credentials details '(.*)' '(.*)'$")
	public void userLogin(String uname,String pass) {
	  login.userLogin(uname,pass);
	  login.userLoginValidation();
	  
		
		
	}

	@Given("user login into the application with invalid username and password")
	public void userInvalidLogin() {
	//  login.userLogin(prop.getProperty("username1"), prop.getProperty("password1"));
	  login.userInvalidLoginValidation();
	  
}
	

	

}
