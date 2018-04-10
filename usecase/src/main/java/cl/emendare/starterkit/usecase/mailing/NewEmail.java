/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.mailing;

import cl.emendare.starterkit.domain.mailing.contract.NewEmailInterface;
import cl.emendare.starterkit.domain.mailing.contract.SendEmailInterface;
import cl.emendare.starterkit.domain.mailing.entity.Email;
import cl.emendare.starterkit.domain.mailing.repository.EmailRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import com.google.inject.Inject;
import java.util.Date;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
        Email email = new Email();
        email.setSubject(subject);
        email.setDate(new Date());
        email.setContent(content);
        email.setTo(to);
        email.setName(name);
        email = emailRepository.persist(email);
        sendEmail.send(email);
        return email;
    }
}
