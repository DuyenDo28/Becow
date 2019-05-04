package BecowActions;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BecowUI.CreateProductPageUI;
import CommonPage.CommonFunction;

public class CreateProductPage extends CommonFunction{

	public CreateProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void getCurrentURL()
	{
		getCurrentURL();
	}
	public void ClickOnTaoSanPham()
	{
		waitVisible(CreateProductPageUI.DANGSANPHAMMOI_BOX);
		click(CreateProductPageUI.DANGSANPHAMMOI_BOX);
	}
	public void ClickOnDangSanPhamByJS(String javascript)
	{
		executeScriptBrowser(javascript);


	}
	public void ClickOnDangButton()
	{
		waitVisible(CreateProductPageUI.DANG_BTN);
		click(CreateProductPageUI.DANG_BTN);
	}
	public String getTextHayChonHinhAnhChoSanPhamLBL()
	{
		waitVisible(CreateProductPageUI.CHON_HINHANH_CHO_SANPHAM_LBL);
		return getText(CreateProductPageUI.CHON_HINHANH_CHO_SANPHAM_LBL);
	}
	public String getTextDienTenSanPhamLBL()
	{
		waitVisible(CreateProductPageUI.DIEN_TENSANPHAM_LBL);
		return getText(CreateProductPageUI.DIEN_TENSANPHAM_LBL);
	}
	public String getTextHayChonDanhMucLBL()
	{
		waitVisible(CreateProductPageUI.HAYCHON_DANHMUC_LBL);
		return getText(CreateProductPageUI.HAYCHON_DANHMUC_LBL);
	}
	public String getTextHayMoTaSanPhamLBL()
	{
		waitVisible(CreateProductPageUI.HAY_MOTA_SANPHAM_LBL);
		return getText(CreateProductPageUI.HAY_MOTA_SANPHAM_LBL);
	}
	public String getTextNhapSoLuongLBL()
	{
		waitVisible(CreateProductPageUI.NHAP_SOLUONG_LBL);
		return getText(CreateProductPageUI.NHAP_SOLUONG_LBL);
	}
	public String getTextHayDienGiaLBL()
	{
		waitVisible(CreateProductPageUI.HAY_DIENGIA_LBL);
		return getText(CreateProductPageUI.HAY_DIENGIA_LBL);
	}
	public String getTextKichThuocLBL()
	{
		waitVisible(CreateProductPageUI.KICHTHUOC_LBL);
		return getText(CreateProductPageUI.KICHTHUOC_LBL);
	}
	public String getTextChieuDaiLBL()
	{
		waitVisible(CreateProductPageUI.CHIEUDAI_LBL);
		return getText(CreateProductPageUI.CHIEUDAI_LBL);
	}
	public String getTextChieuCaoLBL()
	{
		waitVisible(CreateProductPageUI.CHIEUCAO_LBL);
		return getText(CreateProductPageUI.CHIEUCAO_LBL);
	}
	public String getTextHayDienCanNangSanPhamLBL()
	{
		waitVisible(CreateProductPageUI.HAY_DIENCANNANGSANPHAM_LBL);
		return getText(CreateProductPageUI.HAY_DIENCANNANGSANPHAM_LBL);
	}
	public void UploadImage(String PathImage)
	{
		uploadBySendKeys(CreateProductPageUI.UPLOADIMAGE, PathImage);
	}
	public void inputProductName(String Name)
	{
		waitVisible(CreateProductPageUI.PRODUCTNAME_TXT);
		clearText(CreateProductPageUI.PRODUCTNAME_TXT);
		input(CreateProductPageUI.PRODUCTNAME_TXT, Name);
	}
	
	public void clickRandomCombobox(String locator) {
		List<WebElement> selects = driver.findElements(By.xpath(locator));
		Random rand = new Random();
		int list = rand.nextInt(selects.size());
		selects.get(list).click();
	}
	public void ClickOnChonDanhMuc1()
	{
		waitVisible(CreateProductPageUI.DANHMUC_BTN1);
		click(CreateProductPageUI.DANHMUC_BTN1);
	}
	public void SelectDanhMuc1()
	{
		waitVisible(CreateProductPageUI.DANHMUC_LISTBOX1);
		clickRandomCombobox(CreateProductPageUI.DANHMUC_LISTBOX1);
	}
	
	public void ClickOnChonDanhMuc2()
	{
		waitVisible(CreateProductPageUI.DANHMUC_BTN2);
		click(CreateProductPageUI.DANHMUC_BTN2);
	}
	
	public void ClickOnThoiTrangNam()
	{
		waitVisible(CreateProductPageUI.DANHMUC_THOITRANGNAM);
		click(CreateProductPageUI.DANHMUC_THOITRANGNAM);
	}
	public void ClickOnThoiTrangNamByJS()
	{
		waitVisible(CreateProductPageUI.DANHMUC_THOITRANGNAM);
		executeClickByJS(CreateProductPageUI.DANHMUC_THOITRANGNAM);
	}
	public void SelectDanhMuc2()
	{
		waitVisible(CreateProductPageUI.DANHMUC_LISTBOX2);
		clickRandomCombobox(CreateProductPageUI.DANHMUC_LISTBOX2);
	}
	
	public void ClickRandomDanhMuc3() {
		if (checkElementDisplay(CreateProductPageUI.DANHMUC_BTN3)) {
			waitVisible(CreateProductPageUI.DANHMUC_BTN3);
			click(CreateProductPageUI.DANHMUC_BTN3);
			waitVisible(CreateProductPageUI.DANHMUC_BTN3);
			clickRandomCombobox(CreateProductPageUI.DANHMUC_LISTBOX3);
			
		}
	}
	public void inputDescription(String value)
	{
		waitVisible(CreateProductPageUI.DESCRIPTION_TXT);
		clearText(CreateProductPageUI.DESCRIPTION_TXT);
		input(CreateProductPageUI.DESCRIPTION_TXT, value);
	}
	public void inputQuantity(String value)
	{
		waitVisible(CreateProductPageUI.QUANTITY_TXT);
		input(CreateProductPageUI.QUANTITY_TXT, value);
	}
	public void inputPrice(String value)
	{
		waitVisible(CreateProductPageUI.PRICE_TXT);
		clearText(CreateProductPageUI.PRICE_TXT);
		input(CreateProductPageUI.PRICE_TXT, value);
	}
	public void inputWeight(String value)
	{
		waitVisible(CreateProductPageUI.WEIGHT_TXT);
		clearText(CreateProductPageUI.WEIGHT_TXT);
		input(CreateProductPageUI.WEIGHT_TXT, value);
	}
	public String getTextWeightLBL()
	{
		waitVisible(CreateProductPageUI.WEIGHT_LBL);
		return getText(CreateProductPageUI.WEIGHT_LBL);
	}
	public void inputWidth(String value)
	{
		waitVisible(CreateProductPageUI.WIDTH_TXT);
		clearText(CreateProductPageUI.WIDTH_TXT);
		input(CreateProductPageUI.WIDTH_TXT, value);
	}
	public void inputLength(String value)
	{
		waitVisible(CreateProductPageUI.LENGTH_TXT);
		clearText(CreateProductPageUI.LENGTH_TXT);
		input(CreateProductPageUI.LENGTH_TXT, value);
	}
	public void inputHeight(String value)
	{
		waitVisible(CreateProductPageUI.HEIGHT_TXT);
		clearText(CreateProductPageUI.HEIGHT_TXT);
		input(CreateProductPageUI.HEIGHT_TXT, value);
	}
	public String getTextDangThanhCongSP()
	{
		waitVisible(CreateProductPageUI.DANGTHANHCONGSP_MSG);
		return getText(CreateProductPageUI.DANGTHANHCONGSP_MSG);
	}
	public void clickOnXemDanhMucSanPham()
	{
		waitVisible(CreateProductPageUI.XEMDANHMUCSP_BTN);
		click(CreateProductPageUI.XEMDANHMUCSP_BTN);
	}
	public void inputWidthByJS(String javaScript)
	{
		inputKeyByJS(javaScript);
	}
	public String getTextProductName()
	{
		waitVisible(CreateProductPageUI.PRODUCTNAME_ISCREATED);
		return getText(CreateProductPageUI.PRODUCTNAME_ISCREATED);
	}
	public String getTextPrice()
	{
		waitVisible(CreateProductPageUI.PRICE_ISCREATED);
		return getText(CreateProductPageUI.PRICE_ISCREATED);
	}


}
