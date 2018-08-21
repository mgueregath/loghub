/*
 * StarterKit.
 */
package cl.emendare.starterkit.persistence.storage;

import cl.emendare.starterkit.persistence.exception.DeletingException;
import static cl.emendare.starterkit.persistence.storage.StoragePath.BASE_PATH;
import cl.emendare.starterkit.persistence.storage.exception.FileStorageException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class FileManager {

    private final String path;

    public FileManager() {
        if (SystemUtils.IS_OS_WINDOWS) {
            path = "/Temp";
        } else {
            path = BASE_PATH;
        }
    }

    public String save(byte[] bytes, String originalName, String namePrefix, String extension) {
        String name = "/" + namePrefix.replace(" ", "_");
        File file = new File(path);

        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(path + name);

        if (!file.exists()) {
            file.mkdir();
        }

        name += "/" + originalName.replace(" ", "_") + "_" + new Date().getTime() + "." + extension;
        FileOutputStream fileOutputStream = null;
        try {
            file = new File(path + name);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new FileStorageException();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                // No action
            }
        }
        return name;
    }

    public File getByName(String fileName) {
        File file = new File(path + fileName);
        if (file.exists()) {
            return file;
        } else {
            throw new FileStorageException();
        }
    }

    public boolean delete(String name) {
        File file = getByName(name);
        if (file.delete()) {
            return true;
        }
        throw new DeletingException();
    }

    public File createTemporal(String namePrefix, String type) {
        String name = "/" + namePrefix.replace(" ", "_") + "/" + new Date().getTime();
        try {
            File file = File.createTempFile(name, type);
            file.deleteOnExit();
            return file;
        } catch (IOException ex) {
            throw new FileStorageException();
        }
    }
}
