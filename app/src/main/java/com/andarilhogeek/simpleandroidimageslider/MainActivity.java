package com.andarilhogeek.simpleandroidimageslider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager imageSliderViewPager = (ViewPager) findViewById(R.id.image_slider_view_pager);
        int[] imageResourceIds = {R.drawable.image1, R.drawable.image2};
        ViewPagerAdapter myViewPagerAdapter = new ViewPagerAdapter(this, imageResourceIds);
        imageSliderViewPager.setAdapter(myViewPagerAdapter);

        addIndicatorCircles(imageResourceIds.length);
    }

    private void addIndicatorCircles(int numberIndicators) {
        // get reference to the LinearLayout that will hold the indicators
        LinearLayout circularIndicatorsLayout = (LinearLayout) findViewById(R.id.circular_indicators_layout);

        // create the layout params
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        // TODO: convert the arguments from pixels to dips
        layoutParams.setMargins(10, 10, 10, 10);

        for (int i = 0; i < numberIndicators; i++) {
            // create image view and set its resource and params
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_circle);
            imageView.setLayoutParams(layoutParams);

            // add the ImageView to the linear layout
            circularIndicatorsLayout.addView(imageView);
        }
    }

}
