/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.entity;

import io.codeffeine.brugge.domain.migration.entity.MigratedEntity;
import java.util.Set;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Role extends MigratedEntity {

    private int id;
    private String name;
    private boolean deletable;
    private boolean assignable;
    private Set<SecureMethod> permissions;

    public Role() {
    }

    public Role(int domainId, String name, boolean deletable, boolean assignable) {
        super(domainId);
        this.name = name;
        this.deletable = deletable;
        this.assignable = assignable;
    }

    public Role(String name, boolean deletable) {
        this.name = name;
        this.deletable = deletable;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the deletable
     */
    public boolean isDeletable() {
        return deletable;
    }

    /**
     * @param deletable the deletable to set
     */
    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }

    /**
     * @return the permissions
     */
    public Set<SecureMethod> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(Set<SecureMethod> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return the assignable
     */
    public boolean isAssignable() {
        return assignable;
    }

    /**
     * @param assignable the assignable to set
     */
    public void setAssignable(boolean assignable) {
        this.assignable = assignable;
    }
}
