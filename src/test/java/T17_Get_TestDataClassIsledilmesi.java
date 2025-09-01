import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPLaceHolder;

import static io.restassured.RestAssured.given;

public class T17_Get_TestDataClassIsledilmesi extends BaseUrlJsonPlaceHolder {

      /*

  https://jsonplaceholder.typicode.com/posts/44 bir Get sorgusu gonder
  asagdakı bodyle eynı oldugun test ed

  Expected data

  {
  "userId": 5,
  "id": 44,
  "title": "optio dolor molestias sit",
  "body": "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
}
   */



    @Test
    public  void  test01(){

        //1 request body yarad url hazırla

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","44");

        //2 Expected data hazırla

        JSONObject expectData = TestDataJsonPLaceHolder.responseBodyYaradır44();

        //3 request gonder responsu yadda saxla

        Response response = given()
                .spec(specJsonPlaceHolder)
                .when()
                .get("{pp1}/{pp2}");

        // 4 Assertion

        Assert.assertEquals(TestDataJsonPLaceHolder.ugurluSorguStatusKodu,response.statusCode());

        Assert.assertEquals(expectData.get("userId"),response.jsonPath().getInt("userId"));
        Assert.assertEquals(expectData.get("id"),response.jsonPath().getInt("id"));
        Assert.assertEquals(expectData.get("title"),response.jsonPath().getString("title"));
        Assert.assertEquals(expectData.get("body"),response.jsonPath().getString("body"));


    }
}
