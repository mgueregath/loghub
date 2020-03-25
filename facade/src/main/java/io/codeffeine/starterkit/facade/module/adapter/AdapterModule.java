/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.adapter;

import io.codeffeine.starterkit.external.mailing.Mailing;
import io.codeffeine.starterkit.usecase.adapter.jwt.Auth0Jwt;
import io.codeffeine.starterkit.usecase.adapter.jwt.JwtAdapter;
import io.codeffeine.starterkit.usecase.adapter.mailing.MailingAdapter;
import io.codeffeine.starterkit.usecase.adapter.password.generator.PasswordGenerator;
import io.codeffeine.starterkit.usecase.adapter.password.generator.PasswordGeneratorAdapter;
import io.codeffeine.starterkit.usecase.adapter.password.hasher.BCryptPasswordHasher;
import io.codeffeine.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import io.codeffeine.starterkit.usecase.adapter.validation.email.EmailAddressValidator;
import io.codeffeine.starterkit.usecase.adapter.validation.email.EmailAddressValidatorAdapter;
import io.codeffeine.starterkit.usecase.adapter.validation.field.FieldValidator;
import io.codeffeine.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import com.google.inject.AbstractModule;
import io.codeffeine.starterkit.usecase.adapter.validation.identification.ChileanIdentificationNumberValidator;
import io.codeffeine.starterkit.usecase.adapter.validation.identification.IdentificationNumberValidatorAdapter;
import io.codeffeine.starterkit.usecase.adapter.validation.phone.ChileanPhoneValidator;
import io.codeffeine.starterkit.usecase.adapter.validation.phone.PhoneValidatorAdapter;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
        bind(IdentificationNumberValidatorAdapter.class).to(ChileanIdentificationNumberValidator.class);
        bind(PhoneValidatorAdapter.class).to(ChileanPhoneValidator.class);
    }
}
