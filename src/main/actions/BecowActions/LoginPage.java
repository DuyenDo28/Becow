package BecowActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BecowUI.LoginUI;
import CommonPage.CommonFunction;

public class LoginPage extends CommonFunction {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void inputUserName(String userName)
	{
		waitVisible(LoginUI.USERNAME_TXT);
		input(LoginUI.USERNAME_TXT,userName );
	}
	public void clearUserName()
	{
		waitVisible(LoginUI.USERNAME_TXT);
		clearText(LoginUI.USERNAME_TXT);
	}
	public void inputPassword(String passWord)
	{
		waitVisible(LoginUI.PASSWORD_TXT);
		input(LoginUI.PASSWORD_TXT,passWord );
	}
	public void clearPassword()
	{
		waitVisible(LoginUI.PASSWORD_TXT);
		clearText(LoginUI.PASSWORD_TXT);
	}
	public String getTextUserName()
	{
		waitVisible(LoginUI.USERNAME_TXT);
		return getText(LoginUI.USERNAME_TXT);
	}
	public DashboardPage clickDangNhap()
	{
		waitVisible(LoginUI.DANGNHAP_BTN);
		click(LoginUI.DANGNHAP_BTN);
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	public String WarningDangNhapEmailSDT_LBL()
	{
		waitVisible(LoginUI.DANGNHAP_EMAIL_SDT_LBL);		
		return getText(LoginUI.DANGNHAP_EMAIL_SDT_LBL);
	}
	public String WarningDangNhapWrongSDT_LBL()
	{
		waitVisible(LoginUI.DANGNHAP_WRONG_SDT_LBL);		
		return getText(LoginUI.DANGNHAP_WRONG_SDT_LBL);
	}
	public String WarningDangNhapWrongEMAIL_LBL()
	{
		waitVisible(LoginUI.DANGNHAP_WRONG_EMAIL_LBL);		
		return getText(LoginUI.DANGNHAP_WRONG_EMAIL_LBL);
	}
	public HomePage CLickCloseDangNhapPopUp()
	{
		waitVisible(LoginUI.CLOSE_DANGNHAP_POPUP);
		click(LoginUI.CLOSE_DANGNHAP_POPUP);
		return PageFactory.initElements(driver, HomePage.class);	
		
	}
	public String getTextInvalidPassWordErr()
	{
		waitVisible(LoginUI.PASSWORD_VALID_ERROR_LBL);
		return getText(LoginUI.PASSWORD_VALID_ERROR_LBL);
		
		
	}
	public String getTextInvalidEmailOrSdtOrPassword()
	{
		

		waitVisible(LoginUI.EMAIL_SDT_PASSWORD_ERROR_LBL);
		return getText(LoginUI.EMAIL_SDT_PASSWORD_ERROR_LBL);
		//JavascriptExecutor js = (JavascriptExecutor) driver; 
		//return js.executeScript("return $ ('$('input[beetranslate="beecow.login.error.loginError"]').children("span")').text()").toString();			
	}
	public void clearUserNameByJs()
	{
		executeScriptBrowser("$('input#usr').val('')");
		
	}
	public void clearPasswordByJs()
	{
		executeScriptBrowser("$('input#pwd').val('')");
		//$('#sign-in input#pwd')
		//$('#sign-in input#pwd').val('')
		
	}




}
