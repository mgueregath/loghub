/*
 * StarterKit.
 */
package cl.emendare.starterkit.persistence.storage.repository;

import cl.emendare.starterkit.domain.storage.repository.FileRepositoryInterface;
import cl.emendare.starterkit.persistence.storage.FileManager;
import cl.emendare.starterkit.persistence.storage.adapter.Base64Converter;
import cl.emendare.starterkit.persistence.storage.adapter.Base64ConverterAdapter;
import java.io.File;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class FileRepository implements FileRepositoryInterface {

    private final FileManager fileManager;
    private final Base64ConverterAdapter base64Converter;

    public FileRepository() {
        fileManager = new FileManager();
        base64Converter = new Base64Converter();
    }

    @Override
    public String persist(String base64, String name, String prefix) {
        return fileManager.save(base64Converter.decode(base64), name, prefix,
                base64Converter.getExtension(base64)
        );
    }

    @Override
    public String findByName(String name) {
        return base64Converter.encode(fileManager.getByName(name));
    }

    @Override
    public boolean delete(String name) {
        return fileManager.delete(name);
    }

    @Override
    public File createTemporal(String namePrefix, String type) {
        return fileManager.createTemporal(namePrefix, type);
    }
}
