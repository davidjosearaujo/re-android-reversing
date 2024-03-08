package i;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    public static Configuration f4405f;

    /* renamed from: a  reason: collision with root package name */
    public int f4406a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f4407b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f4408c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f4409d;
    public Resources e;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static Context a(c cVar, Configuration configuration) {
            return cVar.createConfigurationContext(configuration);
        }
    }

    public c() {
        super(null);
    }

    public c(Context context, int i7) {
        super(context);
        this.f4406a = i7;
    }

    public c(Context context, Resources.Theme theme) {
        super(context);
        this.f4407b = theme;
    }

    public final void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f4409d == null) {
            this.f4409d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f4407b == null) {
            this.f4407b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f4407b.setTo(theme);
            }
        }
        this.f4407b.applyStyle(this.f4406a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources;
        if (this.e == null) {
            Configuration configuration = this.f4409d;
            if (configuration != null) {
                if (f4405f == null) {
                    Configuration configuration2 = new Configuration();
                    configuration2.fontScale = 0.0f;
                    f4405f = configuration2;
                }
                if (!configuration.equals(f4405f)) {
                    resources = a.a(this, this.f4409d).getResources();
                    this.e = resources;
                }
            }
            resources = super.getResources();
            this.e = resources;
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f4408c == null) {
            this.f4408c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f4408c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f4407b;
        if (theme != null) {
            return theme;
        }
        if (this.f4406a == 0) {
            this.f4406a = 2131886623;
        }
        b();
        return this.f4407b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i7) {
        if (this.f4406a != i7) {
            this.f4406a = i7;
            b();
        }
    }
}
