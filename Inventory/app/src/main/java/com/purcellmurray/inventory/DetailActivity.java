package com.purcellmurray.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DetailActivity extends AppCompatActivity {

    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String title = this.getIntent().getExtras().getString("title");
        String url = this.getIntent().getExtras().getString("description");
    }

    public void setFavourite(View v){
        ImageButton imageButton=(ImageButton)findViewById(R.id.btn_favourite);
        if (flag==0) {
            imageButton.setBackgroundResource(R.mipmap.favorite_on);
            flag=1;
        }
        else if (flag==1){
            imageButton.setBackgroundResource(R.mipmap.favorite_off);
            flag=0;
        }

    }
}
