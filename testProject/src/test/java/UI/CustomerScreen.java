package UI;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerScreen {

    @Test
    public void AccessingCustomerScreen(){
        System.setProperty("webdriver.chrome.driver", "/Users/kyang/nnty/api/testProject/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin");

        driver.findElement(By.id("site_title")).getText().equals("Active Admin Depot");
        driver.findElement(By.id("order_300")).click();
        driver.findElement(By.id("page_title")).getText().equals("elva_blick14");
        driver.findElement(By.id("active_admin_comment_body")).sendKeys("my comments");
        driver.findElement(By.name("commit")).click();

        String value = driver.findElement(By.id("active_admin_comments_for_user_15")).getText();

        if (value.isEmpty()){
            System.out.println("Test failed");
        } else { System.out.println("Test passed"); }
        driver.close();
    }

}
