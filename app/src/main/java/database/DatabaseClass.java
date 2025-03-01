package database;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorconverter.R;

import java.util.ArrayList;

public class DatabaseClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_class);

        DBHelper helper=new DBHelper(this);
        /*
        helper.addContacts("Suraj","6263662581");
        helper.addContacts("Sagar","6263662581");
        helper.addContacts("Radhe","6263662581");
        helper.addContacts("Krishna","6263662581");
        helper.addContacts("Arjun","6263662581");
         */

        ContactModel  obj=new ContactModel();
        obj.id=1;
        obj.name="suraj";
        obj.phone="1234567890";
        helper.updateContact(obj);

        helper.deleteContact(1);

        ArrayList<ContactModel> contactModel=helper.fetchContact();

        for(int i=0;i<contactModel.size();i++){
            Log.d("Contact Info ","Name "+contactModel.get(i).name+", Phone Number "+contactModel.get(i).phone);
        }
    }
}