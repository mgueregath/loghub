/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.user;

import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.security.repository.UserRepositoryInterface;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetUser implements GetUserInterface {

    private final UserRepositoryInterface repository;
    private final GetRoleInterface getRole;

    @Inject
    public GetUser(
            UserRepositoryInterface repository,
            GetRoleInterface getRole
    ) {
        this.repository = repository;
        this.getRole = getRole;
    }

    @Override
    public List<User> getAll() {
        List<User> users = repository.findAll();
        if (users.isEmpty()) {
            throw new DataNotFoundException();
        }
        return users;
    }

    @Override
    public List<User> getByRole(int roleId) {
        Role role = getRole.getById(roleId);
        List<User> users = repository.findByRole(role);
        if (users.isEmpty()) {
            throw new DataNotFoundException();
        }
        return users;
    }

    @Override
    public User getById(int id) {
        User user = repository.findById(id);
        if (user == null) {
            throw new DataNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getPaginated(int page) {
        List<User> users = repository.findPaginated(page);
        if (users.isEmpty()) {
            throw new DataNotFoundException();
        }
        return users;
    }

    @Override
    public List<User> search(String search) {
        List<User> users = repository.search(search);
        if (users.isEmpty()) {
            throw new DataNotFoundException();
        }
        return users;
    }

    @Override
    public User getByUsername(String username) {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new DataNotFoundException();
        }
        return user;
    }
}
