package com.app.waclabdev.breastselfttesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.app.ActionBar.LayoutParams;

/**
 * Created by waclabdev on 15.04.17.
 */

// slideshow with breast testing tutorial
public class SlideshowActivity  extends AppCompatActivity {

    private ImageSwitcher sw;
    private Button b1,b2;
    private int i = 0;
    private int counter = 0;

    // array with tutorial images
    private Integer[] mImages = {
            R.drawable.badanie1, R.drawable.badanie2, R.drawable.badanie1,
            R.drawable.badanie2, R.drawable.badanie1, R.drawable.badanie2,
            R.drawable.badanie1, R.drawable.badanie2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideshow);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        // create slideshow
        sw = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT));
                return myView;
            }
        });
        sw.setImageResource(R.drawable.badanie2);

        counter = mImages.length;

        // prev button click event
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setEnabled(true);
                if (i > 0) {
                    if (i == counter) {
                        i--;
                    }
                    sw.setImageResource(mImages[i]);
                    i--;
                } else {
//                Toast.makeText(getApplicationContext(), "You are in the beginning "+ i + " " + counter,
//                        Toast.LENGTH_LONG).show();
                    b1.setEnabled(false);
                }
            }
        });

        // next button click event
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setEnabled(true);
                if (i < counter) {
                    sw.setImageResource(mImages[i]);
                    i++;
                } else {
//                Toast.makeText(getApplicationContext(), "The end "+ i + " " + counter,
//                        Toast.LENGTH_LONG).show();
                    b2.setEnabled(false);
                }
            }
        });

    }
}
