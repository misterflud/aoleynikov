package ru.generator;

/**
 * Created by Anton on 14.07.2017.
 * Container for information row and height row.
 */
public class Row {
    /**
     * Information row.
     */
    private String row;
    /**
     * Height row.
     */
    private int heightRow;

    /**
     * Constructor.
     * @param row row
     * @param heightRow heightRow
     */
    public Row(String row, int heightRow) {
        this.row = row;
        this.heightRow = heightRow;
    }

    /**
     * Getter.
     * @return Information row
     */
    public String getRow() {
        return row;
    }

    /**
     * Getter.
     * @return Height row
     */
    public int getHeightRow() {
        return heightRow;
    }
}
