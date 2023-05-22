package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;

import pageObjects.HomePage_PF;
import pageObjects.LinkedListPage_PF;
import pageObjects.QueuePage_PF;
import pageObjects.StackPage_PF;
import pageObjects.registerPage_PF;
import pageObjects.signPage_PF;
import pageObjects.startPage_PF;


public class baseTest {
	// Base class to maintain the page object classes
	//reusable methods that are applicable to all classes
	public HomePage_PF hPage;
	public startPage_PF sPage;
	public registerPage_PF regPage;
	public signPage_PF signpage;
	public LinkedListPage_PF lListpage;
	public StackPage_PF stackPage;
	public QueuePage_PF queuePage;
	
	
	
	public static String randomUtilUsername() {
		
		String userName = RandomStringUtils.randomAlphanumeric(5);
		String id="@ninja.com";
		String Userid=userName+id;
		System.out.println(Userid);
		return Userid;
	}
	
	
}
