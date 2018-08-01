package Text.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import random.SC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import static Text.excel.ExcelUtil.checkExcelVaild;
import static Text.excel.ExcelUtil.getWorkbook;
import static org.junit.Assert.*;

public class ExcelUtilTest {

    @Test
    public void getWorkbok() {
        try {
            // 同时支持Excel 2003、2007
            File excelFile = new File("C:\\Users\\dell-pc\\IdeaProjects\\FreedomTest\\src\\main\\java\\Text\\excel\\1.xlsx"); // 创建文件对象
            FileInputStream in = new FileInputStream(excelFile); // 文件流
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbook(in,excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            /**
             * 设置当前excel中sheet的下标：0开始
             */
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet

            //获取总行数
            System.out.println("总行数："+sheet.getLastRowNum());

            Row row1 = sheet.getRow(0);
            for (Cell cell : row1) {
                System.out.print(cell+" ");
            }
            Cell cell2 = row1.createCell(2);
            cell2.setCellValue("结果b");

            Cell cell3 = row1.createCell(3);
            cell3.setCellValue("结果c");



            System.out.println();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                double a = sheet.getRow(i).getCell(0).getNumericCellValue();
                double b = sheet.getRow(i).getCell(1).getNumericCellValue();
                BigDecimal[] caculate = SC.caculate(a, b, 100);
                System.out.println("原始a："+a+" 原始b："+b+" 结果b："+caculate[0]+" 结果c："+caculate[1]);
                Cell cell = sheet.getRow(i).createCell(2);
                Cell cell1 = sheet.getRow(i).createCell(3);

                cell.setCellValue(caculate[0].toString());
                cell1.setCellValue(caculate[1].toString());


            }
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\dell-pc\\IdeaProjects\\FreedomTest\\src\\main\\java\\Text\\excel\\2.xlsx");
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;

    }
}