package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveInfo extends AppCompatActivity implements View.OnClickListener {
    private EditText id_et, name_et, quantity_et, price_et;
    private Button save_btn;
    private String id, name, quantity, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);
        id_et = findViewById(R.id.product_id_et);
        name_et = findViewById(R.id.product_name_et);
        quantity_et = findViewById(R.id.product_quantity_et);
        price_et = findViewById(R.id.product_price_et);
        save_btn = findViewById(R.id.save_button);
        save_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_button:
                id = id_et.getText().toString();
                name = name_et.getText().toString();
                quantity = quantity_et.getText().toString();
                price = price_et.getText().toString();

                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute("add_info", id, name, quantity, price);
                finish();
                break;
        }
    }
}
