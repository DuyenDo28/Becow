package BecowTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BecowActions.DashboardPage;
import BecowActions.HomePage;
import BecowActions.LoginPage;
import CommonPage.Commontestcase;

public class LoginPageScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	DashboardPage dashBoardPage;
	@Parameters({"browser","version","url"})
	@BeforeClass
	public void BeforeClass(String browser, String version, String url)
	{
		inititalReport("DuyenDOLoginPageScript.html");
		driver = openMultiBrowser(browser, version, url);

		homePage= PageFactory.initElements(driver, HomePage.class);
		loginPage=homePage.ClickDangNhapBTN();	
		
		
	}
	@BeforeMethod
	public void BeforeMethod()
	{
		loginPage.clearUserNameByJs();
		loginPage.clearPasswordByJs();
	}
	@Test
	public void TC_01_LoginEmptyEmailAndPassWord()
	{
		logTestCase("Log test caseTC_01_LoginEmptyEmailAndPassWord");
		loginPage.inputUserName("");
		loginPage.inputPassword("");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");
	}
	
	@Test
	public void TC_02_LoginWrongSDTFormat()
	{	
		logTestCase("Log test case TC_02_LoginWrongSDTFormat");
		loginPage.inputUserName("1234");
		loginPage.inputPassword("");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");
		verifyEqual(loginPage.WarningDangNhapWrongSDT_LBL(), "Số điện thoại không đúng");
		
	}
	@Test
	public void TC_03_LoginWrongEMAILFormat() throws InterruptedException
	{
		
		logTestCase("Log test case TC_03_LoginWrongEMAILFormat");
		loginPage.inputUserName("5678abcd");
		loginPage.inputPassword("");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");
		verifyEqual(loginPage.WarningDangNhapWrongEMAIL_LBL(), "Email không đúng");
	}
	@Test
	public void TC_04_LoginIncorrectAccount()
	{
		
		logTestCase("Log test case TC_04_LoginIncorrectAccount");
		loginPage.inputUserName("genymotionios@gmail.com");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");		
	}
	@Test
	public void TC_05_LoginIncorrectAccountAndIncorrectPassword()
	{
		
		logTestCase("Log test case TC_05_LoginIncorrectAccountAndIncorrectPassword");
		loginPage.inputUserName("genymotionios@gmail.com");
		loginPage.inputPassword("123");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");		
		verifyEqual(loginPage.getTextInvalidPassWordErr(), "Tối thiểu 6 ký tự");
	}
	@Test
	public void TC_06_LoginIncorrectEmailOrSdtOrPassword()
	{	
		logTestCase("Log test case TC_06_LoginIncorrectEmailOrSdtOrPassword");
		loginPage.inputUserName("genymotionios@gmail.com");
		loginPage.inputPassword("123456");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.getTextInvalidEmailOrSdtOrPassword(), "Sai email / số điện thoại hoặc mật khẩu");
	}
	@Test
	public void TC_07_LoginSucessFully() throws InterruptedException
	{	
		logTestCase("Log test case TC_07_LoginSucessFully");
		loginPage.inputUserName("genymotionios@gmail.com");
		loginPage.inputPassword("1234@abcd");
		dashBoardPage=loginPage.clickDangNhap();
		Thread.sleep(4000);
		verifyEqual(dashBoardPage.getTextUserNameLogin(),"genymotionios");
		
		
	}
	@AfterMethod
	public void AfterMethod(ITestResult result)
	{
		getResult(result);
	}
	@AfterClass
	public void AfterClass()
	{
		exportReport();
		closeBrowser();
	}
	
	
	

}
