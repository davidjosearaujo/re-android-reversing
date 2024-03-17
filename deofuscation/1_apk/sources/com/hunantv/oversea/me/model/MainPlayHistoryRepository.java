package com.hunantv.oversea.me.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.oversea.me.data.PlayRecordEntityV3;
import com.hunantv.oversea.me.data.PlayRecordUploadEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.task.http.HttpParams;
import j.l.a.b0.b0;
import j.l.a.b0.j;
import j.l.a.b0.v;
import j.l.a.i.e.n;
import j.l.c.k.e.k;
import j.l.c.k.m.m;
import j.v.r.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MainPlayHistoryRepository extends j.l.c.k.g.f {
    private static final /* synthetic */ c.b i = null;
    private l c;
    private l d;
    private WeakReference<f> e;
    private volatile boolean g;
    private final Runnable h = new c();
    private final Handler f = new Handler(Looper.getMainLooper());

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ImgoHttpCallBack<PlayRecordEntityV3> {
        public a() {
        }

        /* renamed from: w */
        public void failed(@Nullable PlayRecordEntityV3 playRecordEntityV3, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(playRecordEntityV3, i, i2, str, th);
            MainPlayHistoryRepository.this.k();
        }

        @Override // com.hunantv.imgo.net.ImgoHttpCallBack
        /* renamed from: x */
        public void previewCache(PlayRecordEntityV3 playRecordEntityV3) {
        }

        /* renamed from: y */
        public void success(PlayRecordEntityV3 playRecordEntityV3) {
            MainPlayHistoryRepository mainPlayHistoryRepository = MainPlayHistoryRepository.this;
            mainPlayHistoryRepository.l(mainPlayHistoryRepository.m(playRecordEntityV3), playRecordEntityV3 == null ? "" : playRecordEntityV3.seqId);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends ImgoHttpCallBack<PlayRecordEntityV3> {
        public b() {
        }

        /* renamed from: w */
        public void failed(@Nullable PlayRecordEntityV3 playRecordEntityV3, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(playRecordEntityV3, i, i2, str, th);
            MainPlayHistoryRepository.this.k();
        }

        @Override // com.hunantv.imgo.net.ImgoHttpCallBack
        /* renamed from: x */
        public void previewCache(PlayRecordEntityV3 playRecordEntityV3) {
        }

        /* renamed from: y */
        public void success(PlayRecordEntityV3 playRecordEntityV3) {
            MainPlayHistoryRepository mainPlayHistoryRepository = MainPlayHistoryRepository.this;
            mainPlayHistoryRepository.l(mainPlayHistoryRepository.m(playRecordEntityV3), playRecordEntityV3 == null ? "" : playRecordEntityV3.seqId);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!j.l.c.k.h.a.g()) {
                    MainPlayHistoryRepository.this.l(Collections.EMPTY_LIST, "");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List f = j.l.c.k.m.l.f();
                if (!j.a(f)) {
                    int min = Math.min(m.i() ? 30 : 10, f.size());
                    for (int i = 0; i < min; i++) {
                        n nVar = (n) f.get(i);
                        if (nVar != null && nVar.j() > 0) {
                            arrayList2.add(new k(m.l(nVar)));
                            arrayList.add(m.k(nVar));
                        }
                    }
                }
                if (!b0.f() || arrayList.isEmpty()) {
                    MainPlayHistoryRepository.this.l(arrayList2, "");
                } else {
                    MainPlayHistoryRepository.this.v(j.v.j.b.A(arrayList, PlayRecordUploadEntity.class));
                }
            } catch (Exception e) {
                e.printStackTrace();
                MainPlayHistoryRepository.this.k();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d extends ImgoHttpCallBack<Object> {
        public d() {
        }

        public void failed(@Nullable Object obj, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(obj, i, i2, str, th);
            v.g("checkSyncHistory", "requestSyncHistory result failed");
            MainPlayHistoryRepository.this.g = false;
        }

        public void success(Object obj) {
            v.g("checkSyncHistory", "requestSyncHistory result success");
            MainPlayHistoryRepository.this.g = false;
            MainPlayHistoryRepository.this.j();
            MainPlayHistoryRepository.this.requestPlayHistory();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public final class e implements Runnable {
        private e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = null;
                List<n> f = j.l.c.k.m.l.f();
                if (!j.a(f)) {
                    arrayList = new ArrayList();
                    for (n nVar : f) {
                        if (nVar != null) {
                            arrayList.add(m.k(nVar));
                        }
                    }
                }
                String A = j.a(arrayList) ? "" : j.v.j.b.A(arrayList, PlayRecordUploadEntity.class);
                v.g("checkSyncHistory", "playRecordListStr = " + A);
                MainPlayHistoryRepository.this.u(A);
            } catch (Exception e) {
                e.printStackTrace();
                MainPlayHistoryRepository.this.g = false;
            }
        }

        public /* synthetic */ e(MainPlayHistoryRepository mainPlayHistoryRepository, a aVar) {
            this();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface f {
        void onError();

        void onHistoryDataReady(@NonNull List<k> list, String str);
    }

    static {
        h();
    }

    public MainPlayHistoryRepository(f fVar) {
        this.e = new WeakReference<>(fVar);
    }

    private static /* synthetic */ void h() {
        r.a.c.c.e eVar = new r.a.c.c.e("MainPlayHistoryRepository.java", MainPlayHistoryRepository.class);
        i = eVar.H("method-execution", eVar.E("1", "requestPlayHistory", "com.hunantv.oversea.me.model.MainPlayHistoryRepository", "", "", "", "void"), 98);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ThreadManager.getCommonExecutorService().execute(j.l.c.k.g.d.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        WeakReference<f> weakReference;
        if (((j.l.c.k.g.f) this).b || (weakReference = this.e) == null || weakReference.get() == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f.post(new j.l.c.k.g.b(this));
        } else {
            this.e.get().onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@NonNull List<k> list, String str) {
        WeakReference<f> weakReference;
        if (((j.l.c.k.g.f) this).b || (weakReference = this.e) == null || weakReference.get() == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f.post(new j.l.c.k.g.c(this, list, str));
        } else {
            this.e.get().onHistoryDataReady(list, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<k> m(PlayRecordEntityV3 playRecordEntityV3) {
        PlayRecordEntityV3.DataEntity dataEntity;
        List<PlayRecordEntityV3.PlayListEntity> list;
        ArrayList arrayList = new ArrayList();
        if (playRecordEntityV3 != null && (dataEntity = playRecordEntityV3.data) != null && (list = dataEntity.playList) != null && !list.isEmpty()) {
            for (PlayRecordEntityV3.PlayListEntity playListEntity : playRecordEntityV3.data.playList) {
                arrayList.add(new k(playListEntity));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p() {
        this.e.get().onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(List list, String str) {
        this.e.get().onHistoryDataReady(list, str);
    }

    private void s() {
        if (this.c != null && a().c(this.c, true)) {
            a().B(this.c);
        }
        HttpParams d2 = m.d();
        if (m.h()) {
            d2.put("isFilter", Integer.valueOf(m.e(m.i())));
        }
        d2.put("pageSize", 30);
        d2.put("isInteract", 1);
        if (((j.l.c.k.g.f) this).b) {
            return;
        }
        this.c = a().n(true).u("https://playhistory.bz.mgtv.com/playHistory/v3/get", d2, new a());
    }

    public static final /* synthetic */ void t(MainPlayHistoryRepository mainPlayHistoryRepository, r.a.b.c cVar) {
        if (j.l.c.k.h.a.g() && b0.f()) {
            mainPlayHistoryRepository.s();
        } else {
            ThreadManager.execute(mainPlayHistoryRepository.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@Nullable String str) {
        if (this.d != null && a().c(this.d, true)) {
            a().B(this.d);
        }
        HttpParams d2 = m.d();
        Integer valueOf = Integer.valueOf(m.e(m.i()));
        HttpParams.Type type = HttpParams.Type.BODY;
        d2.put("isFilter", valueOf, type);
        d2.put("playList", str, type);
        d2.put("isInteract", 1);
        if (((j.l.c.k.g.f) this).b) {
            return;
        }
        this.d = a().n(true).u("https://playhistory.bz.mgtv.com/playHistory/v3/getHistoryInfo", d2, new b());
    }

    public void i() {
        if (!j.l.c.k.h.a.g() || this.g) {
            return;
        }
        this.g = true;
        ThreadManager.getCommonExecutorService().execute(new e(this, null));
    }

    public void onCleared() {
        super.onCleared();
        this.e = null;
    }

    @WithTryCatchRuntime
    public void requestPlayHistory() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.g.j(new Object[]{this, r.a.c.c.e.v(i, this, this)}).e(69648));
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            this.g = false;
            return;
        }
        HttpParams d2 = m.d();
        d2.put("playList", str, HttpParams.Type.BODY);
        a().n(true).u("https://playhistory.bz.mgtv.com/playHistory/v2/add", d2, new d());
    }
}
