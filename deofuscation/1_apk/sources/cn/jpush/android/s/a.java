package cn.jpush.android.s;

import android.content.Context;
import android.view.View;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.e;
import cn.jpush.android.r.l;
import cn.jpush.android.r.n;
import cn.jpush.android.r.o;
import cn.jpush.android.s.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends c {
    private n c;

    public a(l lVar, cn.jpush.android.u.e eVar) {
        super(lVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(boolean z) {
        l f = f();
        if (f == null) {
            return -1;
        }
        int l = z ? f.l() : f.m();
        if (l != 0) {
            l = 0;
        }
        if (l == 0) {
            return f.c() == 80 ? 0 : 3;
        } else if (l != 1) {
            return l != 2 ? 3 : 1;
        } else {
            return 2;
        }
    }

    private void g() {
        n nVar = this.c;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // cn.jpush.android.s.c
    public void a() {
        g();
        super.a();
    }

    @Override // cn.jpush.android.s.c
    public void a(final Context context) {
        final View d;
        final l f;
        try {
            d = d();
            f = f();
        } catch (Throwable th) {
            Logger.w("InAppBannerBindingWrapper", "start in-app with animation error. " + th.getMessage());
        }
        if (f != null && d != null) {
            boolean z = true;
            if (f.f()) {
                int a = a(true);
                if (a < 0) {
                    return;
                }
                cn.jpush.android.r.e.a(context, d, a, f.j(), new e.a() { // from class: cn.jpush.android.s.a.1
                    @Override // cn.jpush.android.r.e.a
                    public void a() {
                        Logger.d("InAppBannerBindingWrapper", "in-app message show success use animation.");
                    }
                });
            } else {
                Logger.d("InAppBannerBindingWrapper", "in-app message show success directory.");
            }
            if (f.h()) {
                d.setOnTouchListener(new o(this, null, new o.a() { // from class: cn.jpush.android.s.a.2
                    @Override // cn.jpush.android.r.o.a
                    public void a(View view, Object obj) {
                        a aVar = a.this;
                        c.a aVar2 = aVar.b;
                        if (aVar2 != null) {
                            cn.jpush.android.u.e eVar = aVar.a;
                            if (eVar != null) {
                                eVar.u = 1;
                            }
                            aVar2.a(context, view, eVar);
                        }
                    }

                    @Override // cn.jpush.android.r.o.a
                    public boolean a(Object obj) {
                        return true;
                    }
                }));
            }
            cn.jpush.android.u.e eVar = this.a;
            if (eVar == null || !eVar.u().bq) {
                z = false;
            }
            Logger.d("InAppBannerBindingWrapper", "message is fixed: " + z + ", banner auto dismiss time: " + f.i());
            if (f.g() && !z) {
                n nVar = this.c;
                if (nVar == null) {
                    nVar = new n();
                    this.c = nVar;
                }
                n nVar2 = nVar;
                this.c = nVar2;
                nVar2.a(new n.a() { // from class: cn.jpush.android.s.a.3
                    @Override // cn.jpush.android.r.n.a
                    public void a() {
                        try {
                            Logger.d("InAppBannerBindingWrapper", "dismiss timer reach, dismiss in-app message");
                            cn.jpush.android.u.e eVar2 = a.this.a;
                            if (eVar2 != null) {
                                cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL", eVar2.u(), false);
                            }
                            int a2 = a.this.a(false);
                            if (a2 < 0) {
                                return;
                            }
                            cn.jpush.android.r.e.b(context, d, a2, f.k(), new e.a() { // from class: cn.jpush.android.s.a.3.1
                                @Override // cn.jpush.android.r.e.a
                                public void a() {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    a aVar = a.this;
                                    c.a aVar2 = aVar.b;
                                    if (aVar2 != null) {
                                        cn.jpush.android.u.e eVar3 = aVar.a;
                                        if (eVar3 != null) {
                                            eVar3.u = 2;
                                        }
                                        aVar2.a(context, d, eVar3);
                                    }
                                }
                            });
                        } catch (Throwable th2) {
                            Logger.w("InAppBannerBindingWrapper", "in-app slide to dismiss error." + th2.getMessage());
                        }
                    }
                }, f.i(), 1000L);
            }
            Logger.d("InAppBannerBindingWrapper", "in app animation with: slideToShow: " + f.f() + " , autoSlideToDismiss: " + f.g() + ", swipeToDismiss: " + f.h());
            super.a(context);
        }
    }

    @Override // cn.jpush.android.s.c
    public void b(Context context) {
    }
}
