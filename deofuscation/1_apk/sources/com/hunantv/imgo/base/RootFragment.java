package com.hunantv.imgo.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hunantv.imgo.nightmode.SkinModel;
import j.l.a.b0.t;
import j.l.a.z.j;
import j.l.a.z.k;
import j.l.a.z.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class RootFragment extends Fragment implements j {
    @j.l.a.e
    private SkinModel initNightModeState;
    @j.l.a.e
    public boolean isFragmentVisible;
    public Activity mActivity;
    public Context mContext;
    private e mHandler;
    @SuppressLint({"MissingSaveStateAnnotation"})
    private boolean mRealVisible;
    private Map<k, List<Pair<k, Object>>> mRestoreRefMap;
    public Unbinder mUnbinder;
    private boolean needRefreshGray;
    @j.l.a.e
    private SkinModel receiveNightMode;
    public View rootView;
    public final String TAG = getClass().getSimpleName();
    private final Comparator<Object> mObjComparator = new a();
    private final n mSaver = new j.l.a.z.d();
    @SuppressLint({"MissingSaveStateAnnotation"})
    public int layoutResourceId = -1;
    @j.l.a.e
    public boolean isDestroyed = true;
    @j.l.a.e
    private boolean mFixedUserVisibleHint = true;
    public BroadcastReceiver mNightModeBroadcastReceiver = new b();
    private boolean needchange = true;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Comparator<Object> {
        public a() {
        }

        public int a(int i, int i2) {
            return Integer.compare(i, i2);
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return a(obj.hashCode(), obj2.hashCode());
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RootFragment.this.onReceiveNightMode(intent);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c implements Comparator<k> {
        public c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(k kVar, k kVar2) {
            return kVar.c().compareTo(kVar2.c());
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d implements View.OnAttachStateChangeListener {
        public d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            RootFragment.this.switchRealVisible();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class e extends Handler {
        private WeakReference<RootFragment> a;

        public e(RootFragment rootFragment) {
            this.a = new WeakReference<>(rootFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RootFragment rootFragment;
            FragmentActivity activity;
            WeakReference<RootFragment> weakReference = this.a;
            if (weakReference == null || (rootFragment = weakReference.get()) == null || (activity = rootFragment.getActivity()) == null || activity.isFinishing()) {
                return;
            }
            rootFragment.onHandleMessage(message);
        }
    }

    private boolean isRealVisible() {
        for (Fragment fragment = this; fragment != null; fragment = fragment.getParentFragment()) {
            if (!fragment.isResumed() || !fragment.isVisible() || !this.mFixedUserVisibleHint) {
                return false;
            }
        }
        return true;
    }

    private void onHiddenChangedFromParent(boolean z) {
        this.needchange = false;
        onHiddenChanged(z);
        this.needchange = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean switchRealVisible() {
        boolean z = this.mRealVisible;
        boolean isRealVisible = isRealVisible();
        this.mRealVisible = isRealVisible;
        if (z == isRealVisible) {
            return false;
        }
        onVisibleChanged(isRealVisible);
        return true;
    }

    public String getMqttTopic() {
        return null;
    }

    public boolean getRealVisible() {
        return this.mRealVisible;
    }

    @NonNull
    public n getSaver() {
        return this.mSaver;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public boolean isRecycled() {
        return this.layoutResourceId == -1;
    }

    public boolean needNightModeChangeState() {
        return true;
    }

    public abstract int obtainLayoutResourceId();

    public Message obtainMessage(int i) {
        return this.mHandler.obtainMessage(i);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        onIntentAction(bundle);
        onInitializeData(bundle);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = j.l.a.a.a();
        if (bundle != null) {
            this.mRestoreRefMap = new TreeMap(new c());
            this.mSaver.b((Bundle) bundle.clone(), this, new k(), this.mRestoreRefMap);
        }
        this.mHandler = new e(this);
        getActivity();
        SkinModel l = j.l.a.t.e.m().l();
        this.initNightModeState = l;
        this.receiveNightMode = l;
        this.needRefreshGray = false;
        registNightModeReceiver();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int obtainLayoutResourceId = obtainLayoutResourceId();
        this.layoutResourceId = obtainLayoutResourceId;
        View view = null;
        if (-1 != obtainLayoutResourceId) {
            view = layoutInflater.inflate(obtainLayoutResourceId, (ViewGroup) null);
            this.mUnbinder = ButterKnife.bind(this, view);
            view.addOnAttachStateChangeListener(new d());
        }
        this.rootView = view;
        return view;
    }

    public void onDestroy() {
        super.onDestroy();
        t.i().g(this);
        unRegistNightModeReceiver();
    }

    public void onDestroyView() {
        this.isDestroyed = true;
        super.onDestroyView();
        Unbinder unbinder = this.mUnbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onGrayModeChange() {
        View view = this.rootView;
        if (view != null) {
            j.l.a.g.a.a(view);
        }
    }

    public void onHandleMessage(Message message) {
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        switchRealVisible();
        if (this.needchange && this.mFixedUserVisibleHint) {
            onSelectChangeInParent(!z);
        }
        List<Fragment> list = null;
        try {
            list = getChildFragmentManager().getFragments();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (list != null) {
            for (Fragment fragment : list) {
                try {
                    if (fragment instanceof RootFragment) {
                        ((RootFragment) fragment).onHiddenChangedFromParent(z);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    @Deprecated
    public void onInitializeData() {
    }

    public void onInitializeData(@Nullable Bundle bundle) {
        onInitializeData();
    }

    @Deprecated
    public void onInitializeUI(View view) {
    }

    public void onInitializeUI(View view, @Nullable Bundle bundle) {
        onInitializeUI(view);
    }

    public void onIntentAction(@Nullable Bundle bundle) {
    }

    public void onNightModeChange(SkinModel skinModel) {
        View view = this.rootView;
        if (view != null) {
            j.l.a.g.b.a(view);
        }
    }

    public void onPageMqttSubFail(String str) {
        String str2 = this.TAG;
        Log.i(str2, "onPageMqttSubFail: topic-->" + str);
    }

    public void onPageMqttSubSuccess(String str, Object obj) {
        String str2 = this.TAG;
        Log.i(str2, "onPageMqttSubSuccess: topic-->" + str + "; entity->" + obj);
    }

    public void onPause() {
        super.onPause();
        switchRealVisible();
    }

    public void onReceiveNightMode(Intent intent) {
        if (j.l.a.t.e.h.equals(intent.getAction())) {
            this.needRefreshGray = intent.getBooleanExtra("action_is_gray_key", false);
            if (isRealVisible()) {
                if (this.needRefreshGray) {
                    this.needRefreshGray = false;
                    onGrayModeChange();
                    return;
                }
                SkinModel skinModel = (SkinModel) intent.getSerializableExtra("action_skin_change_key");
                this.receiveNightMode = skinModel;
                this.initNightModeState = skinModel;
                onNightModeChange(skinModel);
            } else if (this.needRefreshGray) {
            } else {
                this.receiveNightMode = (SkinModel) intent.getSerializableExtra("action_skin_change_key");
            }
        }
    }

    public void onResume() {
        super.onResume();
        switchRealVisible();
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        ArrayList<String> arrayList = new ArrayList();
        boolean z = false;
        try {
            int a2 = j.v.t.a.a(bundle);
            if (a2 > 204800) {
                z = true;
                for (String str : bundle2.keySet()) {
                    bundle.remove(str);
                    int a3 = j.v.t.a.a(bundle);
                    if (a2 - a3 > 204800) {
                        arrayList.add(str);
                    }
                    a2 = a3;
                }
            }
        } finally {
            if (!arrayList.isEmpty()) {
                for (String str2 : arrayList) {
                    bundle2.remove(str2);
                }
            }
            if (z) {
                bundle.putAll(bundle2);
            }
            super.onSaveInstanceState(bundle);
            TreeMap treeMap = new TreeMap(this.mObjComparator);
            TreeMap treeMap2 = new TreeMap(this.mObjComparator);
            this.mSaver.d(bundle, this, new k(), treeMap);
            this.mSaver.c(bundle, this, new k(), treeMap, treeMap2);
        }
    }

    public void onSelectChangeInParent(boolean z) {
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.isDestroyed = false;
        onInitializeUI(getView(), bundle);
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.mSaver.a(bundle, this, new k(), this.mRestoreRefMap, new TreeMap(this.mObjComparator));
        }
    }

    public void onVisibleChanged(boolean z) {
        this.isFragmentVisible = z;
        if (z) {
            if (!this.initNightModeState.equals(this.receiveNightMode)) {
                SkinModel skinModel = this.receiveNightMode;
                this.initNightModeState = skinModel;
                onNightModeChange(skinModel);
            }
            if (this.needRefreshGray) {
                this.needRefreshGray = false;
                onGrayModeChange();
            }
        }
    }

    public void registNightModeReceiver() {
        if (needNightModeChangeState()) {
            this.mContext.registerReceiver(this.mNightModeBroadcastReceiver, new IntentFilter(j.l.a.t.e.h), j.l.a.t.e.g, null);
        }
    }

    public void removeCallbacksAndMessages() {
        e eVar = this.mHandler;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
        }
    }

    public void removeMessages(int i) {
        e eVar = this.mHandler;
        if (eVar != null) {
            eVar.removeMessages(i);
        }
    }

    public boolean sendMessage(Message message) {
        e eVar = this.mHandler;
        return eVar != null && eVar.sendMessage(message);
    }

    public boolean sendMessageDelayed(int i, long j) {
        e eVar = this.mHandler;
        return eVar != null && eVar.sendEmptyMessageDelayed(i, j);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mFixedUserVisibleHint = z;
        if (switchRealVisible()) {
            onSelectChangeInParent(z);
            List<Fragment> list = null;
            try {
                list = getChildFragmentManager().getFragments();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (list != null) {
                for (Fragment fragment : list) {
                    try {
                        if (fragment instanceof RootFragment) {
                            ((RootFragment) fragment).switchRealVisible();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public void unRegistNightModeReceiver() {
        BroadcastReceiver broadcastReceiver = this.mNightModeBroadcastReceiver;
        if (broadcastReceiver != null) {
            try {
                this.mContext.unregisterReceiver(broadcastReceiver);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Message obtainMessage(int i, Object obj) {
        return this.mHandler.obtainMessage(i, obj);
    }

    public boolean sendMessage(int i) {
        e eVar = this.mHandler;
        return eVar != null && eVar.sendEmptyMessage(i);
    }

    public boolean sendMessageDelayed(Message message, long j) {
        e eVar = this.mHandler;
        return eVar != null && eVar.sendMessageDelayed(message, j);
    }

    public boolean sendMessage(int i, Object obj) {
        e eVar = this.mHandler;
        return eVar != null && eVar.sendMessage(eVar.obtainMessage(i, obj));
    }

    public boolean sendMessageDelayed(int i, Object obj, long j) {
        e eVar = this.mHandler;
        return eVar != null && eVar.sendMessageDelayed(eVar.obtainMessage(i, obj), j);
    }

    public boolean sendMessage(Runnable runnable, int i) {
        e eVar = this.mHandler;
        return eVar != null && eVar.postDelayed(runnable, (long) i);
    }
}
