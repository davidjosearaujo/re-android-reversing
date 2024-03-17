package cn.jpush.android.api;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CustomMessage {
    public String appId;
    public String contentType;
    public String extra;
    public String message;
    public String messageId;
    public byte platform;
    public String senderId;
    public String title;

    public String toString() {
        return "CustomMessage{messageId='" + this.messageId + "', extra='" + this.extra + "', message='" + this.message + "', contentType='" + this.contentType + "', title='" + this.title + "', senderId='" + this.senderId + "', appId='" + this.appId + "', platform='" + ((int) this.platform) + "'}";
    }
}
