package com.hunantv.imgo.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.util.Pair;
import butterknife.ButterKnife;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hunantv.imgo.nightmode.SkinModel;
import com.hunantv.imgo.nightmode.SkinnableActivity;
import j.l.a.a0.b;
import j.l.a.b0.f0;
import j.l.a.b0.t;
import j.l.a.e;
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
public abstract class RootActivity extends SkinnableActivity implements j {
    public static final int MSG_INIT_DATA = 63761;
    public static final int MSG_INIT_ROUTER = 65281;
    public static final String OUT_ANIM_TRANSITION = "anim_transition";
    public static final String PREF_H5_APP_BACKGROUND_TIME = "pref_h5_app_background_time";
    public static final String PREF_PVSOURCE_APP_BACKGROUND_TIME = "pref_pvsource_app_background_time";
    private SkinModel initNightModeState;
    @e
    public boolean isAd;
    private d mHandler;
    public j.l.c.b.b mIBusinessProvider;
    private Map<k, List<Pair<k, Object>>> mRestoreRefMap;
    private boolean needRefreshGray;
    private SkinModel receiveNightMode;
    public final String TAG = getClass().getSimpleName();
    private final n mSaver = new j.l.a.z.d();
    private final Comparator<Object> mObjComparator = new a();
    @e
    public int layoutResourceId = -1;
    @e
    public int mCustomAnimOutTransition = -1;
    @e
    public boolean isOnResumed = false;
    @e
    public boolean isDestroyed = false;
    private List<View.OnTouchListener> mOnTouchListeners = new ArrayList();
    private BroadcastReceiver mBroadcastReceiver = new b();

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
            RootActivity.this.onReceiveBroadcast(intent);
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
    public static class d extends Handler {
        private WeakReference<RootActivity> a;

        public d(RootActivity rootActivity) {
            this.a = new WeakReference<>(rootActivity);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.hunantv.imgo.base.RootActivity, android.app.Activity] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RootActivity rootActivity;
            WeakReference<RootActivity> weakReference = this.a;
            if (weakReference == null || (rootActivity = weakReference.get()) == 0 || rootActivity.isFinishing() || rootActivity.isDestroyed) {
                return;
            }
            if (message.what != 63761) {
                rootActivity.onHandleMessage(message);
            } else {
                rootActivity.onInitializeData(message.peekData());
            }
        }
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public void backToFront() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        for (View.OnTouchListener onTouchListener : this.mOnTouchListeners) {
            onTouchListener.onTouch(null, motionEvent);
        }
        return super/*android.app.Activity*/.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
    }

    public void frontToBack() {
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.res.Resources getResources() {
        /*
            r8 = this;
            boolean r0 = r8.needNightModeChangeState()
            if (r0 == 0) goto L5a
            android.content.Context r0 = j.l.a.a.a()
            if (r0 == 0) goto L11
            android.content.res.Resources r0 = r0.getResources()
            return r0
        L11:
            android.content.res.Resources r0 = super.getResources()
            android.content.res.Configuration r1 = r0.getConfiguration()
            r2 = 0
            j.l.a.t.e r3 = j.l.a.t.e.m()
            boolean r3 = r3.t()
            r4 = 1
            r5 = 32
            r6 = 16
            if (r3 == 0) goto L38
            int r3 = r1.uiMode
            r7 = r3 & 48
            if (r7 != r6) goto L38
            r2 = r3 & (-49)
            r1.uiMode = r2
            r2 = r2 | r5
            r1.uiMode = r2
        L36:
            r2 = 1
            goto L50
        L38:
            j.l.a.t.e r3 = j.l.a.t.e.m()
            boolean r3 = r3.t()
            if (r3 != 0) goto L50
            int r3 = r1.uiMode
            r7 = r3 & 48
            if (r7 != r5) goto L50
            r2 = r3 & (-49)
            r1.uiMode = r2
            r2 = r2 | r6
            r1.uiMode = r2
            goto L36
        L50:
            if (r2 == 0) goto L59
            android.util.DisplayMetrics r2 = r0.getDisplayMetrics()
            r0.updateConfiguration(r1, r2)
        L59:
            return r0
        L5a:
            android.content.res.Resources r0 = super.getResources()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.imgo.base.RootActivity.getResources():android.content.res.Resources");
    }

    @NonNull
    public n getSaver() {
        return this.mSaver;
    }

    public int getSceneType() {
        return j.l.a.k.e.b0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object getSystemService(@NonNull String str) {
        if ("audio".equals(str)) {
            return getApplicationContext().getSystemService(str);
        }
        return super/*android.app.Activity*/.getSystemService(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isAppOnForeground() {
        return j.l.a.b0.e.O0(this);
    }

    public boolean isDisablePendingTransition() {
        return false;
    }

    public abstract int obtainLayoutResourceId();

    public final Message obtainMessage(int i) {
        d dVar = this.mHandler;
        if (dVar == null) {
            return null;
        }
        return dVar.obtainMessage(i);
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        try {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            if (isDisablePendingTransition()) {
                overridePendingTransition(0, 0);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.nightmode.SkinnableActivity
    public void onCreate(@Nullable Bundle bundle) {
        try {
            Process.setThreadPriority(-19);
        } catch (Exception e) {
            e.printStackTrace();
        }
        j.l.c.b.b bVar = (j.l.c.b.b) ARouter.getInstance().build("/business/provider").navigation();
        this.mIBusinessProvider = bVar;
        if (bVar != null) {
            bVar.W(this);
        }
        super.onCreate(bundle);
        if (isDisablePendingTransition()) {
            overridePendingTransition(0, 0);
        }
        int obtainLayoutResourceId = obtainLayoutResourceId();
        this.layoutResourceId = obtainLayoutResourceId;
        if (-1 != obtainLayoutResourceId) {
            setContentView(obtainLayoutResourceId);
            ButterKnife.bind(this);
        }
        onIntentAction(getIntent(), bundle);
        this.isDestroyed = false;
        this.mHandler = new d(this);
        onInitObjects();
        onInitializeUI(bundle);
        if (bundle != null) {
            this.mRestoreRefMap = new TreeMap(new c());
            this.mSaver.b(bundle, this, new k(), this.mRestoreRefMap);
        }
        Message obtainMessage = obtainMessage(MSG_INIT_DATA);
        if (obtainMessage != null) {
            obtainMessage.setData(bundle);
            sendMessage(obtainMessage);
        }
        SkinModel l = j.l.a.t.e.m().l();
        this.initNightModeState = l;
        this.receiveNightMode = l;
        this.needRefreshGray = false;
        if (needNightModeChangeState()) {
            registerReceiver(this.mBroadcastReceiver, new IntentFilter(j.l.a.t.e.h), j.l.a.t.e.g, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super.onDestroy();
        t.i().f(this);
        unregisterReceiver(this.mBroadcastReceiver);
        this.isDestroyed = true;
    }

    public void onHandleMessage(Message message) {
        if (!this.isDestroyed && message.what == 65281) {
            routerInject();
        }
    }

    public void onInitObjects() {
    }

    public void onInitializeData(@Nullable Bundle bundle) {
    }

    public void onInitializeUI(@Nullable Bundle bundle) {
    }

    public void onIntentAction(Intent intent, @Nullable Bundle bundle) {
        this.mCustomAnimOutTransition = intent.getIntExtra(OUT_ANIM_TRANSITION, -1);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return onKeyDownEvent(i, keyEvent);
    }

    public boolean onKeyDownEvent(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
    }

    public void onReceiveBroadcast(Intent intent) {
        if (j.l.a.t.e.h.equals(intent.getAction())) {
            boolean booleanExtra = intent.getBooleanExtra("action_is_gray_key", false);
            this.needRefreshGray = booleanExtra;
            if (booleanExtra) {
                j.l.a.t.b.a().d(intent.getBooleanExtra("action_gray_mode_all", false));
                j.l.a.t.b.a().e(intent.getBooleanExtra("action_gray_mode_single", false));
            }
            if (this.isOnResumed) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestart() {
        super/*android.app.Activity*/.onRestart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestoreInstanceState(Bundle bundle) {
        super/*android.app.Activity*/.onRestoreInstanceState(bundle);
        this.mSaver.a(bundle, this, new k(), this.mRestoreRefMap, new TreeMap(this.mObjComparator));
    }

    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        this.isOnResumed = true;
        SkinModel skinModel = this.initNightModeState;
        if (skinModel != null && !skinModel.equals(this.receiveNightMode)) {
            SkinModel skinModel2 = this.receiveNightMode;
            this.initNightModeState = skinModel2;
            onNightModeChange(skinModel2);
        }
        if (this.needRefreshGray) {
            this.needRefreshGray = false;
            onGrayModeChange();
        }
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
            try {
                super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            TreeMap treeMap = new TreeMap(this.mObjComparator);
            TreeMap treeMap2 = new TreeMap(this.mObjComparator);
            this.mSaver.d(bundle, this, new k(), treeMap);
            this.mSaver.c(bundle, this, new k(), treeMap, treeMap2);
        }
    }

    public void onStop() {
        super.onStop();
        this.isOnResumed = false;
        f0.v(PREF_H5_APP_BACKGROUND_TIME, System.currentTimeMillis());
    }

    public final boolean post(Runnable runnable, long j) {
        d dVar = this.mHandler;
        return dVar != null && dVar.postDelayed(runnable, j);
    }

    public void registerOnTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener == null || this.mOnTouchListeners.contains(onTouchListener)) {
            return;
        }
        this.mOnTouchListeners.add(onTouchListener);
    }

    public final void removeMessages(int i) {
        d dVar = this.mHandler;
        if (dVar != null) {
            dVar.removeMessages(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void routerInject() {
        try {
            j.l.d.d.e(this);
        } catch (HandlerException e) {
            e.printStackTrace();
        } catch (InitException e2) {
            e2.printStackTrace();
            j.l.d.d.d(getApplication(), false);
        }
    }

    public final boolean sendMessage(Message message) {
        d dVar = this.mHandler;
        return dVar != null && dVar.sendMessage(message);
    }

    public final boolean sendMessageDelayed(int i, long j) {
        d dVar = this.mHandler;
        return dVar != null && dVar.sendEmptyMessageDelayed(i, j);
    }

    public boolean shouldProcess(@Nullable String str, @Nullable Object obj) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent intent) {
        super/*android.app.Activity*/.startActivity(intent);
        overridePendingTransition(b.a.slide_in_left, b.a.fake_fade_out);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent intent, int i) {
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(intent, i);
        overridePendingTransition(b.a.slide_in_left, b.a.fake_fade_out);
    }

    public boolean supportMqttMeet() {
        return false;
    }

    public boolean supportYeahPet() {
        return false;
    }

    public void unRegisterOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.mOnTouchListeners.size() == 0) {
            return;
        }
        this.mOnTouchListeners.remove(onTouchListener);
    }

    public final boolean post(Runnable runnable) {
        d dVar = this.mHandler;
        return dVar != null && dVar.post(runnable);
    }

    public final boolean sendMessage(int i) {
        d dVar = this.mHandler;
        return dVar != null && dVar.sendEmptyMessage(i);
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        d dVar = this.mHandler;
        return dVar != null && dVar.sendMessageDelayed(message, j);
    }

    public final boolean sendMessage(int i, Object obj) {
        d dVar = this.mHandler;
        return dVar != null && dVar.sendMessage(dVar.obtainMessage(i, obj));
    }

    public final boolean sendMessageDelayed(int i, Object obj, long j) {
        d dVar = this.mHandler;
        return dVar != null && dVar.sendMessageDelayed(dVar.obtainMessage(i, obj), j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent intent, Bundle bundle) {
        super/*android.app.Activity*/.startActivity(intent, bundle);
        overridePendingTransition(b.a.slide_in_left, b.a.fake_fade_out);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(intent, i, bundle);
        overridePendingTransition(b.a.slide_in_left, b.a.fake_fade_out);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent intent, int i, int i2) {
        if (i != -1 && i2 != -1) {
            intent.putExtra(OUT_ANIM_TRANSITION, i2);
            super/*android.app.Activity*/.startActivity(intent);
            overridePendingTransition(i, i2);
            return;
        }
        super/*android.app.Activity*/.startActivity(intent);
        overridePendingTransition(b.a.slide_in_left, b.a.fake_fade_out);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent intent, int i, int i2, int i3) {
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(intent, i);
        if (i2 != -1 && i3 != -1) {
            intent.putExtra(OUT_ANIM_TRANSITION, i3);
            overridePendingTransition(i2, i3);
            return;
        }
        overridePendingTransition(b.a.slide_in_left, b.a.fake_fade_out);
    }
}
