package y2;

import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q {

    /* renamed from: f  reason: collision with root package name */
    public static volatile q f6636f;

    /* renamed from: c  reason: collision with root package name */
    public int f6640c;
    public static final File e = new File("/proc/self/fd");

    /* renamed from: g  reason: collision with root package name */
    public static volatile int f6637g = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6641d = true;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6638a = true;

    /* renamed from: b  reason: collision with root package name */
    public final int f6639b = 20000;

    public q() {
        new AtomicBoolean(false);
    }

    public final boolean a(int i7, int i8, boolean z6, boolean z7) {
        boolean z8;
        if (!z6) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        } else if (!this.f6638a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        } else if (z7) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else if (i7 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        } else if (i8 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        } else {
            synchronized (this) {
                int i9 = this.f6640c + 1;
                this.f6640c = i9;
                if (i9 >= 50) {
                    this.f6640c = 0;
                    int length = e.list().length;
                    long j7 = (long) (f6637g != -1 ? f6637g : this.f6639b);
                    boolean z9 = ((long) length) < j7;
                    this.f6641d = z9;
                    if (!z9 && Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j7);
                    }
                }
                z8 = this.f6641d;
            }
            if (z8) {
                return true;
            }
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
            }
            return false;
        }
    }
}
