package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        // 一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("陈文震你好呀");
        mailMessage.setText("谢谢你的牛逼");

        mailMessage.setTo("Wenzhen_Kris@163.com");
        mailMessage.setFrom("2100488181@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        // 一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        // 正文
        helper.setSubject("陈文震你好呀~999");
        helper.setText("<p style='color:pink'>谢谢你的牛逼啊啊啊啊啊啊啊啊啊啊啊</p>",true);

        // 附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        helper.addAttachment("666.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));

        helper.setTo("Wenzhen_Kris@163.com");
        helper.setFrom("2100488181@qq.com");

        mailSender.send(mimeMessage);
    }

}
