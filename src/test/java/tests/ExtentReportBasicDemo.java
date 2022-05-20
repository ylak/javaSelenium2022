package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportBasicDemo {
    public static void main(String[] args) {
        ExtentSparkReporter htmlReport = new ExtentSparkReporter("spark.html");
        //ExtentReports is a logger-style reporting library for automated tests.
        // A logger is simply an object to log messages or events for a specific system or application
        ExtentReports report = new ExtentReports();
        report.attachReporter(htmlReport);

        ExtentTest extentTest = report.createTest("eBay Search Test");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        extentTest.log(Status.INFO, "Starting the test case");
        driver.get("https://www.ebay.com");
        extentTest.pass("Navigated to eBay Home Page");

        driver.findElement(By.id("gh-ac")).sendKeys("ipod");
        extentTest.pass("Entered the search text in text box");

        driver.findElement(By.id("gh-btn")).click();
        extentTest.pass("Clicked the Search button on Home page");

        driver.close();
        extentTest.pass("Browser session completed successfully");
        report.flush(); // To generate the html report
    }
}
