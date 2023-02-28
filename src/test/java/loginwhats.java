import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;


public class loginwhats {

    WebDriver driver = null;
    Actions action ;



    @BeforeTest
    public void open (){
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openBrowser() throws InterruptedException, IOException {

        //driver.navigate().to("http://justnotepad.com/");
        driver.navigate().to("http://justnotepad.com/get/807dc12dcf67017f28d958103e02ee25");
        Thread.sleep(3000);

        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
         action = new Actions(driver);
        driver.findElement(By.id("editable_text")).click();
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();


        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://web.whatsapp.com/");
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
    XSSFSheet sheet = wb.getSheet("phones");
    //  XSSFSheet sheetMsg = wb.getSheet("Msg");

    //Create a row object to retrieve row at index 1
    XSSFRow row1 = sheet.getRow(0);
    // XSSFRow rowMsg = sheetMsg.getRow(0);

    //Create a cell object to retreive cell at index 0
    XSSFCell cell1 = row1.getCell(0);
    // XSSFCell cellMsg = rowMsg.getCell(0);

    //Get the phone in a variable
    //String phoneNum = cell1.getStringCellValue();
    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    for (int i = 0; i <= rowCount; i++)
    {
        //get cell count in a row
        int cellcount = sheet.getRow(i).getLastCellNum();

        for (int j = 0; j < cellcount; j++) {
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).clear();
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).sendKeys(sheet.getRow(i).getCell(j).getStringCellValue());
            driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).sendKeys(Keys.ENTER);
            action.keyDown(Keys.CONTROL);
            action.sendKeys("v");
            action.keyUp(Keys.CONTROL);
            action.build().perform();
Thread.sleep(5000);
            action.sendKeys(Keys.ENTER);
            action.build().perform();
            Thread.sleep(5000);

           //driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]")).sendKeys(Keys.ENTER);
            action.sendKeys(Keys.ESCAPE);
            action.build().perform();
            Thread.sleep(6000);

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