package com.android.dell.mylistview;

/**
 * Created by dell on 2020/4/18.
 */
public class Friut {
    private String name;
    private int imageid;
    public Friut(String name,int imageid){
        this.name = name;
        this.imageid = imageid;
    }
    public String getName(){
        return name;
    }
    public int getImageid(){
        return imageid;
    }
}
