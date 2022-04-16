package io;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class YourStoreAutomation {

    ChromeDriver driver;

    public YourStoreAutomation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Before()
    public void beforeClass()
    {}

    @Ignore()
    public void inogre()
    {

    }


    @Given("user is on homepage")
    public void user_is_on_homepage() {
        driver.get("https://demo.opencart.com/index.php?route=common/home");
    }

    @Then("user click on all navbar title")
    public void user_click_on_all_navbar_title() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(new By.ByXPath("//*[@id=\"menu\"]/div[2]/ul/li/a"));
        AtomicInteger count = new AtomicInteger(0);

        list.forEach(webElement -> {
            try {
                if (count.get() != 3)
                    webElement.click();
                count.getAndIncrement();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }


}
