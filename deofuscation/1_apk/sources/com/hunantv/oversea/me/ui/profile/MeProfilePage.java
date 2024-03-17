package com.hunantv.oversea.me.ui.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import j.l.c.k.c;
import j.l.c.k.d.s;
import j.l.c.k.e.g;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeProfilePage extends SkinnableRelativeLayout {
    private RecyclerView a;
    private FrameLayout b;
    private CustomizeTitleBar c;
    private s d;
    private b e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements CustomizeTitleBar.b {
        public a() {
        }

        @Override // com.hunantv.imgo.widget.CustomizeTitleBar.b
        public void a(View view, byte b) {
            if (1 == b) {
                if (MeProfilePage.this.e != null) {
                    MeProfilePage.this.e.Q();
                }
            } else if (3 != b || MeProfilePage.this.e == null) {
            } else {
                MeProfilePage.this.e.c();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface b {
        void Q();

        void c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MeProfilePage(Context context) {
        super(context);
        setBackgroundResource(c.f.me_skin_color_page_bg);
        LayoutInflater.from(context).inflate(c.m.me_activity_profile, (ViewGroup) this);
        r0();
        q0(context);
        this.b = (FrameLayout) findViewById(c.j.loadingFrame);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q0(Context context) {
        this.a = findViewById(c.j.recyclerView);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(context);
        linearLayoutManagerWrapper.setOrientation(1);
        this.a.setLayoutManager(linearLayoutManagerWrapper);
        s sVar = new s(context);
        this.d = sVar;
        this.a.setAdapter(sVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r0() {
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        this.c = customizeTitleBar;
        customizeTitleBar.t0((byte) 3, 0);
        this.c.setRightText(c.r.me_profile_save);
        this.c.setOnComponentClickListener(new a());
        this.c.setBackgroundResource(c.h.me_bg_title_bar);
    }

    public void o0() {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void setOnProfileItemClickListener(s.a aVar) {
        s sVar = this.d;
        if (sVar != null) {
            sVar.D(aVar);
        }
    }

    public void setOnViewActionListener(b bVar) {
        this.e = bVar;
    }

    public void t0(List<g> list) {
        s sVar = this.d;
        if (sVar != null) {
            sVar.setList(list);
            this.d.notifyDataSetChanged();
        }
    }

    public void u0() {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }
}
