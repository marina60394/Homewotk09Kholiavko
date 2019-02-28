package com.aqacources.tests.pages;

import com.aqacources.tests.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marina on 19.02.2019.
 */
public class AbstractPage {

    String currentPageURL;

    // Web Elements
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;

    @FindBy(xpath = "//div[@class='header_user_info']/a[@class='logout']")
    private WebElement logOut;

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='Dresses']")
    private WebElement menuDresses;

    // Instances of BaseTest
    protected BaseTest testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on Sign In link
     *
     * @return new instance of LoginPage
     */
    public LoginPage clickSignInLink() {
        testClass.waitTillElementIsVisible(signInLink);
        signInLink.click();
        return new LoginPage(testClass);
    }

    /**
     * get Current URL
     *
     * @param
     * @return
     */
    public String getTitle() {
        currentPageURL = testClass.getDriver().getTitle();
        return currentPageURL;
    }


    /**
     * Click Log Out
     */
    public void logOut() {
        logOut.click();
    }

    /**
     * Click to menu Dresses
     *
     * @return new instance of Category page
     */
    public DressesPage clickMenuDresses() {
        testClass.waitTillElementIsVisible(menuDresses);
        menuDresses.click();
        return new DressesPage(testClass);
    }

}

