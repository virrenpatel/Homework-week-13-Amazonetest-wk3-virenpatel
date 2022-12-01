package amazonetest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserCanCheckHowManyProductsAreDisplayed() {

        // Click to accept cookies
        clickOnElement(By.id("sp-cc-accept"));

        // Type "Dell Laptop" in the search box
        sendTextToElement(By.xpath("//input[@id ='twotabsearchtextbox']"), "Dell Laptop");

        // Click on search button
        clickOnElement(By.xpath("//input[@id ='nav-search-submit-button']"));

        //Click on the checkbox brand dell on the left side.
        clickOnElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[5]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]"));

        // Verify that the 24 products are displayed on the page
        int expectedItem = 24;
        List<WebElement> numberOfItems = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int numberOfItemsOnPage = numberOfItems.size();
        System.out.println("Number of item on page :" + numberOfItemsOnPage);
        Assert.assertEquals(expectedItem, numberOfItemsOnPage);

        //Print all product names in the console
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class ='a-size-medium a-color-base a-text-normal']"));

        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
    }
        @After
        public void tearDown(){
            closeBrowser();
        }
    }


