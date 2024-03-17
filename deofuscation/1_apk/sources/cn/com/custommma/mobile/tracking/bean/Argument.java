package cn.com.custommma.mobile.tracking.bean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class Argument {
    public boolean isRequired;
    public boolean urlEncode;
    public String key = "";
    public String value = "";

    public String toString() {
        return "[ key:" + this.key + ",value:" + this.value + ",encode:" + this.urlEncode + ",require:" + this.isRequired + " ]";
    }
}
