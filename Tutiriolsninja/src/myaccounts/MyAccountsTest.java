package myaccounts;

import browsefactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyAccountsTest extends BaseTest {
    String baseUrl ="http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUpOpenBrowser(){  //navigating to the Homepage
        openBrowser(baseUrl);
}
    public void selectMyAccountOptions(String menu) {
        driver.findElement(By.xpath(menu)).click();
    }
@Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
//    1.1 Clickr on My Account Link.
    driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();

//    1.2 Call the method “selectMyAccountOptions” method and pass the parameter
//“Register”
    selectMyAccountOptions("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[1]/a");

//    1.3 Verify the text “Register Account”.
    String actualResult= driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/h1")).getText();
    System.out.println(actualResult);
    String expectedResult = "Register Account";
    Assert.assertEquals(actualResult,expectedResult);

}
@Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
//    2.1 Clickr on My Account Link.
    driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();

//    2.2 Call the method “selectMyAccountOptions” method and pass the parameter //“Login”
    selectMyAccountOptions("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[2]/a");

//    2.3 Verify the text “Returning Customer”.
    String actualResult1= driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/h2")).getText();
    System.out.println(actualResult1);
   String expectedResult1 = "Returning Customer";
    Assert.assertEquals(actualResult1,expectedResult1);
}
@Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
//    3.1 Clickr on My Account Link.
    driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();

//    3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    selectMyAccountOptions("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[1]/a");

//    3.3 Enter First Name
    driver.findElement(By.id("input-firstname")).sendKeys("Kinja");

//    3.4 Enter Last Name
    driver.findElement(By.id("input-lastname")).sendKeys("Shh");
//    3.5 Enter Email
    driver.findElement(By.id("input-email")).sendKeys("Kshah555@yahoo.com");
//    3.6 Enter Telephone
    driver.findElement(By.id("input-telephone")).sendKeys("2154789656");
//    3.7 Enter Password
    driver.findElement(By.id("input-password")).sendKeys("123456");

//    3.8 Enter Password Confirm
    driver.findElement(By.id("input-confirm")).sendKeys("123456");

//    3.9 Select Subscribe Yes radio button
    driver.findElement(By.xpath("//div[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
//    3.10 Click on Privacy Policy check box
    driver.findElement(By.xpath("//div[@class=\"buttons\"]/div/input[1]")).click();
//    3.11 Click on Continue button
    driver.findElement(By.xpath("//div[@class=\"buttons\"]/div/input[2]")).click();

//    3.12 Verify the message “Your Account Has Been Created!”
    Thread.sleep(5000);
    String actualResult2= driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
    System.out.println(actualResult2);
    String expectedResult2 = "Your Account Has Been Created!";
    Assert.assertEquals(actualResult2,expectedResult2);


//    3.13 Click on Continue button
    driver.findElement(By.xpath("//div[@id=\"content\"]/div/div/a")).click();

//    3.14 Clickr on My Account Link.
    driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();


//    3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
    selectMyAccountOptions("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[5]/a");


//    3.16 Verify the text “Account Logout”
    Thread.sleep(5000);
    String actualResult3= driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
    System.out.println(actualResult3);
    String expectedResult3 = "Account Logout";
    Assert.assertEquals(actualResult3,expectedResult3);

//    3.17 Click on Continue button
    driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
}
@Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
//    4.1 Clickr on My Account Link.
    driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();

//    4.2 Call the method “selectMyAccountOptions” method and pass the parameter login
    selectMyAccountOptions("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[2]/a");

//    4.3 Enter Email address
    driver.findElement(By.id("input-email")).sendKeys("Kshah555@yahoo.com");

//    4.5 Enter Password
    driver.findElement(By.id("input-password")).sendKeys("123456");
//    4.6 Click on Login button
    driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")).click();

//    4.7 Verify text “My Account”
    Thread.sleep(5000);
    String actualResult3 = driver.findElement(By.xpath("//div[@id='content']/h2[1]")).getText();
    System.out.println(actualResult3);
       String expectedResult3 = "My Account";
        Assert.assertEquals(actualResult3,expectedResult3);

//    4.8 Clickr on My Account Link.
    driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();

//    4.9 Call the method “selectMyAccountOptions” method and pass the parameter logout
    selectMyAccountOptions("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[5]/a");

//    4.10 Verify the text “Account Logout”
    String actualResult4 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    System.out.println(actualResult4);
    String expectedResult4 = "Account Logout";
    Assert.assertEquals(actualResult4,expectedResult4);

//    4.11 Click on Continue button
    driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
}
}
