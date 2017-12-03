package com.example.arturmusayelyan.sqliteexampleasynctask;

/**
 * Created by artur.musayelyan on 01/12/2017.
 */

public final class ProductDbBaseInfo {
    public ProductDbBaseInfo() {

    }

    public static abstract class ProductEntry {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PRICE = "price";
        public static final String QUANTITY = "quantity";

        public static final String TABLE_NAME = "product_table";
    }
}
