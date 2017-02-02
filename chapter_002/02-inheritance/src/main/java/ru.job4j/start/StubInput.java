package ru.job4j.start;

/**For Tests; Putting this class instead ConsoleInput in StartUI; Initialisation massive in StartUITest.
 *@author Anton Oleynikov
 *@version 1
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        return answers[position++];
    }
}
