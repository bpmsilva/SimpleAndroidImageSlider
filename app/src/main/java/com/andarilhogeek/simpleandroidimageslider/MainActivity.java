package com.andarilhogeek.simpleandroidimageslider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager imageSliderViewPager = (ViewPager) findViewById(R.id.image_slider_view_pager);
        int[] imageResourceIds = {R.drawable.image1, R.drawable.image2};
        ViewPagerAdapter myViewPagerAdapter = new ViewPagerAdapter(this, imageResourceIds);
        imageSliderViewPager.setAdapter(myViewPagerAdapter);
    }
}
