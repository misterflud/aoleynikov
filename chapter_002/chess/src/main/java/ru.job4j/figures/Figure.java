package ru.job4j.figures;

import ru.job4j.board.Board;
import ru.job4j.board.Cell;
import ru.job4j.exceptions.ImpossibleMoveException;

/**Main class of figures.
 * @author Anton
 * @version 1
 */
public abstract class Figure {
    //protected Cell CellPosition;// зачем фигуре знать где она стоит -- все это передает доска
    //protected String name;
    /**Just constructor.
     */
    /**Way our Cell.
     * @param source source
     * @param disc disc
     * @param board board
     * @return Cell[] Cell[]
     * @throws ImpossibleMoveException ImpossibleMoveException
     */
    public abstract Cell[] way(Cell source, Cell disc, Board board) throws ImpossibleMoveException; //чтобы получить список объектов клеток, нужно их откуда то взять. Можно или напрямую или передать в параметре.
    /**Just constructor.
     * @return String Name
     */
    public abstract String getName();
}
