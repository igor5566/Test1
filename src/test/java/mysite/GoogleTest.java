package mysite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.testng.Assert.*;

public class GoogleTest extends BaseTest {
    @Test
    public void testSearchForm() {
        driver.get("http://google.com");
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchField.sendKeys("selenium", Keys.ENTER);
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".srg .g:nth-child(1)")));
        Assert.assertTrue(firstResult.getText().contains("Selenium"));

        driver.findElement(By.name("q")).sendKeys(" chemical element", Keys.ENTER);
        WebElement secondResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".srg .g:nth-child(1)")));
        wait.until(textToBePresentInElementLocated(By.cssSelector(".srg"),"element"));
     }

}
