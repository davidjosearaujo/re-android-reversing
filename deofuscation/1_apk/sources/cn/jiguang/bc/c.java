package cn.jiguang.bc;

import android.util.SparseArray;
import com.alibaba.fastjson.JSONStreamContext;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static final SparseArray<String> a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(0, "OK");
        sparseArray.put(-1001, "Exceed buffer size. Please contact support.");
        sparseArray.put(-1000, "Connection failed. Please check your connection and retry later!");
        sparseArray.put(-998, "Sending failed or timeout. Please Retry later!");
        sparseArray.put(-997, "Receiving failed or timeout. Please Retry later!");
        sparseArray.put(-996, "Connection is closed. Please Retry later!");
        sparseArray.put(-994, "Response timeout. Please Retry later!");
        sparseArray.put(-993, "Invalid socket. Please Retry later!");
        sparseArray.put(11, "Failed to register!");
        sparseArray.put(JSONStreamContext.ArrayValue, "Your appKey and android package name are not matched. Please double check them according to Application you created on Portal.");
        sparseArray.put(1006, "You android package name is not exist, Please register your pacakge name in Portal.");
        sparseArray.put(1007, "Invalid Imei, Register again.");
        sparseArray.put(1008, "Invalid appKey, Please get your Appkey from JIGUANG web console!");
        sparseArray.put(1009, "Your appKey is related to a non-Android App.Please use your Android App's appKey, or add an Android app for this appKey.");
        sparseArray.put(10000, "Receiver data parse error");
        sparseArray.put(102, "102 - Incorrect password");
        sparseArray.put(108, "108 - Incorrect uid");
        sparseArray.put(1012, "Server reject this connection, will clear cache and restart connect.");
    }

    public static String a(int i) {
        SparseArray<String> sparseArray = a;
        if (sparseArray.get(i) == null) {
            cn.jiguang.ar.c.c("StatusCode", "Unknown error code - " + i);
            return null;
        }
        return sparseArray.get(i);
    }
}
