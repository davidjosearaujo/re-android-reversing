package com.hunantv.imgo.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import j.l.a.t.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class RootDialogFragment extends DialogFragment {
    public final String a = getClass().getSimpleName();
    private boolean b = true;
    public BroadcastReceiver c = new a();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RootDialogFragment.this.onReceiveNightMode(intent);
        }
    }

    private boolean isRealVisible() {
        for (RootDialogFragment rootDialogFragment = this; rootDialogFragment != null; rootDialogFragment = rootDialogFragment.getParentFragment()) {
            try {
                if (rootDialogFragment.isResumed() && rootDialogFragment.isVisible() && this.b) {
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean needNightModeChangeState() {
        return true;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        registNightModeReceiver();
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        unRegistNightModeReceiver();
    }

    public void onGrayModeChange() {
        if (getView() != null) {
            j.l.a.g.a.a(getView());
        }
    }

    public void onReceiveNightMode(Intent intent) {
        if (e.h.equals(intent.getAction())) {
            boolean booleanExtra = intent.getBooleanExtra("action_is_gray_key", false);
            if (isRealVisible() && booleanExtra) {
                onGrayModeChange();
            }
        }
    }

    public void registNightModeReceiver() {
        try {
            if (!needNightModeChangeState() || getContext() == null) {
                return;
            }
            getContext().registerReceiver(this.c, new IntentFilter(e.h), e.g, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(z);
        this.b = z;
    }

    public void unRegistNightModeReceiver() {
        try {
            if (this.c != null && getContext() != null) {
                try {
                    getContext().unregisterReceiver(this.c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
