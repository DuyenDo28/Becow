package BecowTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BecowActions.HomePage;
import BecowActions.LoginPage;
import CommonPage.Commontestcase;

public class HomePageScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	@Parameters({"browser","version","url"})
	@BeforeClass
	public void BeforeClass(String browser, String version, String url)
	{
		
		
	}
	@Test
	public void TC_01()
	{
		
	}
	
	

}
