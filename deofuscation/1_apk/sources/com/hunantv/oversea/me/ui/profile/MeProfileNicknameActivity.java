package com.hunantv.oversea.me.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import j.l.a.b0.o0;
import j.l.c.k.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class MeProfileNicknameActivity extends MeBaseActivity {
    public static final String b = "extra_nickname";
    private EditText a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements CustomizeTitleBar.b {
        public a() {
        }

        @Override // com.hunantv.imgo.widget.CustomizeTitleBar.b
        public void a(View view, byte b) {
            if (1 == b) {
                MeProfileNicknameActivity.this.finish();
            } else if (3 == b) {
                String obj = MeProfileNicknameActivity.this.a.getText().toString();
                String trim = TextUtils.isEmpty(obj) ? null : obj.trim();
                if (TextUtils.isEmpty(trim)) {
                    o0.n(c.r.me_profile_nickname_empty);
                    return;
                }
                int length = trim.length();
                if (length >= 2 && length <= 20) {
                    Intent intent = MeProfileNicknameActivity.this.getIntent();
                    if (intent == null) {
                        intent = new Intent();
                    }
                    intent.putExtra(MeProfileNicknameActivity.b, trim);
                    MeProfileNicknameActivity.this.setResult(-1, intent);
                    MeProfileNicknameActivity.this.finish();
                    return;
                }
                o0.n(c.r.me_profile_nickname_illegal);
            }
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return c.m.me_activity_profile_nickname;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onHandleMessage(Message message) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeData(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra(b);
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        this.a.setText(stringExtra);
        this.a.setSelection(stringExtra.length());
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        customizeTitleBar.t0((byte) 3, 0);
        customizeTitleBar.setRightText(c.r.me_profile_save);
        customizeTitleBar.setOnComponentClickListener(new a());
        customizeTitleBar.setBackgroundResource(c.h.me_bg_title_bar);
        this.a = (EditText) findViewById(c.j.etNickname);
    }
}
