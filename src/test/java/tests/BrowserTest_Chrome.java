package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest_Chrome {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("ipod");
        driver.findElement(By.id("gh-btn")).click();
        driver.close();
        System.out.println("Test completed Successfully");
    }
}
