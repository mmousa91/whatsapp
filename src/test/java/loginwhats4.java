import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class loginwhats4 {

    WebDriver driver = null;
    Actions action ;



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
    public void openBrowser() throws InterruptedException {

        //driver.navigate().to("http://justnotepad.com/");
        driver.navigate().to("http://justnotepad.com/get/ad93288a4c2589a5a7533d26221d8def");
        Thread.sleep(3000);

        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        action = new Actions(driver);
        driver.findElement(By.id("editable_text")).click();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://web.whatsapp.com/");
        Thread.sleep(120000);

    }

    @Test (priority = 2)
    public void  iteration () throws InterruptedException, IOException {
        File file = new File("C:\\Users\\MMousa\\Downloads\\num.xlsx");

        //Create an object of FileInputStream class to read Excel file
        FileInputStream inputStream = new FileInputStream(file);

        //Creating workbook instance that refers to xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        XSSFSheet sheet = wb.getSheet("phones4");
        //  XSSFSheet sheetMsg = wb.getSheet("Msg");

        //Create a row object to retrieve row at index 1
        //XSSFRow row1 = sheet.getRow(0);
        // XSSFRow rowMsg = sheetMsg.getRow(0);

        //Create a cell object to retrieve cell at index 0
        //XSSFCell cell1 = row1.getCell(0);
        // XSSFCell cellMsg = rowMsg.getCell(0);

        //Get the phone in a variable
        //String phoneNum = cell1.getStringCellValue();
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 0; i <= rowCount; i++)
        {
            //get cell count in a row
            int loginWhats1 = sheet.getRow(i).getLastCellNum();

            for (int j = 0; j < loginWhats1; j++) {
                driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).click();
                driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).clear();
                driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).sendKeys(sheet.getRow(i).getCell(j).getStringCellValue());
                driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[1]")).sendKeys(Keys.ENTER);
                Thread.sleep(3000);

                action.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
                action.keyUp(Keys.CONTROL).build().perform();
                Thread.sleep(4000);

                action.sendKeys(Keys.ENTER).build().perform();
                Thread.sleep(4000);

                action.sendKeys(Keys.ESCAPE).build().perform();
                Thread.sleep(30000);


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