package util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import static javax.mail.Message.RecipientType.*;
//添加注释
public class SendMail {
    public static String myEmailAccount = "liyali0158@163.com";
    public static String myEmailPassword = "ZLVGOARHYNXWWBDR";
    public static String myEmailSMTPHost = "smtp.163.com";
    public static String[] receiveMailAccount = {"alily2020@outlook.com","lylcrm@163.com","xhl@ytxinhai.com","yali04120525@gmail.com","liyali007@aliyun.com"};
    public static void main(String[] args) throws Exception {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        //session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);


        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();

        // 5. 使用 邮箱账号 和 密码 连接邮件服务器
        //    这里认证的邮箱必须与 message 中的发件人邮箱一致，否则报错
        transport.connect(myEmailAccount, myEmailPassword);
        for(int i=1;i<=4;i++){
            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("第"+i+"次");
        }

        // 7. 关闭连接
        transport.close();
        System.out.println("发送结束");
    }
    public static MimeMessage createMimeMessage(Session session,String sendmail,String[] receivemail) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendmail,"昵称","UTF-8"));
        for(String rec: receivemail){
            message.addRecipients(TO, String.valueOf(new InternetAddress(rec)));} //收件人 ，群发邮件
        message.setSubject("自定义收件，广告，询盘云，18:11发"); //邮件主题
        // 创建附件
        MimeBodyPart attachment = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        attachment.setDataHandler(dh2);
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));
        // 正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是哈哈哈哈哈哈哈啊哈正文，询盘云<br/><img src='cid:image'/>","text/html;charset=UTF-8");

        //插入图片
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        image.setDataHandler(dh);
        image.setContentID("image");
        //将图片和正文合成一个节点
        MimeMultipart mix = new MimeMultipart();
        mix.addBodyPart(image);
        mix.addBodyPart(text);
        mix.setSubType("related");
        MimeBodyPart fh = new MimeBodyPart();
        fh.setContent(mix);

        // 设置混合节点，将附件、正文等添加到邮件对象中
        MimeMultipart mm = new MimeMultipart();

        mm.addBodyPart(fh);
        mm.addBodyPart(attachment);
        mm.setSubType("mixed");
        message.setContent(mm);


        return message;
    }


}
