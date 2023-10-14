package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageClothingShoesAndAccessories extends PageBase{


    @FindBy(xpath = "//span[text()='adidas']/parent::*/parent::*/parent::*//input")
    public WebElement chbBrandAdidas;

    public PageClothingShoesAndAccessories(WebDriver driver){
        super(driver);
    }

    public void clickOnAdidasBrand(){
        chbBrandAdidas.click();
    }

//    public void scrollPageByPixel(int x, int y){
//        new Actions(driver).scrollByAmount(x, y).perform();
//    }
}
