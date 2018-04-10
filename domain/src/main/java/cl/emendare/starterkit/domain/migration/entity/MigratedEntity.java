/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.migration.entity;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class MigratedEntity {

    protected Integer domainId;

    public MigratedEntity(int domainId) {
        this.domainId = domainId;
    }

    public MigratedEntity() {
    }

    /**
     * @return the domainId
     */
    public Integer getDomainId() {
        return domainId;
    }

    /**
     * @param domainId the domainId to set
     */
    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }
}
