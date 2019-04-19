/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.migration.data;

import io.codeffeine.starterkit.domain.migration.InitData;
import io.codeffeine.starterkit.domain.security.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Users extends InitData {

    public static final int CODEFFEINE = 1;
    private static final Map<Integer, User> users = new HashMap<>();

    public Users() {
        super();
        users.put(CODEFFEINE, new User(CODEFFEINE, "codeffeine", "$2a$10$WILulspOQKKgTnJKKMrFZeNk71EkNMpWwTCch/DNl8Okt5NnnrMxO", "development@codeffeine.io", Roles.getById(Roles.DEVELOPMENT)));
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
