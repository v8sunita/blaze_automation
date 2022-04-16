package io.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactAutomation {

    ChromeDriver driver;
    WebDriverWait wait;

    public ContactAutomation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // driver wait initialization
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("customer is on add to cart page")
    public void customer_is_on_add_to_cart_page() {

        driver.get("https://www.demoblaze.com/cart.html");

    }

    @When("click on contact")
    public void click_on_contact() {
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
    }

    @Then("modal from appear")
    public void modal_from_appear() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"exampleModalLabel\"]"))));

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"exampleModalLabel\"]")).getText(), "New message");

    }

    @Then("user click on close button")
    public void user_click_on_close_button() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]"))));

        driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")).click();
    }


    @Given("customer is on home page")
    public void customer_is_on_home_page() {

        driver.get("https://www.demoblaze.com/index.html");
    }

    @Then("modal form opens")
    public void modal_form_opens() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"exampleModalLabel\"]"))));

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"exampleModalLabel\"]")).getText(), "New message");
    }

    @Then("user fills form")
    public void user_fills_form() {

        driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"recipient-name\"]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"message-text\"]")).sendKeys("test");

    }

    @Then("click on send massage")
    public void click_on_send_massage() {

        driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")).click();

    }

    @Then("click on ok")
    public void click_on_ok() {
        wait.until(ExpectedConditions.alertIsPresent()); // wait until pop present
        Alert alertOK = driver.switchTo().alert(); // switch to pop up
        alertOK.accept(); // click on pop up
    }


}
