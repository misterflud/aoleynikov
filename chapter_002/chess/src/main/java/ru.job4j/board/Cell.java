package ru.job4j.board;

import ru.job4j.figures.Figure;

/**
 * Created by Anton on 03.02.2017.
 */
public class Cell {
    /**
     * figure.
     */
    private Figure figure;
    /**
     * horizontal.
     */
    private int horizontal;
    /**
     * vertical.
     */
    private int vertical;
    /**Constructor of class.
     * @param vertical vertical
     * @param horizontal horizontal
     */
    public Cell(int vertical, int horizontal) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
    /**
     * Print Cell or Figure.
     */
    public void print() {
        if (figure instanceof Figure) {
            System.out.print(figure.getName() + " ");
        } else {
            System.out.print("*" + " ");
        }
    }
    /**Get horizontal.
     * @return  horizontal
     */
    public int getHorizontal() {
        return horizontal;
    }
    /**Get vertical.
     * @return  vertical
     */
    public int getVertical() {
        return vertical;
    }
    /**Set Figure.
     * @param figure figure
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }
    /**Get Figure.
     * @return figure figure
     */
    public Figure getFigure() {
        return this.figure;
    }
}
