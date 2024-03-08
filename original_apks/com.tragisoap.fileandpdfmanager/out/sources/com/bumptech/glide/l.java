package com.bumptech.glide;

import a3.a;
import a3.e;
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
import androidx.activity.h;
import androidx.fragment.app.e0;
import c3.a;
import c3.c;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import f.t;
import f3.a;
import g6.i;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import p.a0;
import p2.j;
import s2.b;
import s2.d;
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
import y2.f;
import y2.g;
import y2.o;
import y2.s;
import y2.u;
import y2.w;
import y2.x;
import z2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {
    public static j a(b bVar, List list) {
        j jVar;
        j jVar2;
        String str;
        d dVar = bVar.f2623f;
        b bVar2 = bVar.f2626i;
        Context applicationContext = bVar.f2625h.getApplicationContext();
        h hVar = bVar.f2625h.f2637h;
        j jVar3 = new j();
        y2.j jVar4 = new y2.j();
        a0 a0Var = jVar3.f2652g;
        synchronized (a0Var) {
            a0Var.f5422a.add(jVar4);
        }
        o oVar = new o();
        a0 a0Var2 = jVar3.f2652g;
        synchronized (a0Var2) {
            a0Var2.f5422a.add(oVar);
        }
        Resources resources = applicationContext.getResources();
        List<ImageHeaderParser> d7 = jVar3.d();
        a aVar = new a(applicationContext, d7, dVar, bVar2);
        x xVar = new x(dVar, new x.g());
        y2.l lVar = new y2.l(jVar3.d(), resources.getDisplayMetrics(), dVar, bVar2);
        if (hVar.f2640a.containsKey(d.class)) {
            jVar2 = new s();
            jVar = new g();
        } else {
            jVar = new f(lVar, 0);
            jVar2 = new u(lVar, bVar2);
        }
        jVar3.c(new a.c(new a3.a(d7, bVar2)), InputStream.class, Drawable.class, "Animation");
        jVar3.c(new a.b(new a3.a(d7, bVar2)), ByteBuffer.class, Drawable.class, "Animation");
        e eVar = new e(applicationContext);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar3 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        y2.b bVar4 = new y2.b(bVar2);
        d3.a aVar3 = new d3.a();
        a6.a0 a0Var3 = new a6.a0();
        ContentResolver contentResolver = applicationContext.getContentResolver();
        i iVar = new i(3);
        f3.a aVar4 = jVar3.f2648b;
        synchronized (aVar4) {
            aVar4.f4118a.add(new a.C0057a(ByteBuffer.class, iVar));
        }
        t tVar = new t(bVar2);
        f3.a aVar5 = jVar3.f2648b;
        synchronized (aVar5) {
            aVar5.f4118a.add(new a.C0057a(InputStream.class, tVar));
        }
        jVar3.c(jVar, ByteBuffer.class, Bitmap.class, "Bitmap");
        jVar3.c(jVar2, InputStream.class, Bitmap.class, "Bitmap");
        String str2 = Build.FINGERPRINT;
        if (!"robolectric".equals(str2)) {
            str = str2;
            jVar3.c(new f(lVar, 1), ParcelFileDescriptor.class, Bitmap.class, "Bitmap");
        } else {
            str = str2;
        }
        jVar3.c(xVar, ParcelFileDescriptor.class, Bitmap.class, "Bitmap");
        jVar3.c(new x(dVar, new x.c()), AssetFileDescriptor.class, Bitmap.class, "Bitmap");
        u.a<?> aVar6 = u.a.f6255a;
        jVar3.a(Bitmap.class, Bitmap.class, aVar6);
        jVar3.c(new w(), Bitmap.class, Bitmap.class, "Bitmap");
        jVar3.b(Bitmap.class, bVar4);
        jVar3.c(new y2.a(resources, jVar), ByteBuffer.class, BitmapDrawable.class, "BitmapDrawable");
        jVar3.c(new y2.a(resources, jVar2), InputStream.class, BitmapDrawable.class, "BitmapDrawable");
        jVar3.c(new y2.a(resources, xVar), ParcelFileDescriptor.class, BitmapDrawable.class, "BitmapDrawable");
        jVar3.b(BitmapDrawable.class, new androidx.appcompat.widget.l(dVar, bVar4));
        jVar3.c(new c3.i(d7, aVar, bVar2), InputStream.class, c.class, "Animation");
        jVar3.c(aVar, ByteBuffer.class, c.class, "Animation");
        jVar3.b(c.class, new i(4));
        jVar3.a(o2.a.class, o2.a.class, aVar6);
        jVar3.c(new c3.g(dVar), o2.a.class, Bitmap.class, "Bitmap");
        jVar3.c(eVar, Uri.class, Drawable.class, "legacy_append");
        jVar3.c(new y2.a(eVar, dVar), Uri.class, Bitmap.class, "legacy_append");
        jVar3.g(new a.C0138a());
        jVar3.a(File.class, ByteBuffer.class, new c.b());
        jVar3.a(File.class, InputStream.class, new e.C0120e());
        jVar3.c(new b3.a(), File.class, File.class, "legacy_append");
        jVar3.a(File.class, ParcelFileDescriptor.class, new e.b());
        jVar3.a(File.class, File.class, aVar6);
        jVar3.g(new k.a(bVar2));
        if (!"robolectric".equals(str)) {
            jVar3.g(new ParcelFileDescriptorRewinder.a());
        }
        Class cls = Integer.TYPE;
        jVar3.a(cls, InputStream.class, cVar);
        jVar3.a(cls, ParcelFileDescriptor.class, bVar3);
        jVar3.a(Integer.class, InputStream.class, cVar);
        jVar3.a(Integer.class, ParcelFileDescriptor.class, bVar3);
        jVar3.a(Integer.class, Uri.class, dVar2);
        jVar3.a(cls, AssetFileDescriptor.class, aVar2);
        jVar3.a(Integer.class, AssetFileDescriptor.class, aVar2);
        jVar3.a(cls, Uri.class, dVar2);
        jVar3.a(String.class, InputStream.class, new d.c());
        jVar3.a(Uri.class, InputStream.class, new d.c());
        jVar3.a(String.class, InputStream.class, new t.c());
        jVar3.a(String.class, ParcelFileDescriptor.class, new t.b());
        jVar3.a(String.class, AssetFileDescriptor.class, new t.a());
        jVar3.a(Uri.class, InputStream.class, new a.c(applicationContext.getAssets()));
        jVar3.a(Uri.class, AssetFileDescriptor.class, new a.b(applicationContext.getAssets()));
        jVar3.a(Uri.class, InputStream.class, new b.a(applicationContext));
        jVar3.a(Uri.class, InputStream.class, new c.a(applicationContext));
        jVar3.a(Uri.class, InputStream.class, new d.c(applicationContext));
        jVar3.a(Uri.class, ParcelFileDescriptor.class, new d.b(applicationContext));
        jVar3.a(Uri.class, InputStream.class, new v.d(contentResolver));
        jVar3.a(Uri.class, ParcelFileDescriptor.class, new v.b(contentResolver));
        jVar3.a(Uri.class, AssetFileDescriptor.class, new v.a(contentResolver));
        jVar3.a(Uri.class, InputStream.class, new w.a());
        jVar3.a(URL.class, InputStream.class, new e.a());
        jVar3.a(Uri.class, File.class, new j.a(applicationContext));
        jVar3.a(v2.f.class, InputStream.class, new a.C0128a());
        jVar3.a(byte[].class, ByteBuffer.class, new b.a());
        jVar3.a(byte[].class, InputStream.class, new b.d());
        jVar3.a(Uri.class, Uri.class, aVar6);
        jVar3.a(Drawable.class, Drawable.class, aVar6);
        jVar3.c(new a3.f(), Drawable.class, Drawable.class, "legacy_append");
        jVar3.h(Bitmap.class, BitmapDrawable.class, new f.t(resources));
        jVar3.h(Bitmap.class, byte[].class, aVar3);
        jVar3.h(Drawable.class, byte[].class, new e0(dVar, aVar3, a0Var3));
        jVar3.h(c3.c.class, byte[].class, a0Var3);
        x xVar2 = new x(dVar, new x.d());
        jVar3.c(xVar2, ByteBuffer.class, Bitmap.class, "legacy_append");
        jVar3.c(new y2.a(resources, xVar2), ByteBuffer.class, BitmapDrawable.class, "legacy_append");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e3.c cVar2 = (e3.c) it.next();
            try {
                cVar2.b();
            } catch (AbstractMethodError e) {
                StringBuilder d8 = h.d("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                d8.append(cVar2.getClass().getName());
                throw new IllegalStateException(d8.toString(), e);
            }
        }
        return jVar3;
    }
}
