package ru.job4j.board;

import ru.job4j.exceptions.ImpossibleMoveException;
import ru.job4j.exceptions.OccupiedWayException;
import ru.job4j.exceptions.FigureNotFoundException;
import ru.job4j.figures.Figure;
import ru.job4j.figures.Rook;

/**Class Board, All things in program using in this class.
 * @author Anton
 * @version 1
 */
public class Board {
    /**
     * Cell[][] cells.
     */
    private Cell[][] cells;
    /**
     * length of Board.
     */
    private final int lengthBoard = 8;
    /**
     * Constructor of Board where Cells are done initialization.
     */
    public Board() {
        cells = new Cell[lengthBoard][lengthBoard];
        for (int i = 0; i < lengthBoard; i++) {
            for (int j = 0; j < lengthBoard; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }
    /**
     * Method is moved Figure, but it is mistaking method.
     * @return boolean
     * @param source source
     * @param dist dist
     * @throws ImpossibleMoveException if figure cant movement in dest cell.
     * @throws OccupiedWayException if dest cell is occupied.
     * @throws FigureNotFoundException if in source cell no figure.
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException { // В каком месте мы можем получить объекты, если при передвижении мы оперируем просто цифрами и обращение к этому методу происхожит из меню?? И кому нужно вернуть булево значение??
        return true;
    }
    /**
     * Print Board.
     */
    public void printBoard() {
        //System.out.println("  A B C D E F G H ");
        System.out.println("  1 2 3 4 5 6 7 8 ");
        for (int i = 0; i < lengthBoard; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < lengthBoard; j++) {
                cells[j][i].print();
            }
            System.out.println();
        }
    }
    /**Put figures on Board.
     * @param vertical vertical
     * @param horizontal horizontal
     * @param figure figure
     */
    public void putFigure(int vertical, int horizontal, Figure figure) {
        this.cells[vertical][horizontal].setFigure(figure);
    }
    /**Get figures from Board.
     * @param vertical vertical
     * @param horizontal horizontal
     * @return Figure
     */
    public Figure getFigure(int vertical, int horizontal) {
        return this.cells[vertical][horizontal].getFigure();
    }
    /**Get Cell from Board.
     * @param vertical vertical
     * @param horizontal horizontal
     * @return Cell
     */
    public Cell getCell(int vertical, int horizontal) {
        return cells[vertical][horizontal];
    }
    /**initialization Figures.
     */
    public void initializationFiguresOnBoard() {
        putFigure(0, 0, new Rook());
        putFigure(0, 1, new Rook());
    }
    /**Move Figure.
     * @param vertical1 vertical1
     * @param horizontal1 horizontal1
     * @param vertical2 vertical2
     * @param horizontal2 horizontal2
     * @throws ImpossibleMoveException if figure cant movement in dest cell.
     * @throws OccupiedWayException if dest cell is occupied.
     * @throws FigureNotFoundException if in source cell no figure.
     */
    public void moveRight(int vertical1, int horizontal1, int vertical2, int horizontal2) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure figureBegin;
        if (this.cells[vertical1][horizontal1].getFigure() == null) {// ИСПРАВИЛ
            throw new FigureNotFoundException();
        } else {
            figureBegin = this.cells[vertical1][horizontal1].getFigure();
        }
        Cell[] way = figureBegin.way(this.cells[vertical1][horizontal1], this.cells[vertical2][horizontal2], this);
        for (int i = 1; i < way.length; i++) {
            if (way[i].getFigure() != null) { // ИСПРАВИЛ
                throw new OccupiedWayException();
            }
        }
        way[way.length - 1].setFigure(figureBegin);
        way[0].setFigure(null);
    }
}
