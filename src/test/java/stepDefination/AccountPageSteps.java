package stepDefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.Factory.DriverFactory;
import com.Utility.Constant;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialTable) {
		
		List<Map<String, String>> cred = credentialTable.asMaps();
	    String username = cred.get(0).get("username");
	    String password = cred.get(0).get("password");
	    
	    DriverFactory.getDriver().get(Constant.URL);
	    
	    accountsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Account page")
	public void user_is_on_accounts_page() {
	    String title = accountsPage.getAccountsPageTitle();
	    
	    System.out.println("Accounts Page Title is: "+ title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
	    List<String> expAccountSectionList = sectionTable.asList();
	    System.out.println("Expected accounts List: " + expAccountSectionList);
	    
	    List<String> actAccountSectionList = accountsPage.getAccountsSectionList();
	    System.out.println("Accutal accounts List: " + actAccountSectionList);
	    
	    Assert.assertTrue(expAccountSectionList.containsAll(actAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer int1) {
	    Assert.assertTrue(accountsPage.getAccountSectionCount() == int1);
	}

}
