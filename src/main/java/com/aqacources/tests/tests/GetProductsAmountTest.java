package com.aqacources.tests.tests;

import com.aqacources.tests.base.BaseTest;
import com.aqacources.tests.pages.CategoryPage;
import com.aqacources.tests.pages.HomePage;
import com.aqacources.tests.pages.LoginPage;
import com.aqacources.tests.pages.MyAccoutPage;
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
        CategoryPage categoryPage = myAccoutPage.clickMenuDresses();

        // click to Summer Dressses
        categoryPage.clickmenuSummerDresses();

        // compare product amount from message and products
        categoryPage.compareProductAmounts();

        // click to filter color White
        categoryPage.clickFilterColorWhite();

        // compare product amount from message and products
        categoryPage.compareProductAmounts();

        closeSite();

    }

}
