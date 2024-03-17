package cn.jpush.android.t;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.jpush.android.ac.h;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.i;
import cn.jpush.android.u.d;
import java.io.File;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private String e = "";
    private static final String c = cn.jpush.android.ac.d.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 97, 69, 83, 113, 123, 98, 104, 92, 69, 55, 98, 102, 100, 67, 72, 55, 107, 120});
    public static String a = "";
    public static String b = "";
    private static volatile a d = null;

    /* renamed from: cn.jpush.android.t.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0017a extends cn.jpush.android.ac.e {
        private volatile Context a;

        public C0017a(Context context) {
            this.a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String a(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = android.os.Build.MANUFACTURER
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                java.lang.String r2 = ""
                if (r1 != 0) goto L13
                java.lang.String r0 = r0.trim()
                java.lang.String r0 = r0.toLowerCase()
                goto L14
            L13:
                r0 = r2
            L14:
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                java.lang.String r3 = "a"
                if (r1 != 0) goto L41
                if (r5 == 0) goto L41
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r1 = b()
                r5.append(r1)
                java.lang.String r1 = java.io.File.separator
                r5.append(r1)
                r5.append(r3)
                r5.append(r1)
                r5.append(r0)
                r5.append(r1)
                r5.append(r0)
                java.lang.String r0 = ".json"
                goto L64
            L41:
                if (r5 != 0) goto L6c
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r0 = b()
                r5.append(r0)
                java.lang.String r0 = java.io.File.separator
                r5.append(r0)
                r5.append(r3)
                r5.append(r0)
                java.lang.String r1 = "all"
                r5.append(r1)
                r5.append(r0)
                java.lang.String r0 = "all.json"
            L64:
                r5.append(r0)
                java.lang.String r5 = r5.toString()
                goto L6d
            L6c:
                r5 = r2
            L6d:
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 == 0) goto L74
                goto L87
            L74:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r4.c()
                r0.append(r1)
                r0.append(r5)
                java.lang.String r2 = r0.toString()
            L87:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.t.a.C0017a.a(boolean):java.lang.String");
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(Context context, String str) {
            try {
                Sp.set(context, Key.LocalAniConfigSign().set(Sp.get(context, Key.SvrAniConfigSign())));
                Sp.set(context, Key.LastAniConfigReqTime().set(Long.valueOf(System.currentTimeMillis())));
                d.a a = i.a(str);
                if (a == null) {
                    Logger.w("InAppAniConfigDownloadHelper", "dealResponseConfigData getInMatches is null");
                    return;
                }
                Logger.d("InAppAniConfigDownloadHelper", "getInMatches: " + a.toString());
                String f = a.f();
                int a2 = a.a();
                Logger.v("InAppAniConfigDownloadHelper", "response config data, aniConfigPath: " + f + ", aniFileVersion: " + a2);
                if (TextUtils.isEmpty(f) || !a(context, a2, f)) {
                    return;
                }
                String str2 = c() + f;
                String a3 = cn.jpush.android.w.a.a(this.a, str2, "", 2);
                if (TextUtils.isEmpty(a3)) {
                    Logger.w("InAppAniConfigDownloadHelper", "download ani config file failed");
                    return;
                }
                Sp.set(context, Key.LocalAniConfigVersion().set(Integer.valueOf(a2)));
                Sp.set(context, Key.LastAniConfigPath().set(f));
                Logger.d("InAppAniConfigDownloadHelper", "inapp ani-config file response: " + a3 + ", request url: " + str2);
                String a4 = h.a(a3);
                if (!context.getPackageName().equals(cn.jpush.android.ac.a.d(context))) {
                    a.a().a(context, a4);
                    return;
                }
                Logger.i("InAppAniConfigDownloadHelper", "sync animator rule config to main process");
                cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                dVar.bs = a4;
                cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.SYNC_ANI_CONFIG", dVar, true);
            } catch (Throwable th) {
                Logger.w("InAppAniConfigDownloadHelper", "update ani config data parse json failed, e: " + th.getMessage());
            }
        }

        private boolean a(Context context) {
            String str;
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                str = "sdk is banned not request config";
            } else {
                String str2 = (String) Sp.get(context, Key.SvrAniConfigSign());
                String str3 = (String) Sp.get(context, Key.LocalAniConfigSign());
                if (!TextUtils.isEmpty(str2)) {
                    Logger.d("InAppAniConfigDownloadHelper", "current local file md5 equals the server latest");
                    return !str2.equals(str3);
                }
                if (System.currentTimeMillis() - ((Long) Sp.get(context, Key.LastAniConfigReqTime())).longValue() >= Constant.TIME_THREE_DAY) {
                    return true;
                }
                str = "not config request internal time";
            }
            Logger.d("InAppAniConfigDownloadHelper", str);
            return false;
        }

        private boolean a(Context context, int i, String str) {
            return i > ((Integer) Sp.get(context, Key.LocalAniConfigVersion())).intValue() || !(TextUtils.isEmpty(str) || str.equals(Sp.get(context, Key.LastAniConfigPath())));
        }

        public static String b() {
            TextUtils.isEmpty(a.b);
            return "V100";
        }

        private String c() {
            String str = a.c;
            TextUtils.isEmpty(a.a);
            return str + File.separator;
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            try {
                if (a(this.a)) {
                    String a = a(true);
                    if (TextUtils.isEmpty(a)) {
                        Logger.w("InAppAniConfigDownloadHelper", "inapp manu ani config url is null");
                        return;
                    }
                    String a2 = cn.jpush.android.w.a.a(this.a, a, "", 2);
                    if (TextUtils.isEmpty(a2)) {
                        Logger.w("InAppAniConfigDownloadHelper", "request manufacture ani config failed, manufacture: " + Build.MANUFACTURER + ", try common config.");
                        a = a(false);
                        if (TextUtils.isEmpty(a)) {
                            Logger.w("InAppAniConfigDownloadHelper", "inapp common ani config url is null");
                            return;
                        }
                        a2 = cn.jpush.android.w.a.a(this.a, a, "", 2);
                        if (TextUtils.isEmpty(a2)) {
                            Logger.w("InAppAniConfigDownloadHelper", "request common ani config failed");
                            return;
                        }
                    }
                    Logger.d("InAppAniConfigDownloadHelper", "ani config response: " + a2 + ", reqUrl: " + a);
                    a(this.a, a2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public String a(Context context) {
        if (TextUtils.isEmpty(this.e)) {
            synchronized ("ani_config.cache") {
                String str = context.getFilesDir().getAbsolutePath() + File.separator + "ani_config.cache";
                File file = new File(str);
                if (file.exists()) {
                    String str2 = (String) cn.jpush.android.ac.c.a(file);
                    if (!TextUtils.isEmpty(str2)) {
                        String b2 = h.b(str2);
                        Logger.d("InAppAniConfigDownloadHelper", "use config from cache file, path: " + str);
                        this.e = b2;
                        return b2;
                    }
                }
                this.e = cn.jpush.android.u.a.a;
                Logger.d("InAppAniConfigDownloadHelper", "use local mem cache config");
                return this.e;
            }
        }
        return this.e;
    }

    public void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized ("ani_config.cache") {
            cn.jpush.android.ac.c.a(new File(context.getFilesDir(), "ani_config.cache"), str);
            Logger.d("InAppAniConfigDownloadHelper", "cache animator config data");
        }
    }

    public void b(Context context) {
        JCoreHelper.futureExecutor(context, new C0017a(context));
    }
}
