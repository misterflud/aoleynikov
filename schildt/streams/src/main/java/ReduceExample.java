import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

/**
 * Created by AOleynikov on 10.12.2018.
 */
public class ReduceExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            list.add(new Integer(random.nextInt(10) + 1));
        }


        list.forEach(a -> System.out.print(a + " "));
        System.out.println();
        //Два способа получения результата перемножения целочисленных
        // элементов списка с помощью reduce()
        Optional<Integer> productObj = list.stream().reduce((a, b) -> a * b);
        System.out.println(String.format("Произведение в виде объекта типа Optional: %s", productObj.get()));
        //
        int result = list.stream().reduce(8, (a, b) -> a * b);
        System.out.println(String.format("Произведение в виде значения int: %s", result ));
    }
}
