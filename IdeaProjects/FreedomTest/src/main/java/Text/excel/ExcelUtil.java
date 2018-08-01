package Text.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 生成Excel文件的工具类
 * @author weiyuwang
 */
public class ExcelUtil {

    /**
     * 创建excel文档，
     * @param excelName excel的表名
     * @param list 数据，相当于每一行，而map的key代表了单元格的字段，value则是值
     * @param keys list中map的key数组集合
     * @param columnNames excel的列名
     * */
    public static Workbook createWorkBook(String excelName,List<Map<String, Object>> list, String[] keys, String[] columnNames) {
        // 创建excel工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
//        XSSFWorkbook wb = new XSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(excelName);
        // 创建第一行
        Row firstRow = sheet.createRow(0);
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = firstRow.createCell(i);
            cell.setCellValue(columnNames[i]);
        }
        //设置每行每列的值
        for (int i = 0; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row从1开始，因为第一行用来存放了列名，cell从0开始
            // 创建一行，在页sheet上
            Row row = sheet.createRow( i+1);
            // 在row行上创建一个方格
            for(int j=0;j<keys.length;j++){
                Cell cell = row.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
            }
        }
        return wb;
    }



    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * 判断Excel的版本,获取Workbook
     * @param in
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream in, File file) throws IOException {
        Workbook wb = null;
        if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception{
        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
            throw new Exception("文件不是Excel");
        }
    }


}