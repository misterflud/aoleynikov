package ru.generator;

import org.apache.commons.lang3.text.WordUtils;
import ru.generator.Parsers.XmlParameters;

/**
 * Created by Anton on 13.07.2017.
 */
public class FormatterRow {

    /**
     * Number from tsv file.
     */
    private String numberColumn;

    /**
     * Date from tsv file.
     */
    private String dateColumn;

    /**
     * Name of people from tsv file.
     */
    private String nameColumn;

    /**
     * Width of first column.
     */
    private int widthNumber;

    /**
     * Width of the second column.
     */
    private int widthDate;

    /**
     * Width of the third column.
     */
    private int widthName;

    /**
     * Width table.
     */
    private int widthTable;

    /**
     * Height of information row.
     */
    private int heightRow = 0;

    /**
     * StringBuilder for Number.
     */
    private StringBuilder temp1 = new StringBuilder();

    /**
     * StringBuilder for Number.
     */
    private StringBuilder temp2 = new StringBuilder();

    /**
     * StringBuilder for Number.
     */
    private StringBuilder temp3 = new StringBuilder();

    /**
     * StringBuilder for resulted information row.
     */
    private StringBuilder stringRow = new StringBuilder();

    /**
     * Constructor.
     * @param xml xml file with parameters
     */
    public FormatterRow(XmlParameters xml) {
        this.widthNumber = xml.getWidthNumber();
        this.widthDate = xml.getWidthDate();
        this.widthName = xml.getWidthName();
        this.widthTable = xml.getWidthTable();
    }

    /**
     * Creates Information row.
     * @param s mass from tsv
     * @return Row
     */
    public Row formatter(String[] s) {
        this.numberColumn = s[0]; //чтобы удбнее было понимать
        this.dateColumn = s[1];
        this.nameColumn = s[2];

        final String[] s1 = WordUtils.wrap(numberColumn, widthNumber, "\n", true).split("\n");
        final String[] s2 = WordUtils.wrap(dateColumn, widthDate, "\n", true).split("\n");
        final String[] s3 = WordUtils.wrap(nameColumn, widthName, "\n", true).split("\n");

        final int len1 = s1.length;
        final int len2 = s2.length;
        final int len3 = s3.length;

        final int lenTemp = (len1 > len2) ? len1 : len2;
        final int max = (lenTemp > len3) ? lenTemp : len3;


        for (int i = 0; i < max; i++) {
            if (len1 > i) {
                temp1.append(s1[i]);
            }
            if (len2 > i) {
                temp2.append(s2[i]);
            }
            if (len3 > i) {
                temp3.append(s3[i]);
            }
            temp1.setLength(widthNumber);
            temp2.setLength(widthDate);
            temp3.setLength(widthName);
            stringRow.append(String.format("| %s | %s | %s |\r\n", temp1, temp2, temp3));
            temp1.delete(0, temp1.length());
            temp2.delete(0, temp2.length());
            temp3.delete(0, temp3.length());
            heightRow++;
        }
        stringRow.append(String.format("%s\r\n", createString("-", widthTable)));

        Row row = new Row(stringRow.toString(), heightRow);
        heightRow = 0;
        stringRow.delete(0, stringRow.length());
        return row;
    }

    /**
     * For create "------.......------".
     * We can transform this method in future
     * @param word word
     * @param count count
     * @return String
     */
    private String createString(String word, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }

}
