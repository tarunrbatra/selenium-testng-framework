package org.example.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SampleTest {

    public static void main(String[] args) {

        System.out.println("Ecommerce website sample test using Selenium");

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.get("https://rahulshettyacademy.com/client");

        webDriver.findElement(By.id("userEmail")).sendKeys("bigb@email.com");
        webDriver.findElement(By.id("userPassword")).sendKeys("P@ssword5");

        webDriver.findElement(By.id("login")).click();

        //add to cart
        List<WebElement> itemWebElements = webDriver.findElements(By.cssSelector(".mb-3"));
        itemWebElements.forEach(item -> {
            if(item.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")) {
                item.findElement(By.cssSelector("button:last-of-type")).click();
            }
        });

        //check the Added to Card message is displayed on the bottom

        //adding explicit wait, catch it till it is there
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        webDriverWait.until(ExpectedConditions.invisibilityOf( webDriver.findElement(By.cssSelector(".ng-animating"))));

        //click on Cart botton
        webDriver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

        //check if item is same as which was selected earlier
        List<WebElement> cartItemsWebElements = webDriver.findElements(By.cssSelector(".cartSection h3"));
        cartItemsWebElements.forEach(cartItem -> {
            System.out.println(cartItem.getText());
            //TODO: add assert
        });

        //click checkout
        webDriver.findElement(By.cssSelector(".totalRow button")).click();

        //select country
        Actions actions = new Actions(webDriver);
        actions.sendKeys(webDriver.findElement(By.cssSelector(".form-group input")), "United").build().perform();
        //wait for dropdown values to load
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        //select UNited Kingdom
        webDriver.findElement(By.cssSelector(".ta-item:nth-child(4)")).click();

        //click place order
        webDriver.findElement(By.cssSelector(".action__submit")).click();

        System.out.println(webDriver.findElement(By.cssSelector(".hero-primary")).getText());
        System.out.println(webDriver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText());

        //TODO: add asserts
        //THANKYOU FOR THE ORDER.
        //| 67d971bcc019fb1ad62ca46d |

        webDriver.close();
    }
}
