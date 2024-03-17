package cn.jpush.android.n;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d extends JPushResponse {
    private int a;
    private JSONObject b;
    private JSONArray c;

    public d(int i, long j, long j2, ByteBuffer byteBuffer) {
        super(i, j, j2, byteBuffer);
        this.a = -1;
        parseBody();
    }

    public d(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public JSONObject a() {
        return this.b;
    }

    public JSONArray b() {
        return this.c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer == null) {
                Logger.ww("GeoPullResponse", "geo pull response empty");
                return;
            }
            short s = byteBuffer.getShort();
            this.a = s;
            if (s != 0) {
                Logger.ww("GeoPullResponse", "geo pull response error code :" + this.a);
                return;
            }
            byte[] bArr = new byte[this.body.getShort()];
            this.body.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("GeoPullResponse", "receive content：" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.c = jSONObject.getJSONArray("geofence");
            jSONObject.remove("geofence");
            this.b = jSONObject;
        } catch (Throwable unused) {
            Logger.ww("GeoPullResponse", "parse geo pull response failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoPullResponse] - limit:" + this.b + " - geoArray:" + this.c + " - " + super.toString();
    }
}
