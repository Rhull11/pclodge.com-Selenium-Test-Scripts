package scripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HamburgerNavigation
{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));

        driver.get("https://www.pclodge.com");

        driver.findElement(By.className("icon")).click();

        var vacationRentalsElement = driver.findElement(By.xpath("/html/body/form/header/nav/ul/li[1]/a"));

        wait.until(ExpectedConditions.visibilityOf(vacationRentalsElement));

        vacationRentalsElement.click();

        var rentalsUrl = driver.getCurrentUrl();

        Assert.assertEquals("https://www.pclodge.com/rentals", rentalsUrl);

        driver.quit();
    }
}
