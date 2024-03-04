package linc.com.amplituda;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes.dex */
public final class AmplitudaLogger {
    private static final String LIB_TAG = "AMPLITUDA";
    public static final String OPERATION_PREPARING = "Preparing";
    public static final String OPERATION_PROCESSING = "Processing";
    private static boolean enable = false;
    private static int priority = 3;

    public static synchronized void enable(boolean z6) {
        synchronized (AmplitudaLogger.class) {
            enable = z6;
        }
    }

    public static synchronized void log(String str) {
        synchronized (AmplitudaLogger.class) {
            if (enable) {
                Log.println(priority, LIB_TAG, str);
            }
        }
    }

    public static synchronized void logOperationTime(String str, long j5) {
        synchronized (AmplitudaLogger.class) {
            log(String.format(Locale.getDefault(), "%s time: %.04f seconds", str, Float.valueOf(((float) (System.currentTimeMillis() - j5)) / 1000.0f)));
        }
    }

    public static synchronized void priority(int i7) {
        synchronized (AmplitudaLogger.class) {
            priority = i7;
        }
    }
}
