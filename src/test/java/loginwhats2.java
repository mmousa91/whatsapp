import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class loginwhats2 {

    WebDriver driver ;
    Actions action ;
String Text ;


    @BeforeTest
    public void open (){

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromePath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openBrowser() throws InterruptedException, IOException {
/*
        //driver.navigate().to("http://justnotepad.com/");
        driver.navigate().to("http://justnotepad.com/get/912ae5625bb5188d37fa7d9330562577");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement m =driver.findElement(By.id("editable_text"));
        Text = m.getAttribute("value");

       driver.switchTo().newWindow(WindowType.TAB);
*/
        Text = "hello mohamed " + '\n' + "welcome ";
        action.keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).keyUp(Keys.SHIFT).build().perform();


        driver.navigate().to("https://web.whatsapp.com/");

        for ( String handel : driver.getWindowHandles()) {
            driver.switchTo().window(handel);
        }
        Thread.sleep(20000);

    }

@Test (priority = 2)
    public void  iteration () throws InterruptedException, IOException {
    File file = new File("C:\\Users\\MMousa\\Downloads\\num.xlsx");

    //Create an object of FileInputStream class to read excel file
    FileInputStream inputStream = new FileInputStream(file);

    //Creating workbook instance that refers to .xlxs file
    XSSFWorkbook wb = new XSSFWorkbook(inputStream);

    //Creating a Sheet object using the sheet Name
    XSSFSheet sheet = wb.getSheet("phones3");
    //  XSSFSheet sheetMsg = wb.getSheet("Msg");

    //Create a row object to retrieve row at index 1
    XSSFRow row1 = sheet.getRow(0);
    // XSSFRow rowMsg = sheetMsg.getRow(0);

    //Create a cell object to retreive cell at index 0
    XSSFCell cell1 = row1.getCell(0);
    // XSSFCell cellMsg = rowMsg.getCell(0);


    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    for (int i = 0; i <= rowCount; i++)
    {
        //get cell count in a row
        int cellcount = sheet.getRow(i).getLastCellNum();

        for (int j = 0; j < cellcount; j++) {//*[@id="side"]/div[1]/div/div/div[2]/div/div[1]
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).clear();
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).sendKeys(sheet.getRow(i).getCell(j).getStringCellValue());
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).sendKeys(Keys.ENTER);
Thread.sleep(4000);
            WebElement insideText =driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]"));
            boolean insideText1 = true;
               if (insideText1== insideText.isDisplayed())
            {
                insideText.sendKeys(Text);
                Thread.sleep(3000);
                insideText.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
                action.sendKeys(Keys.ESCAPE).build().perform();
            }


        }

    }
}

                @AfterTest
    public void closeBrowser () throws InterruptedException
                {

        Thread.sleep(10000);
        driver.quit();
            }
}