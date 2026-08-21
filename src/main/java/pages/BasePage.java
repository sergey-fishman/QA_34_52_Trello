package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    static WebDriver driver;

    public void setDriver(WebDriver wd) {
        driver = wd;
    }

    public boolean isTextInElementPresent(WebElement element, String text) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions
                            .textToBePresentInElement
                                    (element, text));
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("created exception");
        }
        return false;
    }

    public void clickWait(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(7)).until
                (ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public boolean isUrlContainsText(String text) {
        try {
            return new WebDriverWait(driver,Duration.ofSeconds(5))
                    .until(ExpectedConditions.urlContains(text));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
        }
        return false;
    }
}
