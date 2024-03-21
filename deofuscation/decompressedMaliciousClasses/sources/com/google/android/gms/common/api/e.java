package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import b.a.a.a.e.e1;
import b.a.a.a.e.j;
import b.a.a.a.e.j1;
import b.a.a.a.e.r1;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.w0;
import com.google.android.gms.common.internal.x0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class e {

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static final class a {

        /* renamed from: a */
        private Account f237a;
        private int c;
        private View d;
        private String e;
        private String f;

        /* renamed from: b */
        private final Set<Scope> f238b = new HashSet();
        private final Map<a<?>, x0> g = new a.a.a.d.a();
        private final Map<a<?>, a.AbstractC0005a> h = new a.a.a.d.a();

        public a(Context context) {
            new HashSet();
            b.a.a.a.c.c.j();
            a.b<r1, j1> bVar = e1.c;
            new ArrayList();
            new ArrayList();
            context.getMainLooper();
            this.e = context.getPackageName();
            this.f = context.getClass().getName();
        }

        public final a a(Account account) {
            this.f237a = account;
            return this;
        }

        public final w0 b() {
            j1 j1Var = j1.i;
            if (this.h.containsKey(e1.e)) {
                j1Var = (j1) this.h.get(e1.e);
            }
            return new w0(this.f237a, this.f238b, this.g, this.c, this.d, this.e, this.f, j1Var);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface b {
        void a(int i);

        void c(Bundle bundle);
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface c {
        void b(b.a.a.a.c.a aVar);
    }

    static {
        Collections.newSetFromMap(new WeakHashMap());
    }

    public Looper a() {
        throw new UnsupportedOperationException();
    }

    public <A extends a.c, R extends j, T extends j<R, A>> T b(T t) {
        throw new UnsupportedOperationException();
    }
}
