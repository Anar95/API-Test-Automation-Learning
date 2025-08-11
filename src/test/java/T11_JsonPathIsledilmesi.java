import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class T11_JsonPathIsledilmesi {

    @Test

    public  void  test01(){

        JSONObject  personalInfoJsonObj = new JSONObject();

        JSONObject adressJsonObject = new JSONObject();

        JSONArray telephoneNumber = new JSONArray();
        JSONObject cibTelefonu = new JSONObject();
        JSONObject evTelefonu = new JSONObject();


        adressJsonObject.put("streetAddress", "naist street");
        adressJsonObject.put("city" ,"Nara");
        adressJsonObject.put("postalCode","630-0192");

        cibTelefonu.put("type","iPhone");
        cibTelefonu.put("number","0123-4567-8888");

        evTelefonu.put("type","home");
        evTelefonu.put( "number","0123-4567-8910");

        telephoneNumber.put(cibTelefonu);
        telephoneNumber.put(evTelefonu);


        personalInfoJsonObj.put( "firstName", "John");
        personalInfoJsonObj.put(  "lastName" , "doe");
        personalInfoJsonObj.put( "age", 26);
        personalInfoJsonObj.put( "address", adressJsonObject);
        personalInfoJsonObj.put(  "phoneNumbers", telephoneNumber);


        System.out.printf(String.valueOf(personalInfoJsonObj));


        System.out.println("firstName: " + personalInfoJsonObj.get("firstName"));

        System.out.println("Küçe adı: " + personalInfoJsonObj.getJSONObject("address").get("streetAddress"));

        System.out.println("cib telefon nömresi: " +personalInfoJsonObj.getJSONArray("phoneNumbers")
                .getJSONObject(0).get("number"));




    }

}
