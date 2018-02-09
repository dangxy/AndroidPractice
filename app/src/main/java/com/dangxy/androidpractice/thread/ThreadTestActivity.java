package com.dangxy.androidpractice.thread;

import android.app.Activity;
import android.os.Bundle;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.utils.MLog;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);

        initThread();
    }

    private void initThread() {

        CallTest callTest = new CallTest();


        FutureTask<String> futureTask = new FutureTask<String>(callTest);


        Thread thread = new Thread(futureTask);


        thread.start();

        try {
          String get =   futureTask.get();
              MLog.e("DANG",get+"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
