/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.migration.repository;

import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface MigrationDataRepositoryInterface {

    public <T> List<T> getByClass(Class<T> targetClass);

    public <T> T getByClassAndDomainId(Class<T> targetClass, int id);

    public Object persist(Class targetClass, Object element);
}
