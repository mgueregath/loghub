/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.repository;

import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.entity.User;
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
