package edu.mirea.pr_18.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@Configuration
@EnableScheduling
public class AppConfig {
    @Bean
    public JavaMailSender initJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.yandex.ru");
        mailSender.setPort(587);
        mailSender.setUsername("liemartt@yandex.ru");
        mailSender.setPassword("osdomcnnymmbglua");
        mailSender.setProtocol("smtp");
        mailSender.setDefaultEncoding("UTF-8");
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
