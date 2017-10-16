package sstest;

import org.apache.commons.collections.functors.WhileClosure;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ss{
    private static FirefoxDriver driver;



    @BeforeClass
    public static void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ss.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void simple_search(){
            System.out.println("Test execution" + new Object() {
            }.getClass().getEnclosingMethod().getName());
            driver.findElementByXPath(".//*[@class='menu_lang']/a").click();
            driver.findElementByXPath("//a[@title= 'Объявления Электротехника']").click();
            driver.findElementByXPath("//a[@title= 'Искать объявления']").click();
            driver.findElementById("ptxt").sendKeys("Телевизор");
            driver.findElementByName("topt[8][min]").sendKeys("200");
            driver.findElementByName("topt[8][max]").sendKeys("1000");
            Select dd = new Select(driver.findElementById("s_region_select")); //Select from dropdown using Visible text
            dd.selectByVisibleText("Рига");
            driver.findElementById("sbtn").click();
            Select prc = new Select(driver.findElementByXPath("//table[@id='page_main']/tbody/tr/td/div[2]/span[3]/select")); //Select from dropdown using index
            prc.selectByIndex(1);
            driver.findElementByLinkText("Цена").click();
            driver.findElementByClassName("a9a").click();

        }


    @Test
    public void advanced_search(){
        driver.findElementByName("topt[8][min]").clear();
        driver.findElementByName("topt[8][min]").sendKeys("0");
        driver.findElementByName("topt[8][max]").clear();
        driver.findElementByName("topt[8][max]").sendKeys("300");
        Select sell = new Select(driver.findElementByName("sid"));
        sell.selectByIndex(1);
        driver.findElementById("sbtn").click();
    }
    @Test
    public void add_to_fav(){

        driver.findElementByName("mid[]").click();
        String desc1 = driver.findElementByName("mid[]").getAttribute("id");
        driver.findElementById("a_fav_sel").click();
        driver.findElementById("alert_ok").click();     //Close pop up
        driver.findElementById("show_selected_a").click();
        String desc2 = driver.findElementByName("mid[]").getAttribute("id");
        Assert.assertEquals(desc1, desc2);
        System.out.println("Value in list" + desc1);
        System.out.println("Value in fav" +desc2);
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }

}