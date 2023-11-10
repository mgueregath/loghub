/*
 * Emendare product for an specific client.
 */
package io.codeffeine.starterkit.usecase.adapter.file.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GenerateXLS implements GenerateXLSAdapter {

    @Override
    public File generate(File file, Map<String, List<List<String>>> sheets) {
        try {
            Workbook workbook = new XSSFWorkbook();
            for (String sheetName : sheets.keySet()) {
                if (sheets.containsKey(sheetName)) {
                    Sheet sheet = workbook.createSheet(sheetName);
                    int rowNumber = 0;
                    for (List<String> rowData : sheets.get(sheetName)) {
                        Row row = sheet.createRow(rowNumber++);
                        int cellNumber = 0;
                        for (String cellData : rowData) {
                            row.createCell(cellNumber++).setCellValue(cellData);
                        }
                    }
                }
            }
            FileOutputStream fileOut = new FileOutputStream(file);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            return file;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException();
        } catch (IOException ex) {
            throw new RuntimeException();
        }

    }

}
