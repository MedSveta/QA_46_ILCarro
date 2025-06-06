package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(BasePage.class);

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWait(WebElement element, int time) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean validateTextInElementWait(WebElement element, String text, int time) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println("Create Exception " + exception.getMessage());
            return false;
        }
    }

}
