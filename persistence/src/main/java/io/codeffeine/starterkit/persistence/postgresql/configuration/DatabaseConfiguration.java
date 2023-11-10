/*
 * Emendare product for an specific client.
 */
package io.codeffeine.starterkit.persistence.postgresql.configuration;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class DatabaseConfiguration {

    private String schema;
    private String serverName;
    private int port;
    private String databaseName;
    private String user;
    private String password;
    private Boolean defaultValues = true;

    public DatabaseConfiguration() {
    }

    /**
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * @param schema the schema to set
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * @return the serverName
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * @param serverName the serverName to set
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the databaseName
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * @param databaseName the databaseName to set
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
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
     * @return the defaultValues
     */
    public Boolean getDefaultValues() {
        return defaultValues;
    }

    /**
     * @param defaultValues the defaultValues to set
     */
    public void setDefaultValues(Boolean defaultValues) {
        this.defaultValues = defaultValues;
    }
}
