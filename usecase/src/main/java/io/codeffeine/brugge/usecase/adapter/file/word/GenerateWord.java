/*
 * Emendare product for an specific client.
 */
package io.codeffeine.brugge.usecase.adapter.file.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFChart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GenerateWord implements GenerateWordAdapter {

    @Override
    public Map<String, File> generate(XWPFDocument document, File word, File pdf) {

        try {
            FileOutputStream fileOut = new FileOutputStream(word);
            document.write(fileOut);
            fileOut.close();
            document.createStyles();
            document.close();
            Map<String, File> result = new HashMap<>();
            result.put("word", word);
            result.put("pdf", null);
            return result;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException();
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    public XWPFDocument addTitle(XWPFDocument document, String text) {
        addTitle(document, text, true);
        return document;
    }

    public XWPFDocument addTitle(XWPFDocument document, String text, boolean newPage) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        paragraph.setPageBreak(newPage);
        run.setBold(true);
        run.setFontSize(14);
        run.setFontFamily("Cambria");
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setText(text.toUpperCase());
        return document;
    }

    public XWPFDocument addSubTitle1(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.addBreak();
        run.setBold(true);
        run.setFontSize(12);
        run.setFontFamily("Cambria");
        run.setText(text.toUpperCase());
        return document;
    }

    public XWPFDocument addSubTitle2(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.addBreak();
        run.addBreak();
        run.setBold(true);
        run.setFontSize(11);
        run.setColor("cc6600");
        run.setFontFamily("Cambria");
        run.setText(text.toUpperCase());
        return document;
    }

    public XWPFDocument addSubTableComment(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(9);
        run.setFontFamily("Cambria");
        run.setText(text);
        return document;
    }

    public XWPFDocument addChart(XWPFDocument document, String[] x, Double[] y, double width, double height) {

        try {
            XWPFChart chart = document.createChart();
            //chart.setChartBoundingBox((long) (width * Units.EMU_PER_CENTIMETER), (long) (height * Units.EMU_PER_CENTIMETER));
            chart.setChartHeight((long) (height * Units.EMU_PER_CENTIMETER));
            chart.setChartWidth((long) (width * Units.EMU_PER_CENTIMETER));
            XDDFChartLegend legend = chart.getOrAddLegend();
            legend.setPosition(LegendPosition.RIGHT);

            XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromArray(x);
            XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromArray(y);

            XDDFChartData data = chart.createData(ChartTypes.PIE, null, null);
            data.setVaryColors(true);
            XDDFChartData.Series series = data.addSeries(cat, val);
            //series.setTitle("Series", null);
            chart.plot(data);

            if (chart.getCTChart().getAutoTitleDeleted() == null) {
                chart.getCTChart().addNewAutoTitleDeleted();
            }
            chart.getCTChart().getAutoTitleDeleted().setVal(false);

        } catch (InvalidFormatException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;

    }

    public XWPFDocument addTable(XWPFDocument document, String[][] data) {
        XWPFTable table = document.createTable(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (i == 0) {
                    table.getRow(i).getCell(j).setColor("CC6600");
                    table.getRow(i).getCell(j).removeParagraph(0);
                    XWPFParagraph paragraph = table.getRow(i).getCell(j).addParagraph();
                    XWPFRun run = paragraph.createRun();
                    run.setColor("FFFFFF");
                    run.setFontFamily("Cambria");
                    run.setBold(true);
                    run.setText(data[i][j]);
                } else {
                    table.getRow(i).getCell(j).setText(data[i][j]);
                }
                table.getRow(i).getCell(j).setWidthType(TableWidthType.AUTO);

            }
        }
        table.setWidth("100%");
        return document;
    }

    public XWPFDocument addImage(XWPFDocument document, String image) {
        FileInputStream is = null;
        try {
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            is = new FileInputStream(new File(new URI(image)));
            run.addBreak();
            run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, image, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return document;
    }

    public XWPFDocument generatePersonGraphic(XWPFDocument document, double percentage) {
        int decimal = (int) Math.round(percentage / 10);
        File orangeFile = null;
        File grayFile = null;
        try {
            orangeFile = File.createTempFile("temp", "temp");
            grayFile = File.createTempFile("temp", "temp");
        } catch (IOException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileUtils.copyInputStreamToFile(this.getClass().getClassLoader().getResourceAsStream("person-orange.png"), orangeFile);
            FileUtils.copyInputStreamToFile(this.getClass().getClassLoader().getResourceAsStream("person-gray.png"), grayFile);
        } catch (IOException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileInputStream is = null;
        try {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            for (int i = 1; i <= 10; i++) {
                is = new FileInputStream(i <= decimal ? orangeFile : grayFile);
                run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, "person.png", Units.toEMU(30), Units.toEMU(70));
            }
            run.setFontSize(75);
            run.setColor("cc6600");
            run.setFontFamily("Cambria");
            run.setSubscript(VerticalAlign.SUPERSCRIPT);
            run.setText(" " + (Math.round(percentage * 100) / 100) + "%");
            run.addBreak();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(GenerateWord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return document;
    }

}
