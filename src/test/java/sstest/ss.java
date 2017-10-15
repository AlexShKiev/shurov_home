package sstest;

import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ss{
    private static FirefoxDriver driver;
    WebElement element;
    int min;

    @BeforeClass
    public static void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ss.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void flow(){
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

    }
}