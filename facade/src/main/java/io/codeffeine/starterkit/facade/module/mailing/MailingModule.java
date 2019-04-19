/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.mailing;

import io.codeffeine.starterkit.domain.mailing.contract.GetEmailInterface;
import io.codeffeine.starterkit.domain.mailing.contract.NewEmailInterface;
import io.codeffeine.starterkit.domain.mailing.contract.SendEmailInterface;
import io.codeffeine.starterkit.domain.mailing.repository.EmailRepositoryInterface;
import io.codeffeine.starterkit.persistence.postgresql.repository.EmailRepository;
import io.codeffeine.starterkit.usecase.mailing.GetEmail;
import io.codeffeine.starterkit.usecase.mailing.NewEmail;
import io.codeffeine.starterkit.usecase.mailing.SendEmail;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MailingModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EmailRepositoryInterface.class).to(EmailRepository.class);
        bind(NewEmailInterface.class).to(NewEmail.class);
        bind(GetEmailInterface.class).to(GetEmail.class);
        bind(SendEmailInterface.class).to(SendEmail.class);
    }
}
