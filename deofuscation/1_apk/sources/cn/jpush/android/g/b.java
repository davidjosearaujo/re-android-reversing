package cn.jpush.android.g;

import android.content.Intent;
import android.text.TextUtils;
import cn.asus.push.DataBuffer;
import cn.jiguang.push.asus.PushMessageReceiver;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class b extends i.a.a.c {
    public final void call(DataBuffer dataBuffer) {
        try {
            cn.jpush.android.i.b.a("ClientAIDLCallBack", "[call] data:" + String.valueOf(dataBuffer) + ",cmd:" + dataBuffer.cmd);
            String str = dataBuffer.cmd;
            long j = dataBuffer.bundle.getLong("message_rid", -1L);
            String string = dataBuffer.bundle.getString("message_content");
            String b = cn.jpush.android.f.c.b(cn.jpush.android.f.c.a);
            if (TextUtils.isEmpty(b)) {
                Intent intent = new Intent();
                dataBuffer.bundle.putString("message_cmd", dataBuffer.cmd);
                intent.putExtras(dataBuffer.bundle);
                intent.setAction("com.ups.push.PUSH_RESPONSE");
                intent.setPackage(cn.jpush.android.f.c.c);
                cn.jpush.android.f.c.a.sendBroadcast(intent);
            } else {
                ((PushMessageReceiver) Class.forName(b).newInstance()).a(cn.jpush.android.f.c.a, j, str, string);
            }
        } catch (Throwable unused) {
        }
    }
}
