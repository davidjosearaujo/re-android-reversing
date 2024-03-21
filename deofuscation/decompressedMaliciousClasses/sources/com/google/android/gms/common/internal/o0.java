package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b.a.a.a.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class o0 extends Handler {
    private static short[] $ = {31213, 31174, 31175, 31118, 31197, 31113, 31170, 31175, 31174, 31198, 31113, 31169, 31174, 31198, 31113, 31197, 31174, 31113, 31169, 31176, 31175, 31181, 31173, 31180, 31113, 31172, 31180, 31194, 31194, 31176, 31182, 31180, 31123, 31113, 31880, 31906, 31932, 31884, 31907, 31910, 31914, 31905, 31931};

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ k0 f270a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(k0 k0Var, Looper looper) {
        super(looper);
        this.f270a = k0Var;
    }

    private static void a(Message message) {
        ((p0) message.obj).b();
    }

    private static boolean b(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f270a.s.get() == message.arg1) {
            int i = message.what;
            if ((i == 1 || i == 7 || i == 4 || i == 5) && !this.f270a.c()) {
                a(message);
                return;
            }
            int i2 = message.what;
            PendingIntent pendingIntent = null;
            if (i2 == 4) {
                this.f270a.q = new a(message.arg2);
                if (!(this.f270a.T()) || (this.f270a.r)) {
                    a aVar = this.f270a.q != null ? this.f270a.q : new a(8);
                    this.f270a.h.b(aVar);
                    this.f270a.o(aVar);
                    return;
                }
                this.f270a.v(3, null);
            } else if (i2 == 5) {
                a aVar2 = this.f270a.q != null ? this.f270a.q : new a(8);
                this.f270a.h.b(aVar2);
                this.f270a.o(aVar2);
            } else if (i2 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                a aVar3 = new a(message.arg2, pendingIntent);
                this.f270a.h.b(aVar3);
                this.f270a.o(aVar3);
            } else if (i2 == 6) {
                this.f270a.v(5, null);
                if (this.f270a.m != null) {
                    this.f270a.m.a(message.arg2);
                }
                this.f270a.p(message.arg2);
                boolean unused = this.f270a.z(5, 1, null);
            } else if (i2 == 2 && !this.f270a.d()) {
                a(message);
            } else if (b(message)) {
                ((p0) message.obj).c();
            } else {
                int i3 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append($(0, 34, 31145));
                sb.append(i3);
                Log.wtf($(34, 43, 31951), sb.toString(), new Exception());
            }
        } else if (b(message)) {
            a(message);
        }
    }
}
