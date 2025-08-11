import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T08_Post_ResponsBodyTest {

    @Test

    public  void  test01(){

        /*

https://jsonplaceholder.typicode.com/posts urlne

asagdakı body ile bir POST request gonderdiğimizde

{
"title: "API,
"body": "API ogrenmek ne gözeldir",
"userID": 10,
}

donen responsenın
status codunun 201
content tyoe nin application/json
Respons Bodysindeki "title" nin "API" oldugunu
"userID" degerının 100 den kıcık oldugunu
"body" nin "API" kelimesi ıcınde kecdıyını test edin

        */

      // 1 endpoint ve request body hazırla

      String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "API");
        requestBody.put("body", "API ogrenmek ne gözeldir");
        requestBody.put("userID", 10);

        //2 expected data hazırla

        // 3 request gönder responsu yadda saxla

        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        response.prettyPrint();


        // 4 Assertion

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId", Matchers.lessThan(100))
                .body("body", Matchers.containsString("API"));



    }
}

