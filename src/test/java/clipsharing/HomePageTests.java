package clipsharing;

import clipsharing.common.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTests {

  WebDriver driver;

  @BeforeClass
  public static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @Before
  public void setup() {
    driver = getDriver();
    driver.get("https://clip-sharing-reactjs.herokuapp.com/");
  }

  @After
  public void cleanup() {
    driver.quit();
  }

  private WebDriver getDriver() {
    return new ChromeDriver();
  }

  @Test
  public void loadHomePageTest() {
    HomePage homePage = new HomePage(driver);
    homePage.loadHomePageTest();
  }

}
