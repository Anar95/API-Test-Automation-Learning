package testData;

import org.json.JSONObject;

public class TestDataJsonPLaceHolder {
/*
    {
        "userId": 5,
            "id": 44,
            "title": "optio dolor molestias sit",
            "body": "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
    }
    */

    public static int ugurluSorguStatusKodu= 200;

    public  static  JSONObject responseBodyYaradır44(){

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 5);
        expectedData.put( "id", 44);
        expectedData.put("title", "optio dolor molestias sit");
        expectedData.put("body", "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae");

        return expectedData;

    }

}
