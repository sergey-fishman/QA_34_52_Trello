package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.PropertiesReader.*;

public class LoginTests extends AppManager {

    @Test
    public void loginPositiveTest() {
        new HomePage(getDriver()).clickLinkLogin();
        User user = User.builder()
                .email(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        new LoginPage(getDriver()).typeLoginForm(user);
        Assert.assertTrue(new BoardsPage(getDriver())
                .isUrlContainsText("boards"));
    }
}
