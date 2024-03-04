package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.app.n;

/* loaded from: classes.dex */
public final class r {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final Animation f1754a;

        /* renamed from: b */
        public final Animator f1755b;

        public a(Animator animator) {
            this.f1754a = null;
            this.f1755b = animator;
        }

        public a(Animation animation) {
            this.f1754a = animation;
            this.f1755b = null;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: f */
        public final ViewGroup f1756f;

        /* renamed from: g */
        public final View f1757g;

        /* renamed from: h */
        public boolean f1758h;

        /* renamed from: i */
        public boolean f1759i;

        /* renamed from: j */
        public boolean f1760j;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1760j = true;
            this.f1756f = viewGroup;
            this.f1757g = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public final boolean getTransformation(long j5, Transformation transformation) {
            this.f1760j = true;
            if (this.f1758h) {
                return !this.f1759i;
            }
            if (!super.getTransformation(j5, transformation)) {
                this.f1758h = true;
                p1.s.a(this.f1756f, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public final boolean getTransformation(long j5, Transformation transformation, float f7) {
            this.f1760j = true;
            if (this.f1758h) {
                return !this.f1759i;
            }
            if (!super.getTransformation(j5, transformation, f7)) {
                this.f1758h = true;
                p1.s.a(this.f1756f, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f1758h || !this.f1760j) {
                this.f1756f.endViewTransition(this.f1757g);
                this.f1759i = true;
                return;
            }
            this.f1760j = false;
            this.f1756f.post(this);
        }
    }

    public static a a(Context context, n nVar, boolean z6, boolean z7) {
        int i7;
        n.b bVar = nVar.M;
        boolean z8 = false;
        int i8 = bVar == null ? 0 : bVar.f1724f;
        if (z7) {
            if (z6) {
                if (bVar != null) {
                    i7 = bVar.f1723d;
                }
                i7 = 0;
            } else {
                if (bVar != null) {
                    i7 = bVar.e;
                }
                i7 = 0;
            }
        } else if (z6) {
            if (bVar != null) {
                i7 = bVar.f1721b;
            }
            i7 = 0;
        } else {
            if (bVar != null) {
                i7 = bVar.f1722c;
            }
            i7 = 0;
        }
        nVar.N(0, 0, 0, 0);
        ViewGroup viewGroup = nVar.I;
        if (viewGroup != null && viewGroup.getTag(2131296920) != null) {
            nVar.I.setTag(2131296920, null);
        }
        ViewGroup viewGroup2 = nVar.I;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            if (i7 == 0 && i8 != 0) {
                i7 = i8 != 4097 ? i8 != 4099 ? i8 != 8194 ? -1 : z6 ? 2130837507 : 2130837508 : z6 ? 2130837509 : 2130837510 : z6 ? 2130837511 : 2130837512;
            }
            if (i7 != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(i7));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, i7);
                        if (loadAnimation != null) {
                            return new a(loadAnimation);
                        }
                        z8 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z8) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, i7);
                        if (loadAnimator != null) {
                            return new a(loadAnimator);
                        }
                    } catch (RuntimeException e7) {
                        if (equals) {
                            throw e7;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i7);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }
}
