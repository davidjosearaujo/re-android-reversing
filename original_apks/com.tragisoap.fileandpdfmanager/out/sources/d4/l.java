package d4;

import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.activity.result.c;
import g4.d;
import java.lang.ref.WeakReference;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {

    /* renamed from: c  reason: collision with root package name */
    public float f3626c;
    public WeakReference<b> e;

    /* renamed from: f  reason: collision with root package name */
    public d f3628f;

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f3624a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public final a f3625b = new a();

    /* renamed from: d  reason: collision with root package name */
    public boolean f3627d = true;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends c {
        public a() {
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
            if (!z6) {
                l lVar = l.this;
                lVar.f3627d = true;
                b bVar = lVar.e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        void a();

        int[] getState();

        @Override // d4.l.b
        boolean onStateChange(int[] iArr);
    }

    public l(b bVar) {
        this.e = new WeakReference<>(null);
        this.e = new WeakReference<>(bVar);
    }

    public final float a(String str) {
        if (!this.f3627d) {
            return this.f3626c;
        }
        this.f3626c = str == null ? 0.0f : this.f3624a.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(this.f3624a.getFontMetrics().ascent);
        }
        this.f3627d = false;
        return this.f3626c;
    }
}
