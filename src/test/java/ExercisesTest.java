import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ExercisesTest extends BaseUtils{


@Test
    public void testAddItemToCart() throws InterruptedException {
    int maxPrice = 0;

    driver.get("http://demowebshop.tricentis.com/");

    WebElement computersDrop = driver.findElement(By.xpath("//a[@href='/computers'][1]"));
    WebElement desktops = driver.findElement(By.xpath("//a[@href='/desktops'][1]"));

    Actions action = new Actions(driver);

    action.moveToElement(computersDrop).click(desktops).build().perform();

    Select display = new Select(driver.findElement(By.id("products-pagesize")));
    display.selectByVisibleText("4");

    List<WebElement> actualItems = driver.findElements(By.className("item-box"));
    Assert.assertEquals(actualItems.size(), 4);

    Select sort = new Select(driver.findElement(By.id("products-orderby")));
    sort.selectByVisibleText("Price: High to Low");

    driver.findElement(By.xpath("//div/input[@class='button-2 product-box-add-to-cart-button']")).click();
    Thread.sleep(2000);
    driver.findElement(By.className("ico-cart")).click();
    String  actualCartItem = driver.findElement(By.className("order-summary-content")).getText();
    String expectedCartItem = "Your Shopping Cart is empty!";
    Assert.assertEquals(actualCartItem, expectedCartItem);











}
}
