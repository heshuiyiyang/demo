package com.android.dell.mylistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recycleractivity extends AppCompatActivity {
    private List<Friut> friutslist = new ArrayList<Friut>();
   // 同样使用了 initFruits() 方法，用于初始化数据。然后在 onCreate() 方法中，我们先获取到 RecyclerView 的实例，然后创建了一个 LinearLayoutManager 对象，并将它设置到 RecyclerView 当中。 LayoutManager 用于指定 RecyclerView 的布局方式，LinearLayoutManager 是线性布局的意思，可以实现和 ListView 类似的效果。接下来创建了 FruitAdapter 实例，并将数据传入到其构造函数中，最后调用 RecyclerView 的 setAdapter() 方法来完成适配器设置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);
        initfriut();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        Friutrecycle adapter = new Friutrecycle(friutslist);
        recyclerView.setAdapter(adapter);
    }
    public void initfriut(){
        for (int i=0;i<3;i++){
            Friut apple = new Friut("apple",R.drawable.apple);
            friutslist.add(apple);
            Friut banana = new Friut("banana",R.drawable.banana);
            friutslist.add(banana);
            Friut caomei = new Friut("caomei",R.drawable.caomei);
            friutslist.add(caomei);
            Friut cherry = new Friut("cherry",R.drawable.cherry);
            friutslist.add(cherry);
            Friut fengli = new Friut("fengli",R.drawable.fengli);
            friutslist.add(fengli);
            Friut margon = new Friut("margon",R.drawable.margon);
            friutslist.add(margon);
            Friut orange = new Friut("orange",R.drawable.orange);
            friutslist.add(orange);
            Friut pear = new Friut("pear",R.drawable.pear);
            friutslist.add(pear);
            Friut putao = new Friut("putao",R.drawable.putao);
            friutslist.add(putao);
            Friut watermonle = new Friut("putao",R.drawable.watermelon);
            friutslist.add(watermonle);}

    }
}
