package com.aqacources.tests.base;

import com.aqacources.tests.pages.HomePage;
import com.aqacources.tests.utils.YamlParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marina on 24.02.2019.
 */
public class BaseTest {

    // Instance of WebDriver
    private WebDriver driver;
    private WebDriverWait wait;

    // Product loader element
    private final static String LOADING_PRODUCT = "//ul[@class='product_list grid row']/p";

    /**
     * Constructor
     */
    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */
    public HomePage openSite() {
        driver.get(YamlParser.getYamlData().getUrl());
        return new HomePage(this);
    }

    /**
     * Close site with driver.quit()
     */
    public void closeSite() {
        driver.quit();
    }

    /**
     * Wait till element is visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Wait till Loadet isn't present
     */
    public void waitTillLoaderIsNotPresent() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADING_PRODUCT)));
    }

}
