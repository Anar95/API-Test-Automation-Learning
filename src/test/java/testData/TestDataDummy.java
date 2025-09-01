package testData;

import org.json.JSONObject;

public class TestDataDummy {
    /*

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


     */

    public static int ugurluSorguStatusKodu= 200;

    public static JSONObject dynemicJsonYarad (String status,int id,String name, int salary,int age, String message){

        JSONObject data = new JSONObject();
        data.put("id", id);
        data.put("employee_name", name);
        data.put("employee_salary", salary);
        data.put("employee_age", age);
        data.put("profile_image", "");

        JSONObject anaJson = new JSONObject();
        anaJson.put("status", status);
        anaJson.put("data",data);
        anaJson.put("message", message);

        return  anaJson;
    }



}
