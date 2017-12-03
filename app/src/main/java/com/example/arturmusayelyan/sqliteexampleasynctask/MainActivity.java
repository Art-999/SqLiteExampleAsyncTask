package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addProduct_btn, viewProducts_btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addProduct_btn = findViewById(R.id.add_product_button);
        viewProducts_btn = findViewById(R.id.view_products_button);
        addProduct_btn.setOnClickListener(this);
        viewProducts_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_product_button:
                intent = new Intent(this, SaveInfo.class);
                startActivity(intent);
                break;
            case R.id.view_products_button:
                intent = new Intent(this, DisplayProduct.class);
                startActivity(intent);
                break;
        }
    }
}
