import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T02_GetRequest_ResponsDatanınManualTestEdilmesi {

    @Test
    public void test01(){
        /* https://restful-booker.herokuapp.com/booking/10 urline
       bir GET request gönderin.Dönen respopnsun status codunu 200,
       ve content type nın application/json;
       charset=utf-8;
       ve server isimli Headerin deyerinin Cowboy ve status line HTTP/1.1 200 ok
       ve respons vaxdının 5 sn den az oldugunu manual olaraq test edin

        */

        // 1 body ve end poin hazırla

        String url ="https://restful-booker.herokuapp.com/booking/10";

        // 2 expected data body yarat

        // 3 request gönder qayıdan responsu yadda saxla

        Response response = given().when().get(url);

        System.out.println("Status code: " + response.getStatusCode()+
                "\nContent type: " + response.contentType()+
                "\nServer Header deyeri: " + response.getHeader("Server")+
                "\nStatus Line: " + response.getStatusLine() +
                "\nRespons Müddeti: " + response.getTime());

    }
}
