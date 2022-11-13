package clipsharing.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private WebDriver driver;
  private WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  WebDriver getWebDriver(){
    return driver;
  }

  private static final String XPATH_LOGIN_BUTTON = "//*[@id=\"root\"]/div[2]/nav/ul/li/p";

  void login() {

    WebElement loginButtonElement = driver.findElement(By.xpath(XPATH_LOGIN_BUTTON));
    Assert.assertEquals("Login", loginButtonElement.getText());
    loginButtonElement.click();
    assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name"))).isDisplayed());
    assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).isDisplayed());

    driver.findElement(By.id("name")).sendKeys("huynhvietve@gmail.com");
    driver.findElement(By.id("password")).sendKeys("huynhvietve");
    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div/div/div[2]/div/div/button[2]")).submit();
    assertEquals("huynhvietve@gmail.com",
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/nav/ul/li[2]/p")))
            .getText());
  }

  void logout() {
    WebElement logoutButtonElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/nav/ul/li[1]/a"));
    Assert.assertEquals("Logout", logoutButtonElement.getText());
    logoutButtonElement.click();
    driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[3]")).click();
    assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_LOGIN_BUTTON))).isDisplayed());
  }
}
