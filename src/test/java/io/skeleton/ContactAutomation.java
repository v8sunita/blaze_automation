package io.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactAutomation {

    ChromeDriver driver;
    WebDriverWait wait;

    public ContactAutomation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("customer is on add to cart page")
    public void customer_is_on_add_to_cart_page() {
        driver.get("https://www.demoblaze.com/cart.html");
        //driver.get();
    }

    @When("click on contact")
    public void click_on_contact() {
        driver.findElement(new By.ByXPath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
    }

    @Then("modal from appear")
    public void modal_from_appear() {
        driver.findElement(new By.ByXPath("//*[@id=\"exampleModalLabel\"]")).getText().equalsIgnoreCase("New message");
    }

    @Then("user click on close button")
    public void user_click_on_close_button() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(new By.ByXPath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")).click();
    }


    @Given("customer is on home page")
    public void customer_is_on_home_page() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Then("yek modal form open hoto")
    public void yek_modal_form_open_hoto() {
        driver.findElement(new By.ByXPath("//*[@id=\"exampleModalLabel\"]")).getText().equalsIgnoreCase("new massage");
    }

    @Then("input box madhe email id,contectname,massage enter krto")
    public void input_box_madhe_email_id_contectname_massage_enter_krto() throws InterruptedException {
        driver.findElement(new By.ByXPath("//*[@id=\"recipient-email\"]")).sendKeys("test@gmail.com");
        // driver.findElement(new B)

        driver.findElement(new By.ByXPath("//*[@id=\"recipient-name\"]")).sendKeys("test");
        driver.findElement(new By.ByXPath("//*[@id=\"message-text\"]")).sendKeys("test");
        Thread.sleep(3000);
    }

    @Then("click on sand massage")
    public void click_on_sand_massage() {
        driver.findElement(new By.ByXPath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")).click();

    }

    @Then("click on ok")
    public void click_on_ok() throws InterruptedException {
        Alert alertOK = driver.switchTo().alert();
        // driver.switchTo().defaultContent();
        alertOK.accept();
        Thread.sleep(3000);
    }


}
