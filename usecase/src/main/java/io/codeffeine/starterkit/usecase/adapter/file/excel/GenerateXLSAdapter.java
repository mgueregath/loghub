/*
 * Emendare product for an specific client.
 */
package io.codeffeine.starterkit.usecase.adapter.file.excel;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GenerateXLSAdapter {

    public File generate(File file, Map<String, List<List<String>>> sheets);
}
