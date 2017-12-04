package com.example.arturmusayelyan.sqliteexampleasynctask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addProduct_btn, viewProducts_btn, delete_db;
    Intent intent;
    boolean checkDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addProduct_btn = findViewById(R.id.add_product_button);
        viewProducts_btn = findViewById(R.id.view_products_button);
        delete_db = findViewById(R.id.delete_db_button);
        addProduct_btn.setOnClickListener(this);
        viewProducts_btn.setOnClickListener(this);
        delete_db.setOnClickListener(this);

        checkDb=false;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_product_button:
                intent = new Intent(this, SaveInfo.class);
                startActivity(intent);
                checkDb=false;
                break;
            case R.id.view_products_button:
                if(!checkDb) {
                    intent = new Intent(this, DisplayProduct.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"Db is empty",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.delete_db_button:
                DbOperations dbOperations = new DbOperations(this);
                dbOperations.deleteTable();
                Toast.makeText(this, "Database deleted...", Toast.LENGTH_LONG).show();
                checkDb=true;
//                Intent intent=new Intent(this,DisplayProduct.class);
//                intent.putExtra("key","db_deleted");
                break;
        }
    }
}
