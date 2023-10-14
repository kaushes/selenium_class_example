package pom.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pom.pages.PageBase;
import pom.pages.PageCellPhonesAndAccessories;
import pom.pages.PageEbayHome;

public class CellPhoneCategory extends TestNGUtil {

    @Test
    public void searchMobilePhone() throws InterruptedException {
        ExtentTest extentTest = extent.createTest("searchMobilePhone");
        extentTest.log(Status.INFO, "PageBase class is calling");
//        PageBase pageBase = new PageBase(driver);
        PageBase pageBase = PageFactory.initElements(driver, PageBase.class);
        PageEbayHome pageEbayHome = pageBase.openApplication();
        extentTest.log(Status.INFO, "calling type on search field");
        pageEbayHome.typeOnSearchField("mobile phones");
        pageEbayHome.selectCategoryFromVisibleText("Cell Phones & Accessories");
        Thread.sleep(3000);
        PageCellPhonesAndAccessories pageCellPhonesAndAccessories =
                pageEbayHome.clickSearchButton();
        pageCellPhonesAndAccessories.clickOnAppleBrand();
        pageCellPhonesAndAccessories.scrollPageByPixel(0, 500);
        Thread.sleep(3000);
        extentTest.pass("searchMobilePhone method is passed");
    }

}
