package cn.jiguang.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import com.facebook.common.util.ByteConstants;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private static d b = new d();
    private static int c = ByteConstants.MB;
    public boolean a;
    private Thread.UncaughtExceptionHandler d = null;
    private final Object e = new Object();

    private d() {
        this.a = true;
        this.a = ((Boolean) cn.jiguang.g.b.a(JConstants.getAppContext(null), cn.jiguang.g.a.b())).booleanValue();
    }

    public static d a() {
        return b;
    }

    private JSONArray a(Context context, Throwable th) {
        String d = cn.jiguang.f.c.d(cn.jiguang.f.c.a(context, "jpush_uncaughtexception_file"));
        JSONArray jSONArray = null;
        int i = 0;
        if (!TextUtils.isEmpty(d)) {
            try {
                JSONArray jSONArray2 = new JSONArray(d);
                try {
                    i = d.length();
                } catch (JSONException unused) {
                }
                jSONArray = jSONArray2;
            } catch (JSONException unused2) {
            }
        }
        return a(context, jSONArray, i, th);
    }

    private JSONArray a(Context context, JSONArray jSONArray, int i, Throwable th) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis() + cn.jiguang.d.b.c(context);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i2 = 0;
        while (true) {
            jSONObject = null;
            try {
                if (i2 >= jSONArray.length()) {
                    break;
                }
                jSONObject = jSONArray.optJSONObject(i2);
                if (jSONObject != null && stringWriter2.equals(jSONObject.getString("stacktrace"))) {
                    jSONObject.put("count", jSONObject.getInt("count") + 1);
                    jSONObject.put("crashtime", currentTimeMillis);
                    break;
                }
                i2++;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("crashtime", currentTimeMillis);
            jSONObject2.put("stacktrace", stringWriter2);
            jSONObject2.put("message", b(th));
            jSONObject2.put("count", 1);
            jSONObject2.put("networktype", cn.jiguang.f.a.l(context));
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str == null) {
                    str = "null";
                }
                jSONObject2.put("versionname", str);
                jSONObject2.put("versioncode", packageInfo.versionCode + "");
            }
            if (i + jSONObject2.toString().length() < c) {
                jSONArray.put(jSONObject2);
            } else {
                long j = -1;
                int i3 = 0;
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("crashtime");
                        if (j == -1 || optLong < j) {
                            i3 = i4;
                            j = optLong;
                        }
                    }
                }
                jSONArray.put(i3, jSONObject2);
            }
        }
        return jSONArray;
    }

    private void a(Context context, JSONArray jSONArray) {
        File a;
        String jSONArray2 = jSONArray != null ? jSONArray.toString() : null;
        if (TextUtils.isEmpty(jSONArray2) || (a = cn.jiguang.f.c.a(context, "jpush_uncaughtexception_file")) == null) {
            return;
        }
        cn.jiguang.f.c.b(a, jSONArray2);
    }

    private void a(Throwable th) {
        if (this.a) {
            Context appContext = JConstants.getAppContext(null);
            if (appContext == null) {
                cn.jiguang.ar.c.i("JPushCrashHandler", "handleException failed: context is null");
                return;
            }
            JSONArray a = a(appContext, th);
            d(appContext);
            a(appContext, a);
        }
    }

    private String b(Throwable th) {
        String th2 = th.toString();
        try {
            String[] split = th2.split(CertificateUtil.DELIMITER);
            if (split.length > 1) {
                for (int length = split.length - 1; length >= 0; length--) {
                    if (!split[length].endsWith("Exception") && !split[length].endsWith("Error")) {
                    }
                    return split[length];
                }
                return th2;
            }
            return th2;
        } catch (NullPointerException | PatternSyntaxException unused) {
            return th2;
        }
    }

    public static JSONArray c(Context context) {
        String d = cn.jiguang.f.c.d(cn.jiguang.f.c.a(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        try {
            return new JSONArray(d);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void d(Context context) {
        if (context == null) {
            cn.jiguang.ar.c.g("JPushCrashHandler", "Action - deleteCrashLog context is null");
        } else {
            cn.jiguang.f.c.a(cn.jiguang.f.c.a(context, "jpush_uncaughtexception_file"));
        }
    }

    public final void a(long j) {
        synchronized (this.e) {
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
            if (j == 0) {
                while (cn.jiguang.be.d.b("FUTURE_TASK")) {
                    this.e.wait(0L);
                }
            } else {
                long j2 = 0;
                while (cn.jiguang.be.d.b("FUTURE_TASK")) {
                    long j3 = j - j2;
                    if (j3 <= 0) {
                        break;
                    }
                    this.e.wait(j3);
                    j2 = System.currentTimeMillis() - currentTimeMillis;
                }
            }
        }
    }

    public void a(Context context) {
        if (this.a) {
            return;
        }
        this.a = true;
        cn.jiguang.ar.c.c("JPushCrashHandler", "init caughtException");
        cn.jiguang.g.b.a(JConstants.getAppContext(context), cn.jiguang.g.a.b().a((cn.jiguang.g.a<Boolean>) Boolean.TRUE));
    }

    public void b() {
        if (this.d == null) {
            this.d = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void b(Context context) {
        if (this.a) {
            cn.jiguang.ar.c.c("JPushCrashHandler", "stop caughtException");
            this.a = false;
            cn.jiguang.g.b.a(JConstants.getAppContext(context), cn.jiguang.g.a.b().a((cn.jiguang.g.a<Boolean>) Boolean.FALSE));
        }
    }

    public void e(Context context) {
        if (context == null) {
            cn.jiguang.ar.c.g("JPushCrashHandler", "Action - reportCrashLog context is null");
        } else if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.be.d.a("FUTURE_TASK", new e());
            } catch (Throwable th) {
                cn.jiguang.ar.c.i("JPushCrashHandler", "report crash e:" + th);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.a) {
            cn.jiguang.ar.c.a("JPushCrashHandler", "enable crash report");
            a(th);
            try {
                cn.jiguang.be.d.a("FUTURE_TASK", new e());
                a(AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS);
            } catch (Throwable th2) {
                cn.jiguang.ar.c.i("JPushCrashHandler", "report crash e:" + th2);
            }
        } else {
            cn.jiguang.ar.c.a("JPushCrashHandler", "disable crash report");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
