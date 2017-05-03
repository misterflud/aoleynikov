package ru.job4j.start;

/**For Tests; Putting this class instead ConsoleInput in StartUI; Initialisation massive in StartUITest.
 *@author Anton Oleynikov
 *@version 1
 */
public class StubInput implements Input {
    /**
     * Array.
     */
    private String[] answers;

    /**
     * Iterator.
     */
    private int position = 0;
    /**
     * Constructor.
     * @param answers array.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     *
     * @param question question.
     * @return String
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     *
     * @param question question.
     * @param range range.
     * @return int
     */
    public int ask(String question, int[] range) {

        return Integer.valueOf(this.answers[position++]);
    }
}
