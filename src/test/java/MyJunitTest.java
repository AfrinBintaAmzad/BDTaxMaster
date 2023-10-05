import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunitTest {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(800));
    }

    @DisplayName("Check if title is displayed")
    @Test
    public void a_getTitle() {
        driver.get("https://www.bdtaxmaster.com/");
        String titleActual = driver.getTitle();
        String titleExpected = "Site Title";
        Assertions.assertEquals(titleExpected, titleActual);
    }

//    @DisplayName("Check if logo is exist or not")
//    @Test
//    public void b_checkIfImageExists() {
//        driver.get("https://www.bdtaxmaster.com/");
//        boolean status = driver.findElements(By.tagName("img")).get(12).isDisplayed();
//        assertTrue(status);
//    }
    @DisplayName("Check if email field is exist or not")
    @Test
    public void c_checkLogin() {
        driver.get("https://www.bdtaxmaster.com/");

        // Find the login element by class name
        WebElement loginElement = driver.findElement(By.className("form-control")); // Assuming this class is unique for the login input

        // Check if the login element is displayed
        assertTrue(loginElement.isDisplayed(), "afrin4axiz@gmail.com");
    }

    @DisplayName("Check if password field is working or not")
    @Test
    public void d_checkLoginPassword() {
        driver.get("https://www.bdtaxmaster.com/");

        // Find the password element by class name
        WebElement passwordElement = driver.findElement(By.className("form-control-lg")); // Assuming this class is unique for the password input

        // Check if the password element is displayed
        assertTrue(passwordElement.isDisplayed(), "123456");
    }
    @DisplayName("Check submit button is worked")
    @Test
    public void e_checkSubmit(){
        driver.get("https://www.bdtaxmaster.com/dashboard");
        driver.findElement(By.id("login_form_submit")).click();
    }
    @AfterAll
    public void quitBrowser(){
        driver.quit();
    }

}