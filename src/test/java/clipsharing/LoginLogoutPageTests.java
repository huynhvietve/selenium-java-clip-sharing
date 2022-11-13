package clipsharing;

import clipsharing.common.LoginLogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogoutPageTests {

  WebDriver driver;

  @Before
  public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = getDriver();
    driver.get("https://clip-sharing-reactjs.herokuapp.com/");
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  private WebDriver getDriver() {
    return new ChromeDriver();
  }

  @Test
  public void loginAndLogoutSuccessTest() {
    LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
    loginLogoutPage.loginAndLogoutSuccessTest();
  }
}
