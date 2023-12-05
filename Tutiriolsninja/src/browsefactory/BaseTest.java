package browsefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();   //object to use chrome browser
        driver.get(baseUrl);
        driver.manage().window().maximize();  //to Maximum page
    }

    public void closeBrowser()
    {   //to close Browser
        driver.quit();
    }

}
