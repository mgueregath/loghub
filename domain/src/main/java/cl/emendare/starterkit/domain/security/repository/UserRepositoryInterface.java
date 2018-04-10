/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.repository;

import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.User;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
