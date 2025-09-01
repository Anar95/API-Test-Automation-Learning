import baseUrl.BaseUrlDummyRestApi;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;

public class T18_Get_TestDataClassİsledilmesi extends BaseUrlDummyRestApi {





        /*
Ssenari 1 Kompleks JSON – GET request testi
Endpoint: https://dummy.restapiexample.com/api/v1/employee/3

Expected Data:

{
  "status": "success",
  "data": {
    "id": 3,
    "employee_name": "Ashton Cox",
    "employee_salary": 86000,
    "employee_age": 66,
    "profile_image": ""
  },
  "message": "Successfully! Record has been fetched."
}



Ssenari 2: JSONArray olan JSON – GET request testi ılk ıkı ıstıfadecını qarsılasdır

Endpoint: https://dummy.restapiexample.com/api/v1/employees

Expected Data:

json
Kopyala
Düzenle
{
  "data": [
    {
      "id": 1,
      "employee_name": "Tiger Nixon"
    },
    {
      "id": 2,
      "employee_name": "Garrett Winters"
    }
  ]
}

         */


    @Test
    public  void testKompleksJson(){
        //1 url ve request body yarad
        ///api/v1/employee/3
        specDummyApi.pathParams("pp1","api","pp2","v1","pp3","employee","pp4","3");

        //2 ExpectedData yaradırıq

        JSONObject expectedData = TestDataDummy.dynemicJsonYarad(
                "succes",
                3,
                "Anar Abbas",
                5500,
                66,
                "Successfully! Record has been fetched.");


        // 3 request gpnder responsu yadda saxla

        Response response = given()
                .spec(specDummyApi)
                .when()
                .get("{pp1}/{pp2}/{pp3}/{pp4}");


        JSONObject actualData = new JSONObject(response.asString());

        // 4 Assertion


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(),TestDataDummy.ugurluSorguStatusKodu,"Status code ferqlidir");

        softAssert.assertEquals(actualData.getString("status"),expectedData.getString("status"), "Status gözlenilenden ferqlidir");
        softAssert.assertEquals(actualData.getString("message"),expectedData.getString("message"), "Message gözlenilenden ferqlidir");

        JSONObject expectedInner = expectedData.getJSONObject("data");
        JSONObject actualInner = actualData.getJSONObject("data");

        softAssert.assertEquals(actualInner.getInt("id"),expectedInner.getInt("id"), "ID ferqlidir");
        softAssert.assertEquals(actualInner.getString("employee_name"),expectedInner.getString("employee_name"), "Name gözlenilenden ferqlidir");
        softAssert.assertEquals(actualInner.getInt("employee_salary"),expectedInner.getInt("employee_salary"), "Salary gözlenilenden ferqlidir");
        softAssert.assertEquals(actualInner.getInt("employee_age"),expectedInner.getInt("employee_age"), "Age gözlenilenden ferqlidir");


         softAssert.assertAll(); // Butun assertleri yoxlayır ve sehvleri gösterir
    }


}
