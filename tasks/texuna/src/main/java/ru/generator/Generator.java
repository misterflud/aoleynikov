package ru.generator;

import ru.generator.Parsers.TsvPars;
import ru.generator.Parsers.XmlParameters;
import ru.generator.out.WriteInFile;


/**
 * Created by Anton on 11.07.2017.
 *
 */
public class Generator {

    /**
     * Start.
     * @param args paths
     */
    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.start(args[0], args[1], args[2]);
    }

    /**
     * Start Generator.
     * @param path1 xml file
     * @param path2 tsv file
     * @param path3 txt file
     */
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
