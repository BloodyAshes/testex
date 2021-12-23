import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Exercises2Test extends BaseUtils{


    @Test
    public void testRemoveItemFromCart() throws InterruptedException {
        double finalPrice = 2105.00;
        driver.get("http://demowebshop.tricentis.com/build-your-own-expensive-computer-2");

        getWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("product_attribute_74_5_26_82")))).click();
        driver.findElement(By.id("product_attribute_74_6_27_85")).click();
        driver.findElement(By.id("product_attribute_74_8_29_88")).click();
        driver.findElement(By.id("product_attribute_74_8_29_89")).click();
        driver.findElement(By.id("product_attribute_74_8_29_90")).click();
        driver.findElement(By.id("add-to-cart-button-74")).click();

        Thread.sleep(2000);
        driver.findElement(By.className("cart-qty")).getText();
        Assert.assertEquals(driver.findElement(By.className("cart-qty")).getText(), "(1)");

        driver.findElement(By.className("cart-label")).click();

        List<WebElement> item = new ArrayList<>();
        item.add(driver.findElement(By.className("cart-item-row")));
        Assert.assertEquals(item.size(), 1);

        String actualPrice = driver.findElement(By.className("product-subtotal")).getText();
        double actualResult = Double.parseDouble(actualPrice);
        Assert.assertEquals(finalPrice, actualResult);

        driver.findElement(By.name("removefromcart")).click();
        driver.findElement(By.name("updatecart")).click();
    }
}
