package io;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EndToEndFlow {

    WebDriver driver; // driver declaration
    WebDriverWait wait;  // driver wait declartion


    public EndToEndFlow() {
        WebDriverManager.chromedriver().setup();  // driver set up , third party library
        driver = new ChromeDriver(); // driver initialization
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // driver wait initialization
    }

    @After()
    public void closeBrowser() {
        driver.quit();   // close browser
    }

    @Given("at list one product is present on homepage")
    public void at_list_one_product_is_present_on_homepage() {

        driver.get("https://www.demoblaze.com/");  // start browser and open window

    }

    @When("user click on first product")
    public void user_click_on_first_product() {
        wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));  // wait for element to be clickable
        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click();  // then click

    }

    @When("user verify product, prise and description")
    public void product_verify_prise_and_description() {

        wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//*[@id=\"tbodyid\"]/h2"))); // wait for element to be clickable

        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/h2")).getText().equals("Samsung galaxy s6"); // verify  product name

        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/h3")).getText().equals("$360 *includes tax"); // verify product price

        driver.findElement(new By.ByXPath("//*[@id=\"more-information\"]/p")).
                getText().equals("The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor " +
                        "and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.");  // verify product description
    }

    @When("click add to cart")
    public void click_add_to_cart() {

        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click(); //click add to cart

    }

    @Then("popup appear user click on okay")
    public void popup_appear_user_click_on_okay() {
        wait.until(ExpectedConditions.alertIsPresent()); // wait until pop present
        Alert alertOK = driver.switchTo().alert(); // switch to pop up
        alertOK.accept(); // click on pop up

    }

    @Then("user click on cart")
    public void user_click_on_cart() {
        driver.findElement(new By.ByXPath("//*[@id=\"cartur\"]")).click(); // click on cart

    }

    @Then("place order")
    public void place_order() {
        driver.findElement(new By.ByXPath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click(); // then place order

    }


}
