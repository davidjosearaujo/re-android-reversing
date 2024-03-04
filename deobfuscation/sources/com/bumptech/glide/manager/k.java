package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;

@Deprecated
/* loaded from: classes.dex */
public final class k extends Fragment {

    /* renamed from: f */
    public final com.bumptech.glide.manager.a f2702f;

    /* renamed from: g */
    public final a f2703g;

    /* renamed from: h */
    public final HashSet f2704h;

    /* renamed from: i */
    public com.bumptech.glide.n f2705i;

    /* renamed from: j */
    public k f2706j;

    /* renamed from: k */
    public Fragment f2707k;

    /* loaded from: classes.dex */
    public class a implements m {
        public a() {
            k.this = r1;
        }

        public final String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        com.bumptech.glide.manager.a aVar = new com.bumptech.glide.manager.a();
        this.f2703g = new a();
        this.f2704h = new HashSet();
        this.f2702f = aVar;
    }

    public final void a(Activity activity) {
        k kVar = this.f2706j;
        if (kVar != null) {
            kVar.f2704h.remove(this);
            this.f2706j = null;
        }
        l lVar = com.bumptech.glide.b.b(activity).f2627j;
        lVar.getClass();
        k d7 = lVar.d(activity.getFragmentManager());
        this.f2706j = d7;
        if (equals(d7)) {
            return;
        }
        this.f2706j.f2704h.add(this);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f2702f.b();
        k kVar = this.f2706j;
        if (kVar != null) {
            kVar.f2704h.remove(this);
            this.f2706j = null;
        }
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        k kVar = this.f2706j;
        if (kVar != null) {
            kVar.f2704h.remove(this);
            this.f2706j = null;
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f2702f.c();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f2702f.e();
    }

    @Override // android.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f2707k;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
