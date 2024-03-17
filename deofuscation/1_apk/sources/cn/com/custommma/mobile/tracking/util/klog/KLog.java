package cn.com.custommma.mobile.tracking.util.klog;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.hunantv.oversea.channel.dynamic.data.ParamParser;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class KLog {
    public static final int A = 6;
    public static final int D = 2;
    private static final String DEFAULT_MESSAGE = "execute";
    public static final int E = 5;
    public static final int I = 3;
    private static final int JSON = 7;
    public static final int JSON_INDENT = 4;
    private static final String NULL = "null";
    public static final String NULL_TIPS = "Log with null object";
    private static final String PARAM = "Param";
    private static final int STACK_TRACE_INDEX_4 = 4;
    private static final int STACK_TRACE_INDEX_5 = 5;
    private static final String SUFFIX = ".java";
    public static final int V = 1;
    public static final int W = 4;
    private static final int XML = 8;
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String TAG_DEFAULT = "KLog";
    private static String mGlobalTag = TAG_DEFAULT;
    private static boolean mIsGlobalTagEmpty = false;
    private static boolean IS_SHOW_LOG = false;

    public static void a() {
        printLog(6, null, DEFAULT_MESSAGE);
    }

    public static void d() {
        printLog(2, null, DEFAULT_MESSAGE);
    }

    public static void debug() {
        printDebug(null, DEFAULT_MESSAGE);
    }

    public static void e() {
        printLog(5, null, DEFAULT_MESSAGE);
    }

    public static void file(File file, Object obj) {
        printFile(null, file, null, obj);
    }

    private static String getObjectsString(Object... objArr) {
        if (objArr.length > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj == null) {
                    sb.append(PARAM);
                    sb.append("[");
                    sb.append(i);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(NULL);
                    sb.append("\n");
                } else {
                    sb.append(PARAM);
                    sb.append("[");
                    sb.append(i);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(obj.toString());
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        Object obj2 = objArr[0];
        return obj2 == null ? NULL : obj2.toString();
    }

    public static void i() {
        printLog(3, null, DEFAULT_MESSAGE);
    }

    public static void init(boolean z) {
        IS_SHOW_LOG = z;
    }

    public static void json(String str) {
        printLog(7, null, str);
    }

    private static void printDebug(String str, Object... objArr) {
        String[] wrapperContent = wrapperContent(5, str, objArr);
        String str2 = wrapperContent[0];
        String str3 = wrapperContent[1];
        String str4 = wrapperContent[2];
        BaseLog.printDefault(2, str2, str4 + str3);
    }

    private static void printFile(String str, File file, String str2, Object obj) {
        if (IS_SHOW_LOG) {
            String[] wrapperContent = wrapperContent(5, str, obj);
            FileLog.printFile(wrapperContent[0], file, str2, wrapperContent[2], wrapperContent[1]);
        }
    }

    private static void printLog(int i, String str, Object... objArr) {
        if (IS_SHOW_LOG) {
            String[] wrapperContent = wrapperContent(5, str, objArr);
            String str2 = wrapperContent[0];
            String str3 = wrapperContent[1];
            String str4 = wrapperContent[2];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    BaseLog.printDefault(i, str2, str4 + str3);
                    return;
                case 7:
                    JsonLog.printJson(str2, str3, str4);
                    return;
                case 8:
                    XmlLog.printXml(str2, str3, str4);
                    return;
                default:
                    return;
            }
        }
    }

    private static void printStackTrace() {
        if (IS_SHOW_LOG) {
            Throwable th = new Throwable();
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String[] split = stringWriter.toString().split("\\n\\t");
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (String str : split) {
                if (!str.contains("at com.socks.library.KLog")) {
                    sb.append(str);
                    sb.append("\n");
                }
            }
            String[] wrapperContent = wrapperContent(4, null, sb.toString());
            String str2 = wrapperContent[0];
            String str3 = wrapperContent[1];
            BaseLog.printDefault(2, str2, wrapperContent[2] + str3);
        }
    }

    public static void trace() {
        printStackTrace();
    }

    public static void v() {
        printLog(1, null, DEFAULT_MESSAGE);
    }

    public static void w() {
        printLog(4, null, DEFAULT_MESSAGE);
    }

    private static String[] wrapperContent(int i, String str, Object... objArr) {
        String[] split;
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i];
        String className = stackTraceElement.getClassName();
        if (className.split("\\.").length > 0) {
            className = split[split.length - 1] + SUFFIX;
        }
        if (className.contains(ParamParser.m)) {
            className = className.split("\\$")[0] + SUFFIX;
        }
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        if (lineNumber < 0) {
            lineNumber = 0;
        }
        if (str == null) {
            str = className;
        }
        if (mIsGlobalTagEmpty && TextUtils.isEmpty(str)) {
            str = TAG_DEFAULT;
        } else if (!mIsGlobalTagEmpty) {
            str = mGlobalTag;
        }
        return new String[]{str, objArr == null ? NULL_TIPS : getObjectsString(objArr), "[ (" + className + CertificateUtil.DELIMITER + lineNumber + ")#" + methodName + " ] "};
    }

    public static void xml(String str) {
        printLog(8, null, str);
    }

    public static void a(Object obj) {
        printLog(6, null, obj);
    }

    public static void d(Object obj) {
        printLog(2, null, obj);
    }

    public static void debug(Object obj) {
        printDebug(null, obj);
    }

    public static void e(Object obj) {
        printLog(5, null, obj);
    }

    public static void file(String str, File file, Object obj) {
        printFile(str, file, null, obj);
    }

    public static void i(Object obj) {
        printLog(3, null, obj);
    }

    public static void init(boolean z, String str) {
        IS_SHOW_LOG = z;
        mGlobalTag = str;
        mIsGlobalTagEmpty = TextUtils.isEmpty(str);
    }

    public static void json(String str, String str2) {
        printLog(7, str, str2);
    }

    public static void v(Object obj) {
        printLog(1, null, obj);
    }

    public static void w(Object obj) {
        printLog(4, null, obj);
    }

    public static void xml(String str, String str2) {
        printLog(8, str, str2);
    }

    public static void a(String str, Object... objArr) {
        printLog(6, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        printLog(2, str, objArr);
    }

    public static void debug(String str, Object... objArr) {
        printDebug(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        printLog(5, str, objArr);
    }

    public static void file(String str, File file, String str2, Object obj) {
        printFile(str, file, str2, obj);
    }

    public static void i(String str, Object... objArr) {
        printLog(3, str, objArr);
    }

    public static void v(String str, Object... objArr) {
        printLog(1, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        printLog(4, str, objArr);
    }
}
