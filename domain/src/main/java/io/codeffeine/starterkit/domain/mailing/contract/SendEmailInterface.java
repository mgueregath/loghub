/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.mailing.contract;

import io.codeffeine.starterkit.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface SendEmailInterface {

    public void send(Email email);
}
