package test;


import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.WorkWithLogin;


public class Omnipro_Test1_NavegarQAlified extends TestBase {
	
	
	
	//Logger
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger( Omnipro_Test1_NavegarQAlified.class);
	
	
	
	@Test
	@Parameters({"host"})
	public void loginTestCase(String host){

		logger.info("Navigate to the url of QAlified {}",host);
		this.automator.goTo(host); //host + "/login"
		this.automator.maximizeWindows();
		
		WorkWithLogin loginTestCase = new WorkWithLogin(automator);
		loginTestCase.clickContact();
		loginTestCase.contactInformation("Name","Last Name");
		loginTestCase.verifyEnteredName();
		loginTestCase.verifyMessage();
		

	}


}
