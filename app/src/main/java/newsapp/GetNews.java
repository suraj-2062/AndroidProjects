package newsapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class GetNews {
    ArrayList<GetData> list=new ArrayList<>();
    Context context;
    public ArrayList<GetData> getList() throws Exception {
        String string=getUrl();
        String response=getResponse(string);

        JSONObject jsonObject=new JSONObject(response);
        JSONObject data=jsonObject.getJSONObject("data");
        JSONArray array=data.getJSONArray("news_list");

        for(int i=0;i<array.length();i++){
            JSONObject jsonObject1=array.getJSONObject(i);
            JSONObject jsonObject2=jsonObject1.getJSONObject("news_obj");
            String title=jsonObject2.getString("title");
            String content=jsonObject2.getString("content");
            String image_url=jsonObject2.getString("image_url");
            String source_url=jsonObject2.getString("source_url");

            list.add(new GetData(title,content,image_url,source_url));
        }
        return list;
    }
    public String getResponse(String str) throws Exception{
        URL url=new URL(str);
        HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
        connection.setRequestProperty("accept","application/json");
        Scanner sc=new Scanner(connection.getInputStream());
        StringBuilder sb=new StringBuilder();

        while(sc.hasNext()){
            sb.append(sc.nextLine());
        }
        return sb.toString();
    }
    public String getUrl(){
        String str = "https://www.inshorts.com/api/en/news?category=top_stories&max_limit=20&include_card_data=true&news_offset=xtnqdv2g-1";
        return str;
    }

}

