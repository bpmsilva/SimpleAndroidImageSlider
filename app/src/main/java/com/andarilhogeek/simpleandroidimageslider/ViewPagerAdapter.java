package com.andarilhogeek.simpleandroidimageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by bpmsilva on 17/07/17.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private int[] mImageResourceIds;
    private Context mContext;

    public ViewPagerAdapter(Context context, int[] imageResourceIds) {
        mContext = context;
        mImageResourceIds = imageResourceIds;
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
        super.destroyItem(container, position, object);
    }
}
