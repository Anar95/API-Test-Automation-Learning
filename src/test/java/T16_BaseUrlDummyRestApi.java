import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T16_BaseUrlDummyRestApi extends BaseUrlJsonPlaceHolder {


    //Class içinde 2 Test metodu yaradıb ve asagıdakı testlerı edin
    //1- https://jsonplaceholder.typicode.com/posts endpointine GET
    // request gonderin donen responsu status kodun 200 oldugunu ve 100 data oldugun test edin
    //2- https://jsonplaceholder.typicode.com/posts/44 endpointine GET
    //request gonderin donen responsu status kodun 200 oldugunu
    //ve "title" deyerinin "optio dolor molestias sit" oldugun test edın,


    @Test
    public  void testStatusCodeAndSize(){

        //1 endpoint yarad ve request body yarad

        specJsonPlaceHolder.pathParam("pp1","posts");

        //2 expected data yarad

        //3 request gonder gelen cavabı yadda saxla

        Response response = given()
                .when().spec(specJsonPlaceHolder).get("/{pp1}");


        //4 Assert

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));
    }

    @Test
    public  void  testStatusCodeAndTitle(){
        //2- https://jsonplaceholder.typicode.com/posts/44 endpointine GET
        //request gonderin donen responsu status kodun 200 oldugunu
        //ve "title" deyerinin "optio dolor molestias sit" oldugun test edın,

        //1 endpoint ve body

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);

        //2 expected data(yoxdur)

        //3 request gonder donen responsu yadda saxla

        Response response = given()
                .when().spec(specJsonPlaceHolder).get("/{pp1}/{pp2}");

        // 4 Assert test

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }


}
