package UI;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Filter {

    @Test
    public void FilterAndVeifyTheResults() {
        System.setProperty("webdriver.chrome.driver", "/Users/kyang/nnty/api/testProject/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin");

        driver.findElement(By.id("site_title")).getText().equals("Active Admin Depot");
        driver.findElement(By.id("orders")).click();
        driver.findElement(By.className("count")).getText().equals(300);


        Select select = new Select(driver.findElement(By.cssSelector("#q_total_price_input > select:nth-child(2)")));
        select.selectByVisibleText("Greater than");
        driver.findElement(By.id("q_total_price")).sendKeys("200.00");
        driver.findElement(By.id("q_checked_out_at_gteq_datetime")).click();

        while (!driver.findElement(By.className("ui-datepicker-month")).getText().equals("February")) {
            driver.findElement(By.className("ui-datepicker-prev ")).click();
        }

        driver.findElement(By.className("ui-state-default")).click();
        driver.findElement(By.id("q_checked_out_at_lteq_datetime")).click();
        driver.findElement(By.className("ui-state-default")).click();
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.className("count")).getText().equals(27);

    }
}
