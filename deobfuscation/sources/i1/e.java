package i1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.os.ParcelFileDescriptor;
import h1.f;
import java.io.IOException;
import m1.m;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public static final f f4469a = new f();

    /* renamed from: b */
    public static final o.f<String, Typeface> f4470b = new o.f<>(16);

    /* loaded from: classes.dex */
    public static class a extends a0.e {

        /* renamed from: j0 */
        public f.e f4471j0;

        public a(f.e eVar) {
            this.f4471j0 = eVar;
        }
    }

    public static Typeface a(Context context, m[] mVarArr, int i7) {
        ParcelFileDescriptor openFileDescriptor;
        f4469a.getClass();
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (m mVar : mVarArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(mVar.f5068a, "r", null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(mVar.f5070c).setSlant(mVar.f5071d ? 1 : 0).setTtcIndex(mVar.f5069b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                } else if (openFileDescriptor == null) {
                }
                openFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(f.a(build2, i7).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:369:0x002b, code lost:
        if (r4.equals(r9) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface b(android.content.Context r14, h1.d.b r15, android.content.res.Resources r16, int r17, java.lang.String r18, int r19, int r20, h1.f.e r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.e.b(android.content.Context, h1.d$b, android.content.res.Resources, int, java.lang.String, int, int, h1.f$e, boolean):android.graphics.Typeface");
    }

    public static Typeface c(Resources resources, int i7, String str, int i8, int i9) {
        Typeface typeface;
        f4469a.getClass();
        try {
            Font build = new Font.Builder(resources, i7).build();
            typeface = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            typeface = null;
        }
        if (typeface != null) {
            f4470b.b(d(resources, i7, str, i8, i9), typeface);
        }
        return typeface;
    }

    public static String d(Resources resources, int i7, String str, int i8, int i9) {
        return resources.getResourcePackageName(i7) + '-' + str + '-' + i8 + '-' + i7 + '-' + i9;
    }
}
