/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.role;

import io.codeffeine.brugge.domain.security.contract.role.EditRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.brugge.domain.security.entity.Role;
import io.codeffeine.brugge.domain.security.repository.RoleRepositoryInterface;
import io.codeffeine.brugge.usecase.adapter.validation.field.FieldValidatorAdapter;
import io.codeffeine.brugge.usecase.exception.businessrule.role.CannotChangeRoleException;
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
