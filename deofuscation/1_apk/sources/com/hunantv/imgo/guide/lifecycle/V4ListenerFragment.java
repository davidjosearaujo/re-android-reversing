package com.hunantv.imgo.guide.lifecycle;

import androidx.fragment.app.Fragment;
import j.l.a.l.c.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class V4ListenerFragment extends Fragment {
    public a a;

    public void onDestroy() {
        super.onDestroy();
        a aVar = this.a;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        a aVar = this.a;
        if (aVar != null) {
            aVar.onDestroyView();
        }
    }

    public void onStart() {
        super.onStart();
        a aVar = this.a;
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        a aVar = this.a;
        if (aVar != null) {
            aVar.onStop();
        }
    }

    public void u0(a aVar) {
        this.a = aVar;
    }
}
