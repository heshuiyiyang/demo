package com.android.dell.myaidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.dell.myservice.Book;
import com.android.dell.myservice.BookManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "aidl client";
    private BookManager mBookManager = null;
    private boolean mBound = false;
    private List<Book> mbook;
    private Book book = new Book();
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book newbook = new Book();
                newbook.setPrice(26);
                newbook.setName("父与子");
                Log.d(TAG,newbook.toString());
                try {
                    mBookManager.addbook(newbook);
                    Log.d(TAG,newbook.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        if (!mBound) {
            attemptToBindService();
        }

    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mServiceConnection);
            mBound = false;
        }
    }
    //重写onServiceConnected()方法和onServiceDisconnected()方法
    //在Activity与Service建立关联和解除关联的时候调用
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //使用BookManager.Stub.asInterface()方法获取服务器端返回的IBinder对象
            //将IBinder对象传换成了mBookManager接口对象
            mBookManager = BookManager.Stub.asInterface(service);
            mBound = true;
            if(mBookManager!= null){
                try {
                    //通过该对象调用在MyAIDLService.aidl文件中定义的接口方法,从而实现跨进程通信
                    mbook = mBookManager.getbooks();
                    Log.e(getLocalClassName(),mbook.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {

            mBound=false;
            Log.e(getLocalClassName(),"Service Disconnected");
        }
    };

    private void attemptToBindService(){
        //通过Intent指定服务端的服务名称和所在包，与远程Service进行绑定
        //参数与服务器端的action要一致,即"服务器包名.aidl接口文件名"
        Intent intent = new Intent();
        intent.setAction("com.android.dell.myservice.aidl");
        intent.setPackage("com.android.dell.myservice");
        //绑定服务,传入intent和ServiceConnection对象,重要
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }
    /*public void addbook(Book book){
        if (!mBound){
            attemptToBindService();
            Toast.makeText(this,"当前与服务端处于未连接状态，正在尝试重连，请稍后再试", Toast.LENGTH_SHORT).show();
            return;
        }
        if(mBookManager==null)
            return;
        book = new Book();
        book.setName("父与子");
        book.setPrice(26);
        try {
            mBookManager.addbook(book);
            Log.e(getLocalClassName(), book.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }*/

}
