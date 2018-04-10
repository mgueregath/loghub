/*
 * StarterKit.
 */
package cl.emendare.starterkit.external.mailing;

import cl.emendare.starterkit.domain.mailing.entity.Email;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@Ignore
public class MailingTest {

    public MailingTest() {
    }

    /**
     * Test of send method, of class Mailing.
     */
    @Test
    public void testSend() {
        System.out.println("send");
        Email email = new Email();
        email.setDate(new Date());
        email.setName("Mirko Gueregat");
        email.setSubject("Correo de prueba");
        email.setTo("mgueregath@gmail.com");
        email.setContent("Correo de prueba");
        Mailing instance = new Mailing();
        instance.send(email);
    }

}
