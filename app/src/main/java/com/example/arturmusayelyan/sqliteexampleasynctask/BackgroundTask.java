package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by artur.musayelyan on 01/12/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {
    private Context context;

    public BackgroundTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        DbOperations dbOperations = new DbOperations(context);
        if (method.equals("add_info")) {
            String id = params[1];
            String name = params[2];
            int quantity = Integer.parseInt(params[3]);
            int price = Integer.parseInt(params[4]);

            SQLiteDatabase sqLiteDatabase = dbOperations.getWritableDatabase();
            dbOperations.addInformations(sqLiteDatabase, id, name, quantity, price);

            return "One Row Inserted....";
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context,result,Toast.LENGTH_LONG).show();
    }
}
