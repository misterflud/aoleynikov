package ru.job4j.figures;

import ru.job4j.board.Board;
import ru.job4j.board.Cell;
import ru.job4j.exceptions.ImpossibleMoveException;

/**Rook.
 * @author Anton
 * @version 1
 */
public class Rook extends Figure {
    /**
     * Name of Figure.
     */
    private String name = "R";

    @Override
    public Cell[] way(Cell source, Cell disc, Board board) throws ImpossibleMoveException {
        Cell[] cells;
        int sourceVertical = source.getVertical();
        int sourceHorizontal = source.getHorizontal();
        int discVertical = disc.getVertical();
        int discHorizontal = disc.getHorizontal();
        if (sourceVertical == discVertical) { //движение по горизонтали i -- вертикаль j -- горизонталь
            if (sourceHorizontal < discHorizontal) {
                cells = new Cell[discHorizontal - sourceHorizontal + 1];
                for (int i = 0; i <= discHorizontal - sourceHorizontal; i++) {
                    cells[i] = board.getCell(sourceVertical, sourceHorizontal + i);
                }
            } else {
                cells = new Cell[sourceHorizontal - discHorizontal + 1];
                for (int i = 0; i <= sourceHorizontal - discHorizontal; i++) {
                    cells[i] = board.getCell(sourceVertical, sourceHorizontal - i);
                }
            }
        } else if (sourceHorizontal == discHorizontal) { // движение по вертикали source.horizontal == disc.horizontal
            if (sourceVertical < discVertical) {
                cells = new Cell[discVertical - sourceVertical + 1];
                for (int i = 0; i <= discVertical - sourceVertical; i++) {
                    cells[i] = board.getCell(sourceVertical + i, sourceHorizontal);
                }
            } else {
                cells = new Cell[sourceVertical - discVertical + 1];
                for (int i = 0; i <= sourceVertical - discVertical; i++) {
                    cells[i] = board.getCell(sourceVertical - i, sourceHorizontal);
                }
            }
        } else {
            throw new ImpossibleMoveException();
        }
        return cells;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
