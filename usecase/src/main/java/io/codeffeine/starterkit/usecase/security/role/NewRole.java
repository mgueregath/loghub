/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.role;

import io.codeffeine.starterkit.usecase.exception.data.AlreadyExistException;
import io.codeffeine.starterkit.usecase.exception.data.DataNotFoundException;
import io.codeffeine.starterkit.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.NewRoleInterface;
import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.repository.RoleRepositoryInterface;
import io.codeffeine.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class NewRole implements NewRoleInterface {

    private final RoleRepositoryInterface repository;
    private final GetRoleInterface getRole;
    private final FieldValidatorAdapter fieldValidator;

    @Inject
    public NewRole(
            RoleRepositoryInterface repository,
            GetRoleInterface getRole,
            FieldValidatorAdapter fieldValidator
    ) {
        this.repository = repository;
        this.getRole = getRole;
        this.fieldValidator = fieldValidator;
    }

    @Override
    public Role add(String name) {
        fieldValidator.validate(name);
        try {
            List<Role> roles = getRole.getAll();
            for (Role role : roles) {
                if (role.getName().equalsIgnoreCase(name)) {
                    throw new AlreadyExistException();
                }
            }
        } catch (DataNotFoundException ex) {
            // No action
        }
        Role role = new Role(name, true);
        return repository.persist(role);
    }
}
