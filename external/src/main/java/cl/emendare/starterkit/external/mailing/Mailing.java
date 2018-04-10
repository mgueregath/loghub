/*
 * StarterKit.
 */
package cl.emendare.starterkit.external.mailing;

import cl.emendare.starterkit.domain.mailing.entity.Email;
import cl.emendare.starterkit.external.mailing.exceptions.MailingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import cl.emendare.starterkit.usecase.adapter.mailing.MailingAdapter;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class Mailing implements MailingAdapter {

    private Properties props;
    private String emailAddress;
    private String name;
    private String secret;
    private String host;
    private Integer port;

    public Mailing() {
        props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");

        try {
            emailAddress = MailingConfiguration.emailAddress;
            name = MailingConfiguration.name;
            secret = MailingConfiguration.secret;
            host = MailingConfiguration.server;
            port = MailingConfiguration.port;

            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.socketFactory.port", port);

        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.INFO, "Mailing", ex);
        }
    }

    @Override
    public void send(Email email) {
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        emailAddress,
                        secret
                );
            }
        }
        );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailAddress, name));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
            message.setSubject(email.getSubject());
            message.setContent(email.getContent(), "text/html; charset=utf-8");

            Transport.send(message);

        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.INFO, "Mailing", e);
            throw new MailingException();
        }
    }
}
