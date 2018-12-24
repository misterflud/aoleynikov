import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by AOleynikov on 16.12.2018.
 */
public class Map1077 {
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

        double result = stream.reduce(1.0, (a, b) -> a * b);
        System.out.println(result);
    }

}
