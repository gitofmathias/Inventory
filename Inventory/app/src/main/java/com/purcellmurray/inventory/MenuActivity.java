package com.purcellmurray.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void toBrand(View v){
        Intent intent=new Intent(this, BrandActivity.class);
        startActivity(intent);
    }
    public void toCategories(View v){
        Intent intent=new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }

    public void toProduct(View v){
        Intent intent=new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    public void toLogin(View v){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
