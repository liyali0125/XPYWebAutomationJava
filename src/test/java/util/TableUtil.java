package util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * some method of controlling table
 *
 * @author: davieyang
 * @create: 2018-08-05 14:04
 */
public class TableUtil {
    //声明一个WebElement对象，用于存储页面的表格元素对象
    private WebElement _table;

    //为构造函数传入页面表格元素对象参数，调用TableUtil类的settable方法，将页面表格元素赋值给TableUtil类的_table成员变量
    public TableUtil (WebElement table){
        setTable(table);
    }
    //获取页面表格对象的方法
    public WebElement getTable(){
        return _table;
    }
    //将页面表格元素赋值给TableUtil类中_table成员变量的方法
    public void setTable(WebElement _table){
        this._table = _table;
    }
    //获取表格元素的行数，查找表格元素有几个tr元素,有几个tr元素，就可以知道表格有几行，tr数量和表格行数相一致
    public int getRowCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
        return tableRows.size();
    }
    //获取表格元素的列数，使用get(0)从容器中取出表格第一行的元素，查找有几个“td”,td数量和列数一致
    public int getColumnCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
        return tableRows.get(0).findElements(By.tagName("td")).size();
    }
    //获取表格中某行某列的单元格对象
    public WebElement getCell(int rowNo, int colNo)throws NoSuchElementException{
        try{
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            System.out.println("行总数：" + tableRows.size());
            System.out.println("行号：" + rowNo);
            WebElement currentRow = tableRows.get(rowNo - 1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            System.out.println("列总数：" + tableCols.size());
            WebElement cell = tableCols.get(colNo-1);
            System.out.println("列号：" + colNo);
            return cell;
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("没有找到相关元素");
        }
    }
    /**
     * 获得表格中某行某列的单元格中的某个页面元素对象，by参数用于定位某个表格中的页面元素，例如by.xpath("input[@type='text']")可以定义到表格中的输入框
     */
    public WebElement getWebElementInCell(int rowNo, int colNo, By by)throws NoSuchElementException{
        try{
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            //找到表格中的某一行，行号从0开始，例如第三行，则需要进行3-1来获取即“2”
            WebElement currentRow = tableRows.get(rowNo-1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            //找到表格中的某一列，因为也是从0开始，所以要找到第三列，则需要进行3-1来获取即“2”
            WebElement cell = tableCols.get(colNo-1);
            return cell.findElement(by);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("没有找到相关元素");
        }
    }

    /**
     *
     * @param driver 浏览器驱动
     * @param row 行号
     * @param column 列号
     * @return 函数接受浏览器驱动，表格行数和列数，注意表头行，返回某个cell的值
     */
    public static String tableCell(WebDriver driver, int row, int column) {
        String text = null;
        //avoid get the head line of the table
        row=row+1;
        String xpath="//*[@id='table138']/tbody/tr["+row+"]/td["+column+"]";
        WebElement table=driver.findElement(By.xpath(xpath));
        text=table.getText();
        return text;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @param tablexpath 要便利的table的xpath
     * @param words 要判断的字符串
     * @param tdxpath 该字符串所在行的td[6]的xpath，例如 "//*[@id='app']/section/section/main/section/div[1]/div[3]/table/tbody/tr["+row+"]/td["+col+"]/div/div/span"
     *                注意tr和td是个变量，注意写法，这个是在发放中获取的
     * @throws Exception 定位失败
     */
    public void getTableTd6(WebDriver driver, String tablexpath, String words, String tdxpath) throws Exception {
        //获取表单，xpath是表单的定位
        WebElement tableElement=driver.findElement(By.xpath(tablexpath));
        //将表单的所有tr放进列表，每个tr是表单的一行，逐行遍历
        List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            //将表单的td放进list里，每个td是表单的一列，逐列遍历
            List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cols.size(); j++) {
                String tdText = cols.get(j).getText();
                WaitElementUtil.sleep(1000);
                System.out.println(tdText +"\t");
                //判断哪行哪列的内容包含字段"mysql01", 如果包含则进行操作，然后break 跳出循环结束
                if(tdText.contains(words)){
                    System.out.println(i+1);
                    System.out.println(j+1);
                    int row = i + 1;
                    //点击mysql列表页面，最后一列的。。。按钮
                    //WebElement dropdown = driver.findElement(By.xpath("//*[@id='app']/section/section/main/section/div[1]/div[3]/table/tbody/tr["+row+"]/td[6]/div/div/span"));
                    WebElement dropdown = driver.findElement(By.xpath(tdxpath));
                    dropdown.click();
                }break;
            }
        }
    }
}