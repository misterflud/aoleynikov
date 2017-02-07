package ru.job4j.board;

import org.junit.Test;
import ru.job4j.exceptions.ImpossibleMoveException;
import ru.job4j.exceptions.OccupiedWayException;
import ru.job4j.figures.Rook;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 06.02.2017.
 */
public class BoardTest {
    /**
     * Test1 add.
     */
    @Test
    public void whenRookMoveThenRookIsMoved() {
        Board board = new Board();
        final int six = 6;
        final int zero = 0;
        board.putFigure(zero, zero, new Rook());
        try {
            board.moveRight(zero, zero, zero, six);
        } catch (Exception e) {

        }
        assertThat(board.getFigure(zero, six).getName(), is(new Rook().getName()));
    }
    /**
     * Test2 impossible move.
     * @throws Exception Exception
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenRookMoveThenRookIsNotMoved() throws Exception {
        Board board = new Board();
        final int six = 6;
        final int two = 2;
        final int zero = 0;
        board.putFigure(zero, zero, new Rook());
        board.moveRight(zero, zero, two, six);
        assertThat(board.getFigure(zero, six).getName(), is(new Rook().getName()));
    }
    /**
     * Test3 impossible move.
     * @throws Exception Exception
     */
    @Test(expected = OccupiedWayException.class)
    public void whenRookMoveThenRookIsNotMoved2() throws Exception {
        Board board = new Board();
        final int six = 6;
        final int two = 2;
        final int zero = 0;
        board.putFigure(zero, zero, new Rook());
        board.putFigure(zero, two, new Rook());
        board.moveRight(zero, zero, zero, six);
        assertThat(board.getFigure(zero, six).getName(), is(new Rook().getName()));
    }
}
