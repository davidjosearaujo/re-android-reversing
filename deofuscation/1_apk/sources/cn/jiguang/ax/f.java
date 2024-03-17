package cn.jiguang.ax;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f extends Exception {
    public final int a;

    public f(int i, String str) {
        super(str);
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "JException(" + this.a + "):" + getLocalizedMessage();
    }
}
