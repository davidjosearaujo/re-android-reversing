package a.a.a.d;

import android.util.Log;
import java.io.Writer;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class e extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f91a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f92b = new StringBuilder(128);

    public e(String str) {
        this.f91a = str;
    }

    private void a() {
        if (this.f92b.length() > 0) {
            Log.d(this.f91a, this.f92b.toString());
            StringBuilder sb = this.f92b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.f92b.append(c);
            }
        }
    }
}
