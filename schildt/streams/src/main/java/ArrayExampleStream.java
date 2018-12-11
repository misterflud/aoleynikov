import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by AOleynikov on 10.12.2018.
 */
public class ArrayExampleStream {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("Изначальный список");
        list.forEach(x -> System.out.print(x + " "));
        Stream<Integer> myStream = list.stream();

        System.out.println();

        Optional<Integer> minVal = myStream.min(Integer::compare);
        if(minVal.isPresent()) {
            System.out.println(String.format("Min value is %s", minVal.get()));
        }
        //так как min() -- оконечная операция, необходимо получить новый поток
        myStream = list.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);

        if(maxVal.isPresent()) {
            System.out.println(String.format("Max value is %s", maxVal.get()));
        }

        Stream<Integer> sortedStream = list.stream().sorted();
        System.out.println("Отсортированный список");
        sortedStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        //Вывести только числа больше 51
        Stream<Integer> oddVals = list.stream().filter(n ->
        n > 51);
        System.out.println("Числа больше 51");
        oddVals.forEach(x -> System.out.print(x + " "));


        System.out.println();


        //вывести только те числа которые четные и больше 51
        //операции будем проводить в конвеере

        oddVals = list.stream().filter(n -> (n % 2) == 1)
                .filter(n -> n > 51);
        System.out.println("Нечетные числа больше 51");
        oddVals.forEach(x -> System.out.print(x + " "));

    }

}
