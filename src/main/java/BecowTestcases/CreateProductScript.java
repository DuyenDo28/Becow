package BecowTestcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BecowActions.CreateProductPage;
import BecowActions.DashboardPage;
import BecowActions.HomePage;
import BecowActions.LoginPage;
import CommonPage.Commontestcase;

public class CreateProductScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	DashboardPage dashBoardPage;
	CreateProductPage createProductPage;
	String userPath = System.getProperty("user.dir");
	String xPathOfImage =userPath.concat("\\image\\flower.jpg");
	
	@Parameters({"browser","version","url"})
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) throws InterruptedException
	{
		driver = openMultiBrowser(browser, version, url);

		homePage= PageFactory.initElements(driver, HomePage.class);
		loginPage=homePage.ClickDangNhapBTN();	
		loginPage.inputUserName("genymotionios@gmail.com");
		loginPage.inputPassword("1234@abcd");
		dashBoardPage=loginPage.clickDangNhap();
		Thread.sleep(2000);
		dashBoardPage.ClickOnKenhBanHang();
		createProductPage=dashBoardPage.ClickOnKenhBanHang();
		Thread.sleep(5000);
		createProductPage.ClickOnTaoSanPham();
		//createProductPage.ClickOnDangSanPhamByJS("$('li.inner-menu-mobile a[beetranslate*=\"uploadProduct\"] span')";
		//JavascriptExecutor js = (JavascriptExecutor) driver; 
		//js.executeScript("$('li.inner-menu-mobile a[beetranslate*=\"uploadProduct\"] span')");



	}
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException
	{
		createProductPage.ClickOnThoiTrangNam();
		//createProductPage.ClickOnThoiTrangNamByJS();
		Thread.sleep(1000);
	}
	@Test
	public void TC_01_URL_UploadProduct() throws InterruptedException
	{
		Thread.sleep(2000);
		verifyEqual(createProductPage.getCurrentUrl(), "https://www.beecow.com/page/upload-product");
	
	}
	@Test
	public void TC_02_CreateProductWithoutInputRequireFields()
	{
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextHayChonHinhAnhChoSanPhamLBL(), "Hãy chọn hình ảnh cho sản phẩm");
		//verifyEqual(createProductPage.getTextDienTenSanPhamLBL(),"Hãy điền tên sản phẩm");
		verifyEqual(createProductPage.getTextHayChonDanhMucLBL(),"Hãy chọn danh mục.");
		verifyEqual(createProductPage.getTextHayMoTaSanPhamLBL(),"Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getTextNhapSoLuongLBL(),"Nhập số lượng.");
		verifyEqual(createProductPage.getTextHayDienGiaLBL(),"Hãy điền giá.");
		verifyEqual(createProductPage.getTextHayDienCanNangSanPhamLBL(),"Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getTextKichThuocLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuCaoLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuDaiLBL(),"Bắt buộc");
		
	}
	@Test
	public void TC_03_JustUploadImage()
	{
		createProductPage.ClickOnDangButton();
		createProductPage.UploadImage(xPathOfImage);
		verifyEqual(createProductPage.getTextDienTenSanPhamLBL(),"Hãy điền tên sản phẩm");
		verifyEqual(createProductPage.getTextHayChonDanhMucLBL(),"Hãy chọn danh mục.");
		verifyEqual(createProductPage.getTextHayMoTaSanPhamLBL(),"Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getTextNhapSoLuongLBL(),"Nhập số lượng.");
		verifyEqual(createProductPage.getTextHayDienGiaLBL(),"Hãy điền giá.");
		verifyEqual(createProductPage.getTextHayDienCanNangSanPhamLBL(),"Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getTextKichThuocLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuCaoLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuDaiLBL(),"Bắt buộc");
		
	}
	public String proDuctName="Kieuduyen" +RandomProductName();
	
	@Test
	public void TC_04_JustUploadImageInputRandomProductName()
	{
		createProductPage.ClickOnDangButton();
		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		verifyEqual(createProductPage.getTextHayChonDanhMucLBL(),"Hãy chọn danh mục.");
		verifyEqual(createProductPage.getTextHayMoTaSanPhamLBL(),"Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getTextNhapSoLuongLBL(),"Nhập số lượng.");
		verifyEqual(createProductPage.getTextHayDienGiaLBL(),"Hãy điền giá.");
		verifyEqual(createProductPage.getTextHayDienCanNangSanPhamLBL(),"Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getTextKichThuocLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuCaoLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuDaiLBL(),"Bắt buộc");
		
	}
	
	@Test
	public void TC_05_RandomSelectDanhMuc() throws InterruptedException
	{
		
		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		//createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(2000);
		createProductPage.ClickOnChonDanhMuc2();
		createProductPage.SelectDanhMuc2();
		Thread.sleep(2000);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(1000);
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextHayMoTaSanPhamLBL(),"Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getTextNhapSoLuongLBL(),"Nhập số lượng.");
		verifyEqual(createProductPage.getTextHayDienGiaLBL(),"Hãy điền giá.");
		verifyEqual(createProductPage.getTextHayDienCanNangSanPhamLBL(),"Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getTextKichThuocLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuCaoLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuDaiLBL(),"Bắt buộc");
		Thread.sleep(3000);
	}
	@Test
	public void TC_06_RandomDanhMucAndInputDescription() throws InterruptedException
	{
		createProductPage.UploadImage(xPathOfImage);
		Thread.sleep(1000);
		createProductPage.inputProductName(proDuctName);
		Thread.sleep(3000);
//		createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(3000);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(3000);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(3000);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(2000);
		createProductPage.inputDescription("Testcase6 Description");
		Thread.sleep(1000);
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextNhapSoLuongLBL(),"Nhập số lượng.");
		verifyEqual(createProductPage.getTextHayDienGiaLBL(),"Hãy điền giá.");
		verifyEqual(createProductPage.getTextHayDienCanNangSanPhamLBL(),"Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getTextKichThuocLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuCaoLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuDaiLBL(),"Bắt buộc");
		Thread.sleep(3000);
	}
	@Test
	public void TC_07_RandomDanhMucAndInputDescriptionInputQuantity() throws InterruptedException
	{

		createProductPage.UploadImage(xPathOfImage);
		Thread.sleep(1000);
		createProductPage.inputProductName(proDuctName);
		Thread.sleep(3000);
//		createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(2000);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(2000);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(1000);
		createProductPage.ClickRandomDanhMuc3();	
		Thread.sleep(1000);
		createProductPage.inputDescription("testcase7 Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("8");
		Thread.sleep(1000);
		createProductPage.inputWeight("10001");
	//	JavascriptExecutor js = (JavascriptExecutor) driver; 
	//	js.executeScript("$('input[class*=\"ng-dirty ng-invalid\"]').val(\"12345678\")");

		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextWeightLBL(),"Cân nặng từ 50g đến 10000g.");
		verifyEqual(createProductPage.getTextKichThuocLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuCaoLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuDaiLBL(),"Bắt buộc");
		Thread.sleep(3000);
	}
	@Test
	public void TC_08_RandomDanhMucAndInputDescriptionInputQuantityInputWidth() throws InterruptedException
	{

		createProductPage.UploadImage(xPathOfImage);
		Thread.sleep(1000);
		createProductPage.inputProductName(proDuctName);
		Thread.sleep(3000);
//		createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(4000);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(2000);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(2000);
		createProductPage.ClickRandomDanhMuc3();	
		Thread.sleep(2000);
		createProductPage.inputDescription("testcase8 Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("8");
		Thread.sleep(1000);
		createProductPage.inputWeight("10001");
		Thread.sleep(1000);
		createProductPage.inputWidth("500");
		//createProductPage.inputWidthByJS("$('input[class*=\"pristine ng-invalid ng-touched\"]').val(\"123456\")");
        Thread.sleep(2000);

		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextWeightLBL(),"Cân nặng từ 50g đến 10000g.");
	//	verifyEqual(createProductPage.getTextKichThuocLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuCaoLBL(),"Bắt buộc");
		verifyEqual(createProductPage.getTextChieuDaiLBL(),"Bắt buộc");
		Thread.sleep(5000);

	}
	@Test
	public void TC_09_CreateProductSuccessfully() throws InterruptedException
	{

		createProductPage.UploadImage(xPathOfImage);
		Thread.sleep(1000);
		createProductPage.inputProductName(proDuctName);
		Thread.sleep(4000);
//		createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(4000);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(2000);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(2000);
		createProductPage.ClickRandomDanhMuc3();	
		Thread.sleep(2000);
		createProductPage.inputDescription("testcase Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("11");
		Thread.sleep(1000);
		createProductPage.inputWeight("100");
		Thread.sleep(1000);
		createProductPage.inputWidth("2");
		createProductPage.inputLength("5");
		createProductPage.inputHeight("50");
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextDangThanhCongSP(),"Bạn đã đăng thành công sản phẩm này");
		createProductPage.clickOnXemDanhMucSanPham();
		verifyEqual(createProductPage.getTextProductName(),proDuctName);
		verifyEqual(createProductPage.getTextPrice(), "đ 11,000");
        Thread.sleep(2000);

		
	
		
		
		
		
	}
	

}
