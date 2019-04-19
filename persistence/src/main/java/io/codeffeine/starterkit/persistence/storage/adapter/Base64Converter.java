/*
 * StarterKit.
 */
package io.codeffeine.starterkit.persistence.storage.adapter;

import io.codeffeine.starterkit.persistence.storage.exception.FileConvertionException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Base64Converter implements Base64ConverterAdapter {

    @Override
    public byte[] decode(String base64String) {
        String[] splited = base64String.split(",");
        return Base64.decodeBase64(splited[1]);
    }

    @Override
    public String encode(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            byte[] encoded = Base64.encodeBase64(bytes);
            return new String(encoded);
        } catch (IOException e) {
            throw new FileConvertionException();
        }
    }

    @Override
    public String getExtension(String base64String) {
        String[] extension = base64String.split("/");
        extension = extension[1].split(";");
        return extension[0];
    }
}
