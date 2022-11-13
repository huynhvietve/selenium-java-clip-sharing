package clipsharing.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void loadHomePageTest() {
    Assert.assertTrue(getWebDriver().findElement(By.className("text-header")).isDisplayed());
    Assert.assertEquals("FUNNY MOVIES", getWebDriver().findElement(By.className("text-header")).getText());

    String xPath = "//*[@id=\"root\"]/div[2]/nav/ul/li/p";
    WebElement loginElement = getWebDriver().findElement(By.xpath(xPath));
    System.out.println(loginElement.getText());
    Assert.assertEquals("Login", loginElement.getText());
  }

}
