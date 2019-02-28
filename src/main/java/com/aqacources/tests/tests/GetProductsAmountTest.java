package com.aqacources.tests.tests;

import com.aqacources.tests.base.BaseTest;
import com.aqacources.tests.pages.*;
import org.junit.Test;

/**
 * Created by Marina on 24.02.2019.
 */
public class GetProductsAmountTest extends BaseTest {

    @Test
    public void testGetProductAmount() throws InterruptedException {

        // Initialize Home Page
        HomePage homePage = openSite();

        LoginPage loginPage = homePage.clickSignInLink();

        // Sign In with login and password
        MyAccoutPage myAccoutPage = loginPage.signIn();

        // click to Menu Dresses
        DressesPage dressesPage = myAccoutPage.clickMenuDresses();

        //  Click to Summer Dresses
        SummerDressesPage summerDressesPage = dressesPage.clickmenuSummerDresses();

        // compare product amount from message and products
        summerDressesPage.compareProductAmounts();

        // click to filter color White
        summerDressesPage.clickFilterColorWhite();

        // compare product amount from message and products
        summerDressesPage.compareProductAmounts();

        closeSite();

    }

}
