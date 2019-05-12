package BecowTestcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BecowActions.CreateProductPage;
import BecowActions.DashboardPage;
import BecowActions.HomePage;
import BecowActions.LoginPage;
import BecowUI.CreateProductPageUI;
import CommonPage.Commontestcase;
import ObjectPageJson.JsonData;


public class CreateProductScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	DashboardPage dashBoardPage;
	CreateProductPage createProductPage;
	String userPath = System.getProperty("user.dir");
	String xPathOfImage = userPath.concat("\\image\\flower.jpg");
	JsonData jsondata;
    

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) throws InterruptedException {
		driver = openMultiBrowser(browser, version, url);

		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = homePage.ClickDangNhapBTN();
		loginPage.inputUserName("genymotionios@gmail.com");
		loginPage.inputPassword("1234@abcd");
		dashBoardPage = loginPage.clickDangNhap();
		Thread.sleep(2000);
		dashBoardPage.ClickOnKenhBanHang();
		createProductPage = dashBoardPage.ClickOnKenhBanHang();
		Thread.sleep(5000);
		// createProductPage.ClickOnTaoSanPham();
		// createProductPage.ClickOnDangSanPhamByJS("$('li.inner-menu-mobile
		// a[beetranslate*=\"uploadProduct\"] span')";
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("$('li.inner-menu-mobile a[beetranslate*=\"uploadProduct\"]
		// span')");

	}

	@BeforeMethod
	public void BeforeMethod() throws InterruptedException {
		createProductPage.ClickOnTaoSanPham();
		createProductPage.ClickOnThoiTrangNam();
		// createProductPage.ClickOnThoiTrangNamByJS();
		Thread.sleep(500);
		
	}

//	@Test
	public void TC_01_URL_UploadProduct() throws InterruptedException {
		Thread.sleep(2000);
		verifyEqual(createProductPage.getCurrentUrl(), "https://www.beecow.com/page/upload-product");

	}

	 @Test
	public void TC_09_CreateProductWithoutInputRequireFields() {
		jsondata = getDataJson(userPath.concat("\\Data\\Becow.json"));
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().ChooseImage()),
				jsondata.NewProductExpectedMsgPage().HayChonHinhAnhChoSanPham());
		
		//verifyEqual(createProductPage.getTextDynamicMsg("error.category"), "Hãy chọn danh mục.");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorcategory()),
				jsondata.NewProductExpectedMsgPage().HayChonDanhMuc());
	//	verifyEqual(createProductPage.getTextDynamicMsg("error.description"), "Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errordescription()),
				jsondata.NewProductExpectedMsgPage().HayMoTaSanPham());
		//verifyEqual(createProductPage.getTextDynamicMsg("error.itemQty"),"Nhập số lượng.");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().ErroritemQty()),
				jsondata.NewProductExpectedMsgPage().HayNhapSoLuong());
		//verifyEqual(createProductPage.getTextDynamicMsg("error.price"), "Hãy điền giá.");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorprice()),
				jsondata.NewProductExpectedMsgPage().HayDienGia());
		//verifyEqual(createProductPage.getTextDynamicMsg("shipping.require"), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Shippingrequire()),
				jsondata.NewProductExpectedMsgPage().HayDienCanNangSanPham());
		
	//	verifyEqual(createProductPage.getTextDynamicMsg("width.require"), "Bắt buộc");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
	//	verifyEqual(createProductPage.getTextDynamicMsg("length.require"), "Bắt buộc");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
	//	verifyEqual(createProductPage.getTextDynamicMsg("height.require"), "Bắt buộc");
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
	}

	@Test
	public void TC_10_JustUploadImage() {
		createProductPage.UploadImage(xPathOfImage);
		createProductPage.ClickOnDangButton();	
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().ProductName()),
				jsondata.NewProductExpectedMsgPage().HayDienTenSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorcategory()),
				jsondata.NewProductExpectedMsgPage().HayChonDanhMuc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errordescription()),
				jsondata.NewProductExpectedMsgPage().HayMoTaSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().ErroritemQty()),
				jsondata.NewProductExpectedMsgPage().HayNhapSoLuong());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorprice()),
				jsondata.NewProductExpectedMsgPage().HayDienGia());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Shippingrequire()),
				jsondata.NewProductExpectedMsgPage().HayDienCanNangSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());

	}

	public String proDuctName = "Kieuduyen" + RandomProductName();

	@Test
	public void TC_11_JustUploadImageInputRandomProductName() {
		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorcategory()),
				jsondata.NewProductExpectedMsgPage().HayChonDanhMuc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errordescription()),
				jsondata.NewProductExpectedMsgPage().HayMoTaSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().ErroritemQty()),
				jsondata.NewProductExpectedMsgPage().HayNhapSoLuong());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorprice()),
				jsondata.NewProductExpectedMsgPage().HayDienGia());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Shippingrequire()),
				jsondata.NewProductExpectedMsgPage().HayDienCanNangSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());

	}

    @Test
	public void TC_12_RandomSelectDanhMuc() throws InterruptedException {

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		// createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnDangButton();
		createProductPage.ClickOnChonDanhMuc2();
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);		
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errordescription()),
				jsondata.NewProductExpectedMsgPage().HayMoTaSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().ErroritemQty()),
				jsondata.NewProductExpectedMsgPage().HayNhapSoLuong());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorprice()),
				jsondata.NewProductExpectedMsgPage().HayDienGia());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Shippingrequire()),
				jsondata.NewProductExpectedMsgPage().HayDienCanNangSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
	}


   @Test
	public void TC_14_RandomDanhMucAndInputDescription() throws InterruptedException {
		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
//		createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("Testcase6 Description");
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().ErroritemQty()),
				jsondata.NewProductExpectedMsgPage().HayNhapSoLuong());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorprice()),
				jsondata.NewProductExpectedMsgPage().HayDienGia());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Shippingrequire()),
				jsondata.NewProductExpectedMsgPage().HayDienCanNangSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
	}

	@Test
	public void TC_15_RandomDanhMucAndInputDescriptionInputQuantity() throws InterruptedException {

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
//		createProductPage.ClickOnChonDanhMuc1();
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("testcase7 Description");
		createProductPage.inputQuantity("10");
		createProductPage.ClickOnDangButton();

		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Errorprice()),
				jsondata.NewProductExpectedMsgPage().HayDienGia());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Shippingrequire()),
				jsondata.NewProductExpectedMsgPage().HayDienCanNangSanPham());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
	}
	@Test
	public void TC_16_RandomDanhMucAndInputDescriptionInputQuantityInputPrice() throws InterruptedException {

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("testcase7 Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("8");
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
	}


	@Test
	public void TC_17_RandomDanhMucAndInputDescriptionInputQuantityInputWeight49() throws InterruptedException {

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("testcase8 Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("8");
		createProductPage.inputWeight("49");
		//Thread.sleep(1000);
		// createProductPage.inputWidth("500");
		//createProductPage.inputWidthByJS("$('input[formcontrolname=\"width\"]').val('500')");
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextWeightLBL(), jsondata.NewProductExpectedMsgPage().CanNangTu50Den1000());
		
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		Thread.sleep(5000);

	}
	 @Test
	public void TC_18_RandomDanhMucAndInputDescriptionInputQuantityInputWeight10001() throws InterruptedException {

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("testcase8 Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("8");
		createProductPage.inputWeight("10001");
		createProductPage.ClickOnDangButton();
        verifyEqual(createProductPage.getTextWeightLBL(), jsondata.NewProductExpectedMsgPage().CanNangTu50Den1000());
		
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
				jsondata.NewProductExpectedMsgPage().BatBuoc());
		Thread.sleep(5000);
		Thread.sleep(5000);

	}
	 @Test
		public void TC_19_RandomDanhMucAndInputDescriptionInputQuantityInputWeight50() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase8 Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("8");
			createProductPage.inputWeight("50");
			createProductPage.ClickOnDangButton();		
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			Thread.sleep(5000);
			Thread.sleep(5000);

		}
	// @Test
		public void TC_20_RandomDanhMucAndInputDescriptionInputQuantityInputWeight1000() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase8 Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("8");
			createProductPage.inputWeight("1000");
			createProductPage.ClickOnDangButton();			
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			Thread.sleep(5000);

		}
		@Test
		public void TC_21_InputWith0() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("0");
			createProductPage.ClickOnDangButton();
		//	verifyEqual(createProductPage.getTextWidthLBL(), "Từ 1cm tới 50cm");
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrange()),
					jsondata.NewProductExpectedMsgPage().ChieuRongTu1Den50());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());

		}
		@Test
		public void TC_22_InputWith51() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("51");
			createProductPage.ClickOnDangButton();
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Widthrange()),
					jsondata.NewProductExpectedMsgPage().ChieuRongTu1Den50());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());

		}
		@Test
		public void TC_23_InputWith1() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("1");
			createProductPage.ClickOnDangButton();
			//verifyEqual(createProductPage.getTextWidthLBL(), "Từ 1cm tới 50cm");
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());

		}
		@Test
		public void TC_24_InputWith50() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("50");
			createProductPage.ClickOnDangButton();
			//verifyEqual(createProductPage.getTextWidthLBL(), "Từ 1cm tới 50cm");
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());

		}
		@Test
		public void TC_25_InputLength0() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("51");
			createProductPage.inputLength("0");
			createProductPage.ClickOnDangButton();		
			//verifyEqual(createProductPage.getTextLengthLBL(), "Từ 1cm tới 30cm");
			//verifyEqual(createProductPage.getTextDynamicMsg("length.range"),"Từ 1cm tới 30cm");
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrange()),
					jsondata.NewProductExpectedMsgPage().ChieuDaiTu1Den30());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
			//verifyEqual(createProductPage.getTextChieuCaoLBL(), "Bắt buộc");

		}
		@Test
		public void TC_26_InputLength31() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("51");
			createProductPage.inputLength("31");
			createProductPage.ClickOnDangButton();		
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Lengthrange()),
					jsondata.NewProductExpectedMsgPage().ChieuDaiTu1Den30());
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());

		}
		@Test
		public void TC_27_InputLength1() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("51");
			createProductPage.inputLength("1");
			createProductPage.ClickOnDangButton();	
			//verifyEqual(createProductPage.getTextLengthLBL(), "Từ 1cm tới 30cm");
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());
		}
		@Test
		public void TC_28_InputLength30() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("51");
			createProductPage.inputLength("30");
			createProductPage.ClickOnDangButton();		
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrequire()),
					jsondata.NewProductExpectedMsgPage().BatBuoc());

		}
		@Test
		public void TC_29_InputHeight0() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("51");
			createProductPage.inputLength("30");
			createProductPage.inputHeight("0");
			createProductPage.ClickOnDangButton();		
			//verifyEqual(createProductPage.getTextHeightLBL(), "Từ 1cm tới 50cm");
			//verifyEqual(createProductPage.getTextDynamicMsg("height.range"),"Từ 1cm tới 50cm");
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrange()),
					jsondata.NewProductExpectedMsgPage().ChieuCaoTu1Den50());

		}
		@Test
		public void TC_30_InputHeight51() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			createProductPage.inputWidth("51");
			createProductPage.inputLength("30");
			createProductPage.inputHeight("51");
			createProductPage.ClickOnDangButton();		
			//verifyEqual(createProductPage.getTextDynamicMsg("height.range"),"Từ 1cm tới 50cm");
			verifyEqual(createProductPage.getTextDynamicMsg(jsondata.NewProductMsgPageJson().Heightrange()),
					jsondata.NewProductExpectedMsgPage().ChieuCaoTu1Den50());
		}
	@Test
	public void TC_31_CreateProductSuccessfullyIfInputHeight1() throws InterruptedException {

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("testcase Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("11");
		createProductPage.inputWeight("100");
		createProductPage.inputWidth("2");
		createProductPage.inputLength("5");
		createProductPage.inputHeight("1");
		createProductPage.ClickOnDangButton();
		Thread.sleep(2000);
		verifyEqual(createProductPage.getTextDangThanhCongSP(), jsondata.NewProductExpectedMsgPage().BanDaDangThanhCongSanPhamNay());
		createProductPage.clickOnXemDanhMucSanPham();
		verifyEqual(createProductPage.getTextProductName(), proDuctName);
		verifyEqual(createProductPage.getTextPrice(), "đ 11,000");

	}
	@Test
	public void TC_32_CreateProductSuccessfullyIfInputHeight50() throws InterruptedException {

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("testcase Description");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("11");
		createProductPage.inputWeight("100");
		createProductPage.inputWidth("2");
		createProductPage.inputLength("5");
		createProductPage.inputHeight("50");
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextDangThanhCongSP(), jsondata.NewProductExpectedMsgPage().BanDaDangThanhCongSanPhamNay());
		createProductPage.clickOnXemDanhMucSanPham();
		verifyEqual(createProductPage.getTextProductName(), proDuctName);
		verifyEqual(createProductPage.getTextPrice(), "đ 11,000");
	}
	@Test
	public void TC_33_AllFieldsLikeUserInputted() throws InterruptedException {
		proDuctName = "Kieuduyen" + RandomProductName();

		createProductPage.UploadImage(xPathOfImage);
		createProductPage.inputProductName(proDuctName);
		createProductPage.SelectDanhMuc1();
		Thread.sleep(500);
		createProductPage.ClickOnChonDanhMuc2();
		Thread.sleep(500);
		createProductPage.SelectDanhMuc2();
		Thread.sleep(500);
		createProductPage.ClickRandomDanhMuc3();
		Thread.sleep(500);
		createProductPage.inputDescription("testcase Description");
		createProductPage.inputOnSKU("ABC");
		createProductPage.inputQuantity("10");
		createProductPage.inputPrice("11");
		createProductPage.inputWeight("100");
		createProductPage.inputWidth("2");
		createProductPage.inputLength("5");
		createProductPage.inputHeight("50");
		createProductPage.ClickOnDangButton();
		verifyEqual(createProductPage.getTextDangThanhCongSP(), jsondata.NewProductExpectedMsgPage().BanDaDangThanhCongSanPhamNay());
		createProductPage.clickOnXemDanhMucSanPham();
		verifyEqual(createProductPage.getTextProductName(), proDuctName);
		verifyEqual(createProductPage.getTextPrice(), "đ 11,000");
		//o Truong Hop nay co Hover hay ko can Hover deu dung
		createProductPage.hoverOnProductName(proDuctName);
		createProductPage.clickOnProductName(proDuctName);			
		String NameOfProduct=createProductPage.getTextJS("return $('#name').val()");
		//Thread.sleep(5000);
		verifyEqual(NameOfProduct, proDuctName);
		Thread.sleep(2000);
		verifyEqual(createProductPage.getTextJS("return $('div[class=\"fr-element fr-view\"] p').text()"), "testcase Description");
		verifyEqual(createProductPage.getTextJS("return $('#org-sku').val()"), "ABC");
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"totalItem\"]').val()"), "10");
		verifyEqual(createProductPage.getTextJS("return $('#original-price').val()"), "11,000");
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"weight\"]').val()"), "100");
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"width\"]').val()"), "2");		
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"length\"]').val()"), "5");	
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"height\"]').val()"), "50");
		
	}
	 @Test
		public void TC_34_UpdateQuantityIs0WillShowHetHang() throws InterruptedException {

			createProductPage.UploadImage(xPathOfImage);
			createProductPage.inputProductName(proDuctName);
			createProductPage.SelectDanhMuc1();
			Thread.sleep(500);
			createProductPage.ClickOnChonDanhMuc2();
			Thread.sleep(500);
			createProductPage.SelectDanhMuc2();
			Thread.sleep(500);
			createProductPage.ClickRandomDanhMuc3();
			Thread.sleep(500);
			createProductPage.inputDescription("testcase Description");
			createProductPage.inputQuantity("10");
			createProductPage.inputPrice("11");
			createProductPage.inputWeight("100");
			// createProductPage.inputWidthByJS("$('input[class*=\"pristine ng-invalid
			// ng-touched\"]').val(\"500\")");
			createProductPage.inputWidth("2");
			createProductPage.inputLength("5");
			createProductPage.inputHeight("50");
			createProductPage.ClickOnDangButton();
			verifyEqual(createProductPage.getTextDangThanhCongSP(), jsondata.NewProductExpectedMsgPage().BanDaDangThanhCongSanPhamNay());
			createProductPage.clickOnXemDanhMucSanPham();
			Thread.sleep(10000);
			createProductPage.clickOnEditProduct();
			Thread.sleep(3000);
			createProductPage.clickOnEditQuantity();
			createProductPage.editQuantity("0");
			createProductPage.clickOnUpdateQuantity();
			createProductPage.ClickOnDangButton();
			createProductPage.clickOnXemChiTietSP();
			verifyEqual(createProductPage.getTextHetHangLBL(), jsondata.NewProductExpectedMsgPage().HetHang());
		}

	@AfterMethod
	public void AfterMethod() {
		 createProductPage.navigate("https://www.beecow.com/page/page9985259");
	}

}
