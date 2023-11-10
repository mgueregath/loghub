/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.external.mailing;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.mailing.entity.Email;
import io.codeffeine.brugge.external.mailing.exceptions.MailingException;
import io.codeffeine.brugge.usecase.adapter.mailing.MailingAdapter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Mailing implements MailingAdapter {

    private Properties props;
    private MailingConfiguration mailingConfiguration;

    @Inject
    public Mailing(MailingConfiguration mailingConfiguration) {
        props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", mailingConfiguration.getServer());
        props.put("mail.smtp.port", mailingConfiguration.getPort());
        props.put("mail.smtp.socketFactory.port", mailingConfiguration.getPort());

    }

    @Override
    public void send(Email email) {
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        mailingConfiguration.getEmailAddress(),
                        mailingConfiguration.getSecret()
                );
            }
        }
        );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailingConfiguration.getEmailAddress(), mailingConfiguration.getName()));
            if (mailingConfiguration.isTesting()) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("development@mesias.io"));

            } else {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("development@mesias.io"));

            }
            message.setSubject(email.getSubject());
            message.setContent(email.getContent(), "text/html; charset=utf-8");
            message.setSentDate(new Date());

            Transport.send(message);

        } catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
            throw new MailingException();
        }
    }
}
