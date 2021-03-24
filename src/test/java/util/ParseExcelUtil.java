package util;
/*
 * 描述:The method of parseExcel
 *
 * @author davieyang
 * @create 2018-08-05 0:37
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;

import constants.Constants;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParseExcelUtil {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    /**
     * 读取要操作的Excel的文件
     * @param Path:Excel文件绝对路径
     */
    public static void setExcelFile(String Path){
        FileInputStream ExcelFile;
        try{
            //实例化Excel文件的FileInputStream对象
            ExcelFile = new FileInputStream(Path);
            //实例化Excel文件的XSSFWorkbook对象
            ExcelWBook = new XSSFWorkbook(ExcelFile);
        }catch (Exception e){
            System.out.println("Excel路径设定失败");
            e.printStackTrace();
        }
    }

    /**
     * 设定要读取的Excel路径和Excel文件中Sheet名称
     * @param Path 文件路径
     * @param SheetName 表单名称
     */
    public static void setExcelFile(String Path, String SheetName){
        FileInputStream ExcelFile;
        try {
            ExcelFile = new FileInputStream(Path);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        } catch (Exception e) {
            System.out.println("Excel 路径设定失败");
            e.printStackTrace();
        }
    }

    /**
     * 读取Excel文件指定的单元格函数，此函数只支持扩展名为xlsx的Excel文件
     * @param rowNum 行号
     * @param colNum 列号
     * @return 返回单元格对象
     */
    public static Object getCellData(int rowNum, int colNum) {
        Object CellData;
        try {
            //通过函数参数指定单元格的行号和列号，获取指定的单元格对象
            Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
            CellData = "";
            //如果单元格内容为字符串类型，则使用getStringCellValue方法获取单元格的内容
            //如果单元格内容为数字类型，则使用getNumericCellValue方法获取单元格的内容
            if (Cell.getCellTypeEnum() == CellType.STRING) {
                CellData = Cell.getStringCellValue();
            } else if (Cell.getCellTypeEnum() == CellType.NUMERIC) {
                CellData = Cell.getNumericCellValue();
            }
            return CellData;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 读取指定sheet中的指定单元格函数，此函数只支持.xlsx
     * @param sheetName 表单名称
     * @param rowNum 行号
     * @param colNum 列号
     * @return 返回单元格内字符串
     */
    public static String getCellData(String sheetName, int rowNum, int colNum){
         ExcelWSheet = ExcelWBook.getSheet(sheetName);
         try{
             //通过函数的参数指定单元格的行号和列号，获取指定单元格对象
             Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
             String CellData = null;
             if (Cell.getCellTypeEnum() == CellType.STRING) {
                 CellData = Cell.getStringCellValue();
             }else if (Cell.getCellTypeEnum() == CellType.NUMERIC){
                 CellData = String.valueOf(Math.round(Cell.getNumericCellValue()));
             }
             return CellData;
         }catch (Exception e){
             e.printStackTrace();
             return "";
         }
    }

    /**
     * @param sheetName 表单名称
     * @return 获取指定Sheet中数据的总行数
     */
    public static int getRowCount(String sheetName){
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        int RowCount = ExcelWSheet.getLastRowNum();
        return RowCount;
    }
    public static int getLastRowNum() {
        return ExcelWSheet.getLastRowNum();
    }

    /**
     * @param sheetName 表单名称
     * @param testCaseName 测试用例mine工程
     * @param colNum 列号
     * @return 在Excel的指定Sheet中，获取第一次包含指定测试用例序号文字的行号
     */
    public static int getFirstRowContainsTestCaseID(String sheetName, String testCaseName, int colNum) {
        int i;
        try {
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
            int rowCount = ParseExcelUtil.getRowCount(sheetName);
            for (i = 0; i < rowCount; i++) {
                //使用循环遍历测试用例列的所有行的方法，判断是否包含某个测试用例序号关键字
                if (ParseExcelUtil.getCellData(sheetName, i, colNum).equalsIgnoreCase(testCaseName)) {
                    //如果包含则退出for循环，并返回包含测试用例序号关键字的行号
                    break;
                }
            }
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * @param sheetName 表单名称
     * @param testCaseID 测试用例ID
     * @param testCaseStartRowNumber 测试用例启示行号
     * @return 获取指定Sheet中某个测试用例步骤的个数
     */
    public static int getTestCaseLastStepRow(String sheetName, String testCaseID, int testCaseStartRowNumber) {
        try {
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
            /*从包含指定测试用例序号的第一行开始逐行遍历，直到某一行不出现指定测试用例序号
             *此时的遍历次数就是此测试用例步骤的个数
             */
            for (int i = testCaseStartRowNumber; i <= ParseExcelUtil.getRowCount(sheetName) - 1; i++) {
                if (!testCaseID.equals(ParseExcelUtil.getCellData(sheetName, i, Constants.Col_TestCaseID))) {
                    int number = i;
                    return number;
                }
            }
            int number = ExcelWSheet.getLastRowNum() + 1;
            return number;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 在Excel指定单元格中写入输入，只支持xlsx
     * @param SheetName 表单名称
     * @param RowNum 行号
     * @param ColNum 列号
     * @param Result 结果
     */
    public static void setCellData(String SheetName, int RowNum, int ColNum, String Result){
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        try{
            //获取Excel中的行对象
            Row = ExcelWSheet.getRow(RowNum);
            //如果单元格为空则返回Null
            Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (Cell == null){
                //当单元格为null时创建单元格
                //如果单元格为空，无法直接调用单元格对象的setCellValue方法设定单元格的值
                Cell = Row.createCell(ColNum);
                //创建单元格后，可以直接调用单元格对象的setCellValue方法设定单元格的值
                Cell.setCellValue(Result);
            }else {
                //单元格中有内容，则可以直接调用单元格对象的setCellValue方法设定单元格的值
                Cell.setCellValue(Result);
            }
            //实例化写入Excel文件的文件输出流对象
            FileOutputStream fileOutputStream = new FileOutputStream(Constants.Path_ExcelFile);
            //将内容写入到Excel文件中
            ExcelWBook.write(fileOutputStream);
            //调用flush方法强制刷新写入文件
            fileOutputStream.flush();
            //关闭文件输出流
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


