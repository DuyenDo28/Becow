package BecowActions;

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
		clearText(LoginUI.USERNAME_TXT);
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
	public String getTextUserName()
	{
		waitVisible(LoginUI.USERNAME_TXT);
		return getText(LoginUI.USERNAME_TXT);
	}
	public void clickDangNhap()
	{
		waitVisible(LoginUI.DANGNHAP_BTN);
		click(LoginUI.DANGNHAP_BTN);
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



}
