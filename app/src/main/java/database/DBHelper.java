package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String database = "ContactDB";
    private static final int Db_id = 1;
    private static final String Table = "Contacts";
    private static final String key_id = "id";
    private static final String key_name = "name";
    private static final String key_phone = "phone";

    public DBHelper(Context context) {
        super(context, database, null, Db_id);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table + " ("
                + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + key_name + " TEXT, "
                + key_phone + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table);
        onCreate(db);
    }

    public void addContacts(String name, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_name, name);
        values.put(key_phone, phone);
        db.insert(Table, null, values);
        db.close();
    }

    public ArrayList<ContactModel> fetchContact(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From "+Table,null);
        ArrayList<ContactModel> list=new ArrayList<>();

        while(cursor.moveToNext()){
            ContactModel contactModel=new ContactModel();
            contactModel.id=cursor.getInt(0);
            contactModel.name=cursor.getString(1);
            contactModel.phone=cursor.getString(2);
            list.add(contactModel);
        }
        return list;
    }

    public void updateContact(ContactModel contactModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(key_phone,contactModel.phone);
        db.update(Table,cv,key_id+" = "+contactModel.id,null);
    }

    public void deleteContact(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table,key_id+" = ? ",new String[]{String.valueOf(id)});
    }
}
