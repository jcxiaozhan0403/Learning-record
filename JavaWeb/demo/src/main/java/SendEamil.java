import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendEamil {
    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
        //创建一个配置文件并保存
        Properties prop = new Properties();
        //设置QQ邮件服务器
        prop.setProperty("mail.host", "smtp.qq.com");
        // 邮件发送协议
        prop.setProperty("mail.transport.protocol", "smtp");
        // 需要验证用户名密码
        prop.setProperty("mail.smtp.auth", "true");
        //QQ邮箱存在一个特性设置SSL加密，其他邮箱不用编写
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //创建一个session对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //传入发件人的邮箱和授权码
                return new PasswordAuthentication("349636607@qq.com","gpoqueahgfulbgdi");
            }
        });

        //开启debug模式，控制台打印发送过程
        session.setDebug(true);

        //发送邮件5个步骤
        //1.获取连接对象
        Transport transport = session.getTransport();
        //2.连接服务器
        transport.connect("smtp.qq.com","349636607@qq.com","gpoqueahgfulbgdi");
        //3.创建邮件对象，进行邮件内容设置
        MimeMessage mimeMessage = complexEmail(session);
        //4.发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        //5.关闭连接
        transport.close();
    }

    public static MimeMessage complexEmail(Session session) throws MessagingException {
        //消息的固定信息
        MimeMessage mimeMessage = new MimeMessage(session);
        //设置发件人
        mimeMessage.setFrom(new InternetAddress("349636607@qq.com"));
        //设置收件人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("349636607@qq.com"));
        //设置邮件标题
        mimeMessage.setSubject("带图片和附件的邮件");
        //设置邮件内容
        //准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler handler = new DataHandler(new FileDataSource("D:\\一些文档\\icon.jpg"));
        image.setDataHandler(handler);
        //设置图片id，随意，相当于别名
        image.setContentID("test.png");
        //准备文本
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一段文本<img src='cid:test.png'>","text/html;charset=utf-8");
        //添加附件
        MimeBodyPart appendix = new MimeBodyPart();
        appendix.setDataHandler(new DataHandler(new FileDataSource("D:\\一些文档\\云函数自动签到.md")));
        appendix.setFileName("云函数自动签到.md");
        //拼装邮件正文
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(image);
        mimeMultipart.addBodyPart(text);
        mimeMultipart.setSubType("related");//文本和图片内嵌成功
        //将拼装好的正文内容设置为主体
        MimeBodyPart contentText = new MimeBodyPart();
        contentText.setContent(mimeMultipart);
        //拼接附件
        MimeMultipart allFile = new MimeMultipart();
        allFile.addBodyPart(appendix);//附件
        allFile.addBodyPart(contentText);//正文
        allFile.setSubType("mixed"); //正文和附件都存在邮件中，所有类型设置为mixed
        //放到Message消息中
        mimeMessage.setContent(allFile);
        mimeMessage.saveChanges();//保存修改
        return mimeMessage;
    }
}