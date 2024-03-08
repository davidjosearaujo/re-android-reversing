package f;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import f.q;
import f.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import l1.e;
import o.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class g {

    /* renamed from: f */
    public static s.a f3929f = new s.a(new s.b());

    /* renamed from: g */
    public static int f3930g = -100;

    /* renamed from: h */
    public static e f3931h = null;

    /* renamed from: i */
    public static e f3932i = null;

    /* renamed from: j */
    public static Boolean f3933j = null;

    /* renamed from: k */
    public static boolean f3934k = false;

    /* renamed from: l */
    public static final d<WeakReference<g>> f3935l = new d<>();
    public static final Object m = new Object();

    /* renamed from: n */
    public static final Object f3936n = new Object();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static boolean l(Context context) {
        if (f3933j == null) {
            try {
                int i7 = q.f4011f;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, q.class), q.a.a() | 128).metaData;
                if (bundle != null) {
                    f3933j = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f3933j = Boolean.FALSE;
            }
        }
        return f3933j.booleanValue();
    }

    public static void s(g gVar) {
        synchronized (m) {
            Iterator<WeakReference<g>> it = f3935l.iterator();
            while (it.hasNext()) {
                g gVar2 = it.next().get();
                if (gVar2 == gVar || gVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public Context d(Context context) {
        return context;
    }

    public abstract <T extends View> T e(int i7);

    public Context f() {
        return null;
    }

    public int g() {
        return -100;
    }

    public abstract MenuInflater h();

    public abstract a i();

    public abstract void j();

    public abstract void k();

    public abstract void m(Configuration configuration);

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract boolean t(int i7);

    public abstract void u(int i7);

    public abstract void v(View view);

    public abstract void w(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void x(Toolbar toolbar);

    public void y(int i7) {
    }

    public abstract void z(CharSequence charSequence);
}
