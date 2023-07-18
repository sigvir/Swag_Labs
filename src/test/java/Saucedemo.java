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


    @Test
    public void oneItemPurchase() throws InterruptedException {
        String nameOfTheItem = driver.findElement(By.id("item_2_title_link")).getText();
        String priceOfTheItem = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/div")).getText();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        Thread.sleep(500);
        String nameOfTheItemInCart = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText();
        String priceOfTheItemInCart = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();

        System.out.println((nameOfTheItemInCart.equals(nameOfTheItem) ? "Correct Item" : "Incorrect Item"));
        System.out.println(priceOfTheItemInCart.equals(priceOfTheItem) ? "Correct Price" : "Incorrect Price");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Beata");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Bord");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("5333314");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click(); //enters buyer info, clicks continue

        String nameOfFinalItem = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText();
        String priceOfFinalItem = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]")).getText();
        String priceOfFinalItemTax = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]")).getText();

        System.out.println(priceOfFinalItem = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]")).getText().substring(13));
        System.out.println(priceOfFinalItemTax = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]")).getText().substring(6));

        double finalTotal = sum(priceOfFinalItem, priceOfFinalItemTax);
        System.out.println(finalTotal);
        System.out.println(nameOfTheItem.equals(nameOfFinalItem) ? "Correct Item" : "Incorrect Item");
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]")).click();
    }

    @Test
    public void purchaseAllItems() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click(); //add items to chart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        Thread.sleep(1000);

        String itemOneName = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(); //name of item from home page
        String itemTwoName = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).getText();
        String itemThreeName = driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText();
        String itemFourName = driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div")).getText();
        String itemFiveName = driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText();
        String itemSixName = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
        Thread.sleep(1000);

        String itemOnePrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();//price from home page
        String itemTwoPrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div")).getText();
        String itemThreePrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[2]/div")).getText();
        String itemFourPrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[2]/div[2]/div")).getText();
        String itemFivePrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[2]/div[2]/div")).getText();
        String itemSixPrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[2]/div")).getText();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click(); //click shopping cart
        String nameOfTheOneItemInTheCart = driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText(); //name of item from shopping cart page
        String nameOfTheTwoItemInTheCart = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        String nameOfTheThreeItemInTheCart = driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText();
        String nameOfTheFourItemInTheCart = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).getText();
        String nameOfTheFiveItemInTheCart = driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div")).getText();
        String nameOfTheSixItemInTheCart = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
        Thread.sleep(1000);

        String itemOnePriceInCart = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();//price from shopping cart page
        String itemTwoPriceInCart = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
        String itemThreePriceInCart = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[5]/div[2]/div[2]/div")).getText();
        String itemFourPriceInCart = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[6]/div[2]/div[2]/div")).getText();
        String itemFivePriceInCart = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[7]/div[2]/div[2]/div")).getText();
        String itemSixPriceInCart = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[8]/div[2]/div[2]/div")).getText();
        Thread.sleep(1000);

        System.out.println(nameOfTheOneItemInTheCart.equals(itemOneName) ? "Item is Correct" : "Item is not Correct"); //check if name is correct
        System.out.println(nameOfTheTwoItemInTheCart.equals(itemTwoName) ? "Item is Correct" : "Item is not Correct");
        System.out.println(nameOfTheThreeItemInTheCart.equals(itemThreeName) ? "Item is Correct" : "Item is not Correct");
        System.out.println(nameOfTheFourItemInTheCart.equals(itemFourName) ? "Item is Correct" : "Item is not Correct");
        System.out.println(nameOfTheFiveItemInTheCart.equals(itemFiveName) ? "Item is Correct" : "Item is not Correct");
        System.out.println(nameOfTheSixItemInTheCart.equals(itemSixName) ? "Item is Correct" : "Item is not Correct");

        System.out.println(itemOnePrice.equals(itemOnePriceInCart) ? "Item Price is Correct" : "Item Price is not Correct"); //check if name in shopping cart is correct
        System.out.println(itemTwoPrice.equals(itemTwoPriceInCart) ? "Item Price is Correct" : "Item Price is not Correct");
        System.out.println(itemThreePrice.equals(itemThreePriceInCart) ? "Item Price is Correct" : "Item Price is not Correct");
        System.out.println(itemFourPrice.equals(itemFourPriceInCart) ? "Item Price is Correct" : "Item Price is not Correct");
        System.out.println(itemFivePrice.equals(itemFivePriceInCart) ? "Item Price is Correct" : "Item Price is not Correct");
        System.out.println(itemSixPrice.equals(itemSixPriceInCart) ? "Item Price is Correct" : "Item Price is not Correct");

        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @Test
    public void fillBuyerInfoUsingLTChars() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click(); //add items to chart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click(); //click shopping cart
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("Grąžiną");
        driver.findElement(By.id("last-name")).sendKeys("Broom");
        driver.findElement(By.id("postal-code")).sendKeys("533321");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click(); //PASS
    }

    @Test
    public void fillBuyerInfoUsingSpecialChars() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click(); //add items to chart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click(); //click shopping cart
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("#$%^&*()-+");
        driver.findElement(By.id("last-name")).sendKeys("Broom");
        driver.findElement(By.id("postal-code")).sendKeys("533321");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click(); //PASS
    }

    @Test
    public void fillBuyerInfoUsingALotChars() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click(); //add items to chart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click(); //click shopping cart
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("gagagagaggagagagagagagagagagagggaag");
        driver.findElement(By.id("last-name")).sendKeys("Broom");
        driver.findElement(By.id("postal-code")).sendKeys("533321");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click(); //PASS
    }

    public static double sum(String a, String b) {
        return Double.parseDouble(a) + Double.parseDouble(b);
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

