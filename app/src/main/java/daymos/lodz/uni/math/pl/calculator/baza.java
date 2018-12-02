package daymos.lodz.uni.math.pl.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class baza extends SQLiteOpenHelper {
    public baza(Context context) {
        super(context, "wyniki.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table wyniki(" +
                        "nr integer primary key autoincrement," +
                        "wyrazenie text);" +
                        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void dodajWyrazenie(String wyrazenie) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("wyrazenie", wyrazenie);

        db.insertOrThrow("wyniki", null, wartosci);
    }

    public Cursor pokazWszystkie() {
        String[] kolumny = {"nr", "wyrazenie"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("wyniki", kolumny, null, null, null, null, null);
        return kursor;
    }




}
