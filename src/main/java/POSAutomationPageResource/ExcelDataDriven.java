package POSAutomationPageResource;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataDriven {

    public static String getValueFromExcel(int cell, int col) throws IOException {
        //使Excel表连接流
        FileInputStream fileInputStream = new FileInputStream("E:\\AutomateTestExcelForm\\AppiumInfo.xlsx");
        //实例化Excel表
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet login = xssfWorkbook.getSheet("Login");
        XSSFRow row = login.getRow(cell);//行
        XSSFCell cells = row.getCell(col);//列
        return cells.getRawValue();
    }

    @Test
    public static void getExcelRowAndColoum() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\AutomateTestExcelForm\\AppiumInfo.xlsx");
        //实例化Excel表
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet login = xssfWorkbook.getSheet("Login");
        int colCount = login.getRow(0).getLastCellNum();
        System.out.println(colCount);
//        int firstRowNum = login.getFirstRowNum();
//        System.out.println(firstRowNum);
//        int lastRowNum = login.getLastRowNum();
//        System.out.println(lastRowNum);
//        fileInputStream.close();
    }

    public static String setValueFormExcel(String address, int cell, int col, String value) throws IOException {
        //使Excel表连接流
        FileInputStream fileInputStream = new FileInputStream("E:\\AutomateTestExcelForm\\AppiumInfo.xlsx");
        //实例化Excel表
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet login = xssfWorkbook.getSheet("Login");
        XSSFRow row = login.getRow(cell);//行
        XSSFCell cells = row.getCell(col);//列
        cells.setCellValue(value);
        return cells.getStringCellValue();
    }

    public static void test() throws IOException {
        String s = ExcelDataDriven.setValueFormExcel("E:\\AutomateTestExcelForm\\AppiumInfo.xlsx", 1, 1, "123456");
//        String valueFromExcel = ExcelDataDriven.getValueFromExcel("E:\\AutomateTestExcelForm\\AppiumInfo.xlsx", 1, 1);
        System.out.println(s);
    }
}
