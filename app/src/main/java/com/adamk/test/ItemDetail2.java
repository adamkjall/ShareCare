package com.adamk.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class ItemDetail2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);


        Bundle data = getIntent().getExtras();
        Item item = (Item) data.getParcelable("Item");

        //String hammer_desc = "Hammer for nailing available for borrow. Please if the head falls off try to replace it ";
        //Item item = new Item("Hammer", hammer_desc, R.drawable.hammer, "2.0km" );

        ImageView imView =  findViewById(R.id.itemImage);
        //if(item!= null)
        imView.setImageResource(item.getImage());

        TextView ttl_tvw = findViewById(R.id.ttl_txvw);
        ttl_tvw.setText(item.getTitle());
        ttl_tvw.setTextSize(30);
        //ttl_tvw.setTypeface();

        TextView loc_txt = findViewById(R.id.myImageViewText);
        loc_txt.setText(item.getDistance());
        loc_txt.setTextSize(20);
        //MapView mpView = findViewById(R.id.mapView);
        // mpView.set
        TextView desc_txvw = findViewById(R.id.desc_txtvw);
        desc_txvw.setText(item.getDescription());
        desc_txvw.setTextSize(15);

        TextView name_TxtVw = findViewById(R.id.Name_txtvw);
        name_TxtVw.setText("Very kind Guy");
        name_TxtVw.setTextSize(15);

        TextView addrr_TxtVw = findViewById(R.id.addrss_txtvw);
        addrr_TxtVw.setText("No 1 kind People Street 4200");
        addrr_TxtVw.setTextSize(15);

        TextView no_TxtVw = findViewById(R.id.phoneNo);
        no_TxtVw.setText("070420000");
        no_TxtVw.setTextSize(15);

        Button button = findViewById(R.id.book_btn);
        button.setVisibility(View.INVISIBLE);


        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(item.getRating());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }
}
