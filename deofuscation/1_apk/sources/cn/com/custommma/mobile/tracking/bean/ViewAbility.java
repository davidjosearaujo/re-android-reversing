package cn.com.custommma.mobile.tracking.bean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbility {
    public int intervalTime;
    public int maxAmount;
    public int maxExpirationSecs;
    public int viewabilityFrame;
    public int viewabilityTime;
    public int viewabilityVideoTime;

    public String toString() {
        return "[ interval:" + this.intervalTime + ",framerate:" + this.viewabilityFrame + ",abilitytime:" + this.viewabilityTime + ",viewabilityVideoTime:" + this.viewabilityVideoTime + ",maxtime:" + this.maxExpirationSecs + ",maxAmount:" + this.maxAmount + " ]";
    }
}
