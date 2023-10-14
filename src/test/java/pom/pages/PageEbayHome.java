package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageEbayHome extends PageBase{

//    WebDriver driver;

    private String selectedCategoryStr;

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement tfSearchField;

    @FindBy(xpath = "//select[@id='gh-cat']")
    public WebElement selectCategory;

    @FindBy(xpath = "//input[@id='gh-btn']")
    public WebElement btnSearchButton;

    public PageEbayHome(WebDriver driver) {
        super(driver);
//        this.driver = driver;
    }

    public void typeOnSearchField(String value) {
        tfSearchField.sendKeys(value);
    }

    public void selectCategoryFromVisibleText(String visibleText) {
        new Select(selectCategory).selectByVisibleText(visibleText);
        selectedCategoryStr = visibleText;
    }

    //    public PageCellPhonesAndAccessories clickSearchButton(){
    //put Object instead of <T> T
    public <T> T clickSearchButton() {
        btnSearchButton.click();
        if (selectedCategoryStr.equalsIgnoreCase("Cell Phones & Accessories")) {
            return PageFactory.initElements(driver, (Class<T>) PageCellPhonesAndAccessories.class);
        } else if (selectedCategoryStr.equalsIgnoreCase("Clothing, Shoes & Accessories")) {
            return PageFactory.initElements(driver, (Class<T>) PageClothingShoesAndAccessories.class);
        }
        return null;
    }
}

