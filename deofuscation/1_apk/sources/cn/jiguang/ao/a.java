package cn.jiguang.ao;

import cn.jiguang.internal.JConstants;
import java.util.List;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public Map<String, d> k;
    public List<String> o;
    public List<String> p;
    public List<String> w;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public int f = 5;
    public long g = 1800000;
    public boolean h = true;
    public boolean i = true;
    public int j = 0;
    public long l = JConstants.HOUR;
    public long m = JConstants.HOUR;
    public String n = "disable";
    public long q = 1800000;
    public long r = 1800000;
    public long s = 7200000;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;

    public String toString() {
        return "JWakeConfigInfo{wakeEnableByAppKey=" + this.a + ", beWakeEnableByAppKey=" + this.b + ", wakeEnableByUId=" + this.c + ", beWakeEnableByUId=" + this.d + ", ignorLocal=" + this.e + ", maxWakeCount=" + this.f + ", wakeInterval=" + this.g + ", wakeTimeEnable=" + this.h + ", noWakeTimeConfig=" + this.i + ", apiType=" + this.j + ", wakeTypeInfoMap=" + this.k + ", wakeConfigInterval=" + this.l + ", wakeReportInterval=" + this.m + ", config='" + this.n + "', pkgList=" + this.o + ", blackPackageList=" + this.p + ", accountWakeInterval=" + this.q + ", dactivityWakeInterval=" + this.r + ", activityWakeInterval=" + this.s + ", wakeReportEnable=" + this.t + ", beWakeReportEnable=" + this.u + ", appUnsupportedWakeupType=" + this.v + ", blacklistThirdPackage=" + this.w + '}';
    }
}
