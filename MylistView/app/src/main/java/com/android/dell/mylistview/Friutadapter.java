package com.android.dell.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2020/4/18.
 */

public class Friutadapter extends ArrayAdapter<Friut>{
    private int resorcesid;
    public Friutadapter(Context context, int textViewRescuresid, List<Friut> objects){
        super(context,textViewRescuresid,objects);
        resorcesid = textViewRescuresid;

    }

    @Override
    public View getView(int postion, View converview, ViewGroup partent){
        Friut friut = getItem(postion);
        ViewHolder viewHolder;
        View view;
        if(converview==null){
            view = LayoutInflater.from(getContext()).inflate(resorcesid,partent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)view.findViewById(R.id.image);
            viewHolder.textView = (TextView)view.findViewById(R.id.name);
            view.setTag(viewHolder);
        }else {
/*        View view = LayoutInflater.from(getContext()).inflate(resorcesid,partent,false);
       // View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        TextView textView = (TextView)view.findViewById(R.id.name);
        imageView.setImageResource(friut.getImageid());
        textView.setText(friut.getName());
        return view;*/
            view = converview;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.imageView.setImageResource(friut.getImageid());
        viewHolder.textView.setText(friut.getName());
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

}
