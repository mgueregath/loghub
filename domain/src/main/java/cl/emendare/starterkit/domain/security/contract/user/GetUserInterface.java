/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.user;

import cl.emendare.starterkit.domain.security.entity.User;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GetUserInterface {

    public List<User> getAll();

    public List<User> getPaginated(int page);

    public List<User> search(String search);

    public List<User> getByRole(int roleId);

    public User getById(int id);

    public User getByUsername(String username);
}
