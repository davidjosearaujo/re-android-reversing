package y2;

import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: f */
    public static volatile q f6636f;

    /* renamed from: a */
    public final boolean f6638a;

    /* renamed from: b */
    public final int f6639b;

    /* renamed from: c */
    public int f6640c;

    /* renamed from: d */
    public boolean f6641d = true;
    public static final File e = new File("/proc/self/fd");

    /* renamed from: g */
    public static volatile int f6637g = -1;

    public q() {
        new AtomicBoolean(false);
        this.f6638a = true;
        this.f6639b = 20000;
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
                    long j5 = f6637g != -1 ? f6637g : this.f6639b;
                    boolean z9 = ((long) length) < j5;
                    this.f6641d = z9;
                    if (!z9 && Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j5);
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
