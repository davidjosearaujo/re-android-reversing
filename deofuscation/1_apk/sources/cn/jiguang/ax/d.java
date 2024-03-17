package cn.jiguang.ax;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    public int a = 0;
    public long b;
    public String c;
    public int d;
    public int e;
    public long f;
    public byte[] g;
    public long h;
    public long i;
    public boolean j;

    public d(long j, String str, int i, int i2, long j2, long j3, byte[] bArr) {
        this.b = j;
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = j2;
        this.i = j3;
        this.g = bArr;
        if (j3 > 0) {
            this.j = true;
        }
    }

    public void a() {
        this.a++;
    }

    public String toString() {
        return "InnerRequest{times=" + this.a + ", requestId=" + this.b + ", sdkType='" + this.c + "', command=" + this.d + ", ver=" + this.e + ", rid=" + this.f + ", reqeustTime=" + this.h + ", timeout=" + this.i + '}';
    }
}
