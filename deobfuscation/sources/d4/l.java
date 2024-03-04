package d4;

import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: c */
    public float f3626c;
    public WeakReference<b> e;

    /* renamed from: f */
    public g4.d f3628f;

    /* renamed from: a */
    public final TextPaint f3624a = new TextPaint(1);

    /* renamed from: b */
    public final a f3625b = new a();

    /* renamed from: d */
    public boolean f3627d = true;

    /* loaded from: classes.dex */
    public class a extends androidx.activity.result.c {
        public a() {
            l.this = r1;
        }

        @Override // androidx.activity.result.c
        public final void l(int i7) {
            l lVar = l.this;
            lVar.f3627d = true;
            b bVar = lVar.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // androidx.activity.result.c
        public final void m(Typeface typeface, boolean z6) {
            if (z6) {
                return;
            }
            l lVar = l.this;
            lVar.f3627d = true;
            b bVar = lVar.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public l(b bVar) {
        this.e = new WeakReference<>(null);
        this.e = new WeakReference<>(bVar);
    }

    public final float a(String str) {
        if (this.f3627d) {
            this.f3626c = str == null ? 0.0f : this.f3624a.measureText((CharSequence) str, 0, str.length());
            if (str != null) {
                Math.abs(this.f3624a.getFontMetrics().ascent);
            }
            this.f3627d = false;
            return this.f3626c;
        }
        return this.f3626c;
    }
}
