package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.b;
import com.bumptech.glide.n;
import java.util.HashSet;
@Deprecated
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    public final a f2702f;

    /* renamed from: g  reason: collision with root package name */
    public final a f2703g = new a();

    /* renamed from: h  reason: collision with root package name */
    public final HashSet f2704h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public n f2705i;

    /* renamed from: j  reason: collision with root package name */
    public k f2706j;

    /* renamed from: k  reason: collision with root package name */
    public Fragment f2707k;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements m {
        public a() {
        }

        public final String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        a aVar = new a();
        this.f2702f = aVar;
    }

    public final void a(Activity activity) {
        k kVar = this.f2706j;
        if (kVar != null) {
            kVar.f2704h.remove(this);
            this.f2706j = null;
        }
        l lVar = b.b(activity).f2627j;
        lVar.getClass();
        k d7 = lVar.d(activity.getFragmentManager());
        this.f2706j = d7;
        if (!equals(d7)) {
            this.f2706j.f2704h.add(this);
        }
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

    @Override // android.app.Fragment, java.lang.Object
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
