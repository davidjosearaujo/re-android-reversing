package m1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    public static final o.f<String, Typeface> f5060a = new o.f<>(16);

    /* renamed from: b */
    public static final ThreadPoolExecutor f5061b;

    /* renamed from: c */
    public static final Object f5062c;

    /* renamed from: d */
    public static final o.h<String, ArrayList<o1.a<a>>> f5063d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final Typeface f5064a;

        /* renamed from: b */
        public final int f5065b;

        public a(int i7) {
            this.f5064a = null;
            this.f5065b = i7;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.f5064a = typeface;
            this.f5065b = 0;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new n());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f5061b = threadPoolExecutor;
        f5062c = new Object();
        f5063d = new o.h<>();
    }

    public static a a(String str, Context context, f fVar, int i7) {
        int i8;
        Typeface a7 = f5060a.a(str);
        if (a7 != null) {
            return new a(a7);
        }
        try {
            l a8 = e.a(context, fVar);
            int i9 = a8.f5066a;
            int i10 = 1;
            if (i9 != 0) {
                if (i9 == 1) {
                    i8 = -2;
                }
                i8 = -3;
            } else {
                m[] mVarArr = a8.f5067b;
                if (mVarArr != null && mVarArr.length != 0) {
                    for (m mVar : mVarArr) {
                        int i11 = mVar.e;
                        if (i11 != 0) {
                            if (i11 >= 0) {
                                i8 = i11;
                            }
                            i8 = -3;
                        }
                    }
                    i10 = 0;
                }
                i8 = i10;
            }
            if (i8 != 0) {
                return new a(i8);
            }
            Typeface a9 = i1.e.a(context, a8.f5067b, i7);
            if (a9 != null) {
                f5060a.b(str, a9);
                return new a(a9);
            }
            return new a(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new a(-1);
        }
    }
}
