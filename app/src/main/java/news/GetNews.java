package news;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetNews {
    public static void main(String args[]) throws JSONException {
        JSONObject jo=new JSONObject();
        jo.put("name","Suraj");
        jo.put("age",23);
        jo.put("city","Bhopal");

        JSONObject jo1=new JSONObject();
        jo1.put("name","Suraj");
        jo1.put("age",23);
        jo1.put("city","Bhopal");

        JSONObject jo2=new JSONObject();
        jo2.put("name","Suraj");
        jo2.put("age",23);
        jo2.put("city","Bhopal");

        JSONObject jo3=new JSONObject();
        jo3.put("name","Suraj");
        jo3.put("age",23);
        jo3.put("city","Bhopal");

        JSONObject object=new JSONObject();
        jo1.put("detail",jo2);
        jo.put("Detail",jo1);
        object.put("Detail",jo);

        
        System.out.println(object);
    }
}
