package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class eBayHonePageObjects {

    public WebDriver driver = null;
    public By search_textBox = By.id("gh-ac");
    public By searchButton = By.id("gh-btn");
    public By shopByCat = By.id("gh-shop-a");
    public By footerComp = By.id("gf-t-box");

    public eBayHonePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void textInSearchBox(String text) {
        driver.findElement(search_textBox).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickShopByCatComp() {
        driver.findElement(shopByCat).click();
    }

}
