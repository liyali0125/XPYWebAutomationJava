package shuju;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UploadController {

    public static void fileload(String filePath) {
        DataOutputStream out = null;
        final String newLine = "\r\n";
        final String prefix = "--";
        try {
            URL url = new URL("http://cnend.leadscloud.com/crm/data/uploadFile?orgId=10110&userId=2073");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            String BOUNDARY = "----WebKitFormBoundaryvvAX1ekkiLw2CpjH";
            conn.setRequestMethod("POST");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("accept", "application/json, text/plain, */*");
            conn.setRequestProperty("cookie", "_ga=GA1.2.229653107.1626345529; __root_domain_v=.leadscloud.com; _qddaz=QD.933326348292294; JSESSIONID=F6C7843DCB26AD4A8A3B05A31A2D82F2; user-token=db5b865f1739598dd2d0370ebbf48844; xhl-userId=2073; xhl-orgId=10110; xhl-userId-js=2073; xhl-orgId-js=10110; xhl-userName=liyali_10110; xhl-fullName=%E4%BA%9A%E4%B8%BD; xhl-bi-userId=2073; piwikUserName=admin_1000; piwikPassword=123456; xhl-username=liyali_10110; _gid=GA1.2.1390292584.1626660164; _gat_UA-124568360-1=1");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            out = new DataOutputStream(conn.getOutputStream());

            // 添加参数file
            File file = new File(filePath);
            StringBuilder sb1 = new StringBuilder();
            sb1.append(prefix);
            sb1.append(BOUNDARY);
            sb1.append(newLine);
            sb1.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"" + newLine);
            sb1.append("Content-Type:application/octet-stream");
            sb1.append(newLine);
            sb1.append(newLine);
            out.write(sb1.toString().getBytes());
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            byte[] bufferOut = new byte[1024];
            int bytes = 0;
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            out.write(newLine.getBytes());
            in.close();

            // 添加参数sysName
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(BOUNDARY);
            sb.append(newLine);
            sb.append("Content-Disposition: form-data;name=\"sysName\"");
            sb.append(newLine);
            sb.append(newLine);
            sb.append("test");
            out.write(sb.toString().getBytes());

            // 添加参数returnImage
            StringBuilder sb2 = new StringBuilder();
            sb2.append(newLine);
            sb2.append(prefix);
            sb2.append(BOUNDARY);
            sb2.append(newLine);
            sb2.append("Content-Disposition: form-data;name=\"returnImage\"");
            sb2.append(newLine);
            sb2.append(newLine);
            sb2.append("false");
            out.write(sb2.toString().getBytes());

            byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            // 写上结尾标识
            out.write(end_data);
            out.flush();
            out.close();

            // 定义BufferedReader输入流来读取URL的响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            List<String> fileNames=new ArrayList<>();
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);

                JSONObject j = new JSONObject(line);
                String fileName=j.getString("data");
                fileNames.add(fileName);
                System.out.println(fileNames);
            }

        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws Exception {
        String[] files={"D:\\第一个文件.xlsx","D:\\第二个文件.xlsx","D:\\第三个文件.xlsx","D:\\第四个文件.xlsx","D:\\第五个文件.xlsx","D:\\第六个文件.xlsx",
                "D:\\第七个文件.xlsx","D:\\第八个文件.xlsx","D:\\第九个文件.xlsx","D:\\第十个文件.xlsx","D:\\第11个文件.xlsx","D:\\第12个文件.xlsx","D:\\第13个文件.xlsx",
                "D:\\第14个文件.xlsx","D:\\第15个文件.xlsx","D:\\第16个文件.xlsx","D:\\第17个文件.xlsx","D:\\第18个文件.xlsx","D:\\第19个文件.xlsx","D:\\第20个文件.xlsx",
                "D:\\第21个文件.xlsx","D:\\第22个文件.xlsx","D:\\第23个文件.xlsx","D:\\第24个文件.xlsx","D:\\第25个文件.xlsx","D:\\第26个文件.xlsx","D:\\第27个文件.xlsx",
                "D:\\第28个文件.xlsx","D:\\第29个文件.xlsx","D:\\第30个文件.xlsx"};
        for(String i:files){
            fileload(i);
        }

    }
    public static void writeExel(List<String> filename) throws Exception {
        //创建Excel文件薄
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建工作表sheeet
        Sheet sheet=workbook.createSheet();
        //创建第一行
        Row row=sheet.createRow(0);

        //追加数据
        for (int i=1;i<filename.size();i++){
            Row nextrow=sheet.createRow(i);
            Cell cell2=nextrow.createCell(0);
            cell2.setCellValue(filename.get(i));

        }
        //创建一个文件
        File file=new File("D:/第31个文件.xlsx");
        file.createNewFile();
        FileOutputStream stream= FileUtils.openOutputStream(file);
        workbook.write(stream);
        stream.close();
        System.out.println("文件创建完成");
    }

}




