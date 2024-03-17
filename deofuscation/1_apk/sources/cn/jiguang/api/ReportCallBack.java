package cn.jiguang.api;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface ReportCallBack {
    public static final int DELIVERED = 1;
    public static final int ERROR = -2;
    public static final int FAILED = -1;
    public static final int OK = 0;

    void onFinish(int i);
}
