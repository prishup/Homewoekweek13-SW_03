package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUpOpenBrowser() {  //navigating to the Homepage
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        WebElement elements = driver.findElement(By.xpath(menu));
        elements.click();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        actions.moveToElement(desktops).click().build().perform();

//       1.2 call selectMenu method and pass the menu = “Show All Desktops”
        Thread.sleep(1000);
        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div/a");
//
//    1.3 Verify the text ‘Desktops’
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
       System.out.println(actualResult);
       String expectedResult = "Desktops";
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
//    2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        WebElement laptops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        actions.moveToElement(laptops).click().build().perform();

//    2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("//ul[@class=\"nav navbar-nav\"]/li[2]/div/a");

//    2.3 Verify the text ‘Laptops & Notebooks’
        Thread.sleep(1000);
        String actualText2 =driver.findElement(By.tagName("h2")).getText();
        System.out.println(actualText2);
        String expectedResult2 = "Laptops & Notebooks";
       Assert.assertEquals(actualText2, expectedResult2);

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
//    3.1 Mouse hover on “Components” Tab and click
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        WebElement laptops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
        actions.moveToElement(laptops).click().build().perform();

        //  driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a")).click();
//    3.2 call selectMenu method and pass the menu = “Show All Components”
      selectMenu("//ul[@class=\"nav navbar-nav\"]/li[3]/div/a");
//
//    3.3 Verify the text ‘Components’
        Thread.sleep(1000);
        String actualResult3 = driver.findElement(By.tagName("h2")).getText();
       System.out.println(actualResult3);
       String expectedResult3 = "Components";
        Assert.assertEquals(actualResult3, expectedResult3);
//
    }
    @After
    public void endTest() {
        // closeBrowser();
    }

}
