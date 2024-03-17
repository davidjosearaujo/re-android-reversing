package cn.jpush.android.s;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import cn.jpush.android.ac.i;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.e;
import cn.jpush.android.r.l;
import cn.jpush.android.r.n;
import cn.jpush.android.r.o;
import cn.jpush.android.s.c;
import cn.jpush.android.u.g;
import com.alibaba.fastjson.JSONStreamContext;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import j.l.c.e0.a.a.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends c {
    private n c;
    private LinearLayout d;
    private int e;
    private int f;

    public b(l lVar, cn.jpush.android.u.e eVar) {
        super(lVar, eVar);
        this.e = -1;
        this.f = -1;
    }

    private void g() {
        n nVar = this.c;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // cn.jpush.android.s.c
    public WindowManager.LayoutParams a(Context context, l lVar, boolean z, final WindowManager windowManager, View view) {
        Logger.d("InAppBannerNotificationBindingWrapper", "getLayoutParams");
        if (lVar == null || context == null) {
            return null;
        }
        try {
            int b = lVar.b() | 131072 | 32 | 8;
            int i = z ? Build.VERSION.SDK_INT >= 26 ? 2038 : CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR : JSONStreamContext.PropertyValue;
            boolean z2 = context.getResources().getConfiguration().orientation == 2;
            int g = cn.jpush.android.r.d.g(context, z2);
            int h = cn.jpush.android.r.d.h(context, z2);
            int c = cn.jpush.android.r.d.c(context, z2);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, c, i, b, -3);
            layoutParams.dimAmount = 0.3f;
            layoutParams.gravity = 48;
            layoutParams.windowAnimations = 0;
            Logger.d("InAppBannerNotificationBindingWrapper", "dialog view w: " + g + ", h: " + h + ",heightMax:" + c);
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(g, h, i, b, -3);
            LinearLayout linearLayout = new LinearLayout(context);
            this.d = linearLayout;
            linearLayout.addView(view, layoutParams2);
            layoutParams.y = g.a(context);
            this.d.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: cn.jpush.android.s.b.1
                public int a = -100;
                public int b = -100;
                public int c = -100;

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    int width = view2.getWidth();
                    if (-100 == this.b || -100 == this.c) {
                        DisplayMetrics a = i.a(view2.getContext());
                        this.b = a.widthPixels;
                        this.c = a.heightPixels;
                    }
                    if (this.b == width || this.c == width) {
                        if (-100 == this.a) {
                            this.a = width;
                        }
                        if (this.a != width) {
                            windowManager.removeViewImmediate(view2);
                            Logger.d("InAppBannerNotificationBindingWrapper", "linearLayout onLayoutChange removeViewImmediate:" + this.a);
                        }
                    }
                }
            });
            View view2 = this.d;
            h.a(view2, layoutParams);
            windowManager.addView(view2, layoutParams);
            return layoutParams;
        } catch (Throwable th) {
            Logger.w("InAppBannerNotificationBindingWrapper", "[getLayoutParams] error." + th.getMessage());
            return null;
        }
    }

    @Override // cn.jpush.android.s.c
    public void a() {
        g();
        super.a();
    }

    @Override // cn.jpush.android.s.c
    public void a(final WindowManager windowManager, final Context context) {
        final View d;
        final l f;
        try {
            Logger.d("InAppBannerNotificationBindingWrapper", "startViewAnimation.");
            d = d();
            f = f();
        } catch (Throwable th) {
            Logger.w("InAppBannerNotificationBindingWrapper", "start in-app with animation error. " + th.getMessage());
        }
        if (f != null && d != null) {
            boolean b = ((cn.jpush.android.u.b) c()).b();
            final View b2 = b();
            cn.jpush.android.r.e.a(context, d, b2, new e.a() { // from class: cn.jpush.android.s.b.2
                @Override // cn.jpush.android.r.e.a
                public void a() {
                    Logger.d("InAppBannerNotificationBindingWrapper", "in-app message show success use animation.");
                }
            }, windowManager, b);
            if (f.h()) {
                d.setOnTouchListener(new o(this, null, new o.a() { // from class: cn.jpush.android.s.b.3
                    @Override // cn.jpush.android.r.o.a
                    public void a(View view, Object obj) {
                        b bVar = b.this;
                        c.a aVar = bVar.b;
                        if (aVar != null) {
                            cn.jpush.android.u.e eVar = bVar.a;
                            if (eVar != null) {
                                eVar.u = 1;
                            }
                            aVar.a(context, view, eVar);
                        }
                    }

                    @Override // cn.jpush.android.r.o.a
                    public boolean a(Object obj) {
                        return true;
                    }
                }));
            }
            cn.jpush.android.u.e eVar = this.a;
            boolean z = eVar != null && eVar.u().bq;
            Logger.d("InAppBannerNotificationBindingWrapper", "message is fixed: " + z + ", banner auto dismiss time: " + f.i());
            if (f.g() && !z) {
                n nVar = this.c;
                if (nVar == null) {
                    nVar = new n();
                    this.c = nVar;
                }
                n nVar2 = nVar;
                this.c = nVar2;
                nVar2.a(new n.a() { // from class: cn.jpush.android.s.b.4
                    @Override // cn.jpush.android.r.n.a
                    public void a() {
                        try {
                            Logger.d("InAppBannerNotificationBindingWrapper", "dismiss timer reach, dismiss in-app message");
                            cn.jpush.android.u.e eVar2 = b.this.a;
                            if (eVar2 != null) {
                                cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL", eVar2.u(), false);
                            }
                            f.k();
                            cn.jpush.android.r.e.a(context, d, b2, new e.a() { // from class: cn.jpush.android.s.b.4.1
                                @Override // cn.jpush.android.r.e.a
                                public void a() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    b bVar = b.this;
                                    c.a aVar = bVar.b;
                                    if (aVar != null) {
                                        cn.jpush.android.u.e eVar3 = bVar.a;
                                        if (eVar3 != null) {
                                            eVar3.u = 2;
                                        }
                                        aVar.a(context, d, eVar3);
                                    }
                                }
                            }, windowManager);
                        } catch (Throwable th2) {
                            Logger.w("InAppBannerNotificationBindingWrapper", "in-app slide to dismiss error." + th2.getMessage());
                        }
                    }
                }, f.i(), 1000L);
            }
            Logger.d("InAppBannerNotificationBindingWrapper", "in app animation with: slideToShow: " + f.f() + " , autoSlideToDismiss: " + f.g() + ", swipeToDismiss: " + f.h());
            super.a(context);
        }
    }

    @Override // cn.jpush.android.s.c
    public View b() {
        return this.d;
    }

    @Override // cn.jpush.android.s.c
    public void b(Context context) {
    }

    @Override // cn.jpush.android.s.c
    public boolean c(Context context) {
        cn.jpush.android.webview.bridge.d e = e();
        return e != null && e.a() == context.getResources().getConfiguration().orientation;
    }
}
