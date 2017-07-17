package com.andarilhogeek.simpleandroidimageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by bpmsilva on 17/07/17.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageResourceIds;
    private LinearLayout mCircularIndicatorsLayout;

    public ViewPagerAdapter(Context context, int[] imageResourceIds, LinearLayout circularIndicatorsLayout) {
        mContext = context;
        mImageResourceIds = imageResourceIds;
        mCircularIndicatorsLayout = circularIndicatorsLayout;
        addIndicatorCircles(mImageResourceIds.length);
    }

    private void addIndicatorCircles(int numberIndicators) {
        // create the layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        // TODO: convert the arguments from pixels to dips
        layoutParams.setMargins(10, 10, 10, 10);

        for (int i = 0; i < numberIndicators; i++) {
            // create image view and set its resource and params
            ImageView imageView = new ImageView(mContext);
            imageView.setId(i);
            if (i == 0) {
                imageView.setImageResource(R.drawable.ic_circle_on);
            } else {
                imageView.setImageResource(R.drawable.ic_circle_off);
            }
            imageView.setLayoutParams(layoutParams);

            // add the ImageView to the linear layout
            mCircularIndicatorsLayout.addView(imageView);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // inflate the layout
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = layoutInflater.inflate(R.layout.view_pager_item, container, false);

        // set the image of the image view from the item and put it in the container
        ImageView itemImageView = (ImageView) item.findViewById(R.id.item_image_view);
        itemImageView.setImageResource(mImageResourceIds[position]);
        container.addView(item);

        return item;
    }

    @Override
    public int getCount() {
        return mImageResourceIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
