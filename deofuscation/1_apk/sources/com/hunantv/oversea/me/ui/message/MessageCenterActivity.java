package com.hunantv.oversea.me.ui.message;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import j.l.c.k.c;
import j.l.c.k.f.d;
import j.l.c.k.l.d.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MessageCenterActivity extends MeBaseActivity {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(View view, byte b) {
        if (1 == b) {
            onBackPressed();
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return c.m.me_activity_message_center;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        customizeTitleBar.setBackgroundResource(c.h.me_bg_title_bar);
        customizeTitleBar.setOnComponentClickListener(new a(this));
        getSupportFragmentManager().beginTransaction().replace(c.j.flFragContainer, MessageNoticeFragment.class, (Bundle) null).commitAllowingStateLoss();
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        d.d();
    }
}
