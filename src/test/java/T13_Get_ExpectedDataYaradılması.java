import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T13_Get_ExpectedDataYaradılması {


    @Test

    public  void  test01(){

            /*
     https://jsonplaceholder.typicode.com/posts/22 urlne bir Get request yolladıgımızda
     dönen response bodysinin asagıda verilen ile eyni oldugunu
     test edin

     Response body:
 {
  "userId": 3,
  "id": 22,
  "title": "dolor sint quo a velit explicabo quia nam",
  "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */




        //1 Endpoint ve request body yarad

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2 expected data yarad

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put( "body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3 request gönder dönen resposnu yadda saxla

        Response response= given().when().get(url);

     /*  response
                .then()
                .assertThat()
                .body("userId", equalTo(3),
                        "id", equalTo(22),
                        "title",equalTo("dolor sint quo a velit explicabo quia nam") );
        */

        // 4 Assertion
        JsonPath responseJsonPath = response.jsonPath();



        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));


    }
}
