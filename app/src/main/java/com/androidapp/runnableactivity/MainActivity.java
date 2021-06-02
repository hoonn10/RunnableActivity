package com.androidapp.runnableactivity;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    WorkerThread wt;
    Thread wr;
    boolean running = true;
    String strTag = "THREAD";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(strTag, "Now I am in onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        wt = new WorkerThread();
        wr = new Thread(new WorkerRunnable());
        running = true;
        wt.start();
        wr.start();
        Log.v(strTag, "Now I am in onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;
        Log.v(strTag, "Now I am in onStop");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.v(strTag, "Now I am in onPause");
    }




    class WorkerThread extends Thread {
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(strTag, "Thread time=" + i);
            }
        }
    }

    class WorkerRunnable implements Runnable{
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v("THREAD", "Runnable time=" + i);
            }
        }
    }
}