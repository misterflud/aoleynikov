package ru.job4j;

/**
 * Created by Anton on 12.04.2017.
 * Часть 1.

 Создать класс Food сполями. Name, expaireDate, createDate, price, disscount. На основе класса Food создать другие продукты.

 Создать классы хранилище продуктов Warehouse, Shop, Trash.

 Создать класс обработчик перераспределения продуктов в место использования. ControllQuality. Класс должен перераспределять еду по хранилищам в зависимости от условиый.

 3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.

 3.2 Если срок годности от 25% до 75% направить в Shop

 3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop

 3.4. Если срок годности вышел. Отправить продукт в мусорку.

 В данной задаче надо использовать шаблон проектирование - https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm

 Нельзя использовать instanceOf или if ("Shop".equals(storage.getName())
 */
public class Start {
    /**
     * Start program.
     * @param args args
     */
    public static void main(String[] args) {
        GenerateFood generateFood = new GenerateFood();
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.setFoods(generateFood.generateFood());
        controlQuality.control();
        controlQuality.printWhatWeHave();
    }
}
