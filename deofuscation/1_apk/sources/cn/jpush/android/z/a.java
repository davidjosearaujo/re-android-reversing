package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends JPushResponse {
    private int a;

    public a(int i, long j, long j2, ByteBuffer byteBuffer) {
        super(i, j, j2, byteBuffer);
        parseBody();
    }

    public a(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            this.a = this.body.getShort();
        } catch (Throwable th) {
            Logger.ww("CommonResponse", "parse code failed :" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[CommonResponse] - " + this.a;
    }
}
