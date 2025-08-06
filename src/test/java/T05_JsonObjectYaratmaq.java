import org.json.JSONObject;
import org.junit.Test;

public class T05_JsonObjectYaratmaq {

    @Test
    public void test01(){

               /*
        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",

        "bookingdates": {
             "checkin": "2018-01-01"
              "checkout": "2019-01-01"
              },

        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown"
        }

         */


        //Once inner object yaradılır

        JSONObject datasJsonObject = new JSONObject();
        datasJsonObject.put("checkin", "2018-01-01");
        datasJsonObject.put("checkout", "2019-01-01");


        // Sonra outer json object yaradılır. Lazımı yere inneri qoyuruq

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname","Jim");
        requestBody.put("additionalneeds","Breakfast");
        requestBody.put("bookingdates",datasJsonObject);
        requestBody.put("totalprice", 111);
        requestBody.put( "depositpaid",true);
        requestBody.put("lastname","Brown");

        System.out.println(requestBody);

    }
}
