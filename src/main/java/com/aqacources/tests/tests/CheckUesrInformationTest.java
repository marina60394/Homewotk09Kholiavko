package com.aqacources.tests.tests;

import com.aqacources.tests.base.BaseTest;
import com.aqacources.tests.pages.HomePage;
import com.aqacources.tests.pages.LoginPage;
import com.aqacources.tests.pages.MyAccoutPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Marina on 19.02.2019.
 */
public class CheckUesrInformationTest extends BaseTest {

    /**
     * Open site and authorize user, check customer name and sign out
     */
    @Test
    public void testOpenSiteAndClickTheLinkTest() {

        String loginPageTitle;
        String myAccountPageTitle;

        // Initialize Home page
        HomePage homePage = openSite();

        // Click on Sign In link
        LoginPage loginPage = homePage.clickSignInLink();

        // get Title for Login Page
        loginPageTitle = loginPage.getTitle();

        // Sign In with login and password
        MyAccoutPage myAccoutPage = loginPage.signIn();

        // check customer name
        myAccoutPage.checkCustomerName();

        // log out
        myAccoutPage.logOut();

        // get Title after Sign Out
        myAccountPageTitle = myAccoutPage.getTitle();

        // check that page after click Sign In and page when user is Log Out is the same
        Assert.assertEquals(loginPageTitle, myAccountPageTitle);

        closeSite();


    }


}
