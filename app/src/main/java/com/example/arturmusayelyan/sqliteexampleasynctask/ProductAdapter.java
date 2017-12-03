package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 04.12.2017.
 */

public class ProductAdapter extends ArrayAdapter {
    List list = new ArrayList();
    Context context;

    public ProductAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context=context;
    }


    public void add(Product object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ProductHolder productHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_product_row, parent, false);
            productHolder = new ProductHolder();
            productHolder.tv_id = row.findViewById(R.id.textView_id_for_row);
            productHolder.tv_name = row.findViewById(R.id.textView_name_for_row);
            productHolder.tv_quantity = row.findViewById(R.id.textView_quantity_for_row);
            productHolder.tv_price = row.findViewById(R.id.textView_price_for_row);
            row.setTag(productHolder);
        } else {
            productHolder = (ProductHolder) row.getTag();

        }
        Product product = (Product) getItem(position);
        productHolder.tv_id.setText(product.getId().toString());
        productHolder.tv_name.setText(product.getId().toString());
        productHolder.tv_quantity.setText(Integer.toString(product.getQuantity()));
        productHolder.tv_price.setText(Integer.toString(product.getPrice()));
        return row;
    }

    static class ProductHolder {
        TextView tv_id, tv_name, tv_quantity, tv_price;

    }
}
