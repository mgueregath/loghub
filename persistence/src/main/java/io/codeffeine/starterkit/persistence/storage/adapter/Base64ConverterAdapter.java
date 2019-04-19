/*
 * StarterKit.
 */
package io.codeffeine.starterkit.persistence.storage.adapter;

import java.io.File;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface Base64ConverterAdapter {

    public byte[] decode(String base64String);

    public String encode(File file);

    public String getExtension(String base64String);

}
