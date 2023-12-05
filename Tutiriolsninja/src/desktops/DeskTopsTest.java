package desktops;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DeskTopsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUpOpenBrowser() {  //navigating to the Homepage
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(By.xpath("//ul[@class = 'nav navbar-nav']/li[1]"));
        //1.2 Click on “Show All Desktops”
        WebElement desktop = driver.findElement(By.xpath("//ul[@class = 'nav navbar-nav']/li[1]/div/a"));
        actions.moveToElement(computers).moveToElement(desktop).click().build().perform();
        //1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(2); // select by index
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//       2.1 Mouse hover on Desktops Tab. and click
        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(By.xpath("//ul[@class = 'nav navbar-nav']/li[1]/a"));

        // 2.2 Click on “Show All Desktops”
        WebElement desktop = driver.findElement(By.xpath("//ul[@class = 'nav navbar-nav']/li[1]/div/a"));
        actions.moveToElement(computers).moveToElement(desktop).click().build().perform();

//       2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(1); // select by index


//     2.4 Select product “HP LP3065”
        driver.findElement(By.xpath("//div[@id='content']/div[4]/div[3]/div/div[2]/div[1]/h4/a")).click();

//       2.5 Verify the Text "HP LP3065"
       Thread.sleep(1000);
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
       // String expectedTesult = "HP LP3065";
     //  Assert.assertEquals(actualResult, expectedTesult);


//        2.6 Select Delivery Date "2022-11-30"
        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[1]/div/input")).sendKeys("2022-11-30");

        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[2]/button")).click();


//        2.7.Enter Qty "1” using Select class.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[2]/input[1]")).clear();
        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div[2]/div[2]/input[1]")).sendKeys("1");


//        2.8 Click on “Add to Cart” button
        driver.findElement(By.id("button-cart")).click();

///        2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(1000);
       String actualResult1 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualResult1);
       String expectedResult1="Success: You have added HP LP3065 to your shopping cart!\n" +
               "×";
        Assert.assertEquals(actualResult1,expectedResult1);

//        2.10 Click on link “shopping cart” display into success message
     driver.findElement(By.xpath("//ul[@class='list-inline']/li[4]/a")).click();


//        2.11 Verify the text "Shopping Cart"
     String actualResult3= driver.findElement(By.xpath("//div[@id=\"top-links\"]/ul/li[4]/a")).getText();
     System.out.println(actualResult3);
     String expectedResult3 = "Shopping Cart";
     Assert.assertEquals(actualResult3,expectedResult3);

//        2.12 Verify the Product name "HP LP3065"
        Thread.sleep(1000);
       String actualResult4 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/a")).getText();
        String expectedResult4= "HP LP3065";
      Assert.assertEquals(actualResult4,expectedResult4);

//        2.13 Verify the Delivery Date "2022-11-30"
        Thread.sleep(1000);
        String actualResult5= driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[2]/small[1]")).getText();
        String expectedResult5 = "Delivery Date:2022-11-30";
       Assert.assertEquals(actualResult5,expectedResult5);

//        2.14 Verify the Model "Product21"
        String actualResult6 = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        String expectedResult6 = "Product 21";
        Assert.assertEquals(actualResult6,expectedResult6);

//        2.15 Verify the Todat "£74.73"
        Thread.sleep(1000);
        String actualResult7 = driver.findElement(By.xpath("//div[@id='content']/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
       // String expectedResult7 = "$122.00";
     //   Assert.assertEquals(actualResult7,expectedResult7);
    }
    @After
    public void endTest() {
        //   closeBrowser();
}}


