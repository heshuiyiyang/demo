package com.android.dell.mylistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2020/4/23.
 */
//这里首先定义了一个内部类 ViewHolder ，ViewHolder 要继承自 RecyclerView.ViewHolder，然后 ViewHolder 的构造函数中要传入一个 View 参数，这个参数通常就说 RecyclerView 子项的最外层布局，那么我们就可以通过 findViewById() 方法来获取到布局中的ImageView和TextView的实例了。


public class Friutrecycle extends RecyclerView.Adapter<Friutrecycle.ViewHolder> {
    private List<Friut> mFriut;
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recylerimage;
        TextView recylertext;
        public ViewHolder(View itemView) {
            super(itemView);
            recylerimage = (ImageView)itemView.findViewById(R.id.recycler_image);
            recylertext = (TextView)itemView.findViewById(R.id.recycler_name);


        }
    }
    //构造函数中用于将要展示的数据源传进来，并赋值给一个全局变量 mFriut
    public Friutrecycle(List<Friut> friutList){
        mFriut = friutList;
    }
    //由于 FruitAdapter 继承自 RecyclerView.ViewHolder 的，就必须重写 onCreateViewHolder()、onBindViewHolder()、getItemCount()这3个方法。

    //方法用于创建 ViewHolder 实例，我们在这个方法中将 fruit_item 布局加载进来，然后创建一个 ViewHolder 实例，并把加载出来的布局传入到构造函数当中，最后将 ViewHolder 实例返回

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //用于对RecyclerView子项的数据进行赋值的，会在每个子项被滚动到屏幕内的时候执行，这里我们通过 position 参数得到当前 Fruit 实例，然后再将数据设置到 ViewHolder 的 ImageView 和 TetView 中

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Friut friut= mFriut.get(position);
        holder.recylerimage.setImageResource(friut.getImageid());
        holder.recylertext.setText(friut.getName());

    }

    //返回数据源的长度
    @Override
    public int getItemCount() {
        return mFriut.size();
    }


}
