/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.mailing;

import io.codeffeine.brugge.domain.mailing.contract.GetEmailInterface;
import io.codeffeine.brugge.domain.mailing.contract.NewEmailInterface;
import io.codeffeine.brugge.domain.mailing.contract.SendEmailInterface;
import io.codeffeine.brugge.domain.mailing.repository.EmailRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.repository.EmailRepository;
import io.codeffeine.brugge.usecase.mailing.GetEmail;
import io.codeffeine.brugge.usecase.mailing.NewEmail;
import io.codeffeine.brugge.usecase.mailing.SendEmail;
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
