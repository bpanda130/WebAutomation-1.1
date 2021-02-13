package stepDefination;

import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import com.Utility.Constant;
import com.pages.LoginPage;

public class LoginPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	String pageTitle = "";
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get(Constant.URL);
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		pageTitle = loginpage.getLoginPageTitle();
	    System.out.println("Login page title is : "+ pageTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {
		Assert.assertTrue(pageTitle.contains(expectedPageTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isForgotPasswordLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginpage.enterUserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginpage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLogin();
	}

}
