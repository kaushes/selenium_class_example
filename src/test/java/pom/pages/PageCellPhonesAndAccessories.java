package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageCellPhonesAndAccessories extends PageBase{

//    WebDriver driver;

    public PageCellPhonesAndAccessories(WebDriver driver){
        super(driver);
//        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Apple']/parent::*/parent::*/parent::*//input")
    public WebElement chbBrandApple;

    public void clickOnAppleBrand(){
        chbBrandApple.click();
    }

//    public void scrollPageByPixel(int x, int y){
//        new Actions(driver).scrollByAmount(x, y).perform();
//    }
}
