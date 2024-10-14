package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BaseTest {
    WebDriver driver;
    WebElement logOutButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogOutButton() {

        return driver.findElement(By.linkText("Log out"));
    }

    public void  clickOnLogOutButton(){
        getLogOutButton().click();
    }
}
