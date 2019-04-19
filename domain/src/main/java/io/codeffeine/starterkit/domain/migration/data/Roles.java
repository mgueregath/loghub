/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.migration.data;

import io.codeffeine.starterkit.domain.migration.InitData;
import io.codeffeine.starterkit.domain.security.entity.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Roles extends InitData {

    public static final int DEVELOPMENT = 9990;
    public static final int PUBLIC = 8999;
    private static final Map<Integer, Role> roles = new HashMap<>();

    public Roles() {
        super();
        roles.put(PUBLIC, new Role(PUBLIC, "Público", false));
        roles.put(DEVELOPMENT, new Role(DEVELOPMENT, "Desarrollo", false));
    }

    public static List<Role> getRoles() {
        return new ArrayList<>(roles.values());
    }

    public static Role getById(int id) {
        return roles.get(id);
    }

    @Override
    public Class getTargetClass() {
        return Role.class;
    }

    @Override
    public List<?> getData() {
        return getRoles();
    }

    @Override
    public void setData(List<Object> data) {
        data.forEach(item -> {
            Role role = (Role) item;
            roles.replace(role.getDomainId(), role);
        });
    }

}
