import java.util.Optional;

/**
 * Created by AOleynikov on 01.12.2018.
 */
public class OptionalExample {
     public static void main (String[] args) {
         Optional<String> noVal = Optional.empty();

         Optional<String> hasVal = Optional.of("ABCDEFG");

         if (noVal.isPresent()) {
             System.out.println("Не подлежит выводу");
         } else {
             System.out.println("Object of noVal doesn't have value");
         }
         if (hasVal.isPresent()) {
             System.out.println(String.format("Object hasVal has line %s", hasVal.get()));
             String defStr = noVal.orElse(("Default line"));
             System.out.println(defStr);
         }
     }
}
