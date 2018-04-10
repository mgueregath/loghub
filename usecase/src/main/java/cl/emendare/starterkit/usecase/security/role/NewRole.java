/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.role;

import cl.emendare.exceptions.data.AlreadyExistException;
import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.NewRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
