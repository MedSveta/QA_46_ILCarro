package pages;

import dto.RegistrationBodyDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(id = "name")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement popUpMessage;
    @FindBy(xpath = "//div[@class='error']")
    WebElement errorMessage;

    public void typeRegistrationForm(RegistrationBodyDto user) {
        inputName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickCheckBox(){
        System.out.println(checkBox.getRect().getWidth()+"X"+
                checkBox.getRect().getHeight());
        int widthCheckBox = checkBox.getRect().getWidth();
        int heightCheckBox = checkBox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox, -widthCheckBox/3,
                -heightCheckBox/4).click().perform();
    }
    public void clickBtnYalla(){
        clickWait(btnYalla, 3);
    }
    public void clickBtnYallaWOWait(){
        btnYalla.click();
    }

    public boolean isPopUpMessagePresent(String text){
        return validateTextInElementWait(popUpMessage,
                text, 5);
    }
    public boolean validateErrorMessage(String text){
        return validateTextInElementWait(errorMessage, text, 3);
    }

    public boolean btnYallaDisabled(){
        return !btnYalla.isEnabled();
    }
}
