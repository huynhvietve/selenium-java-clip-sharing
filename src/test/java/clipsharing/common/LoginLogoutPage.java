package clipsharing.common;

import org.openqa.selenium.WebDriver;

public class LoginLogoutPage extends BasePage {

  public LoginLogoutPage(WebDriver driver) {
    super(driver);
  }

  public void loginAndLogoutSuccessTest() {
    login();
    logout();
  }
}
