/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.mailing.contract;

import io.codeffeine.starterkit.domain.mailing.entity.Email;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetEmailInterface {

    public List<Email> getByDate(Date date);

    public List<Email> getByEmailAddress(String emailAddress);
}
