import com.google.gson.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by AOleynikov on 24.10.2018.
 */
public class Parser {
    private static String url = "https://uat.av.ru/rest/v1/az/products/?currentPage=4&pageSize=120&query=:acbestseller:category:Navision:assortmentTypes:INTERNET:categoryPath:/Navision/00002000";



    public static void main(String[] args) {
        Parser parser = new Parser();
        String jsonString = parser.sendRequest(url, HttpMethod.GET);
        List<String> listOfCodeOfProducts = parser.parsing(jsonString);
        System.out.println(listOfCodeOfProducts.size());
        String urlToCart = parser.createUrlForAddingToCart(listOfCodeOfProducts);

        System.out.println(urlToCart);

    }

    private String sendRequest(String url, HttpMethod httpMethod) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(null, null);
        ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class);
        return response.getBody();
    }

    private List<String> parsing(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonString).getAsJsonObject();
        List<String> listOfCodeOfProducts = new ArrayList<>();
        Iterator<JsonElement> iterator = jsonObject.getAsJsonArray("products").iterator();
        while (iterator.hasNext()) {
            listOfCodeOfProducts.add(iterator.next().getAsJsonObject().get("code").getAsString());
        }
        //jsonObject.getAsJsonArray("products").get(0).getAsJsonObject().get("code").getAsInt()
        return listOfCodeOfProducts;
    }

    private String createUrlForAddingToCart(List<String> listOfCodeOfProducts) {
        String urlRequest = "http://uat.av.ru:9001/rest/v1/az/cart?device=mobileapp&recalculate=true&lastChangeTime=01_12_2016_22_16&device_id=ddjjkkccn323413naaam3212322b&products";
        String resultUrl;
        String products = "";
        Gson gson = new Gson();
        for (String iter : listOfCodeOfProducts) {
            ProductPojo productPojo = new ProductPojo();
            productPojo.setCode(iter);
            productPojo.setQuantity(1);
            if (products.equals("")) {
                products = gson.toJson(productPojo);
            } else {
                products = String.format("%s,%s" , products, gson.toJson(productPojo));
            }

        }
        resultUrl = String.format("%s=[%s]", urlRequest, products);
        return resultUrl;
    }

}
