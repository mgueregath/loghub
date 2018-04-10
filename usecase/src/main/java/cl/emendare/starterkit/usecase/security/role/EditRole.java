/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.role;

import cl.emendare.starterkit.domain.security.contract.role.EditRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import cl.emendare.starterkit.usecase.exception.businessrule.role.CannotChangeRoleException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
