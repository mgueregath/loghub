/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.mailing.contract;

import io.codeffeine.brugge.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface SendEmailInterface {

    public void send(Email email);
}
