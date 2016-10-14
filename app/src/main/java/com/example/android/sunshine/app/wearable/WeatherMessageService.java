package com.example.android.sunshine.app.wearable;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by kuldeep.gupta on 10/14/2016.
 */

public class WeatherMessageService extends WearableListenerService {
    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        if(messageEvent.getPath().equals("/update-weather")) {
            SunshineSyncAdapter.syncImmediately(this);
        } else {
            super.onMessageReceived(messageEvent);
        }
    }
}
