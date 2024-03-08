package o4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.c0;
import com.google.android.material.textfield.TextInputLayout;
import e4.j;
import g4.c;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a */
    public final int f5368a;

    /* renamed from: b */
    public final int f5369b;

    /* renamed from: c */
    public final int f5370c;

    /* renamed from: d */
    public final TimeInterpolator f5371d;
    public final TimeInterpolator e;

    /* renamed from: f */
    public final TimeInterpolator f5372f;

    /* renamed from: g */
    public final Context f5373g;

    /* renamed from: h */
    public final TextInputLayout f5374h;

    /* renamed from: i */
    public LinearLayout f5375i;

    /* renamed from: j */
    public int f5376j;

    /* renamed from: k */
    public FrameLayout f5377k;

    /* renamed from: l */
    public Animator f5378l;
    public final float m;

    /* renamed from: n */
    public int f5379n;

    /* renamed from: o */
    public int f5380o;

    /* renamed from: p */
    public CharSequence f5381p;

    /* renamed from: q */
    public boolean f5382q;

    /* renamed from: r */
    public c0 f5383r;
    public CharSequence s;

    /* renamed from: t */
    public int f5384t;

    /* renamed from: u */
    public int f5385u;

    /* renamed from: v */
    public ColorStateList f5386v;

    /* renamed from: w */
    public CharSequence f5387w;

    /* renamed from: x */
    public boolean f5388x;

    /* renamed from: y */
    public c0 f5389y;

    /* renamed from: z */
    public int f5390z;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ int f5391a;

        /* renamed from: b */
        public final /* synthetic */ TextView f5392b;

        /* renamed from: c */
        public final /* synthetic */ int f5393c;

        /* renamed from: d */
        public final /* synthetic */ TextView f5394d;

        public a(int i7, TextView textView, int i8, TextView textView2) {
            o.this = r1;
            this.f5391a = i7;
            this.f5392b = textView;
            this.f5393c = i8;
            this.f5394d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            c0 c0Var;
            o oVar = o.this;
            oVar.f5379n = this.f5391a;
            oVar.f5378l = null;
            TextView textView = this.f5392b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f5393c == 1 && (c0Var = o.this.f5383r) != null) {
                    c0Var.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f5394d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f5394d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            TextView textView = this.f5394d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f5394d.setAlpha(0.0f);
            }
        }
    }

    public o(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f5373g = context;
        this.f5374h = textInputLayout;
        this.m = (float) context.getResources().getDimensionPixelSize(2131099791);
        this.f5368a = j.c(context, 2130903878, 217);
        this.f5369b = j.c(context, 2130903874, 167);
        this.f5370c = j.c(context, 2130903878, 167);
        this.f5371d = j.d(context, 2130903883, n3.a.f5164d);
        LinearInterpolator linearInterpolator = n3.a.f5161a;
        this.e = j.d(context, 2130903883, linearInterpolator);
        this.f5372f = j.d(context, 2130903886, linearInterpolator);
    }

    public final void a(TextView textView, int i7) {
        if (this.f5375i == null && this.f5377k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f5373g);
            this.f5375i = linearLayout;
            linearLayout.setOrientation(0);
            this.f5374h.addView(this.f5375i, -1, -2);
            this.f5377k = new FrameLayout(this.f5373g);
            this.f5375i.addView(this.f5377k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f5374h.getEditText() != null) {
                b();
            }
        }
        if (i7 == 0 || i7 == 1) {
            this.f5377k.setVisibility(0);
            this.f5377k.addView(textView);
        } else {
            this.f5375i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f5375i.setVisibility(0);
        this.f5376j++;
    }

    public final void b() {
        if ((this.f5375i == null || this.f5374h.getEditText() == null) ? false : true) {
            EditText editText = this.f5374h.getEditText();
            boolean d7 = c.d(this.f5373g);
            LinearLayout linearLayout = this.f5375i;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            int f7 = y.e.f(editText);
            if (d7) {
                f7 = this.f5373g.getResources().getDimensionPixelSize(2131100218);
            }
            int dimensionPixelSize = this.f5373g.getResources().getDimensionPixelSize(2131100217);
            if (d7) {
                dimensionPixelSize = this.f5373g.getResources().getDimensionPixelSize(2131100219);
            }
            int e = y.e.e(editText);
            if (d7) {
                e = this.f5373g.getResources().getDimensionPixelSize(2131100218);
            }
            y.e.k(linearLayout, f7, dimensionPixelSize, e, 0);
        }
    }

    public final void c() {
        Animator animator = this.f5378l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z6, TextView textView, int i7, int i8, int i9) {
        if (textView != null && z6) {
            if (i7 == i9 || i7 == i8) {
                boolean z7 = i9 == i7;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z7 ? 1.0f : 0.0f);
                ofFloat.setDuration((long) (z7 ? this.f5369b : this.f5370c));
                ofFloat.setInterpolator(z7 ? this.e : this.f5372f);
                if (i7 == i9 && i8 != 0) {
                    ofFloat.setStartDelay((long) this.f5370c);
                }
                arrayList.add(ofFloat);
                if (i9 == i7 && i8 != 0) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.m, 0.0f);
                    ofFloat2.setDuration((long) this.f5368a);
                    ofFloat2.setInterpolator(this.f5371d);
                    ofFloat2.setStartDelay((long) this.f5370c);
                    arrayList.add(ofFloat2);
                }
            }
        }
    }

    public final TextView e(int i7) {
        if (i7 == 1) {
            return this.f5383r;
        }
        if (i7 != 2) {
            return null;
        }
        return this.f5389y;
    }

    public final void f() {
        this.f5381p = null;
        c();
        if (this.f5379n == 1) {
            this.f5380o = (!this.f5388x || TextUtils.isEmpty(this.f5387w)) ? 0 : 2;
        }
        i(this.f5379n, this.f5380o, h(this.f5383r, ""));
    }

    public final void g(TextView textView, int i7) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = this.f5375i;
        if (viewGroup2 != null) {
            boolean z6 = true;
            if (!(i7 == 0 || i7 == 1)) {
                z6 = false;
            }
            if (z6 && (viewGroup = this.f5377k) != null) {
                viewGroup2 = viewGroup;
            }
            viewGroup2.removeView(textView);
            int i8 = this.f5376j - 1;
            this.f5376j = i8;
            LinearLayout linearLayout = this.f5375i;
            if (i8 == 0) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public final boolean h(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f5374h;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        return y.g.c(textInputLayout) && this.f5374h.isEnabled() && (this.f5380o != this.f5379n || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void i(int i7, int i8, boolean z6) {
        TextView e;
        TextView e7;
        if (i7 != i8) {
            if (z6) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f5378l = animatorSet;
                ArrayList arrayList = new ArrayList();
                d(arrayList, this.f5388x, this.f5389y, 2, i7, i8);
                d(arrayList, this.f5382q, this.f5383r, 1, i7, i8);
                q2.a.J(animatorSet, arrayList);
                animatorSet.addListener(new a(i8, e(i7), i7, e(i8)));
                animatorSet.start();
            } else if (i7 != i8) {
                if (!(i8 == 0 || (e7 = e(i8)) == null)) {
                    e7.setVisibility(0);
                    e7.setAlpha(1.0f);
                }
                if (!(i7 == 0 || (e = e(i7)) == null)) {
                    e.setVisibility(4);
                    if (i7 == 1) {
                        e.setText((CharSequence) null);
                    }
                }
                this.f5379n = i8;
            }
            this.f5374h.r();
            this.f5374h.u(z6, false);
            this.f5374h.x();
        }
    }
}
