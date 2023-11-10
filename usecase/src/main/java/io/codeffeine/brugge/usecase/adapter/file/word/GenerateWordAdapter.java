/*
 * Emendare product for an specific client.
 */
package io.codeffeine.brugge.usecase.adapter.file.word;

import java.io.File;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GenerateWordAdapter {

    public Map<String, File> generate(XWPFDocument document, File word, File pdf);

}
