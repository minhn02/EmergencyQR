package com.retro.emergencyqr;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.retro.emergencyqr.lib.service.NetworkConnectionReceiver;

import java.util.ArrayList;

/**
 * Created by tommy on 06/June/2019.
 */
public class EmergencyQRApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private ArrayList<Activity> listActivity;

    private static EmergencyQRApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        listActivity = new ArrayList<>();
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        listActivity.add(activity);
    }

    public static synchronized EmergencyQRApplication getInstance() {
        return mInstance;
    }

    public void setConnectionListener(NetworkConnectionReceiver.ConnectionReceiverListener listener) {
        NetworkConnectionReceiver.connectionReceiverListener = listener;
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        listActivity.remove(activity);
    }

    public ArrayList<Activity> getListActivity() {
        return listActivity;
    }
}
