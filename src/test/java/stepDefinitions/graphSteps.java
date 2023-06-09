package stepDefinitions;

//import com.github.dockerjava.api.model.Driver;

import io.cucumber.java.en.*;
import pageObjects.HomePage_PF;
import pageObjects.signPage_PF;
import pageObjects.GraphPage_PF;
import utilities.Helper;
import utilities.LoggerLoad;

public class graphSteps {
	
	
	signPage_PF signPage= new signPage_PF(Helper.getDriver());
	HomePage_PF hPage= new HomePage_PF(Helper.getDriver());
	GraphPage_PF graphPage=new GraphPage_PF(Helper.getDriver());
	String title;
	
	@Given("The User is on practice page of Tree")
	public void the_user_is_on_practice_page_of_tree() {
		Helper.getTitle();
		System.out.println(Helper.getTitle());
		LoggerLoad.info("The User is on practice page of Tree");
	   
	}
	
	@Then("User will be navigated to Graph page title as {string}")
	public void user_will_be_navigated_to_graph_page_title_as(String option) throws InterruptedException {
		hPage.homeClickDrpdown(option);
		LoggerLoad.info("User will be navigated to Graph page");
	}
	
	
	@When("User click {string} to select topics covered on Graph page")
	public void user_click_to_select_topics_covered_on_graph_page(String topicCovList) {
		
		graphPage.GraphTopicCovered(topicCovList);
		LoggerLoad.info("User click select topics covered on Graph page");
	}
	
	@When("User clicks Try Here button in the  Graph of selected topic page")
	public void user_clicks_try_here_button_in_the_graph_of_selected_topic_page() {
	   
		graphPage.tryHere();
		LoggerLoad.info("User clicks Try Here button in the  Graph of selected topic page");
	}
	
	@When("User Enter valid Python code in tryEditor from  {string} for Graph topic and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_graph_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException  {
	    
		graphPage.graphPagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.info("User Enter valid Python code in tryEditor for Graph topic and click Run button");
	}
	
	@Then("User should be presented with the Run output for valid Python code and Message for for Graph Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_for_graph_page() {
	   
		String Message=	graphPage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " +Message);
		LoggerLoad.info("User should be presented with the Run output for valid Python code and Message for for Graph Page");
	}
	@When("User Enter Invalid Python code in tryEditor from  {string} for Graph topic and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_graph_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException{
	    
		graphPage.graphPagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.error("User Enter Invalid Python code in tryEditor from  {string} for Graph topic and click Run button");
	}
	
	@Then("User should be presented with alert and no runOutput for Invalid Python code for Graph Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_graph_page() throws InterruptedException {
	    
       String Message=graphPage.tryEditorMessage();
		
		System.out.println("Alert msg will be displayed and Run output will be empty : " +Message);
		LoggerLoad.warn("User should be presented with alert and no runOutput for Invalid Python code for Graph Page");
	}
	
	@Then("User navigate back to Graph page of selected topic")
	public void user_navigate_back_to_graph_page_of_selected_topic() throws InterruptedException {
		
	//	Helper.graphPage();
		Helper.NavBack();
		
		Helper.NavBack();
		
		
		//Helper.NavBack();
		LoggerLoad.info("User navigate back to Graph page of selected topic");
	}

	
	@Given("User is on graph page of selected topic")
	public void user_is_on_graph_page_of_selected_topic() {
	   
		Helper.NavForward();
		LoggerLoad.info("User is on graph page of selected topic");
	}
	
	@When("User clicks Practice Questions Page on Graph Page")
	public void user_clicks_practice_questions_page_on_graph_page() {
		graphPage.practiceQuesGraph();
		LoggerLoad.info("User clicks Practice Questions Page on Graph Page");
	}
	
	
	@Then("User should be redirected to a Practice Questions Page of selected Graph Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_graph_topic_page() {
	    
		title=graphPage.practiceQuesGetTitle();
		System.out.println(title);
		Helper.EqualAssert(title, "Practice Questions");
		LoggerLoad.info("User should be redirected to a Practice Questions Page of selected Graph Topic Page");
	}

	

}