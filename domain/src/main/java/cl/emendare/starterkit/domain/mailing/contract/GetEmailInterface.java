/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.mailing.contract;

import cl.emendare.starterkit.domain.mailing.entity.Email;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GetEmailInterface {

    public List<Email> getByDate(Date date);

    public List<Email> getByEmailAddress(String emailAddress);
}
