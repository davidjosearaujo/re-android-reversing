package com.hunantv.media.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.hunantv.media.player.pragma.DebugLog;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AudioUtil {
    private static final String TAG = "AudioUtil";
    private static volatile HeadsetPlugReceiver mHeadsetPlugReceiver;
    private static Object sLock = new Object();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class HeadsetPlugReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager == null || !intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                    return;
                }
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 0) {
                    audioManager.setSpeakerphoneOn(true);
                    str = "setSpeakerphoneOn true";
                } else if (intExtra != 1) {
                    return;
                } else {
                    audioManager.setSpeakerphoneOn(false);
                    str = "setSpeakerphoneOn false";
                }
                DebugLog.i(AudioUtil.TAG, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void abandonAudioFocus(Context context) {
        if (context == null) {
            return;
        }
        DebugLog.i(TAG, "abandonAudioFocus");
        try {
            ((AudioManager) context.getSystemService("audio")).abandonAudioFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWired(Context context) {
        AudioManager audioManager;
        int i;
        if (context == null) {
            return false;
        }
        try {
            audioManager = (AudioManager) context.getSystemService("audio");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 23) {
            return audioManager.isWiredHeadsetOn() || audioManager.isBluetoothScoOn() || audioManager.isBluetoothA2dpOn();
        }
        AudioDeviceInfo[] devices = audioManager.getDevices(2);
        int length = devices.length;
        while (i < length) {
            int type = devices[i].getType();
            i = (type == 3 || type == 4 || type == 8 || type == 7) ? 0 : i + 1;
            return true;
        }
        return false;
    }

    public static void registerHeadsetReceiverOnce(Context context) {
        Context applicationContext;
        if (mHeadsetPlugReceiver != null || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        synchronized (sLock) {
            if (mHeadsetPlugReceiver == null) {
                mHeadsetPlugReceiver = new HeadsetPlugReceiver();
                applicationContext.registerReceiver(mHeadsetPlugReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            }
        }
    }

    public static void requestAudioFocus(Context context) {
        if (context == null) {
            return;
        }
        DebugLog.i(TAG, "requestAudioFocus");
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AudioManager) context.getSystemService("audio")).requestAudioFocus(null, 3, 2);
                return;
            }
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            context.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unRegisterHeadsetReceiver(Context context) {
        Context applicationContext;
        if (mHeadsetPlugReceiver == null || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        synchronized (sLock) {
            applicationContext.unregisterReceiver(mHeadsetPlugReceiver);
            mHeadsetPlugReceiver = null;
        }
    }
}
