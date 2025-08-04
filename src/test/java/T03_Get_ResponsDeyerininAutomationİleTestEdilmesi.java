import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class T03_Get_ResponsDeyerininAutomationİleTestEdilmesi {

    @Test
    public  void  test02(){

          /* https://restful-booker.herokuapp.com/booking/10 urline
       bir GET request gönderin.Dönen respopnsun status codunu 200,
       ve content type nın application/json;
       charset=utf-8;
       ve server isimli Headerin deyerinin Cowboy ve status line HTTP/1.1 200 ok
       ve respons vaxdının 1 sn den az oldugunu manual olaraq test edin

        */


        // 1 endpoin ve request body yarat

        String url = "https://restful-booker.herokuapp.com/booking/10";

       // 2 expected data yarad

        //3 Request gönder dönen responsu yadda saxla

        Response response = given().when().get(url);

        // 4 Assertion

        response
                .then() // responsu alır
                .assertThat() //assertThat ile bunu assert et
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Heroku")
                .statusLine("HTTP/1.3 200 OK")
                .time(lessThan(2000L));//cavab 1000 milli saniyeden az olmalıdır

    }
}
