package com.hunantv.oversea.me.ui.account;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import com.hunantv.oversea.login.fingerprint.FingerprintBindDialog;
import com.hunantv.oversea.login_api.entity.UserInfo;
import j.l.a.w.a;
import j.l.c.k.c;
import j.l.c.k.m.j;
import j.l.c.k.m.o;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AccountSecurityHelper implements LifecycleObserver {
    private MeAccountSecurityActivity a;
    private FingerprintBindDialog b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements FingerprintBindDialog.a {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public void a() {
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(false);
            }
        }

        public void b() {
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(true);
            }
        }

        public void onCancel() {
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(false);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface b {
        void a(boolean z);
    }

    public AccountSecurityHelper(MeAccountSecurityActivity meAccountSecurityActivity) {
        this.a = meAccountSecurityActivity;
        meAccountSecurityActivity.getLifecycle().addObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(j.l.a.c0.a aVar, View view) {
        aVar.dismiss();
        e();
    }

    public void c() {
        UserInfo f;
        a.b bVar = this.a;
        if (bVar == null || bVar.isFinishing() || (f = j.l.c.k.h.a.f()) == null) {
            return;
        }
        if (f.isThirdParty() && TextUtils.isEmpty(f.relate_mobile)) {
            j.l.a.c0.a aVar = new j.l.a.c0.a(this.a);
            aVar.g(c.r.me_profile_thirdparty_bind_content);
            aVar.j(c.r.me_profile_thirdparty_bind_no);
            aVar.n(c.r.me_profile_thirdparty_bind_yes, new j.l.c.k.l.a.a(this, aVar));
            return;
        }
        g();
    }

    public void d() {
        a.b bVar = this.a;
        if (bVar == null || bVar.isFinishing()) {
            return;
        }
        j.l.c.k.h.c.d(this.a, j.v.o.a.d.d.b.b());
    }

    public void e() {
        a.b bVar = this.a;
        if (bVar == null || bVar.isFinishing()) {
            return;
        }
        j.l.c.k.h.c.d(this.a, j.v.o.a.d.d.b.c());
    }

    public void f() {
        a.b bVar = this.a;
        if (bVar == null || bVar.isFinishing()) {
            return;
        }
        j.l.c.k.h.c.b(this.a, j.v.o.a.d.d.b.f());
    }

    public void g() {
        a.b bVar = this.a;
        if (bVar == null || bVar.isFinishing()) {
            return;
        }
        j.l.c.k.h.c.b(this.a, j.v.o.a.d.d.b.d());
    }

    public void h() {
        a.b bVar = this.a;
        if (bVar == null || bVar.isFinishing()) {
            return;
        }
        j.l.c.k.h.c.d(this.a, j.v.o.a.d.d.b.k());
    }

    public void i() {
        UserInfo f;
        a.b bVar = this.a;
        if (bVar == null || bVar.isFinishing() || (f = j.l.c.k.h.a.f()) == null) {
            return;
        }
        if (TextUtils.isEmpty(f.relate_mobile)) {
            String a2 = o.a();
            j.l.c.k.h.c.d(this.a, a2 + "?changepwd");
            return;
        }
        h();
    }

    public void j(b bVar) {
        a.b bVar2 = this.a;
        if (bVar2 == null || bVar2.isFinishing()) {
            return;
        }
        j.b(this.b);
        FingerprintBindDialog fingerprintBindDialog = new FingerprintBindDialog(this.a);
        this.b = fingerprintBindDialog;
        fingerprintBindDialog.g(new a(bVar));
        this.b.show();
    }
}
