package tests;

import dto.RegistrationBodyDto;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SearchPage;

import java.util.Random;

public class RegistrationTests extends AppManager {
    RegistrationPage registrationPage;

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Bob")
                .lastName("Dilan")
                .username(i + "bob_dilan@gmail.com")
                .password("Pass123!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage
                .isPopUpMessagePresent("You are logged in success"));
    }
    @Test
    public void registrationNegativeTest_WrongEmail() {
        int i = new Random().nextInt(1000) + 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Bob")
                .lastName("Dilan")
                .username(i + "bob_dilan_gmail.com")
                .password("Pass123!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYallaWOWait();
        Assert.assertTrue(registrationPage
                .validateErrorMessage("Wrong email format"));
    }
    @Test
    public void registrationNegativeTest_EmptyLastName() {
        int i = new Random().nextInt(1000) + 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Bob")
                .lastName("")
                .username(i + "bob_dilan@gmail.com")
                .password("Pass123!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYallaWOWait();
        Assert.assertTrue(registrationPage
                .validateErrorMessage("Last name is required"));
    }
    @Test
    public void registrationNegativeTest_SpaceLastName() {
        int i = new Random().nextInt(1000) + 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Bob")
                .lastName(" ")
                .username(i + "bob_dilan@gmail.com")
                .password("Pass123!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYallaWOWait();
        Assert.assertTrue(registrationPage
                .isPopUpMessagePresent("must not be blank"));
    }
    @Test
    public void registrationNegativeTest_WOCheckBox() {
        int i = new Random().nextInt(1000) + 1000;
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Bob")
                .lastName("Dilan")
                .username(i + "bob_dilan@gmail.com")
                .password("Pass123!").build();
        new SearchPage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickBtnYallaWOWait();
        Assert.assertTrue(registrationPage.btnYallaDisabled());
    }
}
