package shuju;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileOutputStream;

public class CreateExcl {

    public static void main(String[] args) throws Exception {
        //创建Excel文件薄
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建工作表sheeet
        Sheet sheet=workbook.createSheet();
        //创建第一行
        Row row=sheet.createRow(0);
        String[] title={"公司名称","姓名","邮箱","电话","whatsapp","负责人","产品分类"};
        Cell cell=null;
        for (int i=0;i<title.length;i++){
            cell=row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //追加数据
        for (int i=1;i<10000;i++){
            Row nextrow=sheet.createRow(i);
            Cell cell2=nextrow.createCell(3);
            cell2.setCellValue(30048565+i);
            cell2=nextrow.createCell(0);
            cell2.setCellValue("第30个文件公司名称"+i);
            cell2=nextrow.createCell(1);
            cell2.setCellValue("第30个文件姓名"+i);
            cell2=nextrow.createCell(2);
            cell2.setCellValue("disanshi1154878"+i+"@qq.com");
            cell2=nextrow.createCell(4);
            cell2.setCellValue(30058781+i);
            cell2=nextrow.createCell(5);
            cell2.setCellValue("李亚丽");
            cell2=nextrow.createCell(6);
            cell2.setCellValue("上线产品");

        }
        //创建一个文件
        File file=new File("D:/第30个文件.xlsx");
        file.createNewFile();
        FileOutputStream stream= FileUtils.openOutputStream(file);
        workbook.write(stream);
        stream.close();
        System.out.println("文件创建完成");
    }

}




