package cn.jpush.android.s;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.e;
import cn.jpush.android.r.l;
import cn.jpush.android.r.n;
import cn.jpush.android.s.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e extends c {
    private n c;

    public e(l lVar, cn.jpush.android.u.e eVar) {
        super(lVar, eVar);
    }

    @Override // cn.jpush.android.s.c
    public void a(final Context context) {
        final View d = d();
        l f = f();
        if (f == null || d == null) {
            return;
        }
        final cn.jpush.android.u.c cVar = (cn.jpush.android.u.c) this.a;
        boolean z = true;
        if (cVar != null) {
            cn.jpush.android.r.e.a(context, d, cVar.a() == 53 ? 2 : 1, 1000L, new e.a() { // from class: cn.jpush.android.s.e.1
                {
                    e.this = this;
                }

                @Override // cn.jpush.android.r.e.a
                public void a() {
                    Logger.d("InAppFloatBindingWrapper", "in-app float message show success use animation");
                }
            });
        }
        z = (cVar == null || !cVar.u().bq) ? false : false;
        Logger.d("InAppFloatBindingWrapper", "message is fixed: " + z + ", float auto dismiss time: " + f.i());
        if (!z) {
            n nVar = this.c;
            if (nVar == null) {
                nVar = new n();
            }
            n nVar2 = nVar;
            this.c = nVar2;
            nVar2.a(new n.a() { // from class: cn.jpush.android.s.e.2
                {
                    e.this = this;
                }

                @Override // cn.jpush.android.r.n.a
                public void a() {
                    try {
                        Logger.d("InAppFloatBindingWrapper", "dismiss timer reach, dismiss in-app message, message to user: " + cVar.u().aL);
                        cn.jpush.android.u.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL", cVar2.u(), false);
                            cn.jpush.android.r.e.b(context, d, cVar.a() == 53 ? 2 : 1, 1000L, new e.a() { // from class: cn.jpush.android.s.e.2.1
                                {
                                    AnonymousClass2.this = this;
                                }

                                @Override // cn.jpush.android.r.e.a
                                public void a() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    c.a aVar = e.this.b;
                                    if (aVar != null) {
                                        cn.jpush.android.u.c cVar3 = cVar;
                                        cVar3.u = 2;
                                        aVar.a(context, d, cVar3);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        Logger.w("InAppFloatBindingWrapper", "in-app slide to dismiss error." + th.getMessage());
                    }
                }
            }, f.i(), 1000L);
        }
        super.a(context);
    }

    @Override // cn.jpush.android.s.c
    public void b(Context context) {
        WebView webView = (WebView) d();
        f();
    }
}
