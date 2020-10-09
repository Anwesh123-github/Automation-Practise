package Practise1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalenderList {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://www.southalltravel.co.uk/");
        driver.manage().window().maximize();
    } //setup ends

    @Test

    public void SouthhallTravels() throws InterruptedException {

        WebElement departingdate = driver.findElement(By.xpath("//input[@id='depdateit']"));
        departingdate.click();

        List<WebElement> alldates = driver.findElements(By.cssSelector(".ui-state-default"));

        for (WebElement alldate : alldates) {
            System.out.println(alldate.getText());

            if (alldate.getText().equals("18")) {
                alldate.click();
            }

            }}

    @Test

    public void SouthhallRet(){
        WebElement arrivaldate = driver.findElement(By.xpath("//input[@id='retdateit']"));
        arrivaldate.click();

       // WebElement returndate = driver.findElement(By.linkText("9"));
       // returndate.click();

        List<WebElement> allretdates = driver.findElements(By.cssSelector(".ui-state-default"));

        for (WebElement allretdate: allretdates){
            System.out.println(allretdate.getText());

            if (allretdate.getText().contains("9")){
            allretdate.click();}
        }

    }
















} //class ends
