/*
 * Emendare product for an specific client.
 */
package io.codeffeine.starterkit.domain.adapter;

import java.io.File;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface Base64ConverterAdapter {

    public byte[] decode(String base64String);

    public String encode(File file);

    public String getExtension(String base64String);
}
