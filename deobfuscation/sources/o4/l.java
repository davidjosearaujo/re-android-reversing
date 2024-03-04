package o4;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class l extends m {
    public final int e;

    /* renamed from: f */
    public final int f5352f;

    /* renamed from: g */
    public final TimeInterpolator f5353g;

    /* renamed from: h */
    public AutoCompleteTextView f5354h;

    /* renamed from: i */
    public final i4.a f5355i;

    /* renamed from: j */
    public final c f5356j;

    /* renamed from: k */
    public final c0.m f5357k;

    /* renamed from: l */
    public boolean f5358l;
    public boolean m;

    /* renamed from: n */
    public boolean f5359n;

    /* renamed from: o */
    public long f5360o;

    /* renamed from: p */
    public AccessibilityManager f5361p;

    /* renamed from: q */
    public ValueAnimator f5362q;

    /* renamed from: r */
    public ValueAnimator f5363r;

    public l(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.f5355i = new i4.a(2, this);
        this.f5356j = new c(this, 1);
        this.f5357k = new c0.m(this);
        this.f5360o = Long.MAX_VALUE;
        this.f5352f = e4.j.c(aVar.getContext(), 2130903877, 67);
        this.e = e4.j.c(aVar.getContext(), 2130903877, 50);
        this.f5353g = e4.j.d(aVar.getContext(), 2130903886, n3.a.f5161a);
    }

    @Override // o4.m
    public final void a() {
        if (this.f5361p.isTouchExplorationEnabled()) {
            if ((this.f5354h.getInputType() != 0) && !this.f5367d.hasFocus()) {
                this.f5354h.dismissDropDown();
            }
        }
        this.f5354h.post(new androidx.activity.d(11, this));
    }

    @Override // o4.m
    public final int c() {
        return 2131820604;
    }

    @Override // o4.m
    public final int d() {
        return 2131165406;
    }

    @Override // o4.m
    public final View.OnFocusChangeListener e() {
        return this.f5356j;
    }

    @Override // o4.m
    public final View.OnClickListener f() {
        return this.f5355i;
    }

    @Override // o4.m
    public final q1.d h() {
        return this.f5357k;
    }

    @Override // o4.m
    public final boolean i(int i7) {
        return i7 != 0;
    }

    @Override // o4.m
    public final boolean j() {
        return this.f5358l;
    }

    @Override // o4.m
    public final boolean l() {
        return this.f5359n;
    }

    @Override // o4.m
    public final void m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f5354h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: o4.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                l lVar = l.this;
                lVar.getClass();
                if (motionEvent.getAction() == 1) {
                    long currentTimeMillis = System.currentTimeMillis() - lVar.f5360o;
                    if (currentTimeMillis < 0 || currentTimeMillis > 300) {
                        lVar.m = false;
                    }
                    lVar.u();
                    lVar.m = true;
                    lVar.f5360o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.f5354h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: o4.j
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                l lVar = l.this;
                lVar.m = true;
                lVar.f5360o = System.currentTimeMillis();
                lVar.t(false);
            }
        });
        this.f5354h.setThreshold(0);
        this.f5364a.setErrorIconDrawable((Drawable) null);
        if (!(editText.getInputType() != 0) && this.f5361p.isTouchExplorationEnabled()) {
            CheckableImageButton checkableImageButton = this.f5367d;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.s(checkableImageButton, 2);
        }
        this.f5364a.setEndIconVisible(true);
    }

    @Override // o4.m
    public final void n(q1.f fVar) {
        if (!(this.f5354h.getInputType() != 0)) {
            fVar.h(Spinner.class.getName());
        }
        if (fVar.f5624a.isShowingHintText()) {
            fVar.f5624a.setHintText(null);
        }
    }

    @Override // o4.m
    @SuppressLint({"WrongConstant"})
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (this.f5361p.isEnabled()) {
            boolean z6 = false;
            if (this.f5354h.getInputType() != 0) {
                return;
            }
            if (accessibilityEvent.getEventType() == 32768 && this.f5359n && !this.f5354h.isPopupShowing()) {
                z6 = true;
            }
            if (accessibilityEvent.getEventType() == 1 || z6) {
                u();
                this.m = true;
                this.f5360o = System.currentTimeMillis();
            }
        }
    }

    @Override // o4.m
    public final void r() {
        int i7 = this.f5352f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(this.f5353g);
        ofFloat.setDuration(i7);
        ofFloat.addUpdateListener(new b(this, 1));
        this.f5363r = ofFloat;
        int i8 = this.e;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(this.f5353g);
        ofFloat2.setDuration(i8);
        ofFloat2.addUpdateListener(new b(this, 1));
        this.f5362q = ofFloat2;
        ofFloat2.addListener(new k(this));
        this.f5361p = (AccessibilityManager) this.f5366c.getSystemService("accessibility");
    }

    @Override // o4.m
    @SuppressLint({"ClickableViewAccessibility"})
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.f5354h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f5354h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z6) {
        if (this.f5359n != z6) {
            this.f5359n = z6;
            this.f5363r.cancel();
            this.f5362q.start();
        }
    }

    public final void u() {
        if (this.f5354h == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f5360o;
        if (currentTimeMillis < 0 || currentTimeMillis > 300) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        t(!this.f5359n);
        if (!this.f5359n) {
            this.f5354h.dismissDropDown();
            return;
        }
        this.f5354h.requestFocus();
        this.f5354h.showDropDown();
    }
}
