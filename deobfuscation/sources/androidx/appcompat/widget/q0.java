package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import androidx.appcompat.widget.j;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: g */
    public static q0 f1022g;

    /* renamed from: a */
    public WeakHashMap<Context, o.i<ColorStateList>> f1024a;

    /* renamed from: b */
    public final WeakHashMap<Context, o.e<WeakReference<Drawable.ConstantState>>> f1025b = new WeakHashMap<>(0);

    /* renamed from: c */
    public TypedValue f1026c;

    /* renamed from: d */
    public boolean f1027d;
    public b e;

    /* renamed from: f */
    public static final PorterDuff.Mode f1021f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h */
    public static final a f1023h = new a();

    /* loaded from: classes.dex */
    public static class a extends o.f<Integer, PorterDuffColorFilter> {
        public a() {
            super(6);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public static synchronized q0 c() {
        q0 q0Var;
        synchronized (q0.class) {
            if (f1022g == null) {
                f1022g = new q0();
            }
            q0Var = f1022g;
        }
        return q0Var;
    }

    public static synchronized PorterDuffColorFilter g(int i7, PorterDuff.Mode mode) {
        PorterDuffColorFilter a7;
        synchronized (q0.class) {
            a aVar = f1023h;
            aVar.getClass();
            int i8 = (i7 + 31) * 31;
            a7 = aVar.a(Integer.valueOf(mode.hashCode() + i8));
            if (a7 == null) {
                a7 = new PorterDuffColorFilter(i7, mode);
                aVar.getClass();
                aVar.b(Integer.valueOf(mode.hashCode() + i8), a7);
            }
        }
        return a7;
    }

    public final synchronized void a(Context context, long j5, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            o.e<WeakReference<Drawable.ConstantState>> eVar = this.f1025b.get(context);
            if (eVar == null) {
                eVar = new o.e<>();
                this.f1025b.put(context, eVar);
            }
            eVar.e(new WeakReference(constantState), j5);
        }
    }

    public final Drawable b(Context context, int i7) {
        int i8;
        if (this.f1026c == null) {
            this.f1026c = new TypedValue();
        }
        TypedValue typedValue = this.f1026c;
        context.getResources().getValue(i7, typedValue, true);
        long j5 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable d7 = d(context, j5);
        if (d7 != null) {
            return d7;
        }
        LayerDrawable layerDrawable = null;
        if (this.e != null) {
            if (i7 == 2131165241) {
                layerDrawable = new LayerDrawable(new Drawable[]{e(context, 2131165240), e(context, 2131165242)});
            } else {
                if (i7 == 2131165276) {
                    i8 = 2131099707;
                } else if (i7 == 2131165275) {
                    i8 = 2131099708;
                } else if (i7 == 2131165277) {
                    i8 = 2131099709;
                }
                layerDrawable = j.a.c(this, context, i8);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, j5, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable d(Context context, long j5) {
        o.e<WeakReference<Drawable.ConstantState>> eVar = this.f1025b.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) eVar.d(null, j5);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int j7 = l0.z.j(eVar.f5193g, eVar.f5195i, j5);
            if (j7 >= 0) {
                Object[] objArr = eVar.f5194h;
                Object obj = objArr[j7];
                Object obj2 = o.e.f5191j;
                if (obj != obj2) {
                    objArr[j7] = obj2;
                    eVar.f5192f = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable e(Context context, int i7) {
        return f(context, i7, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:198:0x002b, code lost:
        if (r0 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0059, code lost:
        j1.a.b.i(r12, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized android.graphics.drawable.Drawable f(android.content.Context r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q0.f(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList h(Context context, int i7) {
        ColorStateList colorStateList;
        o.i<ColorStateList> iVar;
        try {
            WeakHashMap<Context, o.i<ColorStateList>> weakHashMap = this.f1024a;
            ColorStateList colorStateList2 = null;
            colorStateList = (weakHashMap == null || (iVar = weakHashMap.get(context)) == null) ? null : (ColorStateList) iVar.c(i7, null);
            if (colorStateList == null) {
                b bVar = this.e;
                if (bVar != null) {
                    colorStateList2 = ((j.a) bVar).d(context, i7);
                }
                if (colorStateList2 != null) {
                    if (this.f1024a == null) {
                        this.f1024a = new WeakHashMap<>();
                    }
                    o.i<ColorStateList> iVar2 = this.f1024a.get(context);
                    if (iVar2 == null) {
                        iVar2 = new o.i<>();
                        this.f1024a.put(context, iVar2);
                    }
                    iVar2.a(i7, colorStateList2);
                }
                colorStateList = colorStateList2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            androidx.appcompat.widget.q0$b r6 = r6.e
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L6b
            androidx.appcompat.widget.j$a r6 = (androidx.appcompat.widget.j.a) r6
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.j.f939b
            int[] r3 = r6.f942a
            boolean r3 = androidx.appcompat.widget.j.a.a(r3, r8)
            r4 = 16842801(0x1010031, float:2.3693695E-38)
            r5 = -1
            if (r3 == 0) goto L1a
            r4 = 2130903291(0x7f0300fb, float:1.7413396E38)
            goto L46
        L1a:
            int[] r3 = r6.f944c
            boolean r3 = androidx.appcompat.widget.j.a.a(r3, r8)
            if (r3 == 0) goto L26
            r4 = 2130903289(0x7f0300f9, float:1.7413392E38)
            goto L46
        L26:
            int[] r6 = r6.f945d
            boolean r6 = androidx.appcompat.widget.j.a.a(r6, r8)
            if (r6 == 0) goto L31
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L46
        L31:
            r6 = 2131165262(0x7f07004e, float:1.7944736E38)
            if (r8 != r6) goto L41
            r6 = 16842800(0x1010030, float:2.3693693E-38)
            r8 = 1109603123(0x42233333, float:40.8)
            int r8 = java.lang.Math.round(r8)
            goto L48
        L41:
            r6 = 2131165244(0x7f07003c, float:1.79447E38)
            if (r8 != r6) goto L4a
        L46:
            r6 = r4
            r8 = r5
        L48:
            r3 = r0
            goto L4d
        L4a:
            r6 = r1
            r3 = r6
            r8 = r5
        L4d:
            if (r3 == 0) goto L67
            int[] r3 = androidx.appcompat.widget.h0.f914a
            android.graphics.drawable.Drawable r9 = r9.mutate()
            int r6 = androidx.appcompat.widget.v0.c(r7, r6)
            android.graphics.PorterDuffColorFilter r6 = androidx.appcompat.widget.j.c(r6, r2)
            r9.setColorFilter(r6)
            if (r8 == r5) goto L65
            r9.setAlpha(r8)
        L65:
            r6 = r0
            goto L68
        L67:
            r6 = r1
        L68:
            if (r6 == 0) goto L6b
            goto L6c
        L6b:
            r0 = r1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.q0.i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
