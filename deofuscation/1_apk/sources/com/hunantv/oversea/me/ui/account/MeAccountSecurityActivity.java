package com.hunantv.oversea.me.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.oversea.login.fingerprint.FingerprintAuthManager;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.adapter.AccountSecurityAdapter;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import com.hunantv.oversea.me.ui.account.AccountSecurityHelper;
import com.hunantv.oversea.me.ui.profile.MeProfileActivity;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.widget.recyclerview.MGRecyclerView;
import j.l.a.w.a;
import j.l.c.h.e;
import j.l.c.k.c;
import j.l.c.k.e.b;
import j.l.c.k.f.d;
import j.l.c.k.h.c;
import j.l.c.k.o.k;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeAccountSecurityActivity extends MeBaseActivity implements a.b, e {
    private AccountSecurityAdapter a;
    private k b;
    private AccountSecurityHelper c;
    private boolean d = false;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements AccountSecurityHelper.b {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // com.hunantv.oversea.me.ui.account.AccountSecurityHelper.b
        public void a(boolean z) {
            this.a.e = z;
            if (MeAccountSecurityActivity.this.a != null) {
                MeAccountSecurityActivity.this.a.t(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void B0(View view, byte b) {
        if (1 == b) {
            onBackPressed();
        }
    }

    private void C0(j.l.c.k.e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (bVar.e) {
                this.c.j(new a(bVar));
            } else {
                FingerprintAuthManager.e().m((String) null);
            }
        }
    }

    private void D0() {
        if (this.b.i()) {
            return;
        }
        if (this.b.h()) {
            this.c.c();
        } else {
            this.c.i();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void E0() {
        if (isFinishing()) {
            return;
        }
        c.b(this, j.v.o.a.d.d.b.r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(List<j.l.c.k.e.a> list) {
        this.a.setList(list);
        this.a.notifyDataSetChanged();
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return c.m.me_activity_account_security;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 201) {
            j.l.c.k.h.a.k();
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onDestroy() {
        super.onDestroy();
        j.l.c.k.h.a.j(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        customizeTitleBar.setBackgroundResource(c.h.me_bg_title_bar);
        customizeTitleBar.setOnComponentClickListener(new j.l.c.k.l.a.b(this));
        MGRecyclerView findViewById = findViewById(c.j.recyclerView);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(this);
        linearLayoutManagerWrapper.setOrientation(1);
        findViewById.setLayoutManager(linearLayoutManagerWrapper);
        AccountSecurityAdapter accountSecurityAdapter = new AccountSecurityAdapter(this);
        this.a = accountSecurityAdapter;
        accountSecurityAdapter.x(this);
        findViewById.setAdapter(this.a);
        this.c = new AccountSecurityHelper(this);
        k kVar = new ViewModelProvider(this).get(k.class);
        this.b = kVar;
        kVar.g().observe(this, new j.l.c.k.l.a.c(this));
        j.l.c.k.h.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onItemClick(View view, int i) {
        j.l.c.k.e.a aVar = (j.l.c.k.e.a) this.a.getItem(i);
        if (aVar == null) {
            return;
        }
        switch (aVar.a()) {
            case 1:
                D0();
                return;
            case 2:
                this.c.e();
                return;
            case 3:
                this.c.f();
                return;
            case 4:
                startActivity(new Intent((Context) this, (Class<?>) MeProfileActivity.class));
                return;
            case 5:
                E0();
                return;
            case 6:
                C0(aVar);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        if (this.d) {
            this.d = false;
            j.l.c.k.h.a.b(this);
        }
        this.b.l();
        d.a();
        MGDCManager.n().enterScene("account_and_security", this);
        MGDCManager.n().onEvent("page");
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onStop() {
        super.onStop();
        this.d = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onUserInfoChanged(@Nullable UserInfo userInfo) {
        if (isFinishing()) {
            return;
        }
        if (userInfo != null && j.l.c.k.h.a.g()) {
            this.b.m();
        } else {
            finish();
        }
    }
}
