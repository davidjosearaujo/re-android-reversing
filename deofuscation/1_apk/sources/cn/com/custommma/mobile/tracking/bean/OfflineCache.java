package cn.com.custommma.mobile.tracking.bean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class OfflineCache {
    public String length;
    public String queueExpirationSecs;
    public String timeout;

    public String toString() {
        return "<offlineCache>\r\n<length>" + this.length + "</length>\r\n<queueExpirationSecs>" + this.queueExpirationSecs + "</queueExpirationSecs>\r\n<timeout>" + this.timeout + "</timeout></offlineCache>\r\n";
    }
}
