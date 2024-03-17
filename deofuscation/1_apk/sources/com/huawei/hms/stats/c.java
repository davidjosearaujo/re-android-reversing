package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* compiled from: HianalyticsExist.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static final Object a = new Object();
    public static boolean b;
    public static boolean c;

    public static boolean a() {
        boolean z;
        synchronized (a) {
            if (!b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    c = true;
                }
                b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + c);
            }
        }
        return c;
    }
}