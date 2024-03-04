package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class n0 extends Writer {

    /* renamed from: g */
    public StringBuilder f1732g = new StringBuilder(128);

    /* renamed from: f */
    public final String f1731f = "FragmentManager";

    public final void b() {
        if (this.f1732g.length() > 0) {
            Log.d(this.f1731f, this.f1732g.toString());
            StringBuilder sb = this.f1732g;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        b();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        b();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            char c7 = cArr[i7 + i9];
            if (c7 == '\n') {
                b();
            } else {
                this.f1732g.append(c7);
            }
        }
    }
}
