import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/*
public class excel {
    @Test
    public void excelSheet1 () throws IOException {
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
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() );
            }
            System.out.println();
        }




    }

}
*/