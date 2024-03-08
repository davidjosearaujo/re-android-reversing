package com.bumptech.glide;

import a6.a0;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.l;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import e3.e;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import r2.m;
import s2.d;
import s2.j;
import t2.f;
import t2.g;
import t2.h;
import t2.i;
import u2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements ComponentCallbacks2 {
    public static volatile b m;

    /* renamed from: n */
    public static volatile boolean f2622n;

    /* renamed from: f */
    public final d f2623f;

    /* renamed from: g */
    public final h f2624g;

    /* renamed from: h */
    public final g f2625h;

    /* renamed from: i */
    public final s2.b f2626i;

    /* renamed from: j */
    public final l f2627j;

    /* renamed from: k */
    public final c f2628k;

    /* renamed from: l */
    public final ArrayList f2629l = new ArrayList();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
    }

    public b(Context context, m mVar, h hVar, d dVar, s2.b bVar, l lVar, c cVar, int i7, c cVar2, o.b bVar2, List list, ArrayList arrayList, e3.a aVar, h hVar2) {
        this.f2623f = dVar;
        this.f2626i = bVar;
        this.f2624g = hVar;
        this.f2627j = lVar;
        this.f2628k = cVar;
        this.f2625h = new g(context, bVar, new k(this, arrayList, aVar), new a0(), cVar2, bVar2, list, mVar, hVar2, i7);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        ArrayList arrayList;
        d dVar;
        if (!f2622n) {
            f2622n = true;
            o.b bVar = new o.b();
            h.a aVar = new h.a();
            c cVar = new c();
            Context applicationContext = context.getApplicationContext();
            Collections.emptyList();
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Loading Glide modules");
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    if (Log.isLoggable("ManifestParser", 2)) {
                        Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                    }
                    for (String str : applicationInfo.metaData.keySet()) {
                        if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                            arrayList2.add(e.a(str));
                            if (Log.isLoggable("ManifestParser", 3)) {
                                Log.d("ManifestParser", "Loaded Glide module: " + str);
                            }
                        }
                    }
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Finished loading Glide modules");
                    }
                } else if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
                if (generatedAppGlideModule != null && !new HashSet().isEmpty()) {
                    HashSet hashSet = new HashSet();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        e3.c cVar2 = (e3.c) it.next();
                        if (hashSet.contains(cVar2.getClass())) {
                            if (Log.isLoggable("Glide", 3)) {
                                Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + cVar2);
                            }
                            it.remove();
                        }
                    }
                }
                if (Log.isLoggable("Glide", 3)) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        StringBuilder d7 = androidx.activity.h.d("Discovered GlideModule from manifest: ");
                        d7.append(((e3.c) it2.next()).getClass());
                        Log.d("Glide", d7.toString());
                    }
                }
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    ((e3.c) it3.next()).a();
                }
                a.ThreadFactoryC0110a aVar2 = new a.ThreadFactoryC0110a();
                if (u2.a.f6093h == 0) {
                    u2.a.f6093h = Math.min(4, Runtime.getRuntime().availableProcessors());
                }
                int i7 = u2.a.f6093h;
                if (!TextUtils.isEmpty("source")) {
                    u2.a aVar3 = new u2.a(new ThreadPoolExecutor(i7, i7, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.b(aVar2, "source", false)));
                    int i8 = u2.a.f6093h;
                    a.ThreadFactoryC0110a aVar4 = new a.ThreadFactoryC0110a();
                    if (!TextUtils.isEmpty("disk-cache")) {
                        u2.a aVar5 = new u2.a(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.b(aVar4, "disk-cache", true)));
                        if (u2.a.f6093h == 0) {
                            u2.a.f6093h = Math.min(4, Runtime.getRuntime().availableProcessors());
                        }
                        int i9 = u2.a.f6093h >= 4 ? 2 : 1;
                        a.ThreadFactoryC0110a aVar6 = new a.ThreadFactoryC0110a();
                        if (!TextUtils.isEmpty("animation")) {
                            u2.a aVar7 = new u2.a(new ThreadPoolExecutor(i9, i9, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.b(aVar6, "animation", true)));
                            i iVar = new i(new i.a(applicationContext));
                            com.bumptech.glide.manager.e eVar = new com.bumptech.glide.manager.e();
                            int i10 = iVar.f6051a;
                            if (i10 > 0) {
                                arrayList = arrayList2;
                                dVar = new j((long) i10);
                            } else {
                                arrayList = arrayList2;
                                dVar = new s2.e();
                            }
                            s2.i iVar2 = new s2.i(iVar.f6053c);
                            g gVar = new g((long) iVar.f6052b);
                            m mVar = new m(gVar, new f(applicationContext), aVar5, aVar3, new u2.a(new ThreadPoolExecutor(0, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO, u2.a.f6092g, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a.b(new a.ThreadFactoryC0110a(), "source-unlimited", false))), aVar7);
                            List emptyList = Collections.emptyList();
                            h hVar = new h(aVar);
                            b bVar2 = new b(applicationContext, mVar, gVar, dVar, iVar2, new l(null, hVar), eVar, 4, cVar, bVar, emptyList, arrayList, generatedAppGlideModule, hVar);
                            applicationContext.registerComponentCallbacks(bVar2);
                            m = bVar2;
                            f2622n = false;
                            return;
                        }
                        throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
                    }
                    throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
                }
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
            }
        } else {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
    }

    public static b b(Context context) {
        if (m == null) {
            GeneratedAppGlideModule generatedAppGlideModule = null;
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
            } catch (InstantiationException e7) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e7);
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e9);
            }
            synchronized (b.class) {
                if (m == null) {
                    a(context, generatedAppGlideModule);
                }
            }
        }
        return m;
    }

    public static n d(Context context) {
        if (context != null) {
            return b(context).f2627j.b(context);
        }
        throw new NullPointerException("You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    }

    public final void c(n nVar) {
        synchronized (this.f2629l) {
            if (this.f2629l.contains(nVar)) {
                this.f2629l.remove(nVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        k3.l.a();
        ((k3.i) this.f2624g).e(0);
        this.f2623f.b();
        this.f2626i.b();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i7) {
        long j7;
        k3.l.a();
        synchronized (this.f2629l) {
            Iterator it = this.f2629l.iterator();
            while (it.hasNext()) {
                ((n) it.next()).getClass();
            }
        }
        g gVar = (g) this.f2624g;
        if (i7 >= 40) {
            gVar.e(0);
        } else if (i7 >= 20 || i7 == 15) {
            synchronized (gVar) {
                j7 = gVar.f4704b;
            }
            gVar.e(j7 / 2);
        } else {
            gVar.getClass();
        }
        this.f2623f.a(i7);
        this.f2626i.a(i7);
    }
}
