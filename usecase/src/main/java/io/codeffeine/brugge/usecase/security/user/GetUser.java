/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.user;

import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;
import io.codeffeine.brugge.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.brugge.domain.security.contract.user.GetUserInterface;
import io.codeffeine.brugge.domain.security.entity.Role;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.domain.security.repository.UserRepositoryInterface;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
