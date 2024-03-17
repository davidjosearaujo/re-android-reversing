package com.hunantv.media.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.hunantv.media.player.pragma.DebugLog;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvPlayerBroadcastObserver {
    private static final String TAG = "MgtvPlayerBroadcastObserver";
    public static final int TYPE_NONE = -1;
    private Context mContext;
    private OnBluetoothHeadsetListener onBluetoothHeadsetListener;
    private OnHeadsetListener onHeadsetListener;
    private OnNetworkChangeListener onNetworkChangeListener;
    private MgtvPlayerBroadcastReceiver receiver;
    private int mCurrentNetType = -1;
    private Object lock = new Object();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class MgtvPlayerBroadcastReceiver extends BroadcastReceiver {
        public WeakReference<MgtvPlayerBroadcastObserver> observerWeakReference;

        public MgtvPlayerBroadcastReceiver(MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver) {
            this.observerWeakReference = new WeakReference<>(mgtvPlayerBroadcastObserver);
        }

        private void bluetoothStateChange(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "bluetoothStateChange in.state:" + intExtra);
            MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver = this.observerWeakReference.get();
            if (mgtvPlayerBroadcastObserver != null && mgtvPlayerBroadcastObserver.onBluetoothHeadsetListener != null) {
                mgtvPlayerBroadcastObserver.onBluetoothHeadsetListener.onBluetoothHeadsetStateChange(intExtra);
            }
            DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "bluetoothStateChange out");
        }

        private void connectivityChange(Context context, Intent intent) {
            int i;
            DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "connectivityChange in");
            int currentNetworkType = MgtvPlayerBroadcastObserver.getCurrentNetworkType(context);
            MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver = this.observerWeakReference.get();
            if (mgtvPlayerBroadcastObserver != null && (i = mgtvPlayerBroadcastObserver.mCurrentNetType) != currentNetworkType) {
                mgtvPlayerBroadcastObserver.mCurrentNetType = currentNetworkType;
                DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "connectivityChange currentType:" + currentNetworkType);
                OnNetworkChangeListener onNetworkChangeListener = mgtvPlayerBroadcastObserver.onNetworkChangeListener;
                if (onNetworkChangeListener != null) {
                    onNetworkChangeListener.onNetworkChanged(i, currentNetworkType);
                }
            }
            DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "connectivityChange out");
        }

        private void headsetStateChange(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("state", 0);
            DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "headsetStateChange in.state:" + intExtra);
            MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver = this.observerWeakReference.get();
            if (mgtvPlayerBroadcastObserver != null && mgtvPlayerBroadcastObserver.onHeadsetListener != null) {
                mgtvPlayerBroadcastObserver.onHeadsetListener.onHeadsetStateChange(intExtra);
            }
            DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "headsetStateChange out");
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            DebugLog.i(MgtvPlayerBroadcastObserver.TAG, "action" + intent.getAction());
            String action = intent.getAction();
            action.hashCode();
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -1676458352:
                    if (action.equals("android.intent.action.HEADSET_PLUG")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1172645946:
                    if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    headsetStateChange(context, intent);
                    return;
                case 1:
                    connectivityChange(context, intent);
                    return;
                case 2:
                    bluetoothStateChange(context, intent);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnBluetoothHeadsetListener {
        void onBluetoothHeadsetStateChange(int i);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnHeadsetListener {
        void onHeadsetStateChange(int i);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnNetworkChangeListener {
        void onNetworkChanged(int i, int i2);
    }

    public MgtvPlayerBroadcastObserver(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public static int getCurrentNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
            if (activeNetworkInfo == null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType();
            }
        }
        activeNetworkInfo = null;
        return activeNetworkInfo == null ? -1 : -1;
    }

    public void finalize() throws Throwable {
        super.finalize();
        unregister();
    }

    public void register() {
        synchronized (this.lock) {
            if (this.receiver != null) {
                DebugLog.i(TAG, "already register");
                return;
            }
            if (this.mContext != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.setPriority(1000);
                this.mCurrentNetType = getCurrentNetworkType(this.mContext);
                MgtvPlayerBroadcastReceiver mgtvPlayerBroadcastReceiver = new MgtvPlayerBroadcastReceiver(this);
                this.receiver = mgtvPlayerBroadcastReceiver;
                this.mContext.registerReceiver(mgtvPlayerBroadcastReceiver, intentFilter);
                DebugLog.i(TAG, "registerReceiver");
            }
        }
    }

    public MgtvPlayerBroadcastObserver setOnBluetoothHeadsetListener(OnBluetoothHeadsetListener onBluetoothHeadsetListener) {
        this.onBluetoothHeadsetListener = onBluetoothHeadsetListener;
        return this;
    }

    public MgtvPlayerBroadcastObserver setOnHeadsetListener(OnHeadsetListener onHeadsetListener) {
        this.onHeadsetListener = onHeadsetListener;
        return this;
    }

    public MgtvPlayerBroadcastObserver setOnNetworkChangeListener(OnNetworkChangeListener onNetworkChangeListener) {
        this.onNetworkChangeListener = onNetworkChangeListener;
        return this;
    }

    public void unregister() {
        MgtvPlayerBroadcastReceiver mgtvPlayerBroadcastReceiver;
        synchronized (this.lock) {
            try {
                Context context = this.mContext;
                if (context != null && (mgtvPlayerBroadcastReceiver = this.receiver) != null) {
                    context.unregisterReceiver(mgtvPlayerBroadcastReceiver);
                    this.receiver = null;
                    DebugLog.i(TAG, "unregisterReceiver");
                }
            } catch (Exception unused) {
            }
        }
    }
}
