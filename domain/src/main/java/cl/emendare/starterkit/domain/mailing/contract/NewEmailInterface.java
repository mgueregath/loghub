/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.mailing.contract;

import cl.emendare.starterkit.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NewEmailInterface {

    public Email add(String to, String name, String subject, String content);
}
