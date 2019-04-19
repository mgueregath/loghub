/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.role;

import io.codeffeine.starterkit.domain.security.contract.role.EditRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.repository.RoleRepositoryInterface;
import io.codeffeine.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import io.codeffeine.starterkit.usecase.exception.businessrule.role.CannotChangeRoleException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class EditRole implements EditRoleInterface {

    private final RoleRepositoryInterface repository;
    private final GetRoleInterface getRole;
    private final FieldValidatorAdapter fieldValidator;

    @Inject
    public EditRole(
            RoleRepositoryInterface repository,
            GetRoleInterface getRole,
            FieldValidatorAdapter fieldValidator
    ) {
        this.repository = repository;
        this.getRole = getRole;
        this.fieldValidator = fieldValidator;
    }

    @Override
    public Role edit(int id, String name) {
        Role role = getRole.getById(id);
        if (!role.isDeletable()) {
            throw new CannotChangeRoleException();
        }
        if (!role.getName().equals(name)) {
            fieldValidator.validate(name);
            role.setName(name);
            return repository.persist(role);
        }
        return role;
    }
}
