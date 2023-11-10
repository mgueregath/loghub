/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.repository;

import io.codeffeine.brugge.domain.security.entity.Role;
import io.codeffeine.brugge.domain.security.entity.User;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface UserRepositoryInterface {

    public User findById(int id);

    public List<User> findAll();

    public List<User> findPaginated(int page);

    public List<User> findByRole(Role role);

    public List<User> search(String search);

    public User persist(User user);

    public boolean delete(User user);

    public User findByUsername(String username);
}
