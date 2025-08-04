import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T01_GetRequest_ResponsBodyYazdırmaq {


    @Test
    public  void  get01(){

        // https://restful-booker.herokuapp.com/booking/10 urline
        //bir GET request gönderin.Dönen respopnsu yazdırın

        //1 Step Request Body ve endpoint hazırlama

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 Expected data hazırla

        // 3 Request gönderin dönen responsu saxla

        Response response = given().when().get(url);

        response.prettyPrint();

    }





}
