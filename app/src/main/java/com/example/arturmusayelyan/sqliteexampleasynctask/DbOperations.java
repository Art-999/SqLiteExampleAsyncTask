package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by artur.musayelyan on 01/12/2017.
 */

public class DbOperations extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "product_info.db";

    public static String getDbName() {
        return DB_NAME;
    }

    private static final String CREATE_QUERY = "create table " + ProductDbBaseInfo.ProductEntry.TABLE_NAME + "(" + ProductDbBaseInfo.ProductEntry.ID + " text," + ProductDbBaseInfo.ProductEntry.NAME + " text," + ProductDbBaseInfo.ProductEntry.QUANTITY + " integer," + ProductDbBaseInfo.ProductEntry.PRICE + " integer);";

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
        contentValues.put(ProductDbBaseInfo.ProductEntry.ID, id);
        contentValues.put(ProductDbBaseInfo.ProductEntry.NAME, name);
        contentValues.put(ProductDbBaseInfo.ProductEntry.QUANTITY, quantity);
        contentValues.put(ProductDbBaseInfo.ProductEntry.PRICE, price);
        sqLiteDatabase.insert(ProductDbBaseInfo.ProductEntry.TABLE_NAME, null, contentValues);

        Log.d("Database operations", "One Row Inserted.....");
    }

    public Cursor getInformations(SQLiteDatabase sqLiteDatabase) {
        String columns[] = {ProductDbBaseInfo.ProductEntry.ID, ProductDbBaseInfo.ProductEntry.NAME, ProductDbBaseInfo.ProductEntry.QUANTITY, ProductDbBaseInfo.ProductEntry.PRICE};
        Cursor cursor = sqLiteDatabase.query(ProductDbBaseInfo.ProductEntry.TABLE_NAME, columns, null, null, null, null, null);

        Log.d("Database operations", "cursor retrieved");
        return cursor;
    }

    public void deleteTable() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + ProductDbBaseInfo.ProductEntry.TABLE_NAME);
    }


}
