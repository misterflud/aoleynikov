package ru.job4j.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import ru.job4j.board.Board;

/**ManageAll.
 * @author Anton
 * @version 1
 * 1 1 1 2
 * 1 2 2 3
 */
public class Menu {
    /**
     * Start program.
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        new Menu().start();
    }
    /**
     * Start program.
     * @throws Exception Exception
     */
    public void start() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();
        String s;
        String[] ss;
        board.initializationFiguresOnBoard();
        final int three = 3;
        final int two = 2;
        final int one = 1;
        final int zero = 0;
        System.out.println("*************Hello*************");
        while (true) {
            System.out.println("You turn(1 1 1 2) OR write exit");
            board.printBoard();
            s = reader.readLine();
            if (s.equals("exit")) {
                break;
            } else {
                ss = s.split(" ");
                board.moveRight(Integer.parseInt(ss[zero]) - 1, Integer.parseInt(ss[one]) - 1, Integer.parseInt(ss[two]) - 1, Integer.parseInt(ss[three]) - 1);
            }
        }
    }
}
