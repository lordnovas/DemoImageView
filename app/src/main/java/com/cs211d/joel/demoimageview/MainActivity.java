package com.cs211d.joel.demoimageview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * todo Add Borders around pictures
 */


public class MainActivity extends ActionBarActivity
{
    private ImageView mIv;
    int mCurrentIndex =0;

    private Integer[] mImageIds = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };


    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv =(ImageView)findViewById(R.id.iv_pics);
    }


    public void updateView()
    {
        mIv.setImageResource(mImageIds[mCurrentIndex]);
    }

    public void next(View v)
    {
        int numOfPics = mImageIds.length -1;

        ++mCurrentIndex;
        if(mCurrentIndex > numOfPics)
        {
            mCurrentIndex = 0;
        }
        updateView();
    }

    public void prev(View v)
    {
         --mCurrentIndex;

        if(mCurrentIndex < 0)
        {
            mCurrentIndex = mImageIds.length-1;
        }
        updateView();
    }
}
