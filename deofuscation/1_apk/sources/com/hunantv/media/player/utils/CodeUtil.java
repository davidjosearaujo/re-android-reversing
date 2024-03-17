package com.hunantv.media.player.utils;

import com.hunantv.media.player.datasource.p2p.MGTVP2pDirectMediaDataSource;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CodeUtil {
    public static boolean isHttp403(int i, int i2) {
        return i == 400403 || MGTVP2pDirectMediaDataSource.isP2pDirectHttp403(i, i2);
    }

    public static boolean isHttp410(int i, int i2) {
        return i == 400410 || MGTVP2pDirectMediaDataSource.isP2pDirectHttp410(i, i2);
    }

    public static boolean isHttp4XX(int i, int i2) {
        if (i < 400400 || i > 400499) {
            return (i2 >= 300400 && i2 <= 300499) || (i2 >= 301400 && i2 <= 301499) || MGTVP2pDirectMediaDataSource.isP2pDirectHttp4XX(i, i2);
        }
        return true;
    }

    public static boolean isHttp5XX(int i, int i2) {
        if (i < 400500 || i > 400599) {
            return (i2 >= 300500 && i2 <= 300599) || (i2 >= 301500 && i2 <= 301599) || MGTVP2pDirectMediaDataSource.isP2pDirectHttp5XX(i, i2);
        }
        return true;
    }
}
