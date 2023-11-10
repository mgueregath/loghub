/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.user;

import io.codeffeine.brugge.domain.security.entity.User;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetUserInterface {

    public List<User> getAll();

    public List<User> getPaginated(int page);

    public List<User> search(String search);

    public List<User> getByRole(int roleId);

    public User getById(int id);

    public User getByUsername(String username);
}
