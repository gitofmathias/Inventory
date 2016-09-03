package com.purcellmurray.inventory;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by dodobal-1 on 9/2/16.
 */
public class Product {

    public String title;
    public String description;
    public String imageUrl;
    public String instructionUrl;
    public String label;

    public static ArrayList<Product> getProductsFromFile(String filename, Context context){
        final ArrayList<Product> recipeList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("recipes.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray products = json.getJSONArray("recipes");

            // Get Recipe objects from data
            for(int i = 0; i < products.length(); i++){
                Product product = new Product();

                product.title = products.getJSONObject(i).getString("title");
                product.description = products.getJSONObject(i).getString("description");
                product.imageUrl = products.getJSONObject(i).getString("image");
                product.instructionUrl = products.getJSONObject(i).getString("url");
                product.label = products.getJSONObject(i).getString("dietLabel");

                recipeList.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipeList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}

