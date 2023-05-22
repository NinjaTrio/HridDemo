package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.HomePage_PF;
import pageObjects.startPage_PF;
import utilities.Helper;
import utilities.LoggerLoad;

	public class homeSteps {

		private startPage_PF sPage =new startPage_PF(Helper.getDriver());
		private HomePage_PF hPage;
		
		@When("The user clicks on Get Started link on homepage {string} without login")
		public void the_user_clicks_on_get_started_link_on_homepage_without_login(String option) throws InterruptedException {
		   
			Helper.homePage();
			hPage=sPage.startPageHomePage();
			hPage.homeGetStartedClick(option);
		//	Thread.sleep(3000);
			LoggerLoad.info("The user clicks on Get Started link on homepage without login");
		}

		@Then("The user get warning message {string}")
		public void the_user_get_warning_message(String string) {
		   
		String message	=hPage.WarningMsg();
		System.out.println("Warning msg:  "+message);
		LoggerLoad.warn("The user get warning message");
		}

		@When("The user select options from dropbox menu on homepage {string} without login")
		public void the_user_select_options_from_dropbox_menu_on_homepage_without_login(String option) throws InterruptedException {
		    
			hPage.homeClickDrpdown(option);
		//	Thread.sleep(3000);
			LoggerLoad.info("The user select options from dropbox menu on homepage without login");
		}

		
	}


