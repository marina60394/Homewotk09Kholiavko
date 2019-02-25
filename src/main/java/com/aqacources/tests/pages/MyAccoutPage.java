package com.aqacources.tests.pages;

import com.aqacources.tests.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marina on 19.02.2019.
 */
public class MyAccoutPage extends AbstractPage {

    // Web Elements
    @FindBy(xpath = "//div[@class='header_user_info']/a[@class='account']/span")
    private WebElement customerAccount;


    /**
     * Constructor
     *
     * @param testClass
     */
    public MyAccoutPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Check that customer name is correct
     */
    public void checkCustomerName() {
        Assert.assertEquals("Maryna Test", customerAccount.getText());
    }

}
