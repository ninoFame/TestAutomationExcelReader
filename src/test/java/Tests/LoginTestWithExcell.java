package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestWithExcell extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test (priority = 1)
    public void userCanLogin() {
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test (priority = 2)
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {
            String inValidUsername = excelReader.getStringData("Sheet1", i, 2);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);

            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            loginPage.inputUsername(inValidUsername);
            loginPage.inputPassword(validPassword);

            Thread.sleep(3000);

            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());

        }
    }

    @Test (priority = 3)
    public void userCannotLogInWithInvalidPassword () throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {
            String validUsername = excelReader.getStringData("Sheet1", 1, 0);
            String inValidPassword = excelReader.getStringData("Sheet1", i, 3);

            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            loginPage.inputUsername(validUsername);
            loginPage.inputPassword(inValidPassword);

            Thread.sleep(3000);

            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());

        }
    }

    @Test (priority = 3)
    public void userCannotLoginWithinvalidCredentials () throws InterruptedException {
        for (int i = 1; i<= excelReader.getLastRowNumber(); i++) {
            String inValidUsername = excelReader.getStringData("Sheet1", i, 2);
            String inValidPassword = excelReader.getStringData("Sheet1", i, 3);
            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            loginPage.inputUsername(inValidUsername);
            loginPage.inputPassword(inValidPassword);

            Thread.sleep(3000);

            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        }

    }
}
