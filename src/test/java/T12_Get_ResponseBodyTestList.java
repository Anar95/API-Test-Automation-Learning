import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T12_Get_ResponseBodyTestList {


    @Test
    public  void  test01(){

          /*
        http://dummy.restapiexample.com/api/v1/employees rul ine
        bir GET request gönderdikde
         dönen Respnonse"in
         status code un 200,
         ve content type nın applıcatıon/json
         ve response body"sindeki
       employees sayının, 24,
         ve  employees lerden birinin , "Tiger Nixon",
         ve  girilen yaşhlar içinde (employee_age) 61, 21 ve 35 deyerinde
        olduğunu test edin
         */


        // 1 endpoint ve request body yarad

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2 expected data yarad

        // 3 Request gönder gelen responsu yadda saxla

        Response response = given().when().get(url);

     // response.prettyPrint();


        // 4 Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                  "data.employee_name", hasItem("Tiger Nixon"),
                     "data.employee_age", hasItems(61,90,35));


    }
}
