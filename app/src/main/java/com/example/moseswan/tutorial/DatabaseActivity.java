package com.example.moseswan.tutorial;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class DatabaseActivity extends Activity {

    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_acitivity);

        helper = new DatabaseHelper(this);
    }

    public void add(View v){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO wordlist (word) VALUES ('bob')");
        db.close();
        display();
    }

    public void delete(View v){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("DELETE FROM wordlist WHERE word='bob'");
        db.close();
        display();
    }

    private void display() {
        TextView text = (TextView) findViewById(R.id.textView8);

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT word FROM wordlist", null);

        String message = "";

        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            message += cursor.getString(cursor.getColumnIndexOrThrow("word"));
            message += "\n";
        }

        cursor.close();
        db.close();

        text.setText(message);
    }
}
