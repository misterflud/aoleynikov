package ru.job4j.start;

/**StartUI -- It is for manage the program.
 *Example '<Milk> + <12>', it's mean that you should write: Milk 12
 *@author Anton Oleynikov
 *@version 1
 */
public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }
    /**
     *@param args from console
     *@exception Exception
     */
    public static void main(String[] args) throws Exception {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
    /**
     *@exception Exception
     */
    public void init() throws Exception {
        Tracker tracker = new Tracker();
        String in;
        boolean exit = true;
        while (exit) {
            in = input.ask("..................Menu.................." + "\r\n" + "1 - add new Item;"  + "\r\n" + "2 - delete Item;"  + "\r\n" + "3 - change Item;"  + "\r\n" + "4 - Print all;"  + "\r\n" + "5 - Filter;"  + "\r\n" + "6 - add commit;"  + "\r\n" + "7 - END;"  + "\r\n");
            switch (in) {
                case "1" :
                    tracker.add(input.ask("Write <Product's type(Milk or Bread)> + <Numbers>"));
                    break;
                case "2" :
                    tracker.del(Integer.parseInt(input.ask("Write item's number and it will be deleted")));
                    break;
                case "3" :
                    tracker.change(input.ask("Write <item's number(Count)> + <new Name of type product's> + <new number (How mush you are going to buy)> and it will be changed"));
                    break;
                case "4" :
                    System.out.print("Print all items, loaded");
                    Thread.sleep(1000);
                    System.out.print("..");
                    Thread.sleep(1000);
                    System.out.print("...");
                    Thread.sleep(1000);
                    System.out.println("..");
                    tracker.printAll();
                    break;
                case "5" :
                    tracker.filter(input.ask("Print Bread's item or Milk's item, what you wish" + "\r\n" + "Write <Item(Milk or Bread)>"));
                    break;
                case "6" :
                    tracker.addComment(input.ask("You can write comments" + "\r\n" + "Write <item's number(Count)> + <comment>"));
                    break;
                case "7" :
                    System.out.println("................THE END.................");
                    Thread.sleep(2000);
                    exit = false;
                    break;
            }
        }
    }
}
