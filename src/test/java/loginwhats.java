import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;


public class loginwhats {

    WebDriver driver = null;

    @Test
    public void openBrowser() throws InterruptedException, IOException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

//1- go to http://live.techpanda.org/index.php/
        //driver.navigate().to("http://justnotepad.com/");
        driver.navigate().to("http://justnotepad.com/get/a1609a9f4bcf420ed89d7935a6314b40");
        Thread.sleep(3000);

        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Actions action = new Actions(driver);
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
        /*driver.findElement(By.id("editable_text")).click();
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();*/

        Thread.sleep(40000);
       /*
       //
        File inFile = new File("C:\\Users\\MMousa\\Downloads\\sale.txt");
        StringBuilder targetString = new StringBuilder("");
        try {
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);

            String s = null;
            while ((s = br.readLine()) != null) {
                targetString.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //*/

        File file = new File( "C:\\Users\\moham\\Downloads\\num.xlsx");

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream( file);

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
        String phoneNum = cell1.getStringCellValue();
        //  System.out.println(phoneNum);

        //get the numbers of rows in the sheet
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        //System.out.println("the num of rows is : " + rowCount);

        for(int i=0;i<=rowCount;i++){

            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            // System.out.println("Row"+ i+" data is :");

            for(int j=0;j<cellcount;j++){

                driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).clear();
                driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).click();
                driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).sendKeys(sheet.getRow(i).getCell(j).getStringCellValue());
              //  System.out.println(driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/span")).getText());
                if (driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).isDisplayed()) {
                    driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).sendKeys(Keys.ENTER);
                    driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).click();
                    driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).clear();

                    action.keyDown(Keys.CONTROL);
                    action.sendKeys("v");
                    action.keyUp(Keys.CONTROL);
                    action.build().perform();
                    driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).
                            sendKeys(Keys.ENTER);
                    Thread.sleep(2000);

                }
                    else {
                    openBrowser();
                }

            }

        }


        Thread.sleep(3000);
        driver.quit();
    }

    /*
//
    @AfterTest
    public  void closeBrowser () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
*/
}