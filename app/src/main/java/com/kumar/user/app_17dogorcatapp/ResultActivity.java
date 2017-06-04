package com.kumar.user.app_17dogorcatapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 6/3/2017.
 */

public class ResultActivity  extends Activity{
    private TextView result;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result= (TextView) findViewById(R.id.res);
        imageView= (ImageView) findViewById(R.id.imageView);
        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            int catResult=extras.getInt("catCounter");
            int dogResult=extras.getInt("dogCounter");
            if (catResult>dogResult){
                result.setText("CAT PERSON!");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_lg_cat));
            }
            else if (dogResult>catResult){
                result.setText("DOG PERSON!");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_lg_dog));
            }
            else {
                result.setText("NEITHER!");
            }
        }
    }

}
