package BecowTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BecowActions.HomePage;
import BecowActions.LoginPage;
import CommonPage.Commontestcase;

public class LoginPageScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	@Parameters({"browser","version","url"})
	@BeforeClass
	public void BeforeClass(String browser, String version, String url)
	{
		driver = openMultiBrowser(browser, version, url);

		homePage= PageFactory.initElements(driver, HomePage.class);
		loginPage=homePage.ClickDangNhapBTN();	
		
		
	}
	@Test
	public void TC_01_LoginEmptyEmailAndPassWord()
	{
		loginPage.clearUserName();
		loginPage.inputUserName("");
		loginPage.inputPassword("");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");
	}
	
	@Test
	public void TC_02_LoginWrongSDTFormat()
	{	
		
		loginPage.inputUserName("1234");
		loginPage.inputPassword("");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");
		verifyEqual(loginPage.WarningDangNhapWrongSDT_LBL(), "Số điện thoại không đúng");
		
	}
	@Test
	public void TC_03_LoginWrongEMAILFormat() throws InterruptedException
	{
		
		loginPage.clearUserName();
		loginPage.inputUserName("5678abcd");
		loginPage.inputPassword("");
		loginPage.clickDangNhap();
		verifyEqual(loginPage.WarningDangNhapEmailSDT_LBL(), "Hãy nhập email / số điện thoại và mật khẩu");
		verifyEqual(loginPage.WarningDangNhapWrongEMAIL_LBL(), "Email không đúng");
	}
	@Test
	public void TC_04_clear()
	{
		loginPage.clearUserName();
		verifyEqual(loginPage.getTextUserName(), "");
	}

	@AfterClass
	public void AfterClass()
	{
		
	}
	
	
	

}
