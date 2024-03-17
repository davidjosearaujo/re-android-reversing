package cn.jiguang.ap;

import android.content.Context;
import cn.jiguang.r.f;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static String a = "";
    private static final String b = cn.jiguang.r.a.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 106, 124, 100, 67, 69, 107, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 86, 43, 39, 119, 97, 64, 65, 110, 105, 125, 116, 31, 83, 109, 105, 98, 100, 67});

    private static long a(long j) {
        Date date = new Date();
        Date date2 = new Date(j);
        date.setHours(date2.getHours());
        date.setMinutes(date2.getMinutes());
        date.setSeconds(date2.getSeconds());
        return (date.getTime() / 1000) * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x00da A[Catch: JSONException -> 0x0332, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0332, blocks: (B:142:0x0017, B:145:0x0021, B:147:0x002b, B:148:0x002e, B:150:0x0038, B:151:0x003b, B:153:0x0045, B:154:0x004d, B:156:0x0057, B:157:0x005a, B:159:0x0064, B:160:0x0067, B:162:0x0071, B:165:0x0079, B:171:0x009e, B:173:0x00a6, B:178:0x00b1, B:182:0x00bc, B:185:0x00da, B:187:0x00e7, B:189:0x00ed, B:199:0x011d, B:203:0x0143, B:205:0x014a, B:207:0x0157, B:209:0x015f, B:211:0x01c0, B:204:0x0147, B:212:0x01cd, B:214:0x01d5, B:216:0x01dd, B:218:0x020e, B:219:0x021e, B:221:0x0224, B:223:0x024f, B:225:0x026c, B:226:0x026e, B:228:0x027c, B:230:0x0291, B:229:0x028e, B:231:0x0294, B:232:0x029c, B:234:0x02a2, B:235:0x02b5, B:237:0x02bb, B:238:0x02c7, B:239:0x02c9, B:243:0x02da, B:247:0x02eb, B:251:0x02fb, B:255:0x031a, B:259:0x0327, B:175:0x00ab, B:169:0x0081, B:170:0x0084), top: B:264:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0157 A[Catch: JSONException -> 0x0332, TryCatch #0 {JSONException -> 0x0332, blocks: (B:142:0x0017, B:145:0x0021, B:147:0x002b, B:148:0x002e, B:150:0x0038, B:151:0x003b, B:153:0x0045, B:154:0x004d, B:156:0x0057, B:157:0x005a, B:159:0x0064, B:160:0x0067, B:162:0x0071, B:165:0x0079, B:171:0x009e, B:173:0x00a6, B:178:0x00b1, B:182:0x00bc, B:185:0x00da, B:187:0x00e7, B:189:0x00ed, B:199:0x011d, B:203:0x0143, B:205:0x014a, B:207:0x0157, B:209:0x015f, B:211:0x01c0, B:204:0x0147, B:212:0x01cd, B:214:0x01d5, B:216:0x01dd, B:218:0x020e, B:219:0x021e, B:221:0x0224, B:223:0x024f, B:225:0x026c, B:226:0x026e, B:228:0x027c, B:230:0x0291, B:229:0x028e, B:231:0x0294, B:232:0x029c, B:234:0x02a2, B:235:0x02b5, B:237:0x02bb, B:238:0x02c7, B:239:0x02c9, B:243:0x02da, B:247:0x02eb, B:251:0x02fb, B:255:0x031a, B:259:0x0327, B:175:0x00ab, B:169:0x0081, B:170:0x0084), top: B:264:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x020e A[Catch: JSONException -> 0x0332, TryCatch #0 {JSONException -> 0x0332, blocks: (B:142:0x0017, B:145:0x0021, B:147:0x002b, B:148:0x002e, B:150:0x0038, B:151:0x003b, B:153:0x0045, B:154:0x004d, B:156:0x0057, B:157:0x005a, B:159:0x0064, B:160:0x0067, B:162:0x0071, B:165:0x0079, B:171:0x009e, B:173:0x00a6, B:178:0x00b1, B:182:0x00bc, B:185:0x00da, B:187:0x00e7, B:189:0x00ed, B:199:0x011d, B:203:0x0143, B:205:0x014a, B:207:0x0157, B:209:0x015f, B:211:0x01c0, B:204:0x0147, B:212:0x01cd, B:214:0x01d5, B:216:0x01dd, B:218:0x020e, B:219:0x021e, B:221:0x0224, B:223:0x024f, B:225:0x026c, B:226:0x026e, B:228:0x027c, B:230:0x0291, B:229:0x028e, B:231:0x0294, B:232:0x029c, B:234:0x02a2, B:235:0x02b5, B:237:0x02bb, B:238:0x02c7, B:239:0x02c9, B:243:0x02da, B:247:0x02eb, B:251:0x02fb, B:255:0x031a, B:259:0x0327, B:175:0x00ab, B:169:0x0081, B:170:0x0084), top: B:264:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0326  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.ao.a a(android.content.Context r28, org.json.JSONObject r29) {
        /*
            Method dump skipped, instructions count: 844
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ap.b.a(android.content.Context, org.json.JSONObject):cn.jiguang.ao.a");
    }

    private static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeConfigHelper", "get md5 throwable:" + th.getMessage());
            return "";
        }
    }

    private static List<String> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.get(i).toString());
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:540:0x04c0, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x04fd, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x0539, code lost:
        if (r1 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x0575, code lost:
        if (r1 == 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x0577, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x057a, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0131 A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TRY_ENTER, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x014d A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TRY_ENTER, TRY_LEAVE, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0158 A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TRY_ENTER, TRY_LEAVE, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0165 A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TRY_ENTER, TRY_LEAVE, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0172 A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TRY_ENTER, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0179 A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0180 A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x01ac A[Catch: all -> 0x010d, JSONException -> 0x0113, IOException -> 0x0119, UnsupportedEncodingException -> 0x011f, TRY_ENTER, TryCatch #20 {UnsupportedEncodingException -> 0x011f, IOException -> 0x0119, JSONException -> 0x0113, all -> 0x010d, blocks: (B:369:0x00ff, B:371:0x0107, B:383:0x0131, B:385:0x0142, B:388:0x014d, B:391:0x0158, B:394:0x0165, B:397:0x0172, B:399:0x0179, B:401:0x0180, B:402:0x0189, B:404:0x018f, B:405:0x0199, B:408:0x01ac, B:410:0x01b8, B:412:0x01bf, B:414:0x01c6, B:416:0x01d2, B:417:0x01df, B:418:0x01e4, B:422:0x01ee, B:423:0x01fa), top: B:632:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0274 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0276 A[Catch: all -> 0x0475, JSONException -> 0x0479, IOException -> 0x047d, UnsupportedEncodingException -> 0x0482, TryCatch #23 {UnsupportedEncodingException -> 0x0482, IOException -> 0x047d, JSONException -> 0x0479, all -> 0x0475, blocks: (B:356:0x0086, B:367:0x00d9, B:381:0x0125, B:386:0x0147, B:389:0x0152, B:392:0x015f, B:395:0x016c, B:406:0x019f, B:424:0x01ff, B:428:0x0276, B:432:0x0298, B:436:0x02be), top: B:627:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:597:0x0559 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:599:0x04a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:603:0x04e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:608:0x051d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:632:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v27, types: [cn.jiguang.ah.a] */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r6v33, types: [cn.jiguang.ah.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 1444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ap.b.a(android.content.Context):org.json.JSONObject");
    }

    public static void a(Context context, String str) {
        if (str != null) {
            cn.jiguang.ak.a.a("JWakeConfigHelper", "write wakeConfigJson:" + str);
            cn.jiguang.r.c.a(context, "bwc.catch", str);
        }
    }

    public static cn.jiguang.ao.a b(Context context) {
        cn.jiguang.ao.a aVar = null;
        try {
            String c = cn.jiguang.r.c.c(context, "bwc.catch");
            if (c != null) {
                aVar = a(context, new JSONObject(f.a(c)));
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeConfigHelper", "read config json from cache failed !! error:" + th);
        }
        return aVar == null ? new cn.jiguang.ao.a() : aVar;
    }
}
