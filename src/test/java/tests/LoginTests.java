package tests;

import dto.RegistrationBodyDto;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

public class LoginTests extends AppManager {
    LoginPage loginPage;

    @BeforeMethod
    public void goToLoginPage() {
        new SearchPage(getDriver()).clickBtnLogin();
    }

    @Test
    public void loginPositiveTest() {
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("murzik123@gmail.com")
                .password("murZik123!")
                .build();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage
                .isPopUpMessagePresent("Logged in success"));
    }
    @Test
    public void loginNegativeTest_EmptyPassword() {
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("murzik123@gmail.com")
                .password(" ")
                .build();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYallaWOWait();
        Assert.assertTrue(loginPage
                .isPopUpMessagePresent("Login or Password incorrect"));
    }
    @Test
    public void loginNegativeTest_WrongEmail() {
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("murzik123_gmail.com")
                .password("murZik123!")
                .build();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYallaWOWait();
        Assert.assertTrue(loginPage
                .validateErrorMessage("It'snot look like email"));
    }
}
