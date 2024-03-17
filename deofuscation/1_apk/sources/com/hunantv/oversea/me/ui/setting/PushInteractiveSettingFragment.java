package com.hunantv.oversea.me.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.hunantv.imgo.base.RootFragment;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.oversea.me.adapter.MePushSettingAdapter;
import com.mgtv.widget.recyclerview.MGRecyclerView;
import j.l.c.k.c;
import j.l.c.k.e.l;
import j.l.c.k.l.g.j;
import j.l.c.k.l.g.k;
import j.l.c.k.o.p;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PushInteractiveSettingFragment extends RootFragment implements Observer<List<l>> {
    private p a;
    private CustomizeTitleBar b;
    private MGRecyclerView c;
    private MePushSettingAdapter d;
    private LinearLayoutManagerWrapper e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements CustomizeTitleBar.b {
        public a() {
        }

        @Override // com.hunantv.imgo.widget.CustomizeTitleBar.b
        public void a(View view, byte b) {
            if (1 != b || PushInteractiveSettingFragment.this.getActivity() == null) {
                return;
            }
            PushInteractiveSettingFragment.this.getActivity().onBackPressed();
        }
    }

    private void u0(View view, Context context) {
        view.setOnTouchListener(j.a);
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) view.findViewById(c.j.titleBar);
        this.b = customizeTitleBar;
        customizeTitleBar.setBackgroundResource(c.h.me_bg_title_bar);
        this.b.setOnComponentClickListener(new a());
        this.c = view.findViewById(c.j.recyclerView);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(context);
        this.e = linearLayoutManagerWrapper;
        linearLayoutManagerWrapper.setOrientation(1);
        this.c.setLayoutManager(this.e);
        MePushSettingAdapter mePushSettingAdapter = new MePushSettingAdapter(context);
        this.d = mePushSettingAdapter;
        mePushSettingAdapter.x(new k(this));
        this.c.setAdapter(this.d);
    }

    public static /* synthetic */ boolean v0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(View view, int i) {
        MePushSettingAdapter mePushSettingAdapter;
        if (this.a == null || (mePushSettingAdapter = this.d) == null || mePushSettingAdapter.getItem(i) == null) {
            return;
        }
        this.a.w((l) this.d.getItem(i));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public int obtainLayoutResourceId() {
        return c.m.me_activity_push_setting_interactive;
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeUI(View view, @Nullable Bundle bundle) {
        super.onInitializeUI(view, bundle);
        if (getActivity() != null) {
            p pVar = new ViewModelProvider(getActivity()).get(p.class);
            this.a = pVar;
            pVar.s();
            this.a.p().observe(getActivity(), this);
            u0(view, getActivity());
        }
    }

    /* renamed from: y0 */
    public void onChanged(List<l> list) {
        MePushSettingAdapter mePushSettingAdapter = this.d;
        if (mePushSettingAdapter != null) {
            mePushSettingAdapter.setList(list);
            this.d.notifyDataSetChanged();
        }
    }
}
