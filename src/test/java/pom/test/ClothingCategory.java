package pom.test;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pom.pages.PageBase;
import pom.pages.PageClothingShoesAndAccessories;
import pom.pages.PageEbayHome;

public class ClothingCategory extends TestNGUtil {

    @Test
    public void searchShirt() throws InterruptedException {
        ExtentTest extentTest = extent.createTest("searchShirt");
//        PageBase pageBase = new PageBase(driver);
        PageBase pageBase = PageFactory.initElements(driver, PageBase.class);
        PageEbayHome pageEbayHome = pageBase.openApplication();
        pageEbayHome.typeOnSearchField("shirt");
        pageEbayHome.selectCategoryFromVisibleText("Clothing, Shoes & Accessories");
        Thread.sleep(3000);
        PageClothingShoesAndAccessories pageClothingShoesAndAccessories
                = pageEbayHome.clickSearchButton();
        pageClothingShoesAndAccessories.clickOnAdidasBrand();
        pageClothingShoesAndAccessories.scrollPageByPixel(0, 500);
        Thread.sleep(3000);
        extentTest.pass("searchShirt is passed");
    }
}
