package com.andarilhogeek.simpleandroidimageslider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to the View Pager and to the LinearLayout that will hold the indicators
        ViewPager imageSliderViewPager = (ViewPager) findViewById(R.id.image_slider_view_pager);
        final LinearLayout mCircularIndicatorsLayout = (LinearLayout) findViewById(R.id.circular_indicators_layout);

        int[] imageResourceIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
        final ViewPagerAdapter myViewPagerAdapter = new ViewPagerAdapter(this, imageResourceIds, mCircularIndicatorsLayout);
        imageSliderViewPager.setAdapter(myViewPagerAdapter);

        imageSliderViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < myViewPagerAdapter.getCount(); i++) {
                    ImageView circularIndicator = (ImageView) mCircularIndicatorsLayout.findViewById(i);
                    if (i != position) {
                        circularIndicator.setImageResource(R.drawable.ic_circle_off);
                    } else {
                        circularIndicator.setImageResource(R.drawable.ic_circle_on);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }



}
