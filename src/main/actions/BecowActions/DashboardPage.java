package BecowActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BecowUI.DashboardUI;
import CommonPage.CommonFunction;

public class DashboardPage extends CommonFunction{

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getTextUserNameLogin()
	{
		waitVisible(DashboardUI.USERNAME_LOGIN);
		return getText(DashboardUI.USERNAME_LOGIN);
	}
	public CreateProductPage ClickOnKenhBanHang()
	{
		waitVisible(DashboardUI.KENHBANHANG_LBL);
		click(DashboardUI.KENHBANHANG_LBL);
		return PageFactory.initElements(driver, CreateProductPage.class);
	}
	

}
