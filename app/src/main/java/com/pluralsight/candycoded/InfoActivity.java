package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URI;

import static com.pluralsight.candycoded.DetailActivity.HASHTAG_CANDYCODED;
import static com.pluralsight.candycoded.DetailActivity.SHARE_DESCRIPTION;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }
    public void createMapIntent(View view){
        Uri location = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
       Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        mapIntent.setPackage("com.google.android.apps.maps");

       if( mapIntent.resolveActivity(getPackageManager())!= null ){

           startActivity(mapIntent);


        }



    }

    public void createPhoneIntent(View view){

Intent i = new Intent(Intent.ACTION_DIAL);
i.setData(Uri.parse("tel:0123456789"));
InfoActivity.this.startActivity(i);


    }


    private void createShareIntent(){
Intent sendIntent = new Intent();
sendIntent.setType("text/plain");
sendIntent.setAction(Intent.ACTION_SEND);
sendIntent.putExtra(Intent.EXTRA_TEXT,SHARE_DESCRIPTION  + HASHTAG_CANDYCODED);
Intent shareIntent = Intent.createChooser(sendIntent,null);
startActivity(shareIntent);



    }
    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
}
