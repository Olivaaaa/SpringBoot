package com.javamailsend.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class EmailController {

    private final static Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/simple")
    public void sendSimpleMail() throws Exception{
        logger.info("发送简单的文本邮件...");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2453273909@qq.com");
        message.setTo("1036825017@qq.com");
        message.setSubject("来自大可爱的邮件");
        message.setText("hello臭臭！么么！");
        mailSender.send(message);

    }

    @RequestMapping("/attcments")
    public void sendAttachmentsMail() throws Exception{
        logger.info("发送带有附件的邮件...");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("2453273909@qq.com");
        helper.setTo("1036825017@qq.com");
        helper.setSubject("有附件");
        helper.setText("有附件的邮件");
        FileSystemResource file = new FileSystemResource(new File("/static/logo.png"));
        helper.addAttachment("附件1", file);
        mailSender.send(mimeMessage);

    }

    @RequestMapping("/inline")
    public void sendTemplateMail() throws Exception{
        logger.info("发送简单邮件模板的邮件..");
    }


}
