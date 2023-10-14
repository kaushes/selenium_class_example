package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public PageEbayHome openApplication(){
        driver.get("https://www.ebay.com/");
//        return new PageEbayHome(driver);
        return PageFactory.initElements(driver, PageEbayHome.class);
    }

    public void scrollPageByPixel(int x, int y){
        new Actions(driver).scrollByAmount(x, y).perform();
    }
}
