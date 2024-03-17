package com.hunantv.oversea.me.viewmodels;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.data.CountryListData;
import com.hunantv.oversea.me.data.EditUserInfoEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j;
import j.l.a.b0.v;
import j.l.c.k.c;
import j.l.c.k.e.g;
import j.l.c.k.e.m;
import j.l.c.k.g.i;
import j.l.c.k.o.e;
import j.l.c.k.o.n;
import j.l.c.k.o.o;
import j.v.j.b;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeProfileViewModel extends n {
    private static final int r = -1;
    private static final String s = "1900-01-01";
    private static final /* synthetic */ c.b t = null;
    private CountryListData l;
    private boolean m;
    private String n;
    private String o;
    private String q;
    private MutableLiveData<List<g>> j = new MutableLiveData<>();
    private MutableLiveData<EditUserInfoEntity> k = new MutableLiveData<>();
    private int p = -1;
    private i i = b(new i());

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ImgoHttpCallBack<EditUserInfoEntity> {
        public a() {
        }

        /* renamed from: w */
        public void failed(@Nullable EditUserInfoEntity editUserInfoEntity, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(editUserInfoEntity, i, i2, str, th);
            v.g("MeProfileViewModel", "requestModifyUserInfo failed! info = " + str);
            MeProfileViewModel.this.k.setValue((Object) null);
        }

        /* renamed from: x */
        public void success(EditUserInfoEntity editUserInfoEntity) {
            v.g("MeProfileViewModel", "requestModifyUserInfo success! result = " + b.E(editUserInfoEntity));
            MeProfileViewModel.this.k.setValue(editUserInfoEntity);
        }
    }

    static {
        ajc$preClinit();
    }

    public MeProfileViewModel() {
        o(j.l.c.k.h.a.f(), this.i.b());
        ThreadManager.execute(new e(this));
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("MeProfileViewModel.java", MeProfileViewModel.class);
        t = eVar.H("method-execution", eVar.E("1", "userInfoChanged", "com.hunantv.oversea.me.viewmodels.MeProfileViewModel", "", "", "", "boolean"), (int) Opcodes.FCMPL);
    }

    private String k(int i) {
        int i2;
        if (1 == i) {
            i2 = c.r.me_profile_subject_gender_male;
        } else if (2 == i) {
            i2 = c.r.me_profile_subject_gender_female;
        } else {
            i2 = c.r.me_profile_subject_gender_unknown;
        }
        return j.l.a.a.a().getString(i2);
    }

    private g m(byte b) {
        List list = (List) this.j.getValue();
        if (j.a(list)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            g gVar = (g) list.get(i);
            if (gVar != null && gVar.b() == b) {
                return gVar;
            }
        }
        return null;
    }

    private void o(UserInfo userInfo, List<g> list) {
        if (list == null) {
            this.j.setValue(new ArrayList());
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            g gVar = list.get(i);
            byte b = gVar.b();
            if (b == 1) {
                gVar.f(userInfo != null ? userInfo.getAvatar() : "");
            } else if (b == 2) {
                gVar.g(userInfo != null ? userInfo.nickname : "");
            } else if (b == 3) {
                gVar.g(k(UserInfo.a.a(userInfo == null ? 0 : userInfo.sex)));
            } else if (b == 4) {
                gVar.g((userInfo == null || TextUtils.isEmpty(userInfo.birthday)) ? s : userInfo.birthday);
            } else if (b == 5) {
                gVar.g(userInfo != null ? userInfo.country : "");
            }
        }
        this.m = userInfo != null;
        this.j.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q() {
        this.l = this.i.d();
    }

    public static final /* synthetic */ boolean x(MeProfileViewModel meProfileViewModel, r.a.b.c cVar) {
        UserInfo f = j.l.c.k.h.a.f();
        if (!meProfileViewModel.m || f == null) {
            return false;
        }
        boolean z = (TextUtils.isEmpty(meProfileViewModel.n) || meProfileViewModel.n.equals(f.nickname)) ? false : true;
        boolean z2 = ((s.equals(meProfileViewModel.o) && TextUtils.isEmpty(f.birthday)) || TextUtils.isEmpty(meProfileViewModel.o) || meProfileViewModel.o.equals(f.birthday)) ? false : true;
        int i = meProfileViewModel.p;
        boolean z3 = (i == -1 || i == f.sex) ? false : true;
        boolean z4 = (TextUtils.isEmpty(meProfileViewModel.q) || meProfileViewModel.q.equals(f.country)) ? false : true;
        v.g("MeProfileViewModel", "nicknameChanged = " + z + ", birthdayChanged = " + z2 + ", genderChanged = " + z3);
        return z || z2 || z3 || z4;
    }

    @Nullable
    public CountryListData j() {
        return this.l;
    }

    public MutableLiveData<EditUserInfoEntity> l() {
        return this.k;
    }

    public MutableLiveData<List<g>> n() {
        return this.j;
    }

    public void r() {
        m mVar = new m();
        if (!TextUtils.isEmpty(this.n)) {
            mVar.a = this.n;
        }
        int i = this.p;
        if (i != -1) {
            mVar.b = i;
        }
        if (!TextUtils.isEmpty(this.o)) {
            mVar.c = this.o;
        }
        if (!TextUtils.isEmpty(this.q)) {
            mVar.g = this.q;
        }
        this.i.e(mVar, new a());
    }

    public void s(String str) {
        g m = m((byte) 1);
        if (m != null) {
            m.f(str);
        }
        MutableLiveData<List<g>> mutableLiveData = this.j;
        mutableLiveData.postValue(mutableLiveData.getValue());
    }

    public void t(String str) {
        g m = m((byte) 4);
        if (m != null) {
            this.o = str;
            m.g(str);
        }
        MutableLiveData<List<g>> mutableLiveData = this.j;
        mutableLiveData.postValue(mutableLiveData.getValue());
    }

    public void u(String str) {
        g m = m((byte) 5);
        if (m == null || TextUtils.equals(str, m.d())) {
            return;
        }
        this.q = str;
        m.g(str);
        MutableLiveData<List<g>> mutableLiveData = this.j;
        mutableLiveData.postValue(mutableLiveData.getValue());
    }

    @WithTryCatchRuntime
    public boolean userInfoChanged() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, r.a.c.c.e.v(t, this, this)}).e(69648)));
    }

    public void v(int i) {
        g m = m((byte) 3);
        if (m != null) {
            this.p = i;
            m.g(k(i));
        }
        MutableLiveData<List<g>> mutableLiveData = this.j;
        mutableLiveData.postValue(mutableLiveData.getValue());
    }

    public void w(String str) {
        g m = m((byte) 2);
        if (m != null) {
            this.n = str;
            m.g(str);
        }
        MutableLiveData<List<g>> mutableLiveData = this.j;
        mutableLiveData.postValue(mutableLiveData.getValue());
    }
}
