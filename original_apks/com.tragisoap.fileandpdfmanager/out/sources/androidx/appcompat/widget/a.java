package androidx.appcompat.widget;

import a0.e;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.f;
import p1.k0;
import p1.l0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: f */
    public final C0008a f805f;

    /* renamed from: g */
    public final Context f806g;

    /* renamed from: h */
    public ActionMenuView f807h;

    /* renamed from: i */
    public c f808i;

    /* renamed from: j */
    public int f809j;

    /* renamed from: k */
    public k0 f810k;

    /* renamed from: l */
    public boolean f811l;
    public boolean m;

    /* renamed from: androidx.appcompat.widget.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0008a implements l0 {

        /* renamed from: a */
        public boolean f812a = false;

        /* renamed from: b */
        public int f813b;

        public C0008a() {
            a.this = r1;
        }

        @Override // p1.l0
        public final void a() {
            if (!this.f812a) {
                a aVar = a.this;
                aVar.f810k = null;
                a.super.setVisibility(this.f813b);
            }
        }

        @Override // p1.l0
        public final void b(View view) {
            this.f812a = true;
        }

        @Override // p1.l0
        public final void c() {
            a.super.setVisibility(0);
            this.f812a = false;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f805f = new C0008a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(2130903044, typedValue, true) || typedValue.resourceId == 0) {
            this.f806g = context;
        } else {
            this.f806g = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int c(View view, int i7, int i8) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), i8);
        return Math.max(0, (i7 - view.getMeasuredWidth()) - 0);
    }

    public static int d(View view, int i7, int i8, int i9, boolean z6) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = ((i9 - measuredHeight) / 2) + i8;
        if (z6) {
            view.layout(i7 - measuredWidth, i10, i7, measuredHeight + i10);
        } else {
            view.layout(i7, i10, i7 + measuredWidth, measuredHeight + i10);
        }
        return z6 ? -measuredWidth : measuredWidth;
    }

    public final k0 e(int i7, long j7) {
        k0 k0Var = this.f810k;
        if (k0Var != null) {
            k0Var.b();
        }
        if (i7 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            k0 a7 = y.a(this);
            a7.a(1.0f);
            a7.c(j7);
            C0008a aVar = this.f805f;
            a.this.f810k = a7;
            aVar.f813b = i7;
            a7.d(aVar);
            return a7;
        }
        k0 a8 = y.a(this);
        a8.a(0.0f);
        a8.c(j7);
        C0008a aVar2 = this.f805f;
        a.this.f810k = a8;
        aVar2.f813b = i7;
        a8.d(aVar2);
        return a8;
    }

    public int getAnimatedVisibility() {
        return this.f810k != null ? this.f805f.f813b : getVisibility();
    }

    public int getContentHeight() {
        return this.f809j;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, e.f56w, 2130903047, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f808i;
        if (cVar != null) {
            Configuration configuration2 = cVar.f530g.getResources().getConfiguration();
            int i7 = configuration2.screenWidthDp;
            int i8 = configuration2.screenHeightDp;
            cVar.f845u = (configuration2.smallestScreenWidthDp > 600 || i7 > 600 || (i7 > 960 && i8 > 720) || (i7 > 720 && i8 > 960)) ? 5 : (i7 >= 500 || (i7 > 640 && i8 > 480) || (i7 > 480 && i8 > 640)) ? 4 : i7 >= 360 ? 3 : 2;
            f fVar = cVar.f531h;
            if (fVar != null) {
                fVar.p(true);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.m = false;
        }
        if (!this.m) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.m = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.m = false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f811l = false;
        }
        if (!this.f811l) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f811l = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f811l = false;
        }
        return true;
    }

    public void setContentHeight(int i7) {
        this.f809j = i7;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        if (i7 != getVisibility()) {
            k0 k0Var = this.f810k;
            if (k0Var != null) {
                k0Var.b();
            }
            super.setVisibility(i7);
        }
    }
}
