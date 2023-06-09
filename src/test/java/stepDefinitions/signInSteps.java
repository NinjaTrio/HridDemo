package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.cucumber.java.en.*;
import pageObjects.signPage_PF;
//import utilities.ExcelReader;
import utilities.Helper;
import utilities.LoggerLoad;
import utilities.excelReader3;

public class signInSteps {
	
	signPage_PF signPage= new signPage_PF(Helper.getDriver());
	String title;
	
	@Given("User is on Home Page of DS Algo Portal")
	public void user_is_on_home_page_of_ds_algo_portal() throws InterruptedException {
		
		Helper.homePage();
		Thread.sleep(2000);
		Helper.getTitle();
		System.out.println(" Iam on Home page");
		LoggerLoad.info("User is on Home Page of DS Algo Portal");
		
	}

	@When("User clicks on signIn link on Home page")
	public void user_clicks_on_sign_in_link_on_home_page() throws InterruptedException {
	    
	//	Helper.homePage();
		
		signPage.homePageclickLogin();
		LoggerLoad.info("User clicks on signIn link on Home page"); 
	}

	
	@Then("User is navigated to Login Page title as {string}")
	public void user_is_navigated_to_login_page_title_as(String expTitle) {
	
		title	=signPage.homePageclickLogin();
		System.out.println(title+"I am on Login page");
		Helper.EqualAssert(title, expTitle);
		LoggerLoad.info("User is navigated to Login Page");
	}
	
	
	@When("User entered login details from sheet {string} and {int}")
	public void user_entered_login_details_from_sheet_and(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
	//	Helper.LoginPage();
		Thread.sleep(2000);
		excelReader3 reader=new excelReader3();
		
		List<Map<String, String>> testdata = reader.getData("C:\\Users\\shiva\\eclipse-workspace\\DS_Algo_CucumberBDD\\src\\test\\resources\\Exceldata\\invalidSignIn.xlsx",sheetName);
		String username = testdata.get(rowNumber).get("Username");
		String password = testdata.get(rowNumber).get("Password");
		String expMsg = testdata.get(rowNumber).get("expectedMessage");
		
		signPage.signInPageValidation(username, password, expMsg);
		LoggerLoad.info("User entered login details from Excel sheet");
	}
	

	@Then("Error message is displayed")
	public void error_message_is_displayed() throws InterruptedException {
		
		
		String ErrMsg=signPage.loginPageDisplayMsg();
		System.out.println(ErrMsg+" :Invalid user login");
		LoggerLoad.error("Error message is displayed as Invalid user login ");
	   
	}
	
	@Given("User entered Username as {string} and Password as {string}")
	public void user_entered_username_as_and_password_as(String username, String password) throws InterruptedException {
		
		 signPage.LoginPageDoSignin(username, password);
			LoggerLoad.info("User entered Username and Password ");
	}
	  


	@Then("Success message is displayed")
	public void success_message_is_displayed() throws InterruptedException {
	   Thread.sleep(2000); 
	   signPage.loginPageDisplayMsg();
	   System.out.println(signPage.loginPageDisplayMsg()+" Valid login");
		LoggerLoad.info("Success message is displayed");
	}

	@Then("User is navigated to Home page of DsAlgo Portal")
	public void user_is_navigated_to_home_page_of_ds_algo_portal() throws InterruptedException {
		Thread.sleep(2000);
	   Helper.getTitle();
	   System.out.println(Helper.getTitle());
		LoggerLoad.info("User is navigated to Home page of DsAlgo Portal");
	}
	
	@Given("User is logged In with userName as {string} and password {string}")
	public void user_is_logged_in_with_user_name_as_and_password(String userName, String password) throws InterruptedException {
		signPage.LoginPageDoSignin(userName, password);
		LoggerLoad.info("User is logged In with valid userName and password ");
	}


	@When("User clicks on signOut link on Home page")
	public void user_clicks_on_sign_out_link_on_home_page() {
	    
	//	Helper.homePage();
	   signPage.LoginPageDoSignOut();
		LoggerLoad.info("User clicks on signOut link on Home page");
	}

	@Then("Message will be displayed as {string}")
	public void message_will_be_displayed_as(String string) throws InterruptedException {
		
	    Thread.sleep(2000);
		signPage.loginPageDisplayMsg();
		LoggerLoad.info(" Message will be displayed as Logged out successfully");
	   
	}
	
	

}