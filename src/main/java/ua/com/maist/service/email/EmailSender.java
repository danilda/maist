package ua.com.maist.service.email;


import ua.com.maist.model.entity.User;

public interface EmailSender {

    void send(String destinationAddress, String subject, String text);

    void send(User destinationUser, String subject, String text);

}
