import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class T15_Get_SoftAssertleExpectedDataTest {

    @Test
    public  void test01(){

        // HArd Assert Junıtden oyrendık
        // Assert.assertEquals();
        // Assert.assertTrue();
        // Assert.assertFalse();

        //  Soft Assert ıse (verification)
        //eyer softAssert başarısız olursa test methodunu  gerı qalanın dayandırmaz davam eder. if else statmentda oldugu kimi


/*
http://dummy.restapiexample.com/api/v1/employee/3 urline
bir GET Request sorgu gondererken
qayıdan Responsun asagıdaki kimi oldugun test edin


Response Body

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


 */


// 1 endpoint ve request body yarad

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

// 2 expected data yarad


        JSONObject expectedData = new JSONObject();
        JSONObject dataInfoJson= new JSONObject();


        dataInfoJson.put("id", 3);
        dataInfoJson.put("employee_name", "Anar Abbas");
        dataInfoJson.put("employee_salary", 86000);
        dataInfoJson.put("employee_age", 66);
        dataInfoJson.put("profile_image", "");

        expectedData.put("status","success");
        expectedData.put("data",dataInfoJson);
        expectedData.put("message", "Successfully! Record has been fetched.");

        //3 request gönder dönen responsu yadda saxla

        Response response = given().when().get(url);

        JsonPath responsJsonPath = response.jsonPath();

        // 4 Assertion soft Assert ile edirik

        // Birinci SoftAssert objecti yaradılmaldır:   SoftAssert softAssert = new SoftAssert();

        //İkinci addım İstediyimiz verificationları yazırıq: softAssert.assertTrue();

        // Üçüncü addım ise SoftAssertion bütün raporları isteyirikse:  softAssert.assertAll();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responsJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responsJsonPath.get("message"),expectedData.get("message"));


        softAssert.assertEquals(responsJsonPath.get("data.id"),
                expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responsJsonPath.get("data.employee_name"),
                expectedData.getJSONObject("data").get("employee_name"));

        softAssert.assertEquals(responsJsonPath.get("data.employee_salary"),
        expectedData.getJSONObject("data").get("employee_salary"));

        softAssert.assertEquals(responsJsonPath.get("data.employee_age"),
                expectedData.getJSONObject("data").get("employee_age"));

        softAssert.assertEquals(responsJsonPath.get("data.profile_image"),
                expectedData.getJSONObject("data").get("profile_image"));



        softAssert.assertAll();
    }
}
