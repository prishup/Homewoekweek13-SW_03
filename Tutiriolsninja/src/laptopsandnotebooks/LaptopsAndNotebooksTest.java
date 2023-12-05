package laptopsandnotebooks;

import browsefactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LaptopsAndNotebooksTest extends BaseTest {
    String baseUrl ="http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUpOpenBrowser(){  //navigating to the Homepage
        openBrowser(baseUrl);

}
@Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
//    1.1 Mouse hover on Laptops & Notebooks Tab.and click
    driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();

//    1.2 Click on “Show All Laptops & Notebooks”
    driver.findElement(By.xpath("//ul[@class ='nav navbar-nav']/li[2]/div/a")).click();

//    1.3 Select Sort By "Price (High > Low)"
    WebElement dropDown = driver.findElement(By.id("input-sort"));
    Select select = new Select(dropDown);
    select.selectByIndex(4); // select by index

//    1.4 Verify the Product price will arrange in High to Low order.
}
@Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
//    2.1 Mouse hover on Laptops & Notebooks Tab and click
    driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();

//    2.2 Click on “Show All Laptops & Notebooks”
    driver.findElement(By.xpath("//ul[@class ='nav navbar-nav']/li[2]/div/a")).click();

//    2.3 Select Sort By "Price (High > Low)"
    Thread.sleep(1000);
    WebElement dropDown = driver.findElement(By.id("input-sort"));
    Select select = new Select(dropDown);
    select.selectByIndex(4); // select by index

//    2.4 Select Product “MacBook”
    driver.findElement(By.xpath("//div[@id='content']/div[4]/div[4]/div/div[2]/div[1]/h4/a")).click();


//    2.5 Verify the text “MacBook”
    String actualResult4 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
    System.out.println(actualResult4);
    String expectedResult4 = "MacBook";
    Assert.assertEquals(actualResult4,expectedResult4);

//    2.6 Click on ‘Add To Cart’ button
    driver.findElement(By.id("button-cart")).click();


//    2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
    Thread.sleep(1000);
    String actualResult5 = driver.findElement(By.xpath("//div[@id='product-product']/div[1]")).getText();
    System.out.println(actualResult5);
    String expectedResult5 = "Success: You have added MacBook to your shopping cart!\n" +
            "×";
    Assert.assertEquals(actualResult5,expectedResult5);

//    2.8 Click on link “shopping cart” display into success message
    driver.findElement(By.xpath("//ul[@class='list-inline']/li[4]/a")).click();

//    2.9 Verify the text "Shopping Cart"
    Thread.sleep(1000);
    String actualResult6= driver.findElement(By.xpath("//ul[@class='list-inline']/li[4]/a")).getText();
    System.out.println(actualResult6);
    String expectedResult6 = "Shopping Cart";
    Assert.assertEquals(actualResult6,expectedResult6);

//    2.10 Verify the Product name "MacBook"
    String actualResult7= driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
    System.out.println(actualResult7);
    String expectedTesult7= "MacBook";
    Assert.assertEquals(actualResult7,expectedTesult7);

//    2.11 Change Quantity "2"
    driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[4]/div/input")).clear();
    driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[4]/div/input")).sendKeys("2");

//    2.12 Click on “Update” Tab
    driver.findElement(By.xpath("//button[@type='submit']")).click();

//    2.13 Verify the message “Success: You have modified your shopping cart!”
    Thread.sleep(1000);
    String actualResult10 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div[1]")).getText();
    System.out.println(actualResult10);
   String expectedResult10="Success: You have modified your shopping cart!\n" +
           "×";
    Assert.assertEquals(actualResult10,expectedResult10);

//    2.14 Verify the Total £737.45
    String actualResult11= driver.findElement(By.xpath("//div[@id='content']/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
    System.out.println(actualResult11);
    String expectedResult11 = "$1,204.00";
    Assert.assertEquals(actualResult11,expectedResult11);

//    2.15 Click on “Checkout” button
    driver.findElement(By.xpath("//div[@id='content']/div[3]/div[2]/a")).click();

//    2.16 Verify the text “Checkout”
    String actualResult12= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    System.out.println(actualResult12);
    String expectedResult12 = "Checkout";
    Assert.assertEquals(actualResult12,expectedResult12);

//    2.17 Verify the Text “New Customer”
    Thread.sleep(1000);
    String actualResult13= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    System.out.println(actualResult13);
    String expectedResult13 = "Checkout";
    Assert.assertEquals(actualResult12,expectedResult13);

//    2.18 Click on “Guest Checkout” radio button
    driver.findElement(By.xpath("//div[@id='content']/div/div[1]/div[2]/div/div/div[1]/div[2]/label/input")).click();

//    2.19 Click on “Continue” tab
    driver.findElement(By.xpath("//input[@id='button-account']")).click();

//    2.20 Fill the mandatory fields
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@id=\"input-payment-firstname\"]")).sendKeys("kinjal");
    driver.findElement(By.xpath("//input[@id=\"input-payment-lastname\"]")).sendKeys("shah");
    driver.findElement(By.xpath("//input[@id=\"input-payment-email\"]")).sendKeys("kinjalshah2@yahoo.com");
    driver.findElement(By.xpath("//input[@id=\"input-payment-telephone\"]")).sendKeys("1234567892");
    driver.findElement(By.xpath("//input[@id=\"input-payment-address-1\"]")).sendKeys("bntrjhurtnbjrth");//address
    driver.findElement(By.xpath("//input[@id=\"input-payment-city\"]")).sendKeys("bntrjhurtnbjrth");
    driver.findElement(By.xpath("//input[@id=\"input-payment-postcode\"]")).sendKeys("rhrt45");

    WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"input-payment-zone\"]")); //
    Select select1 =new Select(dropdown);
    select1.selectByIndex(29);

//    2.21 Click on “Continue”Button
    driver.findElement(By.xpath("//input[@id=\"button-guest\"]")).click();

//    2.22 Add Comments About your order into text area
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div[2]/div[1]/p[2]/textarea")).sendKeys("put nicely");

     //   2.23 Check the Terms & Conditions check box
    driver.findElement(By.xpath("//div[@id=\"content\"]/div/div[3]/div[2]/div/div[2]/div/input[1]")).click();

//    2.24 Click on “Continue” button
   driver.findElement(By.id("button-payment-method")).click();


//  2.25 Verify the message “Warning: Payment method required!”
    String actualResult14= driver.findElement(By.xpath("//div[@id=\"content\"]/div[1]/div[3]/div[2]/div[1]/div[1]")).getText();
   System.out.println(actualResult14);
    String expectedResult14 = "Warning: No Payment options are available. Please contact us for assistance!";
   Assert.assertEquals(actualResult14,expectedResult14);
//
}


}

