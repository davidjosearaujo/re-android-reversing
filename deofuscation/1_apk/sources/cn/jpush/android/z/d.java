package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d extends JPushResponse {
    public int a;
    public long b;
    public String c;

    public d(int i, long j, long j2, ByteBuffer byteBuffer) {
        super(i, j, j2, byteBuffer);
        parseBody();
    }

    public d(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            this.a = this.body.get();
            this.b = this.body.getLong();
            byte[] bArr = new byte[this.body.getShort()];
            this.body.get(bArr);
            this.c = new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            Logger.ww("MessagePush", "parse msg content failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[MessagePush] - msgType:" + this.a + ", msgId:" + this.b + ", msgContent:" + this.c + " - " + super.toString();
    }
}
