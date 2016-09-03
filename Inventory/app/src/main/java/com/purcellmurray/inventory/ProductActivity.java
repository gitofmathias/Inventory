package com.purcellmurray.inventory;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    public ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mListView = (ListView) findViewById(R.id.product_list_view);
        final ArrayList<Product> productList = Product.getProductsFromFile("recipes.json", this);
        String[] listItems = new String[productList.size()];
//        for(int i = 0; i < productList.size(); i++){
//            Product product = productList.get(i);
//            listItems[i] = product.title;
//        }
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
//        mListView.setAdapter(adapter);

        ProductAdapter adapter = new ProductAdapter(this, productList);
        mListView.setAdapter(adapter);

        final Context context = this;

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Product selectedProduct = productList.get(position);
                Intent detailIntent = new Intent(context, DetailActivity.class);
                detailIntent.putExtra("title", selectedProduct.title);
                detailIntent.putExtra("description", selectedProduct.description);
                startActivity(detailIntent);
            }

        });
    }
}
