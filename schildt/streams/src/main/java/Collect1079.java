import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by AOleynikov on 16.12.2018.
 */
public class Collect1079 {

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            list.add(new Double(random.nextInt(10) + 1));
        }
        list.forEach(a -> System.out.print(a + " "));
        System.out.println();
        //отобразить квадратные корни элементов на новый поток данных:

        Stream<Double> stream = list.stream().map((x) -> Math.sqrt(x));

        ArrayList<Double> result = stream.collect(
                () -> new ArrayList<>(),
                (listd, element) -> listd.add(element),
                (aList, bList) -> aList.addAll(bList));

        result.forEach(a -> System.out.print(a + " "));
        System.out.println();
    }
}
