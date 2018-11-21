package com.example.win.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        new Thread(){
            boolean flag = true;
            int count= 0;
            @Override
            public void run( ) {
                while (flag) {
                    Intent i = new Intent("MyMessage");
                    i.putExtra("background_service", count);
                    sendBroadcast(i);
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
