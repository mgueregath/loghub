/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.adapter.jwt;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface JwtAdapter {

    public String generate(long tokenId, int userId, int userAuth, String key);

    public long validate(String token, String key);
}
