package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.HomePage_PF;

import pageObjects.signPage_PF;
import pageObjects.StackPage_PF;
import utilities.Helper;
import utilities.LoggerLoad;


public class stackSteps {
	
	signPage_PF signPage= new signPage_PF(Helper.getDriver());
	HomePage_PF hPage= new HomePage_PF(Helper.getDriver());
	//linkedListPagePOM lListpage=new linkedListPagePOM(Helper.getDriver());
	StackPage_PF stackPage=new StackPage_PF(Helper.getDriver());
	String title;
	
	@Given("The User is on practice page of LinkedList")
	public void the_user_is_on_practice_page_of_linked_list() {
	    
		Helper.getTitle();
		System.out.println(Helper.getTitle());
		LoggerLoad.info("The User is on practice page of LinkedList");
	}

	
	@Then("User will be navigated to Stack page title as {string}")
	public void user_will_be_navigated_to_stack_page_title_as(String option) throws InterruptedException {
	    
		hPage.homeClickDrpdown(option);
		LoggerLoad.info("User will be navigated to Stack page");
	}

	@When("User click {string} to select topics covered on Stack page")
	public void user_click_to_select_topics_covered_on_stack_page(String topicCovList) {
	    
		stackPage.StackTopicCovered(topicCovList);
		LoggerLoad.info("user_click_to_select_topics_covered_on_stack_page");
	}

	@When("User clicks Try Here button in the  Stack of selected topic page")
	public void user_clicks_try_here_button_in_the_stack_of_selected_topic_page() {
	    
		stackPage.tryHere();
		LoggerLoad.info("User clicks Try Here button in the  Stack of selected topic page");
	   
	}

	@When("User Enter valid Python code in tryEditor from  {string} for Stack topic and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_stack_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		stackPage.stackPagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.info("User Enter valid Python code in tryEditor for stack topic and click run button");
	}

	@Then("User should be presented with the Run output for valid Python code and Message for for Stack Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_for_stack_page() {
	    
		String Message=	stackPage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " +Message);
	LoggerLoad.info("User should be presented with the Run output for valid Python code and Message for for Stack Page");
	}

	@When("User Enter Invalid Python code in tryEditor from  {string} for Stack topic and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_stack_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		stackPage.stackPagePythonCodeValidationAndRun(pythonCodefrmFeature);
	LoggerLoad.error("User Enter Invalid Python code in tryEditor for stack topic and click run button");
	}

	@Then("User should be presented with alert and no runOutput for Invalid Python code for Stack Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_stack_page() throws InterruptedException {
	    
		String Message=	stackPage.tryEditorMessage();
		
		System.out.println("Alert msg will be displayed and Run output will be empty : " +Message);
	LoggerLoad.warn("User should be presented with alert and no runOutput for Invalid Python code for Stack Page");
	}

	@Then("User navigate back to Stack page of selected topic")
	public void user_navigate_back_to_stack_page_of_selected_topic() {
	    
		Helper.NavBack();
		LoggerLoad.info("User navigate back to Stack page of selected topic");
	   
	}

	@When("User clicks Practice Questions Page on Stack Page")
	public void user_clicks_practice_questions_page_on_stack_page() {
	    
	   stackPage.practiceQuesStack();
	   LoggerLoad.info("User clicks Practice Questions Page on Stack Page");
	}

	@Then("User should be redirected to a Practice Questions Page of selected Stack Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_stack_topic_page() {
	    
		title=stackPage.practiceQuesGetTitle();
		System.out.println(title);
		Helper.EqualAssert(title, "Practice Questions");
		LoggerLoad.info("User should be redirected to a Practice Questions Page of selected Stack Topic Page");
	}

}