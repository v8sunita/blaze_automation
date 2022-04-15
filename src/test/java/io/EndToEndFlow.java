package io;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EndToEndFlow {

    ChromeDriver driver;
    WebDriverWait wait;


    public EndToEndFlow() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("at list one product is present on homepage")
    public void at_list_one_product_is_present_on_homepage() {

        driver.get("https://www.demoblaze.com/");

    }

    @When("user click on first product")
    public void user_click_on_first_product() {
        wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click();
    }

    @When("user verify product, prise and description")
    public void product_verify_prise_and_description() {
        wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//*[@id=\"tbodyid\"]/h2")));

        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/h2")).getText().equalsIgnoreCase("Samsung galaxy s6");

        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/h3")).getText().equalsIgnoreCase("$360 *includes tax");

        driver.findElement(new By.ByXPath("//*[@id=\"more-information\"]/p")).getText().equalsIgnoreCase("The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.");
    }

    @When("click add to cart")
    public void click_add_to_cart() {

        driver.findElement(new By.ByXPath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();

    }

    @Then("popup appear user click on okay")
    public void popup_appear_user_click_on_okay() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

    }

    @Then("user click on cart")
    public void user_click_on_cart() {
        driver.findElement(new By.ByXPath("//*[@id=\"cartur\"]")).click();

    }

    @Then("place order")
    public void place_order() {
        driver.findElement(new By.ByXPath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();

    }


}
