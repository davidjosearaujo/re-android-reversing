package cn.jpush.android.z;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends JPushResponse {
    private int a;
    private long b;
    private int c;

    public b(int i, long j, long j2, ByteBuffer byteBuffer) {
        super(i, j, j2, byteBuffer);
        this.a = 0;
        this.b = 300000L;
        this.c = 5;
        parseBody();
    }

    public b(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer != null) {
                byte[] bArr = new byte[byteBuffer.getShort()];
                this.body.get(bArr);
                String str = new String(bArr, "UTF-8");
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    this.a = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE, 0);
                    this.b = jSONObject.optLong("timeInterval", 300000L);
                    this.c = jSONObject.optInt("limitCount", 5);
                }
                Logger.d("MessagePush", "[parseBody]: code=" + this.a + ", reqTimeInterval=" + this.b + ", reqLimitCount=" + this.c);
            }
        } catch (Throwable unused) {
            Logger.ww("MessagePush", "parse in app pull response failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[InAppPullResponse] - code:" + this.a + ", reqTimeInterval:" + this.b + ", reqLimitCount:" + this.c + " - " + super.toString();
    }
}
