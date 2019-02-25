package com.aqacources.tests.pages;

import com.aqacources.tests.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Marina on 24.02.2019.
 */
public class CategoryPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//ul[@class='tree dynamized']/li/a[contains(text(), 'Summer Dresses')]")
    WebElement menuSummerDresses;

    @FindBy(xpath = "//a[contains(text(),'White')]/span")
    WebElement filterColorWhite;

    @FindBy(xpath = "//div[@class='product-container']")
    List <WebElement> productContainer;

    @FindBy(xpath = "//h1[@class='page-heading product-listing']/span[@class='heading-counter']")
    WebElement productCounter;

    @FindBy(xpath = "//div[@id = 'layered_ajax_loader']")
    WebElement loading;

    /**
     * Constructor
     *
     * @param testClass
     */
    public CategoryPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * click to menu Dressses
     */
    public void clickmenuSummerDresses() {
        testClass.waitTillElementIsVisible(menuSummerDresses);
        menuSummerDresses.click();
    }

    /**
     * click to filter color White
     */
    public void clickFilterColorWhite() {
        testClass.waitTillElementIsClickable(filterColorWhite);
        filterColorWhite.click();
    }

    /**
     * verify that product amount from the message is the same with the amount of products on the page
     */
    public void compareProductAmounts() {

        testClass.waitTillElementIsInvisible(loading);

        // get product amount from message on the page
        String productCounterAmount = productCounter.getText().replaceAll("[^\\d]", "");

        int productCounterValue = Integer.parseInt(productCounterAmount);
        System.out.println(productCounterAmount);

        Assert.assertEquals(productContainer.size(), productCounterValue);

    }
}
