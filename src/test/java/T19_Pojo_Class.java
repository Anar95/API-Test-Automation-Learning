import baseUrl.BaseUrlDummyRestApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.EmployeeResponse;
import static org.testng.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class T19_Pojo_Class extends BaseUrlDummyRestApi {

    // Pojo nedir?

    // POJO= Plain Old Java Object
    // Api testde gelen Json cavabı Json objecte ceviri
    //(de-serialzation) ve ya Java Objectini Jsona çevirmek (serialization)

    // ustunlukleri
    //1 Kod oxunaqlı ve maintainble olur
    //2 Json ile iş daha rahatdır
    //3 Nested Json u rahat idare edirsen

    @Test

    public void  testGetEmployeePojo(){

         //  String url = "https://dummy.restapiexample.com/api/v1/employee/3";
        // get sorgusu gonderık


        specDummyApi.pathParams("pp1","api","pp2","v1","pp3","employee","pp4","3");

        Response response = given()
                .spec(specDummyApi)
                .when()
                .get("{pp1}/{pp2}/{pp3}/{pp4}");

        System.out.println("Json Response: " + response.asString());


        EmployeeResponse employeeResponse = response.as(EmployeeResponse.class);

          assertEquals(response.statusCode(),200);
          assertEquals(employeeResponse.getStatus(),"success");
          assertEquals(employeeResponse.getMessage(),"Successfully! Record has been fetched.");

          assertEquals(employeeResponse.getData().getId(),3);
          assertEquals(employeeResponse.getData().getEmployee_name(),"Anar Abbas");
          assertEquals(employeeResponse.getData().getEmployee_salary(),8600);
          assertEquals(employeeResponse.getData().getEmployee_age(),66);
          assertEquals(employeeResponse.getData().getProfile_image(),"");
    }


}
