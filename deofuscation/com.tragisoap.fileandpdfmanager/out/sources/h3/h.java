package h3;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import g3.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
@Deprecated
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class h<T extends View, Z> extends a<Z> {

    /* renamed from: f */
    public final T f4384f;

    /* renamed from: g */
    public final a f4385g;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: d */
        public static Integer f4386d;

        /* renamed from: a */
        public final View f4387a;

        /* renamed from: b */
        public final ArrayList f4388b = new ArrayList();

        /* renamed from: c */
        public ViewTreeObserver$OnPreDrawListenerC0064a f4389c;

        /* renamed from: h3.h$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0064a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: f */
            public final WeakReference<a> f4390f;

            public ViewTreeObserver$OnPreDrawListenerC0064a(a aVar) {
                this.f4390f = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f4390f.get();
                if (aVar != null && !aVar.f4388b.isEmpty()) {
                    int c7 = aVar.c();
                    int b2 = aVar.b();
                    boolean z6 = false;
                    if (c7 > 0 || c7 == Integer.MIN_VALUE) {
                        if (b2 > 0 || b2 == Integer.MIN_VALUE) {
                            z6 = true;
                        }
                    }
                    if (z6) {
                        Iterator it = new ArrayList(aVar.f4388b).iterator();
                        while (it.hasNext()) {
                            ((f) it.next()).b(c7, b2);
                        }
                        ViewTreeObserver viewTreeObserver = aVar.f4387a.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnPreDrawListener(aVar.f4389c);
                        }
                        aVar.f4389c = null;
                        aVar.f4388b.clear();
                    }
                }
                return true;
            }
        }

        public a(View view) {
            this.f4387a = view;
        }

        public final int a(int i7, int i8, int i9) {
            int i10 = i8 - i9;
            if (i10 > 0) {
                return i10;
            }
            int i11 = i7 - i9;
            if (i11 > 0) {
                return i11;
            }
            if (this.f4387a.isLayoutRequested() || i8 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = this.f4387a.getContext();
            if (f4386d == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                q2.a.i(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f4386d = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f4386d.intValue();
        }

        public final int b() {
            int paddingBottom = this.f4387a.getPaddingBottom() + this.f4387a.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.f4387a.getLayoutParams();
            return a(this.f4387a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int c() {
            int paddingRight = this.f4387a.getPaddingRight() + this.f4387a.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.f4387a.getLayoutParams();
            return a(this.f4387a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }
    }

    public h(T t5) {
        q2.a.i(t5);
        this.f4384f = t5;
        this.f4385g = new a(t5);
    }

    @Override // h3.g
    public final void b(d dVar) {
        this.f4384f.setTag(2131296495, dVar);
    }

    @Override // h3.g
    public final void e(f fVar) {
        this.f4385g.f4388b.remove(fVar);
    }

    @Override // h3.g
    public final void f(f fVar) {
        a aVar = this.f4385g;
        int c7 = aVar.c();
        int b2 = aVar.b();
        boolean z6 = false;
        if (c7 > 0 || c7 == Integer.MIN_VALUE) {
            if (b2 > 0 || b2 == Integer.MIN_VALUE) {
                z6 = true;
            }
        }
        if (z6) {
            fVar.b(c7, b2);
            return;
        }
        if (!aVar.f4388b.contains(fVar)) {
            aVar.f4388b.add(fVar);
        }
        if (aVar.f4389c == null) {
            ViewTreeObserver viewTreeObserver = aVar.f4387a.getViewTreeObserver();
            a.ViewTreeObserver$OnPreDrawListenerC0064a aVar2 = new a.ViewTreeObserver$OnPreDrawListenerC0064a(aVar);
            aVar.f4389c = aVar2;
            viewTreeObserver.addOnPreDrawListener(aVar2);
        }
    }

    @Override // h3.g
    public final d h() {
        Object tag = this.f4384f.getTag(2131296495);
        if (tag == null) {
            return null;
        }
        if (tag instanceof d) {
            return (d) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // h3.g
    public void i(Drawable drawable) {
        a aVar = this.f4385g;
        ViewTreeObserver viewTreeObserver = aVar.f4387a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(aVar.f4389c);
        }
        aVar.f4389c = null;
        aVar.f4388b.clear();
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Target for: ");
        d7.append(this.f4384f);
        return d7.toString();
    }
}
