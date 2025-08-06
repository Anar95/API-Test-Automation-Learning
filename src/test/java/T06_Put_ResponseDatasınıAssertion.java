import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T06_Put_ResponseDatasınıAssertion {

    @Test
    public void test01(){


        /*
https://jsonplaceholder.typicode.com/posts/70 urlne
asagıdakı Json fortmatındakı body ile bir PUT request gonderdigimizde

{

"title": "Anar",
"body": "Salamlar",
"userId": 10,
"id":70
}

donen Responsenun,
status codunun 200,
content type: application/json; charset=utf-8,
ve Server isimli Headerin deyerinin cloudflare,
ve status Linenin  HTTP/1.1 200 OK
 */


        // 1 Urli ve request body hazırla

        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Anar");
        requestBody.put("body", "Salamlar");
        requestBody.put("userId", 10);
        requestBody.put("id",70);

        //2 expected body yarad

        // 3 request gönder ve dönen responsu yadda saxla

        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .put(url);

        response.prettyPrint();

     //4 Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");




    }

}
