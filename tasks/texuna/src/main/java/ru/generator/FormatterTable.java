package ru.generator;

import ru.generator.Parsers.XmlParameters;
import ru.generator.out.Output;

/**
 * Created by Anton on 12.07.2017.
 */
public class FormatterTable {

    private int heightTable;

    private int heightNow;

    private final Row stringTop;


    private Output output;


    public FormatterTable(XmlParameters xml, Row stringTop, Output output) {
        this.stringTop = stringTop;
        this.heightTable = xml.getHeightTable();
        this.output = output;

        writeTop();
    }

    public void addRow(Row row) {
        if (heightNow + row.getHeightRow() <= heightTable) {
            output.write(row.getRow());
            heightNow += row.getHeightRow();
        } else {
            writeTop();
            output.write(row.getRow());
            heightNow += row.getHeightRow();
        }

    }

    private void writeTop() {
        heightNow = stringTop.getHeightRow();
        output.write(stringTop.getRow());
    }

    private void writeEnd() {
        output.write("~\r\n");
    }
}
