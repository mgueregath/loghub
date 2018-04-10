/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.migration.data;

import cl.emendare.starterkit.domain.migration.InitData;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.usecase.adapter.password.hasher.BCryptPasswordHasher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class Users extends InitData {

    public static final int EMENDARE = 1;
    private static final Map<Integer, User> users = new HashMap<>();

    public Users() {
        super();
        users.put(EMENDARE, new User(EMENDARE, "emendare", (new BCryptPasswordHasher()).hash("emendare.2018"), "development@emendare.cl", Roles.getById(Roles.DEVELOPMENT)));
    }

    public static List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public static User getById(int id) {
        return users.get(id);
    }

    @Override
    public Class getTargetClass() {
        return User.class;
    }

    @Override
    public List<?> getData() {
        return getUsers();
    }

    @Override
    public void setData(List<Object> data) {
        data.forEach(item -> {
            User role = (User) item;
            users.replace(role.getDomainId(), role);
        });
    }
}
