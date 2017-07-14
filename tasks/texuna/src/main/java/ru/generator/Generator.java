package ru.generator;

import ru.generator.Parsers.TsvPars;
import ru.generator.Parsers.XmlParameters;
import ru.generator.out.WriteInFile;


/**
 * Created by Anton on 11.07.2017.
 *
 */
public class Generator {
    public static void main(String[] args) {

        //TsvPars tsvPars = new TsvPars("C:\\java\\testsTask\\1\\source-data.tsv");
        //tsvPars.getDataNext();
        //int a = 6;
        //int b = 6;
        //System.out.println((a > b) ? a : b);
        //b =+ 1;
        //a += 1;
        //System.out.println(b);
        //System.out.println(a);
        //FormatterRow formatterRow = new FormatterRow(tsvPars.getDataNext(), xmlParameters);
        //System.out.println(formatterRow.getStringRow());
        Generator generator = new Generator();
        generator.start("C:\\java\\testsTask\\1\\settings.xml", "C:\\java\\testsTask\\1\\source-data.tsv", "C:\\java\\testsTask\\1\\out.txt");
    }

    public void start(String path1, String path2, String path3) {
        try (WriteInFile writeInFile = new WriteInFile(path3)) {

            XmlParameters xmlParameters = new XmlParameters(path1);
            TsvPars tsvPars = new TsvPars(path2);
            FormatterRow formatterRow = new FormatterRow(xmlParameters);

            final String[] top = {"Номер", "Дата", "ФИО"};
            final Row rowTop = formatterRow.formatter(top);
            
            FormatterTable formatterTable = new FormatterTable(xmlParameters, rowTop, writeInFile);
            
            while (tsvPars.hasLine()) {
                formatterTable.addRow(formatterRow.formatter(tsvPars.getDataNext()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
