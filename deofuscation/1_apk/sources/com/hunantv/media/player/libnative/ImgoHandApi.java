package com.hunantv.media.player.libnative;

import android.view.Surface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoHandApi {
    public static ImgoImageInfo info;

    public static native void create_overlay(int i, int i2, int i3);

    public static native void display();

    public static native ImgoHandResult execute(ImgoImageInfo imgoImageInfo);

    public static native void free_overlay();

    public static native String get_version();

    public static native void init();

    public static native void set_surface(Surface surface);

    public static native void uninit();
}
