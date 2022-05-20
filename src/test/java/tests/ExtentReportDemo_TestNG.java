package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExtentReportDemo_TestNG {
    ExtentSparkReporter htmlReport;
    ExtentReports report;
    WebDriver driver;


    @BeforeSuite //Means this will execute only once. This helps when we have multiple test cases instead of one
    public void setUpTest() {
        htmlReport = new ExtentSparkReporter("extentReport1.html");
        report = new ExtentReports();
        report.attachReporter(htmlReport );

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        ExtentTest test = report.createTest("Extent Report Test with TestNG");
        test.log(Status.INFO, "Starting the test case");
        driver.get("https://www.ebay.com");
        test.pass("Navigated to eBay Home Page");
    }

    @Test
    public void searchTest() {
        ExtentTest test = report.createTest("search Functionality Test case");
        driver.findElement(By.id("gh-ac")).sendKeys("ipod");
        test.pass("Entered the search text in text box");

        driver.findElement(By.id("gh-btn")).click();
        test.pass("Clicked the Search button on Home page");

        test.addScreenCaptureFromPath("extentReportScreenshot.png");
    }

    @Test
    public void footerComp() {
        ExtentTest test = report.createTest("Footer Component exists");
        WebElement footerComp = driver.findElement(By.id("gf-t-box"));

        if(footerComp!=null) {
            test.pass("Footer Comp is present");
        } else {
            test.fail("Footer comp is missing");
        }
        test.addScreenCaptureFromPath("extentReportScreenshot.png");
    }

    @Test
    public void shopByCatComp() {
        ExtentTest test = report.createTest("Shop By Category Component exists");
        WebElement shopByCat = driver.findElement(By.id("gh-shop-a"));
        if(shopByCat!=null) {
            test.pass("Shop By Category Comp is present");
        } else {
            test.fail("Shop By Category component is missing");
        }
        test.addScreenCaptureFromPath("extentReportScreenshot.png");
    }

    @AfterSuite
    public void tearDown() {
        ExtentTest test = report.createTest("Brwoser Session Completed successfully");
        driver.close();
        test.pass("Browser session completed successfully");
        report.flush(); // To generate the html report
    }
}
