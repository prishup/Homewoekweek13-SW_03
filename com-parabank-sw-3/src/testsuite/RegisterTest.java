package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUpOpenBrowser() {  //navigating to the Homepage
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay() {
//        * click on the ‘Register’ link
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/p[2]/a")).click();

        //       * Verify the text ‘Signing up is easy!’
        String actualText = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/h1")).getText();
        System.out.println(actualText);
        String expextedText = "Signing up is easy!";
        Assert.assertEquals(actualText,expextedText);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {
//  * click on the ‘Register’ link
        driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/p[2]/a")).click();

// * Enter First name
        driver.findElement(By.id("customer.firstName")).sendKeys("kinja");
//* Enter Last name
        driver.findElement(By.id("customer.lastName")).sendKeys("sha");
//  * Enter Address
        driver.findElement(By.id("customer.address.street")).sendKeys("153@yahoo.com");
//  * Enter City
        driver.findElement(By.id("customer.address.city")).sendKeys("london");
//  * Enter State
        driver.findElement(By.id("customer.address.state")).sendKeys("Middlesex");
//  * Enter Zip Code
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("ha27ur");
//* Enter Phone
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1245789654");
//* Enter SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("1245");
//* Enter Username
        driver.findElement(By.id("customer.username")).sendKeys("ksh122");
//* Enter Password
        driver.findElement(By.id("customer.password")).sendKeys("134578");
//* Enter Confirm
        driver.findElement(By.id("repeatedPassword")).sendKeys("134578");
//* Click on REGISTER button
        driver.findElement(By.xpath("//form[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
//* Verify the text 'Your account was created successfully. You are now logged in."
        Thread.sleep(1000);
        String actualText1 = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/p")).getText();
        System.out.println(actualText1);
        String expectedText1 = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(actualText1, expectedText1);
    }
    @After
    public void endTest() {
        closeBrowser();
    }
}