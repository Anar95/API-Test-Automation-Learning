import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T14_Post_Expected_Data_ve_JsonPathleAssertion {


    @Test

    public  void test01(){


/*

https://restful-booker.herokuapp.com/booking urline asagıdaki body"ye sahib bir POST
request gonderdikde donen response"un id xaric asagıdakı kimi olduugnu test edin

Request body
{
    "firstname": "Anar",
    "lastname": "Abbas",
    "totalprice": 626,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2025-03-16",
        "checkout": "2025-03-20"
    }
    "additionalneeds": "Breakfast"
}


Response body
{
  "bookingid": 24,
  "booking": {
    "firstname": "Anar",
    "lastname": "Abbas",
    "totalprice": 626,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2025-03-16",
        "checkout": "2025-03-20"
    },
    "additionalneeds": "Breakfast"
  }

}
 */


        // 1 endpoint ve request body yarad

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject resTarixiJson = new JSONObject();

        resTarixiJson.put("checkin","2025-03-16");
        resTarixiJson.put("checkout","2025-03-20");

        requestBody.put("firstname","İlkin");
        requestBody.put("lastname", "Abbas");
        requestBody.put( "totalprice", 626);
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", resTarixiJson);
        requestBody.put( "additionalneeds", "Breakfast");

        // 2 expected data yarad

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid", 24);
        expectedData.put("booking",requestBody);

        System.out.println(expectedData.toString());


     // 3 request gönder dönen responsu yadda saxla

        Response response = given()
                .contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        // Assertion

        JsonPath responsJsonPath = response.jsonPath();

      //ilk yazılan====> yaratdığımız jsonObjectden gelir JsonObject=expectedData

        // Ikıncı gelen ise actual ===> response = responsJsonPath


        Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                responsJsonPath.get("booking.firstname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                responsJsonPath.get("booking.lastname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                responsJsonPath.get("booking.totalprice"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                responsJsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                responsJsonPath.get("booking.additionalneeds"));



        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responsJsonPath.get("booking.bookingdates.checkin"));

        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responsJsonPath.get("booking.bookingdates.checkout"));

    }


}
