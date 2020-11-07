import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserCreation {
    WebDriver driver;

    String expectedUrl = "https://www.facebook.com/";

    static String baseUrl = "https://www.facebook.com/";
    final static String properties = "/Users/marisol.colon/Downloads/chromedriver 2";

    By createNewButton = By.id("u_0_2");

    By firstNameInput = By.name("firstname");
    By lastNameInput = By.name("lastname");
    By emailInput = By.name("reg_email__");
    By newPassInput = By.id("password_step_input");

    By month_button = By.cssSelector("#month > option:nth-child(4)");
    By date_button = By.cssSelector("#day > option:nth-child(16)");
    By year_button = By.cssSelector("#year > option:nth-child(39)");

    By female = By.cssSelector("span:nth-of-type(1) > input[name='sex']");
//    By male = By.cssSelector("span#u_0_y > span:nth-of-type(2)");

    By closeModal = By.xpath("//html[@id='facebook']/body/div[3]//div[@class='_8ien']/img");

    By forgotPassword = By.cssSelector("._6ltj > a");
    By enterEmail = By.id("identify_email");
    By clickSearchButton = By.id("did_submit");

    public BrowserCreation(WebDriver driver) {
        this.driver=driver;
    }
    public void expectedUrl() {
        driver.get(expectedUrl);
    }
    public void createNewAccountButton() {
        driver.findElement(createNewButton).click();
    }

    public void enterFirstName(String firsName) {
        driver.findElement(firstNameInput).sendKeys(firsName);
    }
    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterNewPass(String newPass) {
        driver.findElement(newPassInput).sendKeys(newPass);
    }
    public void fillUpUser(){
        enterFirstName("Marisol");
        enterLastName("Colon");
        enterEmail("marisolcolontest@email.com");
        enterNewPass("4724372heudhuiwhd");
    }
    public void selectMonth(){
        driver.findElement(month_button).click();
    }
    public void selectDate(){
        driver.findElement(date_button).click();
    }
    public void selectYear(){
        driver.findElement(year_button).click();
    }
    public void selectFemale(){
        driver.findElement(female).click();
    }
//    public void selectMale(){ driver.findElement(male).click();}
    public void closeModal(){
    driver.findElement(closeModal).click();
}

    public void clickForgotOption() { driver.findElement(forgotPassword).click(); }
    public void  enterEmail() { driver.findElement(enterEmail).sendKeys("marisolcolontest@email.com"); };
    public void clickSearchButton() { driver.findElement(clickSearchButton).click(); }
}