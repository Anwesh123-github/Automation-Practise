package Practise1;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListofElements {

    public static WebDriver driver;

    @Before

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        //driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

    }//end of setup

    @Test

    public void searchbox() throws InterruptedException {
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("gift card");


        WebElement searchboxbutton = driver.findElement(By.xpath("//form[@name='site-search']//div[@class='nav-right']"));
        searchboxbutton.click();

        Thread.sleep(5000);

       // List <WebElement> checkboxbuttons = driver.findElements(By.cssSelector(".a-spacing-micro"));
        //for (WebElement checkboxbutton:checkboxbuttons){
          //  System.out.println(checkboxbutton.getText());

           // if (checkboxbutton.getText().contains("Amazon"))
          //  {checkboxbutton.click();

          //  }




    }

    @Test

    //Search and Java Scroll

    public void ebaysearchbutton() throws InterruptedException {


       WebElement searchbox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchbox.sendKeys("nike");

        WebElement searchboxbutton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchboxbutton.click();

        Thread.sleep(5000);

        WebElement nikeair = driver.findElement(By.xpath("//body/div[4]/div[4]/ul[1]/li[1]/ul[1]/li[2]/ul[1]/li[4]/div[2]/ul[1]/li[1]"));
        nikeair.click();

        Thread.sleep(5000);


        WebElement productline = driver.findElement(By.xpath("//h3[contains(text(),'Product Line')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",productline);
       // js.executeScript("window.scrollBy(0,25);");

          }

          @Test

    //AutoDropDown

    public void AutoDropDown() throws InterruptedException {

        WebElement searchbox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchbox.sendKeys("gam");

        Thread.sleep(5000);

        List <WebElement> ebayDropDowns = driver.findElements(By.cssSelector(".ghAC_sugg.ui-corner-all"));

        Thread.sleep(5000);

        for (WebElement ebayDropDown:ebayDropDowns){
            System.out.println(ebayDropDown.getText());



            if (ebayDropDown.getText().contains("gameboy")) {
                ebayDropDown.click();
            }



        }







          }




}
