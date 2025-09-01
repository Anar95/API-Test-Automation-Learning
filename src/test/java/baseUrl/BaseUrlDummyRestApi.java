package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlDummyRestApi {

    protected RequestSpecification specDummyApi;

    @Before

    public  void setUp(){

        specDummyApi = new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com")
                .build();

    }
}
