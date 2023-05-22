package stepDefinitions;
import io.cucumber.java.en.*;
import pageObjects.HomePage_PF;
import pageObjects.LinkedListPage_PF;
import pageObjects.signPage_PF;
import utilities.Helper;
import utilities.LoggerLoad;

public class linkedLIstSteps {

	signPage_PF signPage= new signPage_PF(Helper.getDriver());
	HomePage_PF hPage= new HomePage_PF(Helper.getDriver());
	LinkedListPage_PF lListpage=new LinkedListPage_PF(Helper.getDriver());
	String title;
		
	
	@Given("The User is on practice page of Array")
	public void the_user_is_on_practice_page_of_array() {
	   
		Helper.getTitle();
		System.out.println(Helper.getTitle());
		LoggerLoad.info("The User is on practice page of Array");
	}
	@When("The user select {string}  from homepage dropDown menu")
	public void the_user_select_from_homepage_drop_down_menu(String option) throws InterruptedException {
		
		hPage.homeClickDrpdown(option);
		LoggerLoad.info("the user select_from_homepage_drop_down_menu");
	   
	}

	@Then("User will be navigated to LinkedList page title as {string}")
	public void user_will_be_navigated_to_linked_list_page_title_as(String expTitle) {
	    
		title=Helper.getTitle();
		System.out.println(title);
		Helper.EqualAssert(title, expTitle);
		LoggerLoad.info("User will be navigated to LinkedList page");
	}

	
	@When("User click {string} to select topics covered on Link List page")
	public void user_click_to_select_topics_covered_on_link_list_page(String topicCovList) throws InterruptedException {
	    
		lListpage.LinkedListTopicCovered(topicCovList);
		LoggerLoad.info("User click to select topics covered on Link List page");
	}

	@When("User clicks Try Here button in the  Linked List of selected topic page")
	public void user_clicks_try_here_button_in_the_linked_list_of_selected_topic_page() {
	    
		lListpage.tryHere();
		LoggerLoad.info("User clicks Try Here button in the  Linked List of selected topic page");
	   
	}

	@When("User Enter valid Python code in tryEditor from  {string} for for LinkedList topic and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_for_linked_list_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		lListpage.linkedListPagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.info("User Enter valid Python code in tryEditor for LinkedList topic and click Run button");
	}

	@Then("User should be presented with the Run output for valid Python code and Message for for LinkedList Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_for_linked_list_page() {
	    
		String Message=	lListpage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " +Message);
	LoggerLoad.info("User should be presented with the Run output for valid Python code and Message for for LinkedList Page");
	}

	@When("User Enter Invalid Python code in tryEditor from  {string} for for LinkedList topic and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_for_linked_list_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		lListpage.linkedListPagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.info("User Enter Invalid Python code in tryEditor for LinkedList topic and click Run button");
	}

	@Then("User should be presented with alert and no runOutput for Invalid Python code for LinkedList Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_linked_list_page() {
	    
		String Message=	lListpage.tryEditorMessage();
		System.out.println("Alert msg will be displayed and Run output will be empty : " +Message);
	LoggerLoad.warn("User should be presented with alert and no runOutput for Invalid Python code for LinkedList Page");
	}

	@Then("User navigate back to LinkedList page of selected topic")
	public void user_navigate_back_to_linked_list_page_of_selected_topic() {
		 
		Helper.NavBack();
		LoggerLoad.info("User navigate back to LinkedList page of selected topic");
	}

	@When("User clicks Practice Questions Page on LinkedList Page")
	public void user_clicks_practice_questions_page_on_linked_list_page() throws InterruptedException {
	    
	//	
		lListpage.practiceQuesLinkedList();
		LoggerLoad.info("User clicks Practice Questions Page on LinkedList Page");
	}

	@Then("User should be redirected to a Practice Questions Page of selected LinkedList Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_linked_list_topic_page() {
	    
		title=lListpage.practiceQuesGetTitle();
		System.out.println(title);
		Helper.EqualAssert(title, "Practice Questions");
	LoggerLoad.info("User should be redirected to a Practice Questions Page of selected LinkedList Topic Page");
	}



}
