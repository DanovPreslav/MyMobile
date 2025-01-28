package com.java.mymobile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


import java.util.Properties;


@Configuration
public class MailConfig {

    @Bean
    //public JavaMailSender javaMailSender(
        // @Value("${spring.mail.host}") String mailHost,
        //    @Value("${spring.mail.port}") Integer mailPort,
      //     @Value("${spring.mail.username}") String mailUsername,
    //        @Value("${spring.mail.password}") String mailPassword)
  //  {
//       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

       // javaMailSender.setHost(mailHost);
        //javaMailSender.setPort(mailPort);
        //javaMailSender.setUsername(mailUsername);
      //  javaMailSender.setPassword(mailPassword);
    //    javaMailSender.setJavaMailProperties(mailProperties());
  //     javaMailSender.setDefaultEncoding("UTF-8");
//
    //    return javaMailSender;
  //  }

   public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("localhost");
        mailSender.setPort(1025);
       mailSender.setUsername("admin@example.com");
        mailSender.setPassword("password");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
        return mailSender;
    }
    private Properties mailProperties() {
        Properties properties = new Properties();

        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true");

        return properties;
    }
}
