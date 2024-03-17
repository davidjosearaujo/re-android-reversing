package cn.com.custommma.mobile.tracking.api;

import android.content.Context;
import java.util.Objects;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class RecordEventMessage {
    private static RecordEventMessage mInstance;
    private final Context context;

    private RecordEventMessage(Context context) {
        Objects.requireNonNull(context, "RecordEventMessage context can`t be null!");
        this.context = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long getEventExpirationTime(cn.com.custommma.mobile.tracking.bean.Company r7, long r8) {
        /*
            r6 = this;
            r0 = 0
            cn.com.custommma.mobile.tracking.bean.Switch r2 = r7.sswitch     // Catch: java.lang.Exception -> L26
            java.lang.String r2 = r2.offlineCacheExpiration     // Catch: java.lang.Exception -> L26
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L26
            if (r2 != 0) goto L2a
            cn.com.custommma.mobile.tracking.bean.Switch r7 = r7.sswitch     // Catch: java.lang.Exception -> L26
            java.lang.String r7 = r7.offlineCacheExpiration     // Catch: java.lang.Exception -> L26
            java.lang.String r7 = r7.trim()     // Catch: java.lang.Exception -> L26
            long r2 = java.lang.Long.parseLong(r7)     // Catch: java.lang.Exception -> L26
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L26
            long r2 = r7.longValue()     // Catch: java.lang.Exception -> L26
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            long r2 = r2 + r8
            goto L2b
        L26:
            r7 = move-exception
            r7.printStackTrace()
        L2a:
            r2 = r0
        L2b:
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 != 0) goto L34
            r0 = 86400000(0x5265c00, double:4.2687272E-316)
            long r2 = r8 + r0
        L34:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.api.RecordEventMessage.getEventExpirationTime(cn.com.custommma.mobile.tracking.bean.Company, long):long");
    }

    public static RecordEventMessage getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RecordEventMessage.class) {
                if (mInstance == null) {
                    mInstance = new RecordEventMessage(context);
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:23|(1:25)(2:128|(1:130)(17:131|27|28|29|30|(4:33|(2:37|(2:39|(2:41|42)(1:44))(1:45))|43|31)|48|49|(6:52|(3:54|(1:56)(1:61)|57)(2:62|(1:64)(2:65|(1:67)(2:68|(2:70|(3:72|73|60)(1:74))(2:75|(1:77)(2:78|(2:83|(1:85)(2:86|(1:88)(1:89)))(1:82))))))|58|59|60|50)|90|91|92|(1:123)(7:96|(5:101|102|(1:104)(1:121)|105|(2:(1:119)(3:109|110|111)|112)(1:120))|122|102|(0)(0)|105|(0)(0))|113|114|115|116))|26|27|28|29|30|(1:31)|48|49|(1:50)|90|91|92|(1:94)|123|113|114|115|116) */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0303, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0305, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0306, code lost:
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0307, code lost:
        cn.com.custommma.mobile.tracking.util.Logger.e(r0.getMessage());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00e2 A[Catch: Exception -> 0x0305, all -> 0x0330, TryCatch #1 {, blocks: (B:149:0x0005, B:151:0x0016, B:155:0x001e, B:156:0x0028, B:158:0x002e, B:163:0x0043, B:166:0x005f, B:168:0x006a, B:175:0x00c6, B:176:0x00cb, B:177:0x00dc, B:179:0x00e2, B:181:0x00ee, B:183:0x00f6, B:185:0x0101, B:187:0x0119, B:189:0x013b, B:190:0x0144, B:192:0x014c, B:194:0x0162, B:196:0x016f, B:198:0x0173, B:199:0x017c, B:201:0x0184, B:202:0x019c, B:204:0x01a4, B:205:0x01b4, B:207:0x01bc, B:209:0x01de, B:211:0x01e8, B:213:0x01f0, B:214:0x0207, B:216:0x020f, B:218:0x0215, B:219:0x022c, B:221:0x0234, B:222:0x0247, B:224:0x024f, B:225:0x0262, B:228:0x027e, B:230:0x0284, B:232:0x0288, B:234:0x0292, B:239:0x02a0, B:243:0x02a9, B:247:0x02bb, B:249:0x02cb, B:251:0x02e0, B:254:0x02fd, B:261:0x030e, B:260:0x0307, B:250:0x02d0, B:252:0x02f5, B:171:0x0082, B:173:0x008b, B:174:0x00be, B:264:0x0328), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x014c A[Catch: Exception -> 0x0305, all -> 0x0330, TryCatch #1 {, blocks: (B:149:0x0005, B:151:0x0016, B:155:0x001e, B:156:0x0028, B:158:0x002e, B:163:0x0043, B:166:0x005f, B:168:0x006a, B:175:0x00c6, B:176:0x00cb, B:177:0x00dc, B:179:0x00e2, B:181:0x00ee, B:183:0x00f6, B:185:0x0101, B:187:0x0119, B:189:0x013b, B:190:0x0144, B:192:0x014c, B:194:0x0162, B:196:0x016f, B:198:0x0173, B:199:0x017c, B:201:0x0184, B:202:0x019c, B:204:0x01a4, B:205:0x01b4, B:207:0x01bc, B:209:0x01de, B:211:0x01e8, B:213:0x01f0, B:214:0x0207, B:216:0x020f, B:218:0x0215, B:219:0x022c, B:221:0x0234, B:222:0x0247, B:224:0x024f, B:225:0x0262, B:228:0x027e, B:230:0x0284, B:232:0x0288, B:234:0x0292, B:239:0x02a0, B:243:0x02a9, B:247:0x02bb, B:249:0x02cb, B:251:0x02e0, B:254:0x02fd, B:261:0x030e, B:260:0x0307, B:250:0x02d0, B:252:0x02f5, B:171:0x0082, B:173:0x008b, B:174:0x00be, B:264:0x0328), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x02f5 A[Catch: Exception -> 0x0303, all -> 0x0330, TryCatch #1 {, blocks: (B:149:0x0005, B:151:0x0016, B:155:0x001e, B:156:0x0028, B:158:0x002e, B:163:0x0043, B:166:0x005f, B:168:0x006a, B:175:0x00c6, B:176:0x00cb, B:177:0x00dc, B:179:0x00e2, B:181:0x00ee, B:183:0x00f6, B:185:0x0101, B:187:0x0119, B:189:0x013b, B:190:0x0144, B:192:0x014c, B:194:0x0162, B:196:0x016f, B:198:0x0173, B:199:0x017c, B:201:0x0184, B:202:0x019c, B:204:0x01a4, B:205:0x01b4, B:207:0x01bc, B:209:0x01de, B:211:0x01e8, B:213:0x01f0, B:214:0x0207, B:216:0x020f, B:218:0x0215, B:219:0x022c, B:221:0x0234, B:222:0x0247, B:224:0x024f, B:225:0x0262, B:228:0x027e, B:230:0x0284, B:232:0x0288, B:234:0x0292, B:239:0x02a0, B:243:0x02a9, B:247:0x02bb, B:249:0x02cb, B:251:0x02e0, B:254:0x02fd, B:261:0x030e, B:260:0x0307, B:250:0x02d0, B:252:0x02f5, B:171:0x0082, B:173:0x008b, B:174:0x00be, B:264:0x0328), top: B:274:0x0005 }] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v59 */
    /* JADX WARN: Type inference failed for: r8v60 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void recordEvent(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 821
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.api.RecordEventMessage.recordEvent(java.lang.String):void");
    }
}
