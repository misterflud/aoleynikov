import java.util.Base64;

/**
 * Created by AOleynikov on 02.10.2018.
 */
public class java8StandartCoder {
    public static void main(String[] args) {
        String before = "{\"3DS\":{\"data\":\"eyJhbGciOiJSU0ExXzUiLCJraWQiOiIrVTVsM2pMNm5zLzRjcFBmdklXZk5Pbk83clBUeVNnUlZHeTRkdjF5V2dBPSIsInR5cCI6IkpPU0UiLCJjaGFubmVsU2VjdXJpdHlDb250ZXh0IjoiUlNBX1BLSSIsImVuYyI6IkExMjhHQ00ifQ.jlzfMdfWCE8k4r3yRVBURNqYSqgriVLkUQtvnzd8jP1uy_DCGu-h0HBPp_a4MxGrYsRB8W_QarGVYIErVq9NaZwMlhib5cJNV5lNG3-y0oPkc7YFR46kDfVnehIwz38gZxf8KTe5DIrOVNnyYFD0Yr46LVZ7Gxh-H_d2kp-DdBQlSf_t3wdYe1Oli6DihUFGSR0w-sU-VwRg8odq_gdXoTO0PcRTg79Gp7eoWLT7d8CwyGmdaMDUTugtwUcTUlYWcjt3M7eKWfnRW5ozXtCXdjsp2bY6cOEPFAKqZtU6H7nyaalPs9Az29l8PGlIy6THuvxj9vb61QDvRpAGVohf_Q.smSAe0shdweQ_Mc_.yQOsQHj-2P89uyidLbCH-fyx9YQg94Oxi-Q43MJHH5ApVyha_etUs_dQOR0Fprm1OZ2fdc32C-IkniQJ3RfIbyKTQTWhdESKXLgjfk0UMUizTCHIgRT--PKmD70OJ-EYbqNdbYlwjCEs0VRHIFlKI9gnZZbkBQj4CRJtu9rjnb62RaFUSdh-YfJuI4yab_j2ZIjS4nNHPV3Fsvqh8mfO7pw6VvDCDZlN1AaTkoffCY5v2T_NkA-Vwyo.ApDWFoqk7zxwAZM4HtOj2A\",\"type\":\"S\",\"version\":\"100\"},\"payment_card_brand\":\"MC\",\"payment_currency_type\":\"RUB\",\"payment_last4_dpan\":\"6154\",\"payment_last4_fpan\":\"2653\",\"method\":\"3DS\",\"recurring_payment\":false,\"payment_shipping_address\":{\"shipping\":{},\"email\":\"\"},\"payment_shipping_method\":\"\"}";
        String after = codingBase64(before);
        check(before, after);
    }

    private static String codingBase64(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    private static String decode(String s) {
        String result;
        result = new String(Base64.getDecoder().decode(s));
        return result;
    }

    private static void check(String before, String after) {
        System.out.println(before);
        System.out.println(after);
        System.out.println(decode(after));
        System.out.println(before.equals(decode(after)));
    }
}
