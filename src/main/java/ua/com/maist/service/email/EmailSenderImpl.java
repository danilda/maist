package ua.com.maist.service.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.com.maist.model.entity.User;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service("emailSender")
public class EmailSenderImpl implements EmailSender {

    private String username ;
    private String password;
    @Value("${mail.smtp.host}")
    private String mailSmtpHost;
    @Value("${mail.smtp.socketFactory.port}")
    private String mailSmtpSocketFactoryPort;
    @Value("${mail.smtp.socketFactory.class}")
    private String mailSmtpSocketFactoryClass;
    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;
    @Value("${mail.smtp.port}")
    private String mailSmtpPort;

    private Properties props;

    @PostConstruct
    private void init(){
        props = new Properties();
        System.out.println(props);
        props.put("mail.smtp.host", mailSmtpHost);
        props.put("mail.smtp.socketFactory.port", mailSmtpSocketFactoryPort);
        props.put("mail.smtp.socketFactory.class", mailSmtpSocketFactoryClass);
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.port", mailSmtpPort);
        props.put("java.net.preferIPv4Stack", true);
    }

    @Override
    public void send(User destinationUser, String subject, String text) {
        send(destinationUser.getEmail(), subject, text);
    }

    @Override
    public void send(String destinationAddress, String subject, String text){
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationAddress));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
