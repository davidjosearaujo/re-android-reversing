package com.hunantv.imgo.guide.lifecycle;

import android.app.Fragment;
import j.l.a.l.c.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ListenerFragment extends Fragment {
    public a a;

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.a.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.onStop();
    }
}
