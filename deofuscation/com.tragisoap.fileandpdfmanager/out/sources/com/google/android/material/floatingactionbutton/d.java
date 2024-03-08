package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.s0;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e4.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class d {

    /* renamed from: a */
    public k4.i f3171a;

    /* renamed from: b */
    public boolean f3172b;

    /* renamed from: d */
    public float f3174d;
    public float e;

    /* renamed from: f */
    public float f3175f;

    /* renamed from: g */
    public Animator f3176g;

    /* renamed from: h */
    public n3.g f3177h;

    /* renamed from: i */
    public n3.g f3178i;

    /* renamed from: j */
    public float f3179j;

    /* renamed from: l */
    public int f3181l;

    /* renamed from: n */
    public ArrayList<Animator.AnimatorListener> f3182n;

    /* renamed from: o */
    public ArrayList<Animator.AnimatorListener> f3183o;

    /* renamed from: p */
    public ArrayList<f> f3184p;

    /* renamed from: q */
    public final FloatingActionButton f3185q;

    /* renamed from: r */
    public final j4.b f3186r;

    /* renamed from: w */
    public c4.a f3190w;

    /* renamed from: x */
    public static final c2.a f3168x = n3.a.f5163c;

    /* renamed from: y */
    public static final int f3169y = 2130903868;

    /* renamed from: z */
    public static final int f3170z = 2130903884;
    public static final int A = 2130903871;
    public static final int B = 2130903882;
    public static final int[] C = {16842919, 16842910};
    public static final int[] D = {16843623, 16842908, 16842910};
    public static final int[] E = {16842908, 16842910};
    public static final int[] F = {16843623, 16842910};
    public static final int[] G = {16842910};
    public static final int[] H = new int[0];

    /* renamed from: c */
    public boolean f3173c = true;

    /* renamed from: k */
    public float f3180k = 1.0f;
    public int m = 0;
    public final Rect s = new Rect();

    /* renamed from: t */
    public final RectF f3187t = new RectF();

    /* renamed from: u */
    public final RectF f3188u = new RectF();

    /* renamed from: v */
    public final Matrix f3189v = new Matrix();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends n3.f {
        public a() {
            d.this = r1;
        }

        @Override // android.animation.TypeEvaluator
        public final Matrix evaluate(float f7, Matrix matrix, Matrix matrix2) {
            d.this.f3180k = f7;
            matrix.getValues(this.f5169a);
            matrix2.getValues(this.f5170b);
            for (int i7 = 0; i7 < 9; i7++) {
                float[] fArr = this.f5170b;
                float f8 = fArr[i7];
                float f9 = this.f5169a[i7];
                fArr[i7] = s0.f(f8, f9, f7, f9);
            }
            this.f5171c.setValues(this.f5170b);
            return this.f5171c;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ float f3192a;

        /* renamed from: b */
        public final /* synthetic */ float f3193b;

        /* renamed from: c */
        public final /* synthetic */ float f3194c;

        /* renamed from: d */
        public final /* synthetic */ float f3195d;
        public final /* synthetic */ float e;

        /* renamed from: f */
        public final /* synthetic */ float f3196f;

        /* renamed from: g */
        public final /* synthetic */ float f3197g;

        /* renamed from: h */
        public final /* synthetic */ Matrix f3198h;

        public b(float f7, float f8, float f9, float f10, float f11, float f12, float f13, Matrix matrix) {
            d.this = r1;
            this.f3192a = f7;
            this.f3193b = f8;
            this.f3194c = f9;
            this.f3195d = f10;
            this.e = f11;
            this.f3196f = f12;
            this.f3197g = f13;
            this.f3198h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.f3185q.setAlpha(n3.a.a(this.f3192a, this.f3193b, 0.0f, 0.2f, floatValue));
            FloatingActionButton floatingActionButton = d.this.f3185q;
            float f7 = this.f3194c;
            floatingActionButton.setScaleX(((this.f3195d - f7) * floatValue) + f7);
            FloatingActionButton floatingActionButton2 = d.this.f3185q;
            float f8 = this.e;
            floatingActionButton2.setScaleY(((this.f3195d - f8) * floatValue) + f8);
            d dVar = d.this;
            float f9 = this.f3196f;
            float f10 = this.f3197g;
            dVar.f3180k = s0.f(f10, f9, floatValue, f9);
            dVar.a(s0.f(f10, f9, floatValue, f9), this.f3198h);
            d.this.f3185q.setImageMatrix(this.f3198h);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c extends i {
        public c(c4.b bVar) {
            super(bVar);
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            return 0.0f;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.d$d */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0035d extends i {

        /* renamed from: c */
        public final /* synthetic */ d f3200c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0035d(c4.b bVar) {
            super(bVar);
            this.f3200c = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            d dVar = this.f3200c;
            return dVar.f3174d + dVar.e;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e extends i {

        /* renamed from: c */
        public final /* synthetic */ d f3201c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c4.b bVar) {
            super(bVar);
            this.f3201c = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            d dVar = this.f3201c;
            return dVar.f3174d + dVar.f3175f;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface g {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class h extends i {

        /* renamed from: c */
        public final /* synthetic */ d f3202c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(c4.b bVar) {
            super(bVar);
            this.f3202c = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            return this.f3202c.f3174d;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public boolean f3203a;

        /* renamed from: b */
        public final /* synthetic */ d f3204b;

        public i(c4.b bVar) {
            this.f3204b = bVar;
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.f3204b.getClass();
            this.f3203a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f3203a) {
                this.f3204b.getClass();
                a();
                this.f3203a = true;
            }
            d dVar = this.f3204b;
            valueAnimator.getAnimatedFraction();
            dVar.getClass();
        }
    }

    public d(FloatingActionButton floatingActionButton, FloatingActionButton.b bVar) {
        this.f3185q = floatingActionButton;
        this.f3186r = bVar;
        d4.i iVar = new d4.i();
        c4.b bVar2 = (c4.b) this;
        iVar.a(C, d(new e(bVar2)));
        iVar.a(D, d(new C0035d(bVar2)));
        iVar.a(E, d(new C0035d(bVar2)));
        iVar.a(F, d(new C0035d(bVar2)));
        iVar.a(G, d(new h(bVar2)));
        iVar.a(H, d(new c(bVar2)));
        this.f3179j = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(i iVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f3168x);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(iVar);
        valueAnimator.addUpdateListener(iVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f7, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f3185q.getDrawable();
        if (drawable != null && this.f3181l != 0) {
            RectF rectF = this.f3187t;
            RectF rectF2 = this.f3188u;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i7 = this.f3181l;
            rectF2.set(0.0f, 0.0f, (float) i7, (float) i7);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i8 = this.f3181l;
            matrix.postScale(f7, f7, ((float) i8) / 2.0f, ((float) i8) / 2.0f);
        }
    }

    public final AnimatorSet b(n3.g gVar, float f7, float f8, float f9) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3185q, View.ALPHA, f7);
        gVar.c("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3185q, View.SCALE_X, f8);
        gVar.c("scale").a(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f3185q, View.SCALE_Y, f8);
        gVar.c("scale").a(ofFloat3);
        arrayList.add(ofFloat3);
        a(f9, this.f3189v);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f3185q, new n3.e(), new a(), new Matrix(this.f3189v));
        gVar.c("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        q2.a.J(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f7, float f8, float f9, int i7, int i8) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this.f3185q.getAlpha(), f7, this.f3185q.getScaleX(), f8, this.f3185q.getScaleY(), this.f3180k, f9, new Matrix(this.f3189v)));
        arrayList.add(ofFloat);
        q2.a.J(animatorSet, arrayList);
        animatorSet.setDuration((long) j.c(this.f3185q.getContext(), i7, this.f3185q.getContext().getResources().getInteger(2131361830)));
        animatorSet.setInterpolator(j.d(this.f3185q.getContext(), i8, n3.a.f5162b));
        return animatorSet;
    }

    public float e() {
        throw null;
    }

    public void f(Rect rect) {
        int i7 = 0;
        if (this.f3172b) {
            i7 = Math.max((0 - this.f3185q.getSizeDimension()) / 2, 0);
        }
        float e7 = this.f3173c ? e() + this.f3175f : 0.0f;
        int max = Math.max(i7, (int) Math.ceil((double) e7));
        int max2 = Math.max(i7, (int) Math.ceil((double) (e7 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public void g() {
        throw null;
    }

    public void h() {
        throw null;
    }

    public void i(int[] iArr) {
        throw null;
    }

    public void j(float f7, float f8, float f9) {
        throw null;
    }

    public final void k() {
        ArrayList<f> arrayList = this.f3184p;
        if (arrayList != null) {
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void l() {
        throw null;
    }

    public void m() {
        throw null;
    }

    public final void n() {
        f(this.s);
        a0.e.i(null, "Didn't initialize content background");
        throw null;
    }
}
