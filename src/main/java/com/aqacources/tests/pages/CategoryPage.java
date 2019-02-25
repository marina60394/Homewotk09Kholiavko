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

    @FindBy(xpath = "//input[@style='background: #ffffff;']")
    WebElement filterColorWhite;

    @FindBy(xpath = "//div[@class='product-container']")
    List <WebElement> productContainer;

    @FindBy(xpath = "//h1[@class='page-heading product-listing']/span[@class='heading-counter']")
    WebElement productCounter;

    private boolean isFilterSelected = false;

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
        testClass.waitTillElementIsVisible(filterColorWhite);
        filterColorWhite.click();
        isFilterSelected = true;
    }

    /**
     * verify that product amount from the message is the same with the amount of products on the page
     */
    public void compareProductAmounts() {

        if (isFilterSelected) {
            testClass.waitUntillDataIsLoad();
        }

        // get product amount from message on the page
        String productCounterAmount = productCounter.getText().replaceAll("[^\\d]", "");

        int productCounterValue = Integer.parseInt(productCounterAmount);

        Assert.assertEquals(productContainer.size(), productCounterValue);
    }
}
