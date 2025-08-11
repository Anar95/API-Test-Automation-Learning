import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;


import static org.hamcrest.Matchers.*; // ulduz qoyuruq hamısını qebul edir

import static io.restassured.RestAssured.given;

public class T09_Get_BodyTekrarlarından_Qurtulmaq {

    @Test

    public  void test01(){


     /*
         https://restful-booker.herokuapp.com/booking/10 urlne
         bır GET request gonderdıgımızde donen Rsponse un
          status codunun 200,
         ve content type nın applıcatıon/json
        ve response bodysındekı
        "firstaname"in, "Mary",
         ve  "lastname"in, "Brown",
         ve  "totalprice"in, 1000 den kiçik olduğunu,
         ve  "depositepaid"in, true,
         ve  "additionalneeds"in, boş buraxılmadığını,
        olduğunu test edin

         */

        //1 endpoint ve request body hazırla

        String url = " https://restful-booker.herokuapp.com/booking/10";

        // 2 expected data hazırla

        //3 request gönder gelen respponsu yadda saxla

        Response response = given().when().get(url);

        // 4 Assertion
         response.prettyPrint();
/*
 response
         .then()
         .assertThat()
         .statusCode(200)
         .contentType(ContentType.JSON)
         .body("firstname", Matchers.equalTo("Mary"))
         .body("lastname", Matchers.equalTo("Brown"))
         .body("totalprice", Matchers.lessThan(1000))
         .body("depositpaid", Matchers.notNullValue());
 */


        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Mark"),
                        "lastname", equalTo("Jackson"),
                        "totalprice",lessThan(1000),
                        "depositpaid", notNullValue());








    }
}
