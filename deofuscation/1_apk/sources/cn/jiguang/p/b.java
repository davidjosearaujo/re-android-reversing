package cn.jiguang.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jiguang.n.c;
import com.alibaba.fastjson.JSONStreamContext;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.adapter.internal.CommonCode;
import com.hunantv.media.player.subtitle.MediaFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile b c;
    private Context a;
    private JSONObject b;
    private String d;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jiguang.n.e {
        private Context a;

        private a(Context context) {
            this.a = context;
            this.b = "JDevice#RegisterAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            try {
                Context context = this.a;
                cn.jiguang.q.b.a(context, cn.jiguang.q.b.f(context));
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JDevice", "RegisterAction failed:" + th.getMessage());
            }
        }
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private JSONObject e(Context context) {
        StringBuilder sb;
        String message;
        JSONObject a2;
        StringBuilder sb2;
        if (context == null) {
            cn.jiguang.ak.a.d("JDevice", "when getDeviceInfo, context can't be null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str = "";
            if (cn.jiguang.i.a.a().d(JSONStreamContext.ArrayValue)) {
                String a3 = cn.jiguang.q.b.a();
                if (TextUtils.isEmpty(a3)) {
                    a3 = "";
                }
                jSONObject.put("cpu_info", a3);
            }
            if (cn.jiguang.i.a.a().d(JSONStreamContext.PropertyValue)) {
                jSONObject.put("cpu_count", cn.jiguang.q.b.c());
            }
            if (cn.jiguang.i.a.a().d(1006)) {
                jSONObject.put("cpu_max_freq", cn.jiguang.q.b.d());
            }
            if (cn.jiguang.i.a.a().d(JSONStreamContext.StartArray)) {
                jSONObject.put("cpu_hardware", cn.jiguang.q.b.b());
            }
            if (cn.jiguang.i.a.a().d(1016)) {
                jSONObject.put("ram", cn.jiguang.q.b.c(context));
            }
            if (cn.jiguang.i.a.a().d(1018)) {
                jSONObject.put("rom", cn.jiguang.q.b.d(context));
            }
            if (cn.jiguang.i.a.a().d(1017)) {
                String a4 = cn.jiguang.q.b.a(context);
                if (TextUtils.isEmpty(a4)) {
                    a4 = "";
                }
                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, a4);
            }
            if (cn.jiguang.i.a.a().d(1020)) {
                String format = String.format(Locale.ENGLISH, "%.1f", Double.valueOf(cn.jiguang.q.b.b(context)));
                if (TextUtils.isEmpty(format)) {
                    format = "";
                }
                jSONObject.put("screensize", format);
            }
            if (cn.jiguang.i.a.a().d(1014)) {
                String format2 = String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
                jSONObject.put("os_version", TextUtils.isEmpty(format2) ? "" : format2.trim());
            }
            if (cn.jiguang.i.a.a().d(1013)) {
                String format3 = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
                if (TextUtils.isEmpty(format3)) {
                    format3 = "";
                }
                jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, format3);
            }
            if (cn.jiguang.i.a.a().d(1002)) {
                String format4 = String.format(Locale.ENGLISH, Build.BRAND, new Object[0]);
                if (TextUtils.isEmpty(format4)) {
                    format4 = "";
                }
                jSONObject.put("brand", format4);
            }
            if (cn.jiguang.i.a.a().d(1015)) {
                String format5 = String.format(Locale.ENGLISH, Build.PRODUCT, new Object[0]);
                if (TextUtils.isEmpty(format5)) {
                    format5 = "";
                }
                jSONObject.put("product", format5);
            }
            if (cn.jiguang.i.a.a().d(1007)) {
                String format6 = String.format(Locale.ENGLISH, Build.FINGERPRINT, new Object[0]);
                if (TextUtils.isEmpty(format6)) {
                    format6 = "";
                }
                jSONObject.put("fingerprint", format6);
            }
            if (cn.jiguang.i.a.a().d(1009)) {
                String locale = context.getResources().getConfiguration().locale.toString();
                if (TextUtils.isEmpty(locale)) {
                    locale = "";
                }
                jSONObject.put(MediaFormat.KEY_LANGUAGE, locale);
            }
            if (cn.jiguang.i.a.a().d(1011)) {
                String format7 = String.format(Locale.ENGLISH, c.a.b, new Object[0]);
                if (TextUtils.isEmpty(format7)) {
                    format7 = "";
                }
                jSONObject.put("manufacturer", format7);
            }
            if (cn.jiguang.i.a.a().d(1026)) {
                long rawOffset = TimeZone.getDefault().getRawOffset() / JConstants.HOUR;
                if (rawOffset > 0) {
                    sb2 = new StringBuilder();
                    sb2.append("+");
                    sb2.append(rawOffset);
                } else if (rawOffset < 0) {
                    sb2 = new StringBuilder();
                    sb2.append("-");
                    sb2.append(rawOffset);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(rawOffset);
                }
                String sb3 = sb2.toString();
                if (TextUtils.isEmpty(sb3)) {
                    sb3 = "";
                }
                jSONObject.put("timezone", sb3);
            }
            if (cn.jiguang.i.a.a().d(1019)) {
                String a5 = cn.jiguang.q.d.a();
                if (TextUtils.isEmpty(a5)) {
                    a5 = "";
                }
                jSONObject.put("romversion", a5);
            }
            if (cn.jiguang.i.a.a().d(com.alipay.sdk.app.d.a)) {
                String c2 = cn.jiguang.n.d.c(context, "");
                if (TextUtils.isEmpty(c2)) {
                    c2 = "";
                }
                jSONObject.put("mac", c2);
            }
            if (cn.jiguang.i.a.a().d(1022)) {
                jSONObject.put("sim_slots", cn.jiguang.q.b.e(context));
            }
            if (cn.jiguang.i.a.a().d(1001)) {
                String l = cn.jiguang.n.d.l(context);
                if (!TextUtils.isEmpty(l)) {
                    str = l;
                }
                jSONObject.put("android_id", str);
            }
            if (cn.jiguang.i.a.a().d(1008) && (a2 = cn.jiguang.t.a.a(context)) != null) {
                jSONObject.put("ids", a2);
            }
            jSONObject.put("android_ver", Build.VERSION.SDK_INT);
            jSONObject.put("android_target_ver", context.getApplicationInfo().targetSdkVersion);
            return jSONObject;
        } catch (JSONException e) {
            sb = new StringBuilder();
            sb.append("package json exception: ");
            message = e.getMessage();
            sb.append(message);
            cn.jiguang.ak.a.d("JDevice", sb.toString());
            return null;
        } catch (Throwable th) {
            sb = new StringBuilder();
            sb.append("getDeviceInfo exception: ");
            message = th.getMessage();
            sb.append(message);
            cn.jiguang.ak.a.d("JDevice", sb.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0007, B:18:0x004a, B:21:0x0068, B:24:0x0075, B:27:0x0082, B:30:0x008f, B:33:0x009c, B:37:0x00aa, B:17:0x0044, B:14:0x003e, B:11:0x0021), top: B:42:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0007, B:18:0x004a, B:21:0x0068, B:24:0x0075, B:27:0x0082, B:30:0x008f, B:33:0x009c, B:37:0x00aa, B:17:0x0044, B:14:0x003e, B:11:0x0021), top: B:42:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String f(android.content.Context r11) {
        /*
            java.lang.String r0 = "JDevice"
            java.lang.String r1 = ","
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = cn.jiguang.n.d.a(r11)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r5 = cn.jiguang.n.d.b(r11)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r6 = r11.getPackageName()     // Catch: java.lang.Throwable -> L1f
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch: java.lang.Throwable -> L1d
            r7 = 0
            android.content.pm.PackageInfo r11 = r11.getPackageInfo(r6, r7)     // Catch: java.lang.Throwable -> L1d
            goto L3a
        L1d:
            r11 = move-exception
            goto L21
        L1f:
            r11 = move-exception
            r6 = r2
        L21:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r7.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = "getPackageManager failed:"
            r7.append(r8)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> Lb2
            r7.append(r11)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = r7.toString()     // Catch: java.lang.Throwable -> Lb2
            cn.jiguang.ak.a.d(r0, r11)     // Catch: java.lang.Throwable -> Lb2
            r11 = r3
        L3a:
            if (r11 != 0) goto L3e
            r7 = r2
            goto L40
        L3e:
            java.lang.String r7 = r11.versionName     // Catch: java.lang.Throwable -> Lb2
        L40:
            if (r11 != 0) goto L44
            r11 = r2
            goto L4a
        L44:
            int r11 = r11.versionCode     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> Lb2
        L4a:
            java.lang.String r8 = cn.jiguang.n.d.a()     // Catch: java.lang.Throwable -> Lb2
            int r9 = cn.jiguang.n.d.b()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r10.<init>()     // Catch: java.lang.Throwable -> Lb2
            r10.append(r4)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto L68
            r5 = r2
        L68:
            r10.append(r5)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto L75
            r7 = r2
        L75:
            r10.append(r7)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r4 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto L82
            r11 = r2
        L82:
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r11 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lb2
            if (r11 == 0) goto L8f
            r8 = r2
        L8f:
            r10.append(r8)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lb2
            if (r11 == 0) goto L9c
            r9 = r2
        L9c:
            r10.append(r9)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lb2
            if (r11 == 0) goto La9
            goto Laa
        La9:
            r2 = r6
        Laa:
            r10.append(r2)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = r10.toString()     // Catch: java.lang.Throwable -> Lb2
            return r11
        Lb2:
            r11 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getCurrentCondition throwable: "
            r1.append(r2)
            java.lang.String r11 = r11.getMessage()
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            cn.jiguang.ak.a.d(r0, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.p.b.f(android.content.Context):java.lang.String");
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        return "JDevice";
    }

    public void b(Context context, int i) {
        cn.jiguang.n.d.a(new a(context), i);
    }

    @Override // cn.jiguang.n.a
    public void b(Context context, String str) {
        if (!cn.jiguang.i.a.a().a(1000)) {
            cn.jiguang.ak.a.a("JDevice", "will not report");
            return;
        }
        JSONObject e = e(context);
        this.b = e;
        if (e == null) {
            cn.jiguang.ak.a.d("JDevice", "collect failed");
            return;
        }
        cn.jiguang.ak.a.a("JDevice", "collect success:" + this.b);
        super.b(context, str);
    }

    @Override // cn.jiguang.n.a
    public boolean c(Context context, String str) {
        if (cn.jiguang.n.b.c(context, str)) {
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                cn.jiguang.ak.a.d("JDevice", "there are no data to report");
                return false;
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return false;
            }
            this.d = cn.jiguang.n.d.c(jSONObject2 + f(context));
            String g = cn.jiguang.n.b.g(context);
            if (TextUtils.isEmpty(this.d) || TextUtils.equals(this.d, g)) {
                cn.jiguang.ak.a.a("JDevice", "device detail is not change");
                return false;
            }
            cn.jiguang.ak.a.a("JDevice", "device detail is change");
            return super.c(context, str);
        }
        return false;
    }

    @Override // cn.jiguang.n.a
    public Object d(Context context) {
        return e(context);
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            cn.jiguang.ak.a.a("JDevice", "there are no data to report");
            return;
        }
        cn.jiguang.n.d.a(context, jSONObject, DeviceRequestsHelper.DEVICE_INFO_PARAM);
        cn.jiguang.n.d.a(context, this.b, new cn.jiguang.p.a(context, this.d, str));
        this.b = null;
    }
}
