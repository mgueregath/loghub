/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.adapter.mailing;

import io.codeffeine.starterkit.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface MailingAdapter {

    public void send(Email email);

}
