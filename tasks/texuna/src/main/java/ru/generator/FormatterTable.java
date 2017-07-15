package ru.generator;

import ru.generator.Parsers.XmlParameters;
import ru.generator.out.Output;

/**
 * Created by Anton on 12.07.2017.
 */
public class FormatterTable {
    /**
     * Height of table.
     */
    private int heightTable;
    /**
     * Height of rows in table.
     */
    private int heightNow;
    /**
     * Information on top of table.
     */
    private final Row stringTop;

    /**
     * Output
     */
    private Output output;

    /**
     * Constructor.
     * @param xml parameters
     * @param stringTop TopString
     * @param output output
     */
    public FormatterTable(XmlParameters xml, Row stringTop, Output output) {
        this.stringTop = stringTop;
        this.heightTable = xml.getHeightTable();
        this.output = output;

        addTop();
    }

    /**
     * Adds Row.
     * @param row row
     */
    public void addRow(Row row) {
        if (heightNow + row.getHeightRow() <= heightTable) {
            insert(row.getRow());
            heightNow += row.getHeightRow();
        } else {
            addEnd();
            addTop();
            output.write(row.getRow());
            heightNow += row.getHeightRow();
        }

    }

    /**
     * Adds top of table.
     */
    private void addTop() {
        heightNow = stringTop.getHeightRow();
        insert(stringTop.getRow());
    }

    /**
     * Adds end of table.
     */
    private void addEnd() {
        insert("~\r\n");
    }

    /**
     * Insert in output.
     * @param s s
     */
    private void insert(String s) {
        output.write(s);
    }
}
