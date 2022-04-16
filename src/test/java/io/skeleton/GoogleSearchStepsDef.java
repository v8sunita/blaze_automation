package io.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchStepsDef {

    ChromeDriver driver;
    WebDriverWait wait;

    public GoogleSearchStepsDef() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Given("I am on Google search page")
    public void i_am_on_google_search_page() {
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void search_for(String query) {
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys(query);
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }

    @Then("the page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver, Duration.ofSeconds(10l)).until((ExpectedCondition<Boolean>)
                driverr -> {
                    assert driverr != null;
                    return driverr.getTitle().toLowerCase().startsWith(titleStartsWith);
                });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
