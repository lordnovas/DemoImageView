package com.cs211d.joel.demoimageview;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
{
    private ImageView mIv;
    ArrayList<Integer> al = new ArrayList<>();
    int next =0;

    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv =(ImageView)findViewById(R.id.iv_pics);

        Field fld[] = com.cs211d.joel.demoimageview.R.drawable.class.getFields();

        for(Field f:fld)
        {
            Integer imgId = null;
            try {
                imgId = f.getInt(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            al.add(imgId);
        }
        
    }



    public void next(View v)
    {
        Message.message(getApplicationContext(),"Show Next Pic");
        mIv.setImageResource(al.get(next++));
    }


    public void prev(View v)
    {
        Message.message(getApplicationContext(),"Show Prev Pic");

    }
}
