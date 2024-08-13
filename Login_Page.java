package Admin_Portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriverbase.AppPage;

static class BasePage {
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

    static class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password); //Line 25,26:User name and password can be done through common
								      //methods.Create method ,pass element locators to the method and acheive the sendKeys.
            driver.findElement(By.id("loginButton")).click(); //Line 28: Click also can achieve creating common methods for this.So that we achieve code reusability.

        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();
        }
    }

    static class HomePage extends BasePage {
        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) { //URL can be store it as constant in a separate constant file and call it over here.

                throw new IllegalStateException("Not on the home page");
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click(); //Element locators are hardcoded.we can keep it in object repo
        }

    public class TablePage extends BasePage {

    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");//Element locators are hardcoded.we can keep it in object repo

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }

	}
		
		

}
