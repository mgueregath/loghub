/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.adapter;

import cl.emendare.starterkit.external.mailing.Mailing;
import cl.emendare.starterkit.usecase.adapter.jwt.Auth0Jwt;
import cl.emendare.starterkit.usecase.adapter.jwt.JwtAdapter;
import cl.emendare.starterkit.usecase.adapter.mailing.MailingAdapter;
import cl.emendare.starterkit.usecase.adapter.password.generator.PasswordGenerator;
import cl.emendare.starterkit.usecase.adapter.password.generator.PasswordGeneratorAdapter;
import cl.emendare.starterkit.usecase.adapter.password.hasher.BCryptPasswordHasher;
import cl.emendare.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import cl.emendare.starterkit.usecase.adapter.validation.email.EmailAddressValidator;
import cl.emendare.starterkit.usecase.adapter.validation.email.EmailAddressValidatorAdapter;
import cl.emendare.starterkit.usecase.adapter.validation.field.FieldValidator;
import cl.emendare.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class AdapterModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EmailAddressValidatorAdapter.class).to(EmailAddressValidator.class);
        bind(FieldValidatorAdapter.class).to(FieldValidator.class);
        bind(PasswordHasherAdapter.class).to(BCryptPasswordHasher.class);
        bind(PasswordGeneratorAdapter.class).to(PasswordGenerator.class);
        bind(JwtAdapter.class).to(Auth0Jwt.class);
        bind(MailingAdapter.class).to(Mailing.class);
    }
}
