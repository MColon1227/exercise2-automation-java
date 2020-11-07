import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;
import static java.lang.System.setProperty;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class WebPageInteraction {
    @Test
    @Order(1)
    public void verifyValidUrl() {
        setProperty("webdriver.chrome.driver", BrowserCreation.properties);
        WebDriver driver = new ChromeDriver();
        driver.get(BrowserCreation.baseUrl);

        String actualUrl = driver.getCurrentUrl();
        BrowserCreation url = new BrowserCreation(driver);
        url.expectedUrl();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(actualUrl, url.expectedUrl);
        driver.close();
    }
    @Test
    @Order(2)
    public void validateTitle() {
        setProperty("webdriver.chrome.driver", BrowserCreation.properties);
        WebDriver driver = new ChromeDriver();
        driver.get(BrowserCreation.baseUrl);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.close();

    }
    @Test
    @Order(3)
    public void fillSingUp() {
        setProperty("webdriver.chrome.driver", BrowserCreation.properties);
        WebDriver driver = new ChromeDriver();
        driver.get(BrowserCreation.baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        BrowserCreation fillUp = new BrowserCreation(driver);
        fillUp.createNewAccountButton();
        fillUp.fillUpUser();
        WebElement selectMonthAvailable = new WebDriverWait(driver, (10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//html[@id='facebook']//select[@id='month']")));
            System.out.println(selectMonthAvailable.getText());
        fillUp.selectMonth();
        fillUp.selectDate();
        fillUp.selectYear();
        WebElement selectSexInputRadio = new WebDriverWait(driver, (10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html[@id='facebook']//span[@id='u_1_o']/span[1]/input[@name='sex']")));
            selectSexInputRadio.isEnabled();
        fillUp.selectFemale();
        fillUp.closeModal();

        WebElement afterCloseModal = new WebDriverWait(driver, (10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html[@id='facebook']//div[@id='content']/div/div//h2[@class='_8eso']")));
            afterCloseModal.isDisplayed();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Connect with friends and the world around you on Facebook."));
        driver.close();
    }

    @Test
    @Order(4)
    public void forgotYourAccount(){
        setProperty("webdriver.chrome.driver", BrowserCreation.properties);
        WebDriver driver = new ChromeDriver();
        driver.get(BrowserCreation.baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        BrowserCreation forgotSection = new BrowserCreation(driver);

        WebElement forgotLinkOption = new WebDriverWait(driver, (10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._6ltj > a")));
        forgotLinkOption.isEnabled();
        forgotSection.clickForgotOption();
        forgotSection.enterEmail();
        forgotSection.clickSearchButton();

        // This will capture error message
        String actual_msg=driver.findElement(By.xpath("//html[@id='facebook']//form[@id='identify_yourself_flow']//div[.='No Search Results']")).getText();
        // Store message in variable
        String expect="No Search Results";
        // Verify error message
        Assert.assertEquals(actual_msg, expect);
        driver.close();
    }
}
