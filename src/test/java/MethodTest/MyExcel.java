package MethodTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 描述：excel事件处理
 */
public class MyExcel {
    /*读取excel文件中的数据，并生成数组*/
    @SuppressWarnings("deprecation")
    public Object[][] readExcel(String filePath,String sheetName) throws IOException {

        File file = new File(filePath);//获取文件
        FileInputStream fileInputStream = new FileInputStream(file);//读数据

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);//读取指定标签页的数据
        int rowNum = sheet.getPhysicalNumberOfRows();//获取行数(获取的是物理行数，也就是不包括那些空行（隔行）的情况)
        int columNum = sheet.getRow(0).getPhysicalNumberOfCells();//获取列数

        Object[][] data = new Object[rowNum-1][columNum];//因为第一行作为字段名，不需要记录，所以只有[rowNum-1]行
        for(int i=1;i<rowNum;i++) {///从第二行开始取值
            for (int h = 0; h < columNum; h++) {
                sheet.getRow(i).getCell(h).setCellType(Cell.CELL_TYPE_STRING);//先把类型设置为string
                data[i-1][h] = sheet.getRow(i).getCell(h).getStringCellValue();//填充数组
            }
        }
        workbook.close();
        return data;
    }

}