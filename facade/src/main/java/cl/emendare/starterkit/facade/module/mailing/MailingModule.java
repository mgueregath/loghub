/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.mailing;

import cl.emendare.starterkit.domain.mailing.contract.GetEmailInterface;
import cl.emendare.starterkit.domain.mailing.contract.NewEmailInterface;
import cl.emendare.starterkit.domain.mailing.contract.SendEmailInterface;
import cl.emendare.starterkit.domain.mailing.repository.EmailRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.repository.EmailRepository;
import cl.emendare.starterkit.usecase.mailing.GetEmail;
import cl.emendare.starterkit.usecase.mailing.NewEmail;
import cl.emendare.starterkit.usecase.mailing.SendEmail;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
