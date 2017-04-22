package ru.job4j;

/**
 * Created by Anton on 20.04.2017.
 */
public class Start {
    /**
     * Start.
     * @param args args
     */
    public static void main(String[] args) {
        Start start = new Start();
        start.startBankProgram();
    }

    /**
     * Start too.
     */
    public void startBankProgram() {
        UserAnswer userAnswer = new UserAnswer();
        BankActions bankActions = new BankActions(userAnswer);
        String s;
        do {
            bankActions.showBankAction();
            s = userAnswer.askAnswer("Write point or <exit>");
            if (s.equals("exit")) {
                break;
            }
            bankActions.select(Integer.parseInt(s));
        } while (true);

    }
}
