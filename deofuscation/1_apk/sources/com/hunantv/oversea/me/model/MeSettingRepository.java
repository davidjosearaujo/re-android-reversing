package com.hunantv.oversea.me.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.net.ImgoHttpParams;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.downloader.dir.DownloadDirInfo;
import com.mgtv.json.JsonVoid;
import com.mgtv.task.http.HttpParams;
import j.l.a.b0.m0;
import j.l.c.k.c;
import j.l.c.k.e.h;
import j.l.c.k.e.n;
import j.l.c.k.e.o;
import j.l.c.k.g.f;
import j.l.c.k.g.p;
import j.l.c.k.m.j;
import j.v.r.r;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeSettingRepository extends f {
    private static final /* synthetic */ c.b c = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public boolean a;
        public boolean b;
        public boolean d;
        public boolean e;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public String c = "";
        public String f = "";
        public String g = "";
    }

    static {
        b();
    }

    private static /* synthetic */ void b() {
        e eVar = new e("MeSettingRepository.java", MeSettingRepository.class);
        c = eVar.H("method-execution", eVar.E("1", "getSdCardInfo", "com.hunantv.oversea.me.model.MeSettingRepository", "", "", "", "com.hunantv.oversea.me.data.SDCardInfoResult"), 51);
    }

    @NonNull
    private HttpParams d(int i, boolean z) {
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        String e = j.l.c.k.h.a.e();
        HttpParams.Type type = HttpParams.Type.BODY;
        imgoHttpParams.put("uuid", e, type);
        imgoHttpParams.put("ticket", j.l.c.k.h.a.d(), type);
        imgoHttpParams.put("type", String.valueOf(i), type);
        imgoHttpParams.put("switch", String.valueOf(!z ? 1 : 0), type);
        imgoHttpParams.put(RemoteMessageConst.FROM, "2", type);
        imgoHttpParams.put("isInteract", 1);
        return imgoHttpParams;
    }

    public static final /* synthetic */ n g(MeSettingRepository meSettingRepository, c cVar) {
        n nVar = new n();
        if (m0.b()) {
            nVar.a = new ArrayList();
            if (j.v.f.d.a.j().h() == null) {
                j.v.f.d.a.j().p(j.c());
            }
            List n = j.v.f.d.a.j().n();
            if (n != null && !n.isEmpty()) {
                nVar.a.addAll(n);
            }
        }
        List<File> d = m0.d(j.c());
        if (!j.l.a.b0.j.a(d)) {
            nVar.b = new ArrayList();
            for (File file : d) {
                if (file != null) {
                    long j = m0.j(file);
                    if (j > 0) {
                        n.a aVar = new n.a();
                        aVar.a = file;
                        aVar.b = j;
                        nVar.b.add(aVar);
                    }
                }
            }
        }
        return nVar;
    }

    public void c(n nVar) {
        if (nVar == null || j.l.a.b0.j.a(nVar.b())) {
            return;
        }
        List<n.a> b = nVar.b();
        if (!j.l.a.b0.j.a(b)) {
            for (n.a aVar : b) {
                if (aVar != null) {
                    m0.a(aVar.a);
                }
            }
        }
        if (b != null) {
            b.clear();
        }
        j.l.a.r.a.d().a();
    }

    public List<h> e(@NonNull a aVar) {
        Context a2 = j.l.a.a.a();
        ArrayList arrayList = new ArrayList();
        h hVar = new h(1, (byte) 8);
        hVar.l(a2.getString(c.r.me_setting_category_security));
        arrayList.add(hVar);
        h hVar2 = new h(3, (byte) 81);
        hVar2.l(a2.getString(c.r.me_setting_subject_security_account));
        arrayList.add(hVar2);
        hVar2.h(aVar.a);
        h hVar3 = new h(1, (byte) 1);
        hVar3.l(a2.getString(c.r.me_setting_category_play));
        arrayList.add(hVar3);
        h hVar4 = new h(2, (byte) 11);
        hVar4.l(a2.getString(c.r.me_setting_subject_play_warn_non_wifi));
        hVar4.k(aVar.b);
        arrayList.add(hVar4);
        arrayList.add(new h(5));
        h hVar5 = new h(3, (byte) 12);
        hVar5.l(a2.getString(c.r.me_setting_subject_play_mode));
        hVar5.i(aVar.c);
        arrayList.add(hVar5);
        arrayList.add(new h(5));
        h hVar6 = new h(2, (byte) 13);
        hVar6.l(a2.getString(c.r.me_setting_subject_play_jump));
        hVar6.k(aVar.d);
        arrayList.add(hVar6);
        h hVar7 = new h(1, (byte) 2);
        hVar7.l(a2.getString(c.r.me_setting_category_download));
        arrayList.add(hVar7);
        h hVar8 = new h(2, (byte) 21);
        hVar8.l(a2.getString(c.r.me_setting_subject_download_non_wifi));
        hVar8.k(aVar.e);
        arrayList.add(hVar8);
        arrayList.add(new h(5));
        h hVar9 = new h(3, (byte) 23);
        hVar9.l(a2.getString(c.r.me_setting_subject_download_resolution));
        hVar9.i(aVar.g);
        arrayList.add(hVar9);
        h hVar10 = new h(1, (byte) 3);
        hVar10.l(a2.getString(c.r.me_setting_category_push));
        arrayList.add(hVar10);
        h hVar11 = new h(3, (byte) 31);
        hVar11.l(a2.getString(c.r.me_setting_subject_push));
        arrayList.add(hVar11);
        h hVar12 = new h(1, (byte) 5);
        hVar12.l(a2.getString(c.r.me_setting_category_history));
        arrayList.add(hVar12);
        h hVar13 = new h(2, (byte) 51);
        hVar13.l(a2.getString(c.r.me_setting_subject_history_sync));
        hVar13.k(aVar.k);
        arrayList.add(hVar13);
        h hVar14 = new h(1, (byte) 6);
        hVar14.l(a2.getString(c.r.me_setting_category_other));
        arrayList.add(hVar14);
        h hVar15 = new h(3, (byte) 61);
        hVar15.l(a2.getString(c.r.me_setting_subject_other_clear));
        arrayList.add(hVar15);
        arrayList.add(new h(5));
        if (!j.l.a.b0.e.W0()) {
            h hVar16 = new h(3, (byte) 62);
            hVar16.l(a2.getString(c.r.me_setting_subject_other_update));
            arrayList.add(hVar16);
        }
        arrayList.add(new h(5));
        h hVar17 = new h(3, (byte) 64);
        hVar17.l(a2.getString(c.r.me_setting_subject_privacy));
        arrayList.add(hVar17);
        arrayList.add(new h(5));
        h hVar18 = new h(3, (byte) 83);
        hVar18.l(a2.getString(c.r.me_setting_subject_privacy_setting));
        arrayList.add(hVar18);
        arrayList.add(new h(5));
        h hVar19 = new h(3, (byte) 66);
        hVar19.l(a2.getString(c.r.me_setting_subject_privacy_safeguard));
        arrayList.add(hVar19);
        arrayList.add(new h(5));
        h hVar20 = new h(3, (byte) 67);
        hVar20.l(a2.getString(c.r.me_setting_subject_privacy_safe_guide));
        arrayList.add(hVar20);
        arrayList.add(new h(5));
        h hVar21 = new h(3, (byte) 65);
        hVar21.l(a2.getString(c.r.me_setting_subject_common_problem));
        arrayList.add(hVar21);
        arrayList.add(new h(5));
        h hVar22 = new h(6, (byte) 63);
        hVar22.l(a2.getString(c.r.me_setting_subject_other_about));
        arrayList.add(hVar22);
        if (aVar.l) {
            h hVar23 = new h(4, (byte) 7);
            hVar23.l(j.l.a.a.a().getString(c.r.me_setting_item_logout));
            arrayList.add(hVar23);
        }
        return arrayList;
    }

    public o f(n nVar) {
        if (j.v.f.d.a.j().h() == null) {
            j.v.f.d.a.j().p(j.c());
        }
        j.v.f.d.a.j().x();
        DownloadDirInfo h = j.v.f.d.a.j().h();
        if (h == null || nVar == null || j.l.a.b0.j.a(nVar.a)) {
            return null;
        }
        List list = nVar.a;
        int size = list.size();
        String[] strArr = new String[size];
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            DownloadDirInfo downloadDirInfo = (DownloadDirInfo) list.get(i2);
            strArr[i2] = j.f(c.r.me_setting_download_path_item, new Object[]{downloadDirInfo.getDisplayName(j.c()), downloadDirInfo.availableSizeDesc, downloadDirInfo.totalSizeDesc});
            if (h.equals(downloadDirInfo)) {
                i = i2;
            }
        }
        if (i == -1) {
            return null;
        }
        o oVar = new o();
        oVar.b = i;
        oVar.a = strArr;
        return oVar;
    }

    @WithTryCatchRuntime
    @WorkerThread
    public n getSdCardInfo() {
        return (n) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p(new Object[]{this, e.v(c, this, this)}).e(69648));
    }

    public boolean h(boolean z, ImgoHttpCallBack<JsonVoid> imgoHttpCallBack) {
        r a2 = a();
        if (a2 == null) {
            return false;
        }
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        imgoHttpParams.put("sync", Integer.valueOf(z ? 1 : 0), HttpParams.Type.BODY);
        a2.n(true).u("https://playhistory.bz.mgtv.com/playHistory/v2/setSync", imgoHttpParams, imgoHttpCallBack);
        return true;
    }

    public boolean i(int i, boolean z, ImgoHttpCallBack<JsonVoid> imgoHttpCallBack) {
        r a2 = a();
        if (a2 == null) {
            return false;
        }
        a2.n(true).u("https://courier.bz.mgtv.com/message/setSwitch", d(i, z), imgoHttpCallBack);
        return true;
    }
}
