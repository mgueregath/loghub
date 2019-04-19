/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.mailing;

import io.codeffeine.starterkit.usecase.exception.data.DataNotFoundException;
import io.codeffeine.starterkit.domain.mailing.contract.GetEmailInterface;
import io.codeffeine.starterkit.domain.mailing.entity.Email;
import io.codeffeine.starterkit.domain.mailing.repository.EmailRepositoryInterface;
import io.codeffeine.starterkit.usecase.adapter.validation.email.EmailAddressValidatorAdapter;
import com.google.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
