package com.hunantv.media.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StreamUtil {
    public static InputStream createFileInputStream(String str) {
        if (com.hunantv.media.player.utils.StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            return new FileInputStream(new File(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
