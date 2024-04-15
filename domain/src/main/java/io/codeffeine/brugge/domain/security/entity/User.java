/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.entity;

import io.codeffeine.brugge.domain.migration.entity.MigratedEntity;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class User extends MigratedEntity {

    private int id;
    private String username;
    private String password;
    private String email;
    private Role role;
    private boolean enabled;
    private Boolean accountRecovery;

    public User(int domainId, String username, String password, String email, Role role) {
        super.domainId = domainId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enabled = true;
        this.accountRecovery = false;
    }

    public User(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enabled = true;
        this.accountRecovery = false;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public User() {
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the accountRecovery
     */
    public Boolean getAccountRecovery() {
        return accountRecovery;
    }

    /**
     * @param accountRecovery the accountRecovery to set
     */
    public void setAccountRecovery(Boolean accountRecovery) {
        this.accountRecovery = accountRecovery;
    }
}
