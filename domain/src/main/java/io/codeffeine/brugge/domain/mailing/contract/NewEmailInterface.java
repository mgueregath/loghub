/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.mailing.contract;

import io.codeffeine.brugge.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface NewEmailInterface {

    public Email add(String to, String name, String subject, String content);
}
