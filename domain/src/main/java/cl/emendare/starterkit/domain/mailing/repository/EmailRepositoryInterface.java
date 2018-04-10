/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.mailing.repository;

import cl.emendare.starterkit.domain.mailing.entity.Email;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface EmailRepositoryInterface {

    public List<Email> findByDate(Date date);

    public List<Email> findByAddress(String address);

    public Email persist(Email email);
}
