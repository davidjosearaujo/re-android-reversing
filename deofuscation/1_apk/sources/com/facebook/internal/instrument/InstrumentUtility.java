package com.facebook.internal.instrument;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphRequest$Companion;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.huawei.hms.push.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import kotlin.text.Regex;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import n.u2.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;

/* compiled from: InstrumentUtility.kt */
@b0(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u001c\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u000fH\u0007J$\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u001c\u0010*\u001a\u00020$2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentUtility;", "", "()V", "ANALYSIS_REPORT_PREFIX", "", "ANR_REPORT_PREFIX", "CODELESS_PREFIX", "CRASH_REPORT_PREFIX", "CRASH_SHIELD_PREFIX", "ERROR_REPORT_PREFIX", "FBSDK_PREFIX", "INSTRUMENT_DIR", "SUGGESTED_EVENTS_PREFIX", "THREAD_CHECK_PREFIX", "deleteFile", "", "filename", "getCause", e.a, "", "getInstrumentReportDir", "Ljava/io/File;", "getStackTrace", "thread", "Ljava/lang/Thread;", "isSDKRelatedException", "isSDKRelatedThread", "listAnrReportFiles", "", "()[Ljava/io/File;", "listExceptionAnalysisReportFiles", "listExceptionReportFiles", "readFile", "Lorg/json/JSONObject;", "deleteOnException", "sendReports", "", SDKConstants.PARAM_KEY, "reports", "Lorg/json/JSONArray;", "callback", "Lcom/facebook/GraphRequest$Callback;", "writeFile", "content", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class InstrumentUtility {
    @d
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";
    @d
    public static final String ANR_REPORT_PREFIX = "anr_log_";
    private static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";
    @d
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    @d
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";
    @d
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    private static final String FBSDK_PREFIX = "com.facebook";
    @d
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();
    private static final String INSTRUMENT_DIR = "instrument";
    private static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";
    @d
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    private InstrumentUtility() {
    }

    @k
    public static final boolean deleteFile(@r.e.a.e String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return false;
        }
        return new File(instrumentReportDir, str).delete();
    }

    @k
    @r.e.a.e
    public static final String getCause(@r.e.a.e Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return String.valueOf(th.getCause());
    }

    @k
    @r.e.a.e
    public static final File getInstrumentReportDir() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        f0.o(applicationContext, "FacebookSdk.getApplicationContext()");
        File file = new File(applicationContext.getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @k
    @r.e.a.e
    public static final String getStackTrace(@r.e.a.e Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    @k
    public static final boolean isSDKRelatedException(@r.e.a.e Throwable th) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                f0.o(stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                f0.o(className, "element.className");
                if (u.u2(className, "com.facebook", false, 2, (Object) null)) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    @k
    public static final boolean isSDKRelatedThread(@r.e.a.e Thread thread) {
        StackTraceElement[] stackTrace;
        if (thread != null && (stackTrace = thread.getStackTrace()) != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                f0.o(stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                f0.o(className, "element.className");
                if (u.u2(className, "com.facebook", false, 2, (Object) null)) {
                    String className2 = stackTraceElement.getClassName();
                    f0.o(className2, "element.className");
                    if (!u.u2(className2, CODELESS_PREFIX, false, 2, (Object) null)) {
                        String className3 = stackTraceElement.getClassName();
                        f0.o(className3, "element.className");
                        if (!u.u2(className3, SUGGESTED_EVENTS_PREFIX, false, 2, (Object) null)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    f0.o(methodName, "element.methodName");
                    if (u.u2(methodName, "onClick", false, 2, (Object) null)) {
                        continue;
                    } else {
                        String methodName2 = stackTraceElement.getMethodName();
                        f0.o(methodName2, "element.methodName");
                        if (u.u2(methodName2, "onItemClick", false, 2, (Object) null)) {
                            continue;
                        } else {
                            String methodName3 = stackTraceElement.getMethodName();
                            f0.o(methodName3, "element.methodName");
                            if (!u.u2(methodName3, "onTouch", false, 2, (Object) null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @d
    @k
    public static final File[] listAnrReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null) {
            File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.InstrumentUtility$listAnrReportFiles$reports$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    f0.o(str, "name");
                    s0 s0Var = s0.a;
                    String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.ANR_REPORT_PREFIX}, 1));
                    f0.o(format, "java.lang.String.format(format, *args)");
                    return new Regex(format).matches(str);
                }
            });
            return listFiles != null ? listFiles : new File[0];
        }
        return new File[0];
    }

    @d
    @k
    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null) {
            File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.InstrumentUtility$listExceptionAnalysisReportFiles$reports$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    f0.o(str, "name");
                    s0 s0Var = s0.a;
                    String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.ANALYSIS_REPORT_PREFIX}, 1));
                    f0.o(format, "java.lang.String.format(format, *args)");
                    return new Regex(format).matches(str);
                }
            });
            return listFiles != null ? listFiles : new File[0];
        }
        return new File[0];
    }

    @d
    @k
    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null) {
            File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.InstrumentUtility$listExceptionReportFiles$reports$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    f0.o(str, "name");
                    s0 s0Var = s0.a;
                    String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.CRASH_REPORT_PREFIX, InstrumentUtility.CRASH_SHIELD_PREFIX, InstrumentUtility.THREAD_CHECK_PREFIX}, 3));
                    f0.o(format, "java.lang.String.format(format, *args)");
                    return new Regex(format).matches(str);
                }
            });
            return listFiles != null ? listFiles : new File[0];
        }
        return new File[0];
    }

    @k
    @r.e.a.e
    public static final JSONObject readFile(@r.e.a.e String str, boolean z) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null) {
            try {
                return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, str))));
            } catch (Exception unused) {
                if (z) {
                    deleteFile(str);
                }
            }
        }
        return null;
    }

    @k
    public static final void sendReports(@r.e.a.e String str, @d JSONArray jSONArray, @r.e.a.e GraphRequest$Callback graphRequest$Callback) {
        f0.p(jSONArray, "reports");
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            GraphRequest$Companion graphRequest$Companion = GraphRequest.Companion;
            s0 s0Var = s0.a;
            String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            f0.o(format, "java.lang.String.format(format, *args)");
            graphRequest$Companion.newPostRequest(null, format, jSONObject, graphRequest$Callback).executeAsync();
        } catch (JSONException unused) {
        }
    }

    @k
    public static final void writeFile(@r.e.a.e String str, @r.e.a.e String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
            byte[] bytes = str2.getBytes(n.u2.d.a);
            f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    @k
    @r.e.a.e
    public static final String getStackTrace(@d Thread thread) {
        f0.p(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTrace) {
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }
}
