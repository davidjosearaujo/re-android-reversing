package com.bumptech.glide;

import a3.a;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.fragment.app.e0;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import f.t;
import f3.a;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import p.a0;
import v2.a;
import v2.b;
import v2.c;
import v2.d;
import v2.e;
import v2.j;
import v2.s;
import v2.t;
import v2.u;
import v2.v;
import v2.w;
import w2.a;
import w2.b;
import w2.c;
import w2.d;
import w2.e;
import y2.s;
import y2.u;
import y2.w;
import y2.x;
import z2.a;

/* loaded from: classes.dex */
public final class l {
    public static j a(b bVar, List list) {
        p2.j fVar;
        p2.j uVar;
        String str;
        s2.d dVar = bVar.f2623f;
        s2.b bVar2 = bVar.f2626i;
        Context applicationContext = bVar.f2625h.getApplicationContext();
        h hVar = bVar.f2625h.f2637h;
        j jVar = new j();
        y2.j jVar2 = new y2.j();
        a0 a0Var = jVar.f2652g;
        synchronized (a0Var) {
            a0Var.f5422a.add(jVar2);
        }
        y2.o oVar = new y2.o();
        a0 a0Var2 = jVar.f2652g;
        synchronized (a0Var2) {
            a0Var2.f5422a.add(oVar);
        }
        Resources resources = applicationContext.getResources();
        List<ImageHeaderParser> d7 = jVar.d();
        c3.a aVar = new c3.a(applicationContext, d7, dVar, bVar2);
        x xVar = new x(dVar, new x.g());
        y2.l lVar = new y2.l(jVar.d(), resources.getDisplayMetrics(), dVar, bVar2);
        if (hVar.f2640a.containsKey(d.class)) {
            uVar = new s();
            fVar = new y2.g();
        } else {
            fVar = new y2.f(lVar, 0);
            uVar = new u(lVar, bVar2);
        }
        jVar.c(new a.c(new a3.a(d7, bVar2)), InputStream.class, Drawable.class, "Animation");
        jVar.c(new a.b(new a3.a(d7, bVar2)), ByteBuffer.class, Drawable.class, "Animation");
        a3.e eVar = new a3.e(applicationContext);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar3 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        y2.b bVar4 = new y2.b(bVar2);
        d3.a aVar3 = new d3.a();
        a6.a0 a0Var3 = new a6.a0();
        ContentResolver contentResolver = applicationContext.getContentResolver();
        g6.i iVar = new g6.i(3);
        f3.a aVar4 = jVar.f2648b;
        synchronized (aVar4) {
            aVar4.f4118a.add(new a.C0057a(ByteBuffer.class, iVar));
        }
        t tVar = new t(bVar2);
        f3.a aVar5 = jVar.f2648b;
        synchronized (aVar5) {
            aVar5.f4118a.add(new a.C0057a(InputStream.class, tVar));
        }
        jVar.c(fVar, ByteBuffer.class, Bitmap.class, "Bitmap");
        jVar.c(uVar, InputStream.class, Bitmap.class, "Bitmap");
        String str2 = Build.FINGERPRINT;
        if (!"robolectric".equals(str2)) {
            str = str2;
            jVar.c(new y2.f(lVar, 1), ParcelFileDescriptor.class, Bitmap.class, "Bitmap");
        } else {
            str = str2;
        }
        jVar.c(xVar, ParcelFileDescriptor.class, Bitmap.class, "Bitmap");
        jVar.c(new x(dVar, new x.c()), AssetFileDescriptor.class, Bitmap.class, "Bitmap");
        u.a<?> aVar6 = u.a.f6255a;
        jVar.a(Bitmap.class, Bitmap.class, aVar6);
        jVar.c(new w(), Bitmap.class, Bitmap.class, "Bitmap");
        jVar.b(Bitmap.class, bVar4);
        jVar.c(new y2.a(resources, fVar), ByteBuffer.class, BitmapDrawable.class, "BitmapDrawable");
        jVar.c(new y2.a(resources, uVar), InputStream.class, BitmapDrawable.class, "BitmapDrawable");
        jVar.c(new y2.a(resources, xVar), ParcelFileDescriptor.class, BitmapDrawable.class, "BitmapDrawable");
        jVar.b(BitmapDrawable.class, new androidx.appcompat.widget.l(dVar, bVar4));
        jVar.c(new c3.i(d7, aVar, bVar2), InputStream.class, c3.c.class, "Animation");
        jVar.c(aVar, ByteBuffer.class, c3.c.class, "Animation");
        jVar.b(c3.c.class, new g6.i(4));
        jVar.a(o2.a.class, o2.a.class, aVar6);
        jVar.c(new c3.g(dVar), o2.a.class, Bitmap.class, "Bitmap");
        jVar.c(eVar, Uri.class, Drawable.class, "legacy_append");
        jVar.c(new y2.a(eVar, dVar), Uri.class, Bitmap.class, "legacy_append");
        jVar.g(new a.C0138a());
        jVar.a(File.class, ByteBuffer.class, new c.b());
        jVar.a(File.class, InputStream.class, new e.C0120e());
        jVar.c(new b3.a(), File.class, File.class, "legacy_append");
        jVar.a(File.class, ParcelFileDescriptor.class, new e.b());
        jVar.a(File.class, File.class, aVar6);
        jVar.g(new k.a(bVar2));
        if (!"robolectric".equals(str)) {
            jVar.g(new ParcelFileDescriptorRewinder.a());
        }
        Class cls = Integer.TYPE;
        jVar.a(cls, InputStream.class, cVar);
        jVar.a(cls, ParcelFileDescriptor.class, bVar3);
        jVar.a(Integer.class, InputStream.class, cVar);
        jVar.a(Integer.class, ParcelFileDescriptor.class, bVar3);
        jVar.a(Integer.class, Uri.class, dVar2);
        jVar.a(cls, AssetFileDescriptor.class, aVar2);
        jVar.a(Integer.class, AssetFileDescriptor.class, aVar2);
        jVar.a(cls, Uri.class, dVar2);
        jVar.a(String.class, InputStream.class, new d.c());
        jVar.a(Uri.class, InputStream.class, new d.c());
        jVar.a(String.class, InputStream.class, new t.c());
        jVar.a(String.class, ParcelFileDescriptor.class, new t.b());
        jVar.a(String.class, AssetFileDescriptor.class, new t.a());
        jVar.a(Uri.class, InputStream.class, new a.c(applicationContext.getAssets()));
        jVar.a(Uri.class, AssetFileDescriptor.class, new a.b(applicationContext.getAssets()));
        jVar.a(Uri.class, InputStream.class, new b.a(applicationContext));
        jVar.a(Uri.class, InputStream.class, new c.a(applicationContext));
        jVar.a(Uri.class, InputStream.class, new d.c(applicationContext));
        jVar.a(Uri.class, ParcelFileDescriptor.class, new d.b(applicationContext));
        jVar.a(Uri.class, InputStream.class, new v.d(contentResolver));
        jVar.a(Uri.class, ParcelFileDescriptor.class, new v.b(contentResolver));
        jVar.a(Uri.class, AssetFileDescriptor.class, new v.a(contentResolver));
        jVar.a(Uri.class, InputStream.class, new w.a());
        jVar.a(URL.class, InputStream.class, new e.a());
        jVar.a(Uri.class, File.class, new j.a(applicationContext));
        jVar.a(v2.f.class, InputStream.class, new a.C0128a());
        jVar.a(byte[].class, ByteBuffer.class, new b.a());
        jVar.a(byte[].class, InputStream.class, new b.d());
        jVar.a(Uri.class, Uri.class, aVar6);
        jVar.a(Drawable.class, Drawable.class, aVar6);
        jVar.c(new a3.f(), Drawable.class, Drawable.class, "legacy_append");
        jVar.h(Bitmap.class, BitmapDrawable.class, new f.t(resources));
        jVar.h(Bitmap.class, byte[].class, aVar3);
        jVar.h(Drawable.class, byte[].class, new e0(dVar, aVar3, a0Var3));
        jVar.h(c3.c.class, byte[].class, a0Var3);
        x xVar2 = new x(dVar, new x.d());
        jVar.c(xVar2, ByteBuffer.class, Bitmap.class, "legacy_append");
        jVar.c(new y2.a(resources, xVar2), ByteBuffer.class, BitmapDrawable.class, "legacy_append");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e3.c cVar2 = (e3.c) it.next();
            try {
                cVar2.b();
            } catch (AbstractMethodError e) {
                StringBuilder d8 = androidx.activity.h.d("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                d8.append(cVar2.getClass().getName());
                throw new IllegalStateException(d8.toString(), e);
            }
        }
        return jVar;
    }
}
