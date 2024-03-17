package cn.jiguang.r;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static long a;

    static {
        cn.jiguang.n.d.a("JCommon");
        cn.jiguang.n.d.a("JLocation");
        cn.jiguang.n.d.a("JArp");
    }

    /* JADX WARN: Removed duplicated region for block: B:266:0x019d A[Catch: all -> 0x0311, TryCatch #0 {all -> 0x0311, blocks: (B:178:0x000b, B:180:0x0011, B:182:0x0017, B:184:0x001d, B:186:0x0025, B:187:0x0029, B:188:0x0036, B:230:0x00c8, B:232:0x00d7, B:233:0x00dd, B:235:0x00e2, B:237:0x00f3, B:238:0x0107, B:240:0x0113, B:243:0x0119, B:245:0x0123, B:246:0x0132, B:247:0x0147, B:249:0x0151, B:252:0x015b, B:254:0x0160, B:256:0x0165, B:258:0x016f, B:260:0x017b, B:263:0x0185, B:264:0x0199, B:266:0x019d, B:269:0x01a4, B:270:0x01a8, B:309:0x022b, B:311:0x0233, B:313:0x0239, B:314:0x023e, B:316:0x024a, B:317:0x024f, B:318:0x0258, B:320:0x0264, B:321:0x0270, B:322:0x027a, B:325:0x028f, B:328:0x0298, B:329:0x029c, B:330:0x02a0, B:331:0x02ce, B:333:0x02d8, B:272:0x01ad, B:275:0x01b9, B:278:0x01c5, B:281:0x01cf, B:284:0x01da, B:287:0x01e4, B:290:0x01ef, B:293:0x01fa, B:296:0x0204, B:299:0x020e, B:302:0x0219, B:334:0x02f5, B:336:0x02f9, B:339:0x0300, B:342:0x030a, B:190:0x003b, B:193:0x0048, B:196:0x0054, B:199:0x005f, B:202:0x0069, B:205:0x0073, B:208:0x007f, B:211:0x0089, B:214:0x0093, B:217:0x009d, B:220:0x00a7, B:223:0x00b1), top: B:347:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x01a4 A[Catch: all -> 0x0311, TryCatch #0 {all -> 0x0311, blocks: (B:178:0x000b, B:180:0x0011, B:182:0x0017, B:184:0x001d, B:186:0x0025, B:187:0x0029, B:188:0x0036, B:230:0x00c8, B:232:0x00d7, B:233:0x00dd, B:235:0x00e2, B:237:0x00f3, B:238:0x0107, B:240:0x0113, B:243:0x0119, B:245:0x0123, B:246:0x0132, B:247:0x0147, B:249:0x0151, B:252:0x015b, B:254:0x0160, B:256:0x0165, B:258:0x016f, B:260:0x017b, B:263:0x0185, B:264:0x0199, B:266:0x019d, B:269:0x01a4, B:270:0x01a8, B:309:0x022b, B:311:0x0233, B:313:0x0239, B:314:0x023e, B:316:0x024a, B:317:0x024f, B:318:0x0258, B:320:0x0264, B:321:0x0270, B:322:0x027a, B:325:0x028f, B:328:0x0298, B:329:0x029c, B:330:0x02a0, B:331:0x02ce, B:333:0x02d8, B:272:0x01ad, B:275:0x01b9, B:278:0x01c5, B:281:0x01cf, B:284:0x01da, B:287:0x01e4, B:290:0x01ef, B:293:0x01fa, B:296:0x0204, B:299:0x020e, B:302:0x0219, B:334:0x02f5, B:336:0x02f9, B:339:0x0300, B:342:0x030a, B:190:0x003b, B:193:0x0048, B:196:0x0054, B:199:0x005f, B:202:0x0069, B:205:0x0073, B:208:0x007f, B:211:0x0089, B:214:0x0093, B:217:0x009d, B:220:0x00a7, B:223:0x00b1), top: B:347:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x02f9 A[Catch: all -> 0x0311, TryCatch #0 {all -> 0x0311, blocks: (B:178:0x000b, B:180:0x0011, B:182:0x0017, B:184:0x001d, B:186:0x0025, B:187:0x0029, B:188:0x0036, B:230:0x00c8, B:232:0x00d7, B:233:0x00dd, B:235:0x00e2, B:237:0x00f3, B:238:0x0107, B:240:0x0113, B:243:0x0119, B:245:0x0123, B:246:0x0132, B:247:0x0147, B:249:0x0151, B:252:0x015b, B:254:0x0160, B:256:0x0165, B:258:0x016f, B:260:0x017b, B:263:0x0185, B:264:0x0199, B:266:0x019d, B:269:0x01a4, B:270:0x01a8, B:309:0x022b, B:311:0x0233, B:313:0x0239, B:314:0x023e, B:316:0x024a, B:317:0x024f, B:318:0x0258, B:320:0x0264, B:321:0x0270, B:322:0x027a, B:325:0x028f, B:328:0x0298, B:329:0x029c, B:330:0x02a0, B:331:0x02ce, B:333:0x02d8, B:272:0x01ad, B:275:0x01b9, B:278:0x01c5, B:281:0x01cf, B:284:0x01da, B:287:0x01e4, B:290:0x01ef, B:293:0x01fa, B:296:0x0204, B:299:0x020e, B:302:0x0219, B:334:0x02f5, B:336:0x02f9, B:339:0x0300, B:342:0x030a, B:190:0x003b, B:193:0x0048, B:196:0x0054, B:199:0x005f, B:202:0x0069, B:205:0x0073, B:208:0x007f, B:211:0x0089, B:214:0x0093, B:217:0x009d, B:220:0x00a7, B:223:0x00b1), top: B:347:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0300 A[Catch: all -> 0x0311, TryCatch #0 {all -> 0x0311, blocks: (B:178:0x000b, B:180:0x0011, B:182:0x0017, B:184:0x001d, B:186:0x0025, B:187:0x0029, B:188:0x0036, B:230:0x00c8, B:232:0x00d7, B:233:0x00dd, B:235:0x00e2, B:237:0x00f3, B:238:0x0107, B:240:0x0113, B:243:0x0119, B:245:0x0123, B:246:0x0132, B:247:0x0147, B:249:0x0151, B:252:0x015b, B:254:0x0160, B:256:0x0165, B:258:0x016f, B:260:0x017b, B:263:0x0185, B:264:0x0199, B:266:0x019d, B:269:0x01a4, B:270:0x01a8, B:309:0x022b, B:311:0x0233, B:313:0x0239, B:314:0x023e, B:316:0x024a, B:317:0x024f, B:318:0x0258, B:320:0x0264, B:321:0x0270, B:322:0x027a, B:325:0x028f, B:328:0x0298, B:329:0x029c, B:330:0x02a0, B:331:0x02ce, B:333:0x02d8, B:272:0x01ad, B:275:0x01b9, B:278:0x01c5, B:281:0x01cf, B:284:0x01da, B:287:0x01e4, B:290:0x01ef, B:293:0x01fa, B:296:0x0204, B:299:0x020e, B:302:0x0219, B:334:0x02f5, B:336:0x02f9, B:339:0x0300, B:342:0x030a, B:190:0x003b, B:193:0x0048, B:196:0x0054, B:199:0x005f, B:202:0x0069, B:205:0x0073, B:208:0x007f, B:211:0x0089, B:214:0x0093, B:217:0x009d, B:220:0x00a7, B:223:0x00b1), top: B:347:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(final android.content.Context r17, java.lang.String r18, final java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.r.b.a(android.content.Context, java.lang.String, java.lang.Object):java.lang.Object");
    }

    private static JSONObject a(Bundle bundle) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bundle.getByteArray("RESPONSE_BODY"));
            a = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            cn.jiguang.ak.a.a("JCommonActionHelper", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e) {
            cn.jiguang.ak.a.d("JCommonActionHelper", "parseBundle2Json exception:" + e.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i) {
        long a2 = d.a();
        String a3 = cn.jiguang.q.b.a(context, i);
        byte[] a4 = d.a(a, a3);
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", 25);
        bundle.putInt("ver", 1);
        bundle.putLong("rid", a2);
        bundle.putLong(com.alipay.sdk.data.a.Q, 0L);
        bundle.putByteArray(SDKConstants.PARAM_A2U_BODY, a4);
        if (!TextUtils.isEmpty(a3)) {
            cn.jiguang.ak.a.a("JCommonActionHelper", "tcp report deviceInfo:" + a3);
        }
        cn.jiguang.n.d.a(context, bundle);
    }

    private static void a(Context context, Bundle bundle) {
        cn.jiguang.n.a a2;
        JSONObject a3 = a(bundle);
        if (a3 == null) {
            return;
        }
        int optInt = a3.optInt("cmd");
        a(context, optInt);
        if (optInt == 5 || optInt == 45) {
            if (!cn.jiguang.i.a.a().a(1500) || !cn.jiguang.d.a.l(context)) {
                return;
            }
            a2 = cn.jiguang.ah.a.a();
        } else if (optInt == 50) {
            cn.jiguang.an.b.a(context, a3);
            return;
        } else if (optInt != 52) {
            if (optInt == 55) {
                if (cn.jiguang.i.a.a().d(2200)) {
                    cn.jiguang.n.d.a(context, a3);
                    return;
                }
                return;
            } else if (optInt == 70) {
                cn.jiguang.an.a.a(context);
                return;
            } else if (optInt != 79) {
                return;
            } else {
                cn.jiguang.aj.e.a().b(context, 0);
                return;
            }
        } else if (!cn.jiguang.i.a.a().a(1600)) {
            return;
        } else {
            a2 = cn.jiguang.k.b.a();
        }
        a2.a(context, a3);
    }

    public static int b(Object obj) {
        return ((obj instanceof Bundle) && ((Bundle) obj).getBoolean("login")) ? 2 : 0;
    }

    public static void b(final Context context, final Object obj) {
        cn.jiguang.i.a a2 = cn.jiguang.i.a.a();
        if (a2.a(1600)) {
            cn.jiguang.k.b.a().a(context, a2.b(1600));
        }
        if (a2.a(1500) && cn.jiguang.d.a.l(context)) {
            int b = a2.b(1500);
            cn.jiguang.ah.a.a().a(context, b);
            cn.jiguang.aj.e.a().a(context, b);
        }
        if (a2.a(1800)) {
            cn.jiguang.n.d.a(new cn.jiguang.n.e() { // from class: cn.jiguang.r.b.2
                @Override // cn.jiguang.n.e
                public void a() {
                    cn.jiguang.al.a.a(context, b.b(obj));
                }
            }, a2.b(1800));
        }
        if (a2.a(1000)) {
            cn.jiguang.p.b.a().a(context, a2.b(1000));
        }
        if (a2.d(1200)) {
            cn.jiguang.p.c.a().a(context, a2.b(1200));
        }
        if (a2.d(1900)) {
            cn.jiguang.p.d.a().a(context, a2.b(1900));
        }
        cn.jiguang.an.a.a(context, "heartbeat");
        cn.jiguang.an.b.a(context, null);
        cn.jiguang.an.d.a().b(context);
        cn.jiguang.p.e.a().b(context);
    }
}
