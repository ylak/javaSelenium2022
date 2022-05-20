import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Testng_Demo2 {
    WebDriver driver = null;

    @BeforeTest
    public void setUpTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void clickShopByCatComp() {
        driver.get("https://www.ebay.com");
        driver.findElement(By.id("gh-shop-a")).click();
    }

    @AfterTest
    private void tearDownTest() {
        driver.close();
        System.out.println("Test completed successfully");
    }
}
