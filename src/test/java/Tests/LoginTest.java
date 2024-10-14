package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp () {
        driver.navigate().to("https://practicetestautomation.com/");
    }
    @Test
    public void userCanLogin () {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
                loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCannotLoginWithInvalidUsername () {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("non student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());

    }

    @Test
    public void userCanLogout () {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        profilePage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }
}
