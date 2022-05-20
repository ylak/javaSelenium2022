package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.eBayHonePageObjects;

import java.util.List;


import static java.lang.Thread.sleep;

public class eBayHomePageTests {
    private static WebDriver driver = null;

    public static void main(String[] args) {
        clickSearchBox();
        myEbayLinks();
        shopByCategoryComp();
        footerComp();
        footerLinks();
    }

    /*Click of Search Button*/
    public static void clickSearchBox() {
        //Setting up Chrome Driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Open the eBay Home Page, search for a keyword and click Search button
        eBayHonePageObjects pg = new eBayHonePageObjects(driver);
        driver.get("https://www.ebay.com");
        pg.textInSearchBox("ipod");
        pg.clickSearchButton();
        browserTimeOut(driver);
        System.out.println("Test completed successfully");
    }

    /*Hover on My Ebay link in header and expand the drop down menu and display all the contents from dropdown*/
    public static void myEbayLinks() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");

        //List<WebElement> subMenuLinks = driver.findElements(By.xpath("//*[@id=\"gh-ul-nav\"]/li/a"));
        Actions actions = new Actions(driver);
        WebElement myEBayHover = driver.findElement(By.id("gh-eb-My"));
        actions.moveToElement(myEBayHover).perform();

        List<WebElement> p = driver.findElements(By.xpath("//*[@id=\"gh-ul-nav\"]/li/a"));
        System.out.println("My Ebay Sub menu Links:");
        //iterate through list
        for (WebElement i : p) {
            System.out.println(i.getText());
        }
        driver.quit();
        //browserTimeOut(driver);
        System.out.println("Test completed successfully");
    }

    /*Check if Shop By Category link present
     *Click on the link
     */
    public static void shopByCategoryComp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");

        eBayHonePageObjects pg = new eBayHonePageObjects(driver);
        //Checking if the Shop By Category link present
        if (pg.shopByCat != null) {
            pg.clickShopByCatComp();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Shop by Category comp exists");
        }
        driver.close();
        System.out.println("Test completed successfully");
    }

    /*
    * Check if footer is present
    * */

    public static void footerComp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");

        eBayHonePageObjects pg = new eBayHonePageObjects(driver);
        if (pg.footerComp != null) {
            System.out.println("Footer Component is present");
        } else {
            System.out.println("Footer Component does not exists");
        }
        driver.close();
        System.out.println("Test completed successfully");
    }

    /*Check if footer component is present and iterate thro' all links*/
    public static void footerLinks() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
        //Maximize the window size
        eBayHonePageObjects pg = new eBayHonePageObjects(driver);

        browserResize(driver);
        if (pg.footerComp != null) {
            List<WebElement> footerLinks = driver.findElements(By.xpath("//*[@id=\"gf-l\"]/li/a"));
            System.out.println("Footer Comp links are:");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //iterate through list
            for (WebElement i : footerLinks) {
                System.out.println(i.getText());
            }
        }
        driver.close();
        ;
        System.out.println("Test completed successfully");
    }

    //Resize the browser window to accomadate all components on page
    private static void browserResize(WebDriver driver) {
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1024,768));
    }

    private static void browserTimeOut(WebDriver driver) {
        try {
            sleep (3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
