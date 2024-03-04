package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class m<TranscodeType> extends g3.a<m<TranscodeType>> {
    public final Context F;
    public final n G;
    public final Class<TranscodeType> H;
    public final g I;
    public o<?, ? super TranscodeType> J;
    public Object K;
    public ArrayList L;
    public m<TranscodeType> M;
    public m<TranscodeType> N;
    public boolean O = true;
    public boolean P;
    public boolean Q;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f2689a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f2690b;

        static {
            int[] iArr = new int[i.values().length];
            f2690b = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2690b[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2690b[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2690b[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f2689a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2689a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2689a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2689a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2689a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2689a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2689a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2689a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        g3.g gVar = (g3.g) ((g3.g) new g3.g().d(r2.l.f5794b).i()).m();
    }

    @SuppressLint({"CheckResult"})
    public m(b bVar, n nVar, Class<TranscodeType> cls, Context context) {
        g3.g gVar;
        this.G = nVar;
        this.H = cls;
        this.F = context;
        g gVar2 = nVar.f2738f.f2625h;
        com.bumptech.glide.a aVar = gVar2.f2635f.get(cls);
        if (aVar == null) {
            for (Map.Entry<Class<?>, o<?, ?>> entry : gVar2.f2635f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    aVar = (o<?, ? super TranscodeType>) entry.getValue();
                }
            }
        }
        this.J = (o<?, ? super TranscodeType>) (aVar == null ? g.f2630k : aVar);
        this.I = bVar.f2625h;
        Iterator<g3.f<Object>> it = nVar.f2745n.iterator();
        while (it.hasNext()) {
            q(it.next());
        }
        synchronized (nVar) {
            gVar = nVar.f2746o;
        }
        r(gVar);
    }

    @Override // g3.a
    public final g3.a a(g3.a aVar) {
        q2.a.i(aVar);
        return (m) super.a(aVar);
    }

    @Override // g3.a
    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (super.equals(mVar) && Objects.equals(this.H, mVar.H) && this.J.equals(mVar.J) && Objects.equals(this.K, mVar.K) && Objects.equals(this.L, mVar.L) && Objects.equals(this.M, mVar.M) && Objects.equals(this.N, mVar.N) && this.O == mVar.O && this.P == mVar.P) {
                return true;
            }
        }
        return false;
    }

    @Override // g3.a
    public final int hashCode() {
        return k3.l.h(k3.l.h(k3.l.g(k3.l.g(k3.l.g(k3.l.g(k3.l.g(k3.l.g(k3.l.g(super.hashCode(), this.H), this.J), this.K), this.L), this.M), this.N), null), this.O), this.P);
    }

    public final m<TranscodeType> q(g3.f<TranscodeType> fVar) {
        if (this.A) {
            return clone().q(fVar);
        }
        if (fVar != null) {
            if (this.L == null) {
                this.L = new ArrayList();
            }
            this.L.add(fVar);
        }
        j();
        return this;
    }

    public final m<TranscodeType> r(g3.a<?> aVar) {
        q2.a.i(aVar);
        return (m) super.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g3.d s(int i7, int i8, i iVar, o oVar, g3.a aVar, g3.e eVar, h3.g gVar, Object obj) {
        g3.b bVar;
        g3.b bVar2;
        g3.i x3;
        int i9;
        i iVar2;
        int i10;
        int i11;
        if (this.N != null) {
            g3.b bVar3 = new g3.b(obj, eVar);
            bVar = bVar3;
            bVar2 = bVar3;
        } else {
            bVar = null;
            bVar2 = eVar;
        }
        m<TranscodeType> mVar = this.M;
        if (mVar == null) {
            x3 = x(i7, i8, iVar, oVar, aVar, bVar2, gVar, obj);
        } else if (this.Q) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else {
            o<?, ? super TranscodeType> oVar2 = mVar.O ? oVar : mVar.J;
            if (g3.a.e(mVar.f4193f, 8)) {
                iVar2 = this.M.f4196i;
            } else {
                int ordinal = iVar.ordinal();
                if (ordinal == 0 || ordinal == 1) {
                    iVar2 = i.IMMEDIATE;
                } else if (ordinal == 2) {
                    iVar2 = i.HIGH;
                } else if (ordinal != 3) {
                    StringBuilder d7 = androidx.activity.h.d("unknown priority: ");
                    d7.append(this.f4196i);
                    throw new IllegalArgumentException(d7.toString());
                } else {
                    iVar2 = i.NORMAL;
                }
            }
            i iVar3 = iVar2;
            m<TranscodeType> mVar2 = this.M;
            int i12 = mVar2.f4202p;
            int i13 = mVar2.f4201o;
            if (k3.l.i(i7, i8)) {
                m<TranscodeType> mVar3 = this.M;
                if (!k3.l.i(mVar3.f4202p, mVar3.f4201o)) {
                    i11 = aVar.f4202p;
                    i10 = aVar.f4201o;
                    g3.j jVar = new g3.j(obj, bVar2);
                    g3.i x6 = x(i7, i8, iVar, oVar, aVar, jVar, gVar, obj);
                    this.Q = true;
                    m<TranscodeType> mVar4 = this.M;
                    g3.d s = mVar4.s(i11, i10, iVar3, oVar2, mVar4, jVar, gVar, obj);
                    this.Q = false;
                    jVar.f4242c = x6;
                    jVar.f4243d = s;
                    x3 = jVar;
                }
            }
            i10 = i13;
            i11 = i12;
            g3.j jVar2 = new g3.j(obj, bVar2);
            g3.i x62 = x(i7, i8, iVar, oVar, aVar, jVar2, gVar, obj);
            this.Q = true;
            m<TranscodeType> mVar42 = this.M;
            g3.d s6 = mVar42.s(i11, i10, iVar3, oVar2, mVar42, jVar2, gVar, obj);
            this.Q = false;
            jVar2.f4242c = x62;
            jVar2.f4243d = s6;
            x3 = jVar2;
        }
        if (bVar == null) {
            return x3;
        }
        m<TranscodeType> mVar5 = this.N;
        int i14 = mVar5.f4202p;
        int i15 = mVar5.f4201o;
        if (k3.l.i(i7, i8)) {
            m<TranscodeType> mVar6 = this.N;
            if (!k3.l.i(mVar6.f4202p, mVar6.f4201o)) {
                int i16 = aVar.f4202p;
                i9 = aVar.f4201o;
                i14 = i16;
                m<TranscodeType> mVar7 = this.N;
                g3.d s7 = mVar7.s(i14, i9, mVar7.f4196i, mVar7.J, mVar7, bVar, gVar, obj);
                bVar.f4214c = x3;
                bVar.f4215d = s7;
                return bVar;
            }
        }
        i9 = i15;
        m<TranscodeType> mVar72 = this.N;
        g3.d s72 = mVar72.s(i14, i9, mVar72.f4196i, mVar72.J, mVar72, bVar, gVar, obj);
        bVar.f4214c = x3;
        bVar.f4215d = s72;
        return bVar;
    }

    @Override // g3.a
    /* renamed from: t */
    public final m<TranscodeType> mo1clone() {
        m<TranscodeType> mVar = (m) super.clone();
        mVar.J = (o<?, ? super TranscodeType>) mVar.J.clone();
        if (mVar.L != null) {
            mVar.L = new ArrayList(mVar.L);
        }
        m<TranscodeType> mVar2 = mVar.M;
        if (mVar2 != null) {
            mVar.M = mVar2.clone();
        }
        m<TranscodeType> mVar3 = mVar.N;
        if (mVar3 != null) {
            mVar.N = mVar3.clone();
        }
        return mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(android.widget.ImageView r4) {
        /*
            r3 = this;
            k3.l.a()
            q2.a.i(r4)
            int r0 = r3.f4193f
            r1 = 2048(0x800, float:2.87E-42)
            boolean r0 = g3.a.e(r0, r1)
            if (r0 != 0) goto L56
            boolean r0 = r3.s
            if (r0 == 0) goto L56
            android.widget.ImageView$ScaleType r0 = r4.getScaleType()
            if (r0 == 0) goto L56
            int[] r0 = com.bumptech.glide.m.a.f2689a
            android.widget.ImageView$ScaleType r1 = r4.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L46;
                case 2: goto L3d;
                case 3: goto L2a;
                case 4: goto L2a;
                case 5: goto L2a;
                case 6: goto L3d;
                default: goto L29;
            }
        L29:
            goto L56
        L2a:
            com.bumptech.glide.m r0 = r3.clone()
            y2.k$e r1 = y2.k.f6616a
            y2.p r2 = new y2.p
            r2.<init>()
            g3.a r0 = r0.g(r1, r2)
            r1 = 1
            r0.D = r1
            goto L57
        L3d:
            com.bumptech.glide.m r0 = r3.clone()
            g3.a r0 = r0.f()
            goto L57
        L46:
            com.bumptech.glide.m r0 = r3.clone()
            y2.k$d r1 = y2.k.f6618c
            y2.h r2 = new y2.h
            r2.<init>()
            g3.a r0 = r0.g(r1, r2)
            goto L57
        L56:
            r0 = r3
        L57:
            com.bumptech.glide.g r1 = r3.I
            java.lang.Class<TranscodeType> r2 = r3.H
            a6.a0 r1 = r1.f2633c
            r1.getClass()
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L6e
            h3.b r1 = new h3.b
            r1.<init>(r4)
            goto L7b
        L6e:
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L7f
            h3.d r1 = new h3.d
            r1.<init>(r4)
        L7b:
            r3.v(r1, r0)
            return
        L7f:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unhandled class: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ", try .as*(Class).transcode(ResourceTranscoder)"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.m.u(android.widget.ImageView):void");
    }

    public final void v(h3.g gVar, g3.a aVar) {
        q2.a.i(gVar);
        if (!this.P) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        Object obj = new Object();
        g3.d s = s(aVar.f4202p, aVar.f4201o, aVar.f4196i, this.J, aVar, null, gVar, obj);
        g3.d h7 = gVar.h();
        if (s.g(h7)) {
            if (!(!aVar.f4200n && h7.i())) {
                q2.a.i(h7);
                if (h7.isRunning()) {
                    return;
                }
                h7.f();
                return;
            }
        }
        this.G.l(gVar);
        gVar.b(s);
        n nVar = this.G;
        synchronized (nVar) {
            nVar.f2743k.f2736f.add(gVar);
            com.bumptech.glide.manager.n nVar2 = nVar.f2741i;
            nVar2.f2717a.add(s);
            if (nVar2.f2719c) {
                s.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                nVar2.f2718b.add(s);
            } else {
                s.f();
            }
        }
    }

    public final m<TranscodeType> w(Object obj) {
        if (this.A) {
            return clone().w(obj);
        }
        this.K = obj;
        this.P = true;
        j();
        return this;
    }

    public final g3.i x(int i7, int i8, i iVar, o oVar, g3.a aVar, g3.e eVar, h3.g gVar, Object obj) {
        Context context = this.F;
        g gVar2 = this.I;
        return new g3.i(context, gVar2, obj, this.K, this.H, aVar, i7, i8, iVar, gVar, this.L, eVar, gVar2.f2636g, oVar.f2750f);
    }
}
