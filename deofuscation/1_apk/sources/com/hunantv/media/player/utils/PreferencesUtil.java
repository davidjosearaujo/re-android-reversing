package com.hunantv.media.player.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class PreferencesUtil {
    private static final String PREFERENCE_NAME = "MgtvPlayerConfig";
    public static final String PREKEY_MEDIACODEC_H264_SUPPORT_BASELINE = "prekey_h264_support_base";
    public static final String PREKEY_MEDIACODEC_H264_SUPPORT_HIGH = "prekey_h264_support_high";
    public static final String PREKEY_MEDIACODEC_H264_SUPPORT_MAIN = "prekey_h264_support_main";
    public static final String PREKEY_MEDIACODEC_H265_SUPPORT = "prekey_h265_support";
    private Context mContext;

    public PreferencesUtil(Context context) {
        this.mContext = context;
    }

    private SharedPreferences getSharedPreferences(String str) {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(str, 0);
    }

    private boolean safeCommit(SharedPreferences.Editor editor) {
        try {
            return editor.commit();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        return sharedPreferences == null ? z : sharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public float getFloat(String str, float f) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        return sharedPreferences == null ? f : sharedPreferences.getFloat(str, f);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        return sharedPreferences == null ? i : sharedPreferences.getInt(str, i);
    }

    public long getLong(String str) {
        return getLong(str, -1L);
    }

    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public boolean putBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z);
        return safeCommit(edit);
    }

    public boolean putFloat(String str, float f) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putFloat(str, f);
        return safeCommit(edit);
    }

    public boolean putInt(String str, int i) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        return safeCommit(edit);
    }

    public boolean putLong(String str, long j) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        return safeCommit(edit);
    }

    public boolean putString(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        return safeCommit(edit);
    }

    public void removeKey(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str);
        safeCommit(edit);
    }
}
