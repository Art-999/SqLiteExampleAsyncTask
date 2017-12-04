package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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

    public ProductAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }


    public void add(Product object) {
        super.add(object);
        list.add(object);
        Log.d("LLL_OG", list.toString());
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
        MyViewHolder myViewHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_product_row, parent, false);
            myViewHolder = new MyViewHolder(row);
            row.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) row.getTag();

        }
        Product product = (Product) getItem(position);
        myViewHolder.tv_id.setText(product.getId().toString());
        myViewHolder.tv_name.setText(product.getName().toString());
        myViewHolder.tv_quantity.setText(Integer.toString(product.getQuantity()));
        myViewHolder.tv_price.setText(Integer.toString(product.getPrice()));
        return row;
    }

    class MyViewHolder {
        TextView tv_id, tv_name, tv_quantity, tv_price;

        public MyViewHolder(View view) {
            tv_id = view.findViewById(R.id.textView_id_for_row);
            tv_name = view.findViewById(R.id.textView_name_for_row);
            tv_quantity = view.findViewById(R.id.textView_quantity_for_row);
            tv_price = view.findViewById(R.id.textView_price_for_row);
        }
    }
}
