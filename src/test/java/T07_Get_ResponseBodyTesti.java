import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T07_Get_ResponseBodyTesti {


    @Test
    public  void  test01(){

        /*
        https://jsonplaceholder.typicode.com/posts/44 urlne bir GET request
        yolla donen
        Responsenin
        status code nun 200
        conten type nın Application.JSON,
        response bodysinde olan userIdnin 5,
        response bodysinde olan titlenin "optio dolar molestions sit"
        oldugunu test edin

         */


     // 1 endpointe request body hazırla

        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2 expected data varsa yarat

        //3 request gönder dönen responsu yadda saxla

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body( "title",Matchers.equalTo("optio dolor molestias sit"));



    }
}
