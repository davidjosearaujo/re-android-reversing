package o4;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import androidx.activity.k;
import e4.j;
import i4.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f extends m {
    public final int e;

    /* renamed from: f */
    public final int f5341f;

    /* renamed from: g */
    public final TimeInterpolator f5342g;

    /* renamed from: h */
    public final TimeInterpolator f5343h;

    /* renamed from: i */
    public EditText f5344i;

    /* renamed from: j */
    public final a f5345j = new a(1, this);

    /* renamed from: k */
    public final c f5346k = new c(this, 0);

    /* renamed from: l */
    public AnimatorSet f5347l;
    public ValueAnimator m;

    public f(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.e = j.c(aVar.getContext(), 2130903877, 100);
        this.f5341f = j.c(aVar.getContext(), 2130903877, 150);
        this.f5342g = j.d(aVar.getContext(), 2130903886, n3.a.f5161a);
        this.f5343h = j.d(aVar.getContext(), 2130903884, n3.a.f5164d);
    }

    @Override // o4.m
    public final void a() {
        if (this.f5365b.f3333u == null) {
            t(u());
        }
    }

    @Override // o4.m
    public final int c() {
        return 2131820590;
    }

    @Override // o4.m
    public final int d() {
        return 2131165409;
    }

    @Override // o4.m
    public final View.OnFocusChangeListener e() {
        return this.f5346k;
    }

    @Override // o4.m
    public final View.OnClickListener f() {
        return this.f5345j;
    }

    @Override // o4.m
    public final View.OnFocusChangeListener g() {
        return this.f5346k;
    }

    @Override // o4.m
    public final void m(EditText editText) {
        this.f5344i = editText;
        this.f5364a.setEndIconVisible(u());
    }

    @Override // o4.m
    public final void p(boolean z6) {
        if (this.f5365b.f3333u != null) {
            t(z6);
        }
    }

    @Override // o4.m
    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f5343h);
        ofFloat.setDuration((long) this.f5341f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o4.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f fVar = f.this;
                fVar.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                fVar.f5367d.setScaleX(floatValue);
                fVar.f5367d.setScaleY(floatValue);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(this.f5342g);
        ofFloat2.setDuration((long) this.e);
        ofFloat2.addUpdateListener(new b(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5347l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f5347l.addListener(new d(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(this.f5342g);
        ofFloat3.setDuration((long) this.e);
        ofFloat3.addUpdateListener(new b(this, 0));
        this.m = ofFloat3;
        ofFloat3.addListener(new e(this));
    }

    @Override // o4.m
    public final void s() {
        EditText editText = this.f5344i;
        if (editText != null) {
            editText.post(new k(9, this));
        }
    }

    public final void t(boolean z6) {
        boolean z7 = this.f5365b.d() == z6;
        if (z6 && !this.f5347l.isRunning()) {
            this.m.cancel();
            this.f5347l.start();
            if (z7) {
                this.f5347l.end();
            }
        } else if (!z6) {
            this.f5347l.cancel();
            this.m.start();
            if (z7) {
                this.m.end();
            }
        }
    }

    public final boolean u() {
        EditText editText = this.f5344i;
        return editText != null && (editText.hasFocus() || this.f5367d.hasFocus()) && this.f5344i.getText().length() > 0;
    }
}
