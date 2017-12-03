package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by artur.musayelyan on 01/12/2017.
 */

public class BackgroundTask extends AsyncTask<String, Product, String> {
    private Context context;
    ProductAdapter productAdapter;
    Activity activity;
    ListView listView;

    public BackgroundTask(Context context) {
        this.context = context;
        activity= (Activity) context;
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
        } else if (method.equals("get_info")) {
            listView=activity.findViewById(R.id.list_view_for_display_product);
            SQLiteDatabase sqLiteDatabase = dbOperations.getReadableDatabase();
            Cursor cursor = dbOperations.getInformations(sqLiteDatabase);
            productAdapter = new ProductAdapter(context, R.layout.display_product_row);

            String id, name;
            int quantity, price;
            while (cursor.moveToNext()) {
                id = cursor.getString(cursor.getColumnIndex(ProductDbBaseInfo.ProductEntry.ID));
                name = cursor.getString(cursor.getColumnIndex(ProductDbBaseInfo.ProductEntry.NAME));
                quantity = cursor.getInt(cursor.getColumnIndex(ProductDbBaseInfo.ProductEntry.QUANTITY));
                price = cursor.getInt(cursor.getColumnIndex(ProductDbBaseInfo.ProductEntry.PRICE));
                Product product = new Product(id, name, quantity, price);
                publishProgress(product);

            }
            return "get info";

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Product... values) {
        productAdapter.add(values[0]);

    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("get_info")){
            listView.setAdapter(productAdapter);
        }
        else {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
    }
}
