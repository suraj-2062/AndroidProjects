package demosharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private final String file_name="Shopping";
    private  final int mode=0;
    private String flag="false";
    public SessionManager(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(file_name,mode);
        editor=sharedPreferences.edit();
    }
    public boolean sessionCheck(){
        if(sharedPreferences.contains(flag)){
            return true;
        }
        else{
            return false;
        }
    }
    public void clearSession(){
        editor.clear();
        editor.commit();

        Intent intent =new Intent(context, DemoSharedPreference.class);
        context.startActivity(intent);
    }
    public String getSessionDetail(String key){
        String value=sharedPreferences.getString(key,null);
        return value;
    }
    public void createSession(String name, String email, String phone){
        editor.putString("session_name",name);
        editor.putString("session_email",email);
        editor.putString("session_phone",phone);
        editor.putBoolean(flag,true);
        editor.commit();
    }
}
