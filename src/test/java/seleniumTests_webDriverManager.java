import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class seleniumTests_webDriverManager {
    public static void main(String[] args) {
        //To executes tests on Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //To execute tests on FF
       /* WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();*/
        driver.get("https://www.ebay.com");
        try
        {
            sleep(3000) ;
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
