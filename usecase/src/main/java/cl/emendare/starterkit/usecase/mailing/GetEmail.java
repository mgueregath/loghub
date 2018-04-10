/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.mailing;

import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.starterkit.domain.mailing.contract.GetEmailInterface;
import cl.emendare.starterkit.domain.mailing.entity.Email;
import cl.emendare.starterkit.domain.mailing.repository.EmailRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.validation.email.EmailAddressValidatorAdapter;
import com.google.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetEmail implements GetEmailInterface {

    private final EmailRepositoryInterface emailRepository;
    private final EmailAddressValidatorAdapter emailAddressValidator;

    @Inject
    public GetEmail(
            EmailRepositoryInterface emailRepository,
            EmailAddressValidatorAdapter emailAddressValidator
    ) {
        this.emailRepository = emailRepository;
        this.emailAddressValidator = emailAddressValidator;
    }

    @Override
    public List<Email> getByDate(Date date) {
        List<Email> emails = emailRepository.findByDate(date);
        if (emails.isEmpty()) {
            throw new DataNotFoundException();
        }
        return emails;
    }

    @Override
    public List<Email> getByEmailAddress(String emailAddress) {
        emailAddressValidator.validate(emailAddress);
        List<Email> emails = emailRepository.findByAddress(emailAddress);
        if (emails.isEmpty()) {
            throw new DataNotFoundException();
        }
        return emails;
    }
}
