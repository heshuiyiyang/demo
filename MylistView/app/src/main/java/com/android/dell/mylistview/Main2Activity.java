package com.android.dell.mylistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private List<Friut> friutslist = new ArrayList<Friut>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initfriut();
        Friutadapter adapter = new Friutadapter(Main2Activity.this,R.layout.friut_item,friutslist);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, recycleractivity.class);
                startActivity(intent);
            }
        });
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
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(Main2Activity.this, MainActivity.class);
            startActivity(intent);

    }
}
