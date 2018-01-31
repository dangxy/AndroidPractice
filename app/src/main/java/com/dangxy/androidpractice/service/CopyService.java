package com.dangxy.androidpractice.service;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;

import com.dangxy.androidpractice.utils.MLog;

/**
 * @description  描述
 * @author  dangxy99
 * @date   2018/1/30
 */
public class CopyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        MLog.e("DANG","onCreate");
        registerClipEvents();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
          MLog.e("DANG","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void registerClipEvents() {

        final ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        manager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {

                if (manager.hasPrimaryClip() && manager.getPrimaryClip().getItemCount() > 0) {

                    CharSequence addedText = manager.getPrimaryClip().getItemAt(0).getText();



                    if (addedText != null) {
                          MLog.e("DANG",addedText.toString());
                    }
                }
            }
        });
    }
}
