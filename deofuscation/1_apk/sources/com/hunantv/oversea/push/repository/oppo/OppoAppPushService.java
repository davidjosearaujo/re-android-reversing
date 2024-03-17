package com.hunantv.oversea.push.repository.oppo;

import android.content.Context;
import com.heytap.mcssdk.AppPushService;
import j.j.a.n.b;
import j.j.a.n.h;
import j.l.a.n.m.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class OppoAppPushService extends AppPushService {
    private static final String a = "OppoAppPushService";

    public void a(Context context, b bVar) {
        super.a(context, bVar);
        a.i("0", a, "Receive Opush CommandMessage:" + bVar.l() + ",Params=" + bVar.m());
    }

    public void b(Context context, j.j.a.n.a aVar) {
        super.b(context, aVar);
        a.i("0", a, "Receive Opush AppMessage:" + aVar.j() + ",getTitle=" + aVar.q());
    }

    public void c(Context context, h hVar) {
        super.c(context, hVar);
        a.i("0", a, "Receive Opush SptDataMessage:" + hVar.j() + ",Desc=" + hVar.k());
    }
}
