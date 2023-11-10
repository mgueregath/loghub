/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.adapter.mailing;

import io.codeffeine.brugge.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface MailingAdapter {

    public void send(Email email);

}
