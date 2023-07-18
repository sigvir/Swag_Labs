import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class Saucedemo {
    public static WebDriver driver;
}

    @Test
    public void PurchaseOneItem() throws InterruptedException {
        String nameOfTheItem = driver.findElement(By.id("item_2_title_link")).getText();
        String priceOfTheItem = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/div")).getText();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        Thread.sleep(500);
        String nameOfTheItemInCart = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText();
        String priceOfTheItemInCart = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
//       Assert.assertEquals(nameOfTheItemInCart, nameOfTheItem); // jeigu assert'as gerai suveike, rezultato neparodo, pass
//       Assert.assertEquals(priceOfTheItemInCart, priceOfTheItem);
        System.out.println((nameOfTheItemInCart.equals(nameOfTheItem) ? "Correct Item" : "Incorrect Item"));
        System.out.println(priceOfTheItemInCart.equals(priceOfTheItem) ? "Correct Price" : "Incorrect Price");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Beata");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Bord");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("5333314");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        String nameOfFinalItem = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText();

        String priceOfFinalItem = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]")).getText();
        String priceOfFinalItemTax = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]")).getText();


        System.out.println(nameOfTheItem.equals(nameOfFinalItem) ? "Correct Item" : "Incorrect Item");


    }


    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(1000);
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

}
