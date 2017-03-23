package ru.job4j;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Anton on 22.03.2017.
 */
public class InteractCalc extends Calculator {
    /**
     * Main massage; It contains all action.
     */
    private String menuList = "1 add <number1> to <number2> \n2 subtraction <number2> from <number1> \n3 divide <number1> on <number2> \n4 multiple <number1> on <number2> \n5 use last result as <number> \nIf you want to reselect operation, then write <reselect> before write numbers  \nIf you want exit then write <exit>";
    /**
     * First number from Calculate's methods.
     */
    private double number1;
    /**
     * Second number from Calculate's methods.
     */
    private double number2;
    /**
     * Will we use result as number1? yes (true) or not (false).
     */
    private boolean resultAsNumber1 = false;
    /**
     * Will we use result as number2? yes (true) or not (false).
     */
    private boolean resultAsNumber2 = false;
    /**
     * Will we reselect point of menu? yes (true) or not (false).
     */
    private boolean reselect = false;

    /**
     * Start program.
     * @param args console massive
     */
    public static void main(String[] args) {
        InteractCalc interactCalc = new InteractCalc();
        interactCalc.menu();
    }

    /**
     * Method is analyzed what user wrote.
     * @param s String
     */
    public void reselectOperationOrNot(String s) { //в итоге он оказался неудобным, ибо логичнее все его тело внести в метод selectParameters(), но ведь SRP)))
        if ("reselect".equals(s)) {
            reselect = true; //ставим флаг для метода menu() и selectParameters()
        }
    }

    /**
     * Dividing s on number1 and number2, and convert their to double type.
     * @param s contains <number1 number2>
     */
    public void divideString(String s) {
        String[] numbers = s.split(" ");
        number1 = Double.parseDouble(numbers[0]);
        number2 = Double.parseDouble(numbers[1]);
    }

    /**
     * Printing.
     * @param s any object (here we use just String and Double)
     */
    public void print(Object s) {
        System.out.println(s);
    }

    /**
     * Working with console.
     * @return user command
     */
    public String consoleReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s =  reader.readLine();
        } catch (IOException e) {
            System.out.println("Something is bad");
        }
        return s;
    }

    /**
     * It's subpoint of menu.
     */
    public void selectParameters() { //в общем этот метод для того чтобы не было повторов кода в методе menu()
        print("write reselect, or <number1 number2>, or just <number> if you used  point 5"); //можно было расписать, чтобы было проще пользователю, но не буду)
        String s = consoleReader();
        reselectOperationOrNot(s);
        if (reselect) { //приходится 2 раза его использовать (reselect)

        } else if (resultAsNumber1) { //если нужно использовать результат предыдущего вычесления
            number2 = Double.parseDouble(s);
            number1 = getResult();
            resultAsNumber1 = false;
        }  else if (resultAsNumber2) {
            number1 = Double.parseDouble(s);
            number2 = getResult();
            resultAsNumber2 = false;
        } else {
            divideString(s);
        }
    }

    /**
     * This method are managed all program logic (mostly).
     */
    public void menu() { //упростил меню как мог)
        String s;
        print(menuList);
        while (!"exit".equals(s = consoleReader())) {
            if ("1".equals(s)) {
                selectParameters();
                if (reselect) { //приходится 2 раза его использовать (reselect)
                    reselect = false;
                    break;
                }
                super.add(number1, number2);
                print(getResult()); //после каждого математического действия печатаем, чтобы результат не печатался, когда мы выбираем пункт 5
            } else if ("2".equals(s)) {
                selectParameters();
                if (reselect) { //приходится 2 раза его использовать (reselect)
                    reselect = false;
                    break;
                }
                super.substruct(number1, number2);
                print(getResult());
            } else if ("3".equals(s)) {
                selectParameters();
                if (reselect) { //приходится 2 раза его использовать (reselect)
                    reselect = false;
                    break;
                }
                super.div(number1, number2);
                print(getResult());
            } else if ("4".equals(s)) {
                selectParameters();
                if (reselect) { //приходится 2 раза его использовать (reselect)
                    reselect = false;
                    break;
                }
                super.multiple(number1, number2);
                print(getResult());
            } else if ("5".equals(s)) {
                print("you want use like <number1> or <number2> (write just 1 or 2)");
                s = consoleReader();
                if ("1".equals(s)) {
                    resultAsNumber1 = true;
                } else {
                    resultAsNumber2 = true;
                }
            }
            print(menuList);
        }
    }
}
