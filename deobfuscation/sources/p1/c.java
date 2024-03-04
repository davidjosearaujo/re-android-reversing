package p1;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public final e f5470a;

    /* loaded from: classes.dex */
    public static final class a implements b {

        /* renamed from: a */
        public final ContentInfo.Builder f5471a;

        public a(ClipData clipData, int i7) {
            this.f5471a = new ContentInfo.Builder(clipData, i7);
        }

        @Override // p1.c.b
        public final void a(Uri uri) {
            this.f5471a.setLinkUri(uri);
        }

        @Override // p1.c.b
        public final void b(int i7) {
            this.f5471a.setFlags(i7);
        }

        @Override // p1.c.b
        public final c build() {
            return new c(new d(this.f5471a.build()));
        }

        @Override // p1.c.b
        public final void setExtras(Bundle bundle) {
            this.f5471a.setExtras(bundle);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Uri uri);

        void b(int i7);

        c build();

        void setExtras(Bundle bundle);
    }

    /* renamed from: p1.c$c */
    /* loaded from: classes.dex */
    public static final class C0093c implements b {

        /* renamed from: a */
        public ClipData f5472a;

        /* renamed from: b */
        public int f5473b;

        /* renamed from: c */
        public int f5474c;

        /* renamed from: d */
        public Uri f5475d;
        public Bundle e;

        public C0093c(ClipData clipData, int i7) {
            this.f5472a = clipData;
            this.f5473b = i7;
        }

        @Override // p1.c.b
        public final void a(Uri uri) {
            this.f5475d = uri;
        }

        @Override // p1.c.b
        public final void b(int i7) {
            this.f5474c = i7;
        }

        @Override // p1.c.b
        public final c build() {
            return new c(new f(this));
        }

        @Override // p1.c.b
        public final void setExtras(Bundle bundle) {
            this.e = bundle;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements e {

        /* renamed from: a */
        public final ContentInfo f5476a;

        public d(ContentInfo contentInfo) {
            contentInfo.getClass();
            this.f5476a = contentInfo;
        }

        @Override // p1.c.e
        public final ClipData a() {
            return this.f5476a.getClip();
        }

        @Override // p1.c.e
        public final int b() {
            return this.f5476a.getFlags();
        }

        @Override // p1.c.e
        public final ContentInfo c() {
            return this.f5476a;
        }

        @Override // p1.c.e
        public final int d() {
            return this.f5476a.getSource();
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("ContentInfoCompat{");
            d7.append(this.f5476a);
            d7.append("}");
            return d7.toString();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        ClipData a();

        int b();

        ContentInfo c();

        int d();
    }

    /* loaded from: classes.dex */
    public static final class f implements e {

        /* renamed from: a */
        public final ClipData f5477a;

        /* renamed from: b */
        public final int f5478b;

        /* renamed from: c */
        public final int f5479c;

        /* renamed from: d */
        public final Uri f5480d;
        public final Bundle e;

        public f(C0093c c0093c) {
            ClipData clipData = c0093c.f5472a;
            clipData.getClass();
            this.f5477a = clipData;
            int i7 = c0093c.f5473b;
            if (i7 < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 5));
            }
            if (i7 > 5) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 5));
            }
            this.f5478b = i7;
            int i8 = c0093c.f5474c;
            if ((i8 & 1) == i8) {
                this.f5479c = i8;
                this.f5480d = c0093c.f5475d;
                this.e = c0093c.e;
                return;
            }
            StringBuilder d7 = androidx.activity.h.d("Requested flags 0x");
            d7.append(Integer.toHexString(i8));
            d7.append(", but only 0x");
            d7.append(Integer.toHexString(1));
            d7.append(" are allowed");
            throw new IllegalArgumentException(d7.toString());
        }

        @Override // p1.c.e
        public final ClipData a() {
            return this.f5477a;
        }

        @Override // p1.c.e
        public final int b() {
            return this.f5479c;
        }

        @Override // p1.c.e
        public final ContentInfo c() {
            return null;
        }

        @Override // p1.c.e
        public final int d() {
            return this.f5478b;
        }

        public final String toString() {
            String sb;
            StringBuilder d7 = androidx.activity.h.d("ContentInfoCompat{clip=");
            d7.append(this.f5477a.getDescription());
            d7.append(", source=");
            int i7 = this.f5478b;
            d7.append(i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? i7 != 5 ? String.valueOf(i7) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
            d7.append(", flags=");
            int i8 = this.f5479c;
            d7.append((i8 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i8));
            if (this.f5480d == null) {
                sb = "";
            } else {
                StringBuilder d8 = androidx.activity.h.d(", hasLinkUri(");
                d8.append(this.f5480d.toString().length());
                d8.append(")");
                sb = d8.toString();
            }
            d7.append(sb);
            return androidx.activity.h.c(d7, this.e != null ? ", hasExtras" : "", "}");
        }
    }

    public c(e eVar) {
        this.f5470a = eVar;
    }

    public final String toString() {
        return this.f5470a.toString();
    }
}
