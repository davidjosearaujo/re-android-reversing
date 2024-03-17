package com.hunantv.media.player.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioMetadata;
import android.media.Spatializer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c.a.a.b.d.g;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.StringUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvPlayerSpatializer {
    private static final String TAG = "MgtvPlayerSpatializer";
    private static boolean isTestSupported;
    private static String mHash;
    @Nullable
    private Handler handler;
    @Nullable
    private Spatializer.OnSpatializerStateChangedListener listener;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private boolean spatializationSupported;
    private Spatializer spatializer;

    private MgtvPlayerSpatializer() {
    }

    @RequiresApi(api = 33)
    private MgtvPlayerSpatializer(Spatializer spatializer) {
        this.spatializer = spatializer;
        this.spatializationSupported = spatializer.getImmersiveAudioLevel() != 0;
    }

    public static boolean isSpatializationSupported() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSpatializationSupported : ");
        int i = Build.VERSION.SDK_INT;
        sb.append(i >= 33 && g.y());
        DebugLog.i(TAG, sb.toString());
        return (i >= 33 && g.y()) || isTestSupported;
    }

    public static void setTestApi(boolean z) {
        isTestSupported = z;
    }

    @Nullable
    public static synchronized MgtvPlayerSpatializer tryCreateInstance(Context context, String str) {
        synchronized (MgtvPlayerSpatializer.class) {
            if (Build.VERSION.SDK_INT < 33) {
                return new MgtvPlayerSpatializer();
            }
            mHash = str;
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            return audioManager == null ? null : new MgtvPlayerSpatializer(audioManager.getSpatializer());
        }
    }

    public boolean canBeSpatialized(AudioAttributes audioAttributes, AudioMetadata.Format format) {
        return false;
    }

    public void ensureInitialized(final MgtvPlayerListener.OnSpatializerInfoListener onSpatializerInfoListener, Looper looper) {
        if (Build.VERSION.SDK_INT >= 33 && this.listener == null && this.handler == null) {
            this.listener = new Spatializer.OnSpatializerStateChangedListener() { // from class: com.hunantv.media.player.helper.MgtvPlayerSpatializer.1
                @Override // android.media.Spatializer.OnSpatializerStateChangedListener
                public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                    DebugLog.i(MgtvPlayerSpatializer.TAG, "onSpatializerAvailableChanged :" + z);
                    onSpatializerInfoListener.onSpatializerStateChanged(spatializer.isAvailable());
                }

                @Override // android.media.Spatializer.OnSpatializerStateChangedListener
                public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                    DebugLog.i(MgtvPlayerSpatializer.TAG, "onSpatializerEnabledChanged :" + z);
                    onSpatializerInfoListener.onSpatializerStateChanged(spatializer.isAvailable());
                }
            };
            this.handler = new Handler(looper);
            this.spatializer.addOnSpatializerStateChangedListener(this.mExecutorService, this.listener);
        }
    }

    public boolean isAvailable() {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        DebugLog.i(TAG, "isAvailable : " + this.spatializer.isAvailable());
        return this.spatializer.isAvailable();
    }

    public boolean isEnabled() {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        DebugLog.i(TAG, "isEnabled : " + this.spatializer.isAvailable());
        return this.spatializer.isEnabled();
    }

    public boolean isInnerSpatializationSupported() {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        DebugLog.i(TAG, "isInnerSpatializationSupported : " + this.spatializationSupported);
        return this.spatializationSupported;
    }

    @SuppressLint({"SuspiciousIndentation"})
    public synchronized void release(String str) {
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        DebugLog.i(TAG, "release , hash = " + str);
        if (this.listener != null && this.handler != null && !StringUtil.isEmpty(str) && !StringUtil.isEmpty(mHash) && mHash.equals(str)) {
            this.spatializer.removeOnSpatializerStateChangedListener(this.listener);
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
            this.listener = null;
        }
    }
}
