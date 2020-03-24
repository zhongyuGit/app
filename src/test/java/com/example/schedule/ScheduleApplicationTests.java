package com.example.schedule;

import com.example.schedule.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender javaMailSender;



	@Test
	public void test(){
		System.out.println("日志开启");
		logger.info("记录日志");
	}


	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("骂人");
		simpleMailMessage.setFrom("506889268@qq.com");
		simpleMailMessage.setText("你好飞蛇");
		simpleMailMessage.setTo("zy123665588@163.com");
		simpleMailMessage.setSentDate(new Date());
		javaMailSender.send(simpleMailMessage);
	}
	@Test
	public void complexMail() throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

		mimeMessageHelper.setSubject("骂人");
		mimeMessageHelper.setFrom("506889268@qq.com");
		mimeMessageHelper.setText("你好飞蛇");
		mimeMessageHelper.setTo("zy123665588@163.com");
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.addAttachment("hello.jpg",new File("C:\\w.png"));
		javaMailSender.send(mimeMessage);
	}

}
