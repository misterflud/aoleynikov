import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by AOleynikov on 10.12.2018.
 */
public class ParallelStream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            list.add(new Integer(random.nextInt(10) + 1));
        }
        list.forEach(a -> System.out.print(a + " "));
        System.out.println();

//        Optional<Integer> products = list.parallelStream().reduce((a, b) -> a * b);
//        System.out.println(products.get());

        double sqrtResult = list.parallelStream().reduce(1.0 ,(a, b) -> a * Math.sqrt(b),
                (a, b) -> a * b);
        System.out.println(sqrtResult);

        double sqrtResult2 = list.parallelStream().reduce(1, (a, b) -> a * new Integer( (int) (Math.sqrt(b))));
        System.out.println(sqrtResult2);

    }
    public static void a(List<Number> d) {

    }
}
