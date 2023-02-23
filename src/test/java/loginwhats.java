import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class loginwhats {

    WebDriver driver = null;
    excel excelfile = new excel();
    String phoneNum;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("WebDriver.chrome.driver", chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

//1- go to http://live.techpanda.org/index.php/
        driver.navigate().to("http://justnotepad.com/");

        Thread.sleep(4000);
    }

   /* @Test
    public static int excelSheet () throws IOException {
        //Create an object of File class to open xlsx file
        File file = new File( "C:\\Users\\MMousa\\Downloads\\num.xlsx");

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream( file);

        //Creating workbook instance that refers to .xlxs file
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        XSSFSheet sheet = wb.getSheet("phones");

        //get the numbers of rows in the sheet
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
       // System.out.println("the num of rows is : " + rowCount);

        for(int i=0;i<=rowCount;i++){

            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            System.out.println("Row"+ i+" data is :");

            for(int j=0;j<cellcount;j++){
                String phoneNums = sheet.getRow(i).getCell(j).getStringCellValue() ;
                return phoneNums;
            }

        }


        return rowCount;
    }
*/

    @Test (priority = 1)
    public String msg () throws InterruptedException, IOException {

      //  driver.findElement(By.id("id=\"editable_text\"")).click();

//
        //Create an object of File class to open xlsx file
        File file = new File( "C:\\Users\\MMousa\\Downloads\\num.xlsx");

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream( file);

        //Creating workbook instance that refers to .xlxs file
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        XSSFSheet sheet = wb.getSheet("phones");

        //Create a row object to retrieve row at index 1
        XSSFRow row1 = sheet.getRow(0);

        //Create a cell object to retreive cell at index 0
        XSSFCell cell1 = row1.getCell(0);

        //Get the phone in a variable
         phoneNum = cell1.getStringCellValue();
        //  System.out.println(phoneNum);

        //get the numbers of rows in the sheet
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        //System.out.println("the num of rows is : " + rowCount);

        DataFormatter format = new DataFormatter();
        for(int i=0;i<=rowCount;i++){

            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            // System.out.println("Row"+ i+" data is :");

            for(int j=0;j<cellcount;j++){
               phoneNum=format.formatCellValue(sheet.getRow(i).getCell(j));
            }


        }

        //



       // driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).sendKeys(phoneNum);
       // driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]")).sendKeys(Keys.ENTER);
        //Thread.sleep(2000);

        //driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).click();
     //   driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).sendKeys("hello");
     //   driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).sendKeys(Keys.ENTER);


        return phoneNum;
    }

    @Test (priority = 2)
    public void test(){
        driver.findElement(By.id("id=\"editable_text\"")).sendKeys(phoneNum);

    }

    @AfterTest
    public  void closeBrowser () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    }