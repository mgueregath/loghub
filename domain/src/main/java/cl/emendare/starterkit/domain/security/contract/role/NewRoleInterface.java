/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.role;

import cl.emendare.starterkit.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NewRoleInterface {

    public Role add(String name);
}
