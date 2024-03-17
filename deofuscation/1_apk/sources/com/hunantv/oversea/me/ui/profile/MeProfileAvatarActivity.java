package com.hunantv.oversea.me.ui.profile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.oversea.me.data.EditUserInfoEntity;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import com.hunantv.oversea.me.ui.profile.MePhotoTaker;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.e0;
import j.l.a.b0.o0;
import j.l.a.e;
import j.l.c.k.c;
import j.l.c.k.f.f;
import j.l.c.k.h.a;
import j.l.c.k.l.e.b0;
import j.l.c.k.l.e.c0;
import j.l.c.k.l.e.d0;
import j.l.c.k.l.e.f0;
import j.l.c.k.l.e.o;
import j.l.c.k.l.e.p;
import j.l.c.k.l.e.q;
import j.l.c.k.l.e.r;
import j.l.c.k.o.s;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeProfileAvatarActivity extends MeBaseActivity implements MeDialogHelper$a, MePhotoTaker.a {
    private static final int i = 81;
    private static final int j = 82;
    private static final int k = 83;
    public static final String l = "extra_key_profile_avatar_url";
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private static final /* synthetic */ c.b q = null;
    private MePhotoTaker a;
    private MeDialogHelper b;
    private CustomizeTitleBar c;
    private ImageView d;
    private TextView e;
    private FrameLayout f;
    private s g;
    @e
    private String h;

    static {
        ajc$preClinit();
    }

    private void A0() {
        this.a.onAvatarCamera();
    }

    private void B0() {
        this.a.onAvatarGallery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0(DialogInterface dialogInterface) {
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ void H0(View view, byte b) {
        if (1 == b) {
            onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(EditUserInfoEntity editUserInfoEntity) {
        EditUserInfoEntity.DataBean dataBean;
        FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        if (editUserInfoEntity != null && (dataBean = editUserInfoEntity.data) != null) {
            j.v.h.e.w(this.d, dataBean.xl);
            this.h = editUserInfoEntity.data.l;
            o0.n(c.r.me_profile_upload_avatar_success);
            a.k();
            return;
        }
        o0.n(c.r.me_profile_upload_avatar_failure);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void J0(MeProfileAvatarActivity meProfileAvatarActivity, r.a.b.c cVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (meProfileAvatarActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
                if (meProfileAvatarActivity.checkSelfPermission(e0.d()) == 0) {
                    meProfileAvatarActivity.A0();
                    return;
                } else {
                    meProfileAvatarActivity.checkExternalStoragePermission(83);
                    return;
                }
            }
            meProfileAvatarActivity.requestCameraPermission();
            return;
        }
        meProfileAvatarActivity.A0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void K0(MeProfileAvatarActivity meProfileAvatarActivity, r.a.b.c cVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (meProfileAvatarActivity.checkSelfPermission(e0.d()) == 0) {
                meProfileAvatarActivity.B0();
                return;
            } else {
                meProfileAvatarActivity.checkExternalStoragePermission(82);
                return;
            }
        }
        meProfileAvatarActivity.B0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void L0(MeProfileAvatarActivity meProfileAvatarActivity, int i2, String[] strArr, int[] iArr, r.a.b.c cVar) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i2, strArr, iArr);
        if (strArr[0].equals("android.permission.CAMERA")) {
            if (iArr.length != 0 && iArr[0] != -1) {
                if (meProfileAvatarActivity.checkExternalStoragePermission(83)) {
                    meProfileAvatarActivity.A0();
                    return;
                }
                return;
            }
            o0.o(meProfileAvatarActivity.getString(c.r.camera_permission_denied_toast));
        } else if (strArr[0].equals(e0.d())) {
            if (iArr.length == 0 || iArr[0] == -1) {
                o0.o(meProfileAvatarActivity.getString(c.r.storage_permission_denied_toast));
            } else if (i2 == 82) {
                meProfileAvatarActivity.B0();
            } else if (i2 != 83) {
            } else {
                meProfileAvatarActivity.A0();
            }
        }
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("MeProfileAvatarActivity.java", MeProfileAvatarActivity.class);
        m = eVar.H("method-execution", eVar.E("2", "checkExternalStoragePermission", "com.hunantv.oversea.me.ui.profile.MeProfileAvatarActivity", "int", "requestCode", "", "boolean"), (int) Opcodes.RETURN);
        n = eVar.H("method-execution", eVar.E("2", "requestCameraPermission", "com.hunantv.oversea.me.ui.profile.MeProfileAvatarActivity", "", "", "", "void"), (int) Opcodes.NEW);
        o = eVar.H("method-execution", eVar.E("1", "onRequestPermissionsResult", "com.hunantv.oversea.me.ui.profile.MeProfileAvatarActivity", "int:[Ljava.lang.String;:[I", "requestCode:permissions:grantResults", "", "void"), (int) Opcodes.INSTANCEOF);
        p = eVar.H("method-execution", eVar.E("1", "onChooseCamera", "com.hunantv.oversea.me.ui.profile.MeProfileAvatarActivity", "", "", "", "void"), 231);
        q = eVar.H("method-execution", eVar.E("1", "onChooseGallery", "com.hunantv.oversea.me.ui.profile.MeProfileAvatarActivity", "", "", "", "void"), 251);
    }

    @WithTryCatchRuntime
    private boolean checkExternalStoragePermission(int i2) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b0(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(m, this, this, r.a.c.b.e.k(i2))}).e(69648)));
    }

    @WithTryCatchRuntime
    private void requestCameraPermission() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new c0(new Object[]{this, r.a.c.c.e.v(n, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(View view) {
        this.a.n();
        Dialog showAvatarSelectDialog = this.b.showAvatarSelectDialog();
        if (showAvatarSelectDialog != null) {
            showAvatarSelectDialog.setOnDismissListener(new p(this));
        }
        this.e.setVisibility(8);
        f.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean z0(MeProfileAvatarActivity meProfileAvatarActivity, int i2, r.a.b.c cVar) {
        if (ContextCompat.checkSelfPermission(j.l.a.a.a(), e0.d()) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(meProfileAvatarActivity, new String[]{e0.d(), e0.b()}, i2);
        return false;
    }

    @Override // com.hunantv.oversea.me.ui.profile.MePhotoTaker.a
    public void P() {
        o0.n(c.r.me_profile_subject_avatar_crop_cancel);
    }

    @Override // com.hunantv.oversea.me.ui.profile.MePhotoTaker.a
    public void U(String str) {
        FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        this.g.k(str);
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return c.m.me_activity_profile_avatar;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        this.a.i(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.h)) {
            setResult(-1, new Intent().putExtra(l, this.h));
        }
        super.onBackPressed();
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeDialogHelper$a
    @WithTryCatchRuntime
    public void onChooseCamera() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.l.e.e0(new Object[]{this, r.a.c.c.e.v(p, this, this)}).e(69648));
    }

    @Override // com.hunantv.oversea.me.ui.profile.MeDialogHelper$a
    @WithTryCatchRuntime
    public void onChooseGallery() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f0(new Object[]{this, r.a.c.c.e.v(q, this, this)}).e(69648));
    }

    @Override // com.hunantv.oversea.me.ui.MeBaseActivity, com.hunantv.imgo.base.RootActivity, com.hunantv.imgo.nightmode.SkinnableActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.a.l(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeData(@Nullable Bundle bundle) {
        super.onInitializeData(bundle);
        String stringExtra = getIntent().getStringExtra(l);
        this.h = stringExtra;
        j.v.h.e.w(this.d, stringExtra);
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        MePhotoTaker mePhotoTaker = new MePhotoTaker(this);
        this.a = mePhotoTaker;
        mePhotoTaker.p(this);
        MeDialogHelper meDialogHelper = new MeDialogHelper(this);
        this.b = meDialogHelper;
        meDialogHelper.q(this);
        s sVar = ViewModelProviders.of(this).get(s.class);
        this.g = sVar;
        sVar.j().observe(this, new q(this));
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        this.c = customizeTitleBar;
        customizeTitleBar.setBackgroundResource(c.h.me_bg_title_bar);
        this.c.setOnComponentClickListener(new r(this));
        this.d = (ImageView) findViewById(c.j.me_iv_user_avatar);
        TextView textView = (TextView) findViewById(c.j.me_tv_change_avatar);
        this.e = textView;
        textView.setOnClickListener(new o(this));
        this.f = (FrameLayout) findViewById(c.j.loadingFrame);
    }

    @WithTryCatchRuntime
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d0(new Object[]{this, r.a.c.b.e.k(i2), strArr, iArr, r.a.c.c.e.y(o, this, this, new Object[]{r.a.c.b.e.k(i2), strArr, iArr})}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        MGDCManager.n().enterScene("avatar_change", this);
        MGDCManager.n().onEvent("page");
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onSaveInstanceState(Bundle bundle) {
        this.a.m(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.hunantv.oversea.me.ui.profile.MePhotoTaker.a
    public void x(String str) {
        o0.k(j.l.a.a.a().getString(c.r.me_profile_subject_avatar_crop_failure, str));
    }
}
