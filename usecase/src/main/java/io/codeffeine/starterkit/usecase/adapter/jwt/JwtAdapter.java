/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.adapter.jwt;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface JwtAdapter {

    public String generate(long tokenId, int userId, int userAuth, String key);

    public long validate(String token, String key);
}
