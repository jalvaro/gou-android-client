package com.gou.client;

import android.app.Application;
import android.util.Log;

/**
 * Created by jordi on 31/01/16.
 */
public class GouApplication extends Application {
    private static final String LOG_TAG = GouApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();

        initManagers();
    }

    private void initManagers() {
        Log.d(LOG_TAG, "Initialising managers");
    }
}
