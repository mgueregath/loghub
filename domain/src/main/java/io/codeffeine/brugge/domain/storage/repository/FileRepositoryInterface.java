/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.storage.repository;

import java.io.File;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface FileRepositoryInterface {

    public String persist(String base64, String name, String prefix);

    public String findByName(String name);

    public File createTemporal(String namePrefix, String type);

    public boolean delete(String name);

}
