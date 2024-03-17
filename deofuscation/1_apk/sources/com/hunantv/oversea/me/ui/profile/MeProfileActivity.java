package com.hunantv.oversea.me.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.hunantv.oversea.me.data.EditUserInfoEntity;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import com.hunantv.oversea.me.ui.profile.MeProfilePage;
import com.hunantv.oversea.me.viewmodels.MeProfileViewModel;
import com.hunantv.oversea.report.MGDCManager;
import j.l.a.b0.o0;
import j.l.c.k.c;
import j.l.c.k.d.s;
import j.l.c.k.e.g;
import j.l.c.k.f.d;
import j.l.c.k.f.f;
import j.l.c.k.h.a;
import j.l.c.k.l.e.b;
import j.l.c.k.l.e.n;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeProfileActivity extends MeBaseActivity implements s.a, MeDialogHelper$c, MeDialogHelper$d, MeProfilePage.b, MeDialogHelper$e {
    private static final int d = 4369;
    private static final int e = 4370;
    private MeProfilePage a;
    private MeProfileViewModel b;
    private MeDialogHelper c;

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str) {
        this.b.u(str);
    }

    public void A0(EditUserInfoEntity editUserInfoEntity) {
        this.a.o0();
        if (editUserInfoEntity != null && editUserInfoEntity.data != null) {
            o0.n(c.r.me_profile_modify_user_info_success);
            a.k();
            finish();
            return;
        }
        o0.n(c.r.me_profile_modify_user_info_failure);
    }

    public void B0(List<g> list) {
        this.a.t0(list);
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeDialogHelper$c
    public void F(int i) {
        this.b.v(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void M(View view, @Nullable g gVar, int i) {
        if (gVar == null) {
            return;
        }
        byte b = gVar.b();
        if (b == 1) {
            Intent intent = new Intent((Context) this, (Class<?>) MeProfileAvatarActivity.class);
            intent.putExtra(MeProfileAvatarActivity.l, gVar.a());
            startActivityForResult(intent, e);
            f.a();
        } else if (b == 2) {
            Intent intent2 = new Intent((Context) this, (Class<?>) MeProfileNicknameActivity.class);
            intent2.putExtra(MeProfileNicknameActivity.b, gVar.d());
            startActivityForResult(intent2, d);
            f.f();
        } else if (b == 3) {
            this.c.w();
            f.e();
        } else if (b == 4) {
            this.c.showBirthdaySelectDialog(gVar.d());
            f.b();
        } else if (b != 5) {
        } else {
            this.c.showCountrySelectDialog(this.b.j(), gVar.d(), new n(this));
            f.d();
        }
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeDialogHelper$e
    public void N() {
        finish();
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeProfilePage.b
    public void Q() {
        onBackPressed();
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeProfilePage.b
    public void c() {
        if (!this.b.userInfoChanged()) {
            finish();
            return;
        }
        this.a.u0();
        this.b.r();
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeDialogHelper$d
    public void g0(String str) {
        this.b.t(str);
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeDialogHelper$e
    public void l() {
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.hunantv.oversea.me.ui.profile.MeProfilePage] */
    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        ?? meProfilePage = new MeProfilePage(this);
        this.a = meProfilePage;
        setContentView((View) meProfilePage);
        return -1;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == d && -1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra(MeProfileNicknameActivity.b);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.b.w(stringExtra);
        } else if (i == e && -1 == i2 && intent != null) {
            String stringExtra2 = intent.getStringExtra(MeProfileAvatarActivity.l);
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            this.b.s(stringExtra2);
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onBackPressed() {
        if (this.b.userInfoChanged()) {
            this.c.x();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        MeProfileViewModel meProfileViewModel = new ViewModelProvider(this).get(MeProfileViewModel.class);
        this.b = meProfileViewModel;
        meProfileViewModel.n().observe(this, new b(this));
        this.b.l().observe(this, new j.l.c.k.l.e.a(this));
        this.a.setOnProfileItemClickListener(this);
        this.a.setOnViewActionListener(this);
        MeDialogHelper meDialogHelper = new MeDialogHelper(this);
        this.c = meDialogHelper;
        meDialogHelper.p(this);
        this.c.r(this);
        this.c.s(this);
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        d.h();
        MGDCManager.n().enterScene("profile_editing", this);
        MGDCManager.n().onEvent("page");
    }
}
