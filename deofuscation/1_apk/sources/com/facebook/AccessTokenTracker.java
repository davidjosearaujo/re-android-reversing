package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class AccessTokenTracker {
    private static final String TAG = "AccessTokenTracker";
    private final LocalBroadcastManager broadcastManager;
    private boolean isTracking = false;
    private final BroadcastReceiver receiver;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
        private CurrentAccessTokenBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED.equals(intent.getAction())) {
                Utility.logd(AccessTokenTracker.TAG, "AccessTokenChanged");
                AccessTokenTracker.this.onCurrentAccessTokenChanged((AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_OLD_ACCESS_TOKEN), (AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_NEW_ACCESS_TOKEN));
            }
        }
    }

    public AccessTokenTracker() {
        Validate.sdkInitialized();
        this.receiver = new CurrentAccessTokenBroadcastReceiver();
        this.broadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
        startTracking();
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2);

    public void startTracking() {
        if (this.isTracking) {
            return;
        }
        addBroadcastReceiver();
        this.isTracking = true;
    }

    public void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.unregisterReceiver(this.receiver);
            this.isTracking = false;
        }
    }
}
