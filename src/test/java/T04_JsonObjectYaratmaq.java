import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;



public class T04_JsonObjectYaratmaq {


    @Test
            public void test01(){

    /*
          {
            "title": "Anar",
            "body": "Salamlar",
            "userId": 1,"
          }
*/

    JSONObject obj1 = new JSONObject(); // {}
    obj1.put("title", "Anar");
    obj1.put("body", "Salamlar");
    obj1.put("userId", 1);

        System.out.println(obj1);





    }

}
