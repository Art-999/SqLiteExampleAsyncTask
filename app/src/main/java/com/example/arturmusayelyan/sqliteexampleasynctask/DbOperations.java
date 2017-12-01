package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by artur.musayelyan on 01/12/2017.
 */

public class DbOperations extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "product_info.db";

    private static final String CREATE_QUERY = "create table " + Product.ProductEntry.TABLE_NAME + "(" + Product.ProductEntry.ID + " text," + Product.ProductEntry.NAME + " text," + Product.ProductEntry.QUANTITY + " integer," + Product.ProductEntry.PRICE + " integer);";

    public DbOperations(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Database operations", "Database created...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addInformations(SQLiteDatabase sqLiteDatabase, String id, String name, int quantity, int price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Product.ProductEntry.ID, id);
        contentValues.put(Product.ProductEntry.NAME, name);
        contentValues.put(Product.ProductEntry.QUANTITY, quantity);
        contentValues.put(Product.ProductEntry.PRICE, price);
        sqLiteDatabase.insert(Product.ProductEntry.TABLE_NAME, null, contentValues);

        Log.d("Database operations", "One Row Inserted.....");
    }
}
