/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.mailing;

import io.codeffeine.starterkit.domain.mailing.contract.NewEmailInterface;
import io.codeffeine.starterkit.domain.mailing.contract.SendEmailInterface;
import io.codeffeine.starterkit.domain.mailing.entity.Email;
import io.codeffeine.starterkit.domain.mailing.repository.EmailRepositoryInterface;
import io.codeffeine.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class NewEmail implements NewEmailInterface {

    private final EmailRepositoryInterface emailRepository;
    private final FieldValidatorAdapter fieldValidator;
    private final SendEmailInterface sendEmail;

    @Inject
    public NewEmail(
            EmailRepositoryInterface emailRepository,
            FieldValidatorAdapter fieldValidator,
            SendEmailInterface sendEmail
    ) {
        this.emailRepository = emailRepository;
        this.fieldValidator = fieldValidator;
        this.sendEmail = sendEmail;
    }

    @Override
    public Email add(String to, String name, String subject, String content) {
        fieldValidator.validate(to, subject);
        Email email = new Email(to, subject, content, name);
        email = emailRepository.persist(email);
        sendEmail.send(email);
        return email;
    }
}
