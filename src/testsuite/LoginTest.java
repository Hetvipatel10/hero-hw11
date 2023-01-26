package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }


    @Test
    public void userShouldLoginSuccessFullyWithValidCredentials(){

        //enter username
        WebElement usernameField=driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        //enter password into password field
        WebElement passwordField=driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //click on login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

       //verify the text “Secure Area”
        WebElement text=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        String actualText=text.getText();
        String expectedText="Secure Area";
        assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){

        //enter username
        WebElement usernameField=driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");

        //enter password into password field
        WebElement passwordField=driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //click on login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();
        
        //Verify the error message “Your username is invalid"
        WebElement text1=driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualText=text1.getText();
        String expectedText="Your username is invalid!" +
                "\n×";
        assertEquals(expectedText,actualText);
        
    }
    @Test
    public void verifyThePasswordErrorMessage() {

        //enter username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");

        //enter password into password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");

        //click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //Verify the error message “Your password is invalid
        WebElement message=driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualText=message.getText();
        String expectedText="Your password is invalid!" +
                "\n×";
        assertEquals(expectedText,actualText);

    }

    @After
     public void teardown(){
        closeBrowser();
        
    }


}


   
