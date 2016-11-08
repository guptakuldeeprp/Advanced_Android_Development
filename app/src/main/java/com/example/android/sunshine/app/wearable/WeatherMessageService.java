package com.example.android.sunshine.app.wearable;

import android.util.Log;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by kuldeep.gupta on 10/14/2016.
 */

public class WeatherMessageService extends WearableListenerService {
    private static final String LOG_TAG = WeatherMessageService.class.getName();
    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.i(LOG_TAG, "Message received");
        if(messageEvent.getPath().equals("/update-weather")) {
            Log.i(LOG_TAG, "Message for /update-weather");
            SunshineSyncAdapter.syncImmediately(this);
        } else {
            super.onMessageReceived(messageEvent);
        }
    }
}
