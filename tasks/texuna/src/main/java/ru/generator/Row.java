package ru.generator;

/**
 * Created by Anton on 14.07.2017.
 */
public class Row {
    private String row;
    private int heightRow;

    public Row(String row, int heightRow) {
        this.row = row;
        this.heightRow = heightRow;
    }
    public String getRow() {
        return row;
    }

    public int getHeightRow() {
        return heightRow;
    }
}
