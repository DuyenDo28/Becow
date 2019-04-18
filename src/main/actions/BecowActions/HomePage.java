package BecowActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BecowUI.HomePageUI;
import CommonPage.CommonFunction;

public class HomePage extends CommonFunction {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public LoginPage ClickDangNhapBTN()
	{
		waitVisible(HomePageUI.DANGNHAP_BTN);
		click(HomePageUI.DANGNHAP_BTN);
		return PageFactory.initElements(driver, LoginPage.class);
		
	}

}
