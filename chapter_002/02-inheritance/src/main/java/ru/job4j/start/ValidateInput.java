package ru.job4j.start;

/**ValidateInput.
 *@author Anton Oleynikov
 *@version 1
 */
public class ValidateInput extends ConsoleInput {
    /**
     *
     * @param question question.
     * @param range range.
     * @return int
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range); //
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter data again");
            } catch (MenuOutException e) {
                System.out.println("select right key from menu");
            }
        } while (invalid);

        return value;
    }
}
