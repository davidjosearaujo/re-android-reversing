package p5;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import g5.v;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import r5.h;
import y5.d;

/* loaded from: classes.dex */
public final class a implements d<File> {

    /* renamed from: a */
    public final File f5573a;

    /* renamed from: b */
    public final p5.b f5574b;

    /* renamed from: c */
    public final int f5575c;

    /* renamed from: p5.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0094a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AbstractC0094a(File file) {
            super(file);
            h.f(file, "rootDir");
        }
    }

    /* loaded from: classes.dex */
    public final class b extends g5.b<File> {

        /* renamed from: h */
        public final ArrayDeque<c> f5576h;

        /* renamed from: p5.a$b$a */
        /* loaded from: classes.dex */
        public final class C0095a extends AbstractC0094a {

            /* renamed from: b */
            public boolean f5578b;

            /* renamed from: c */
            public File[] f5579c;

            /* renamed from: d */
            public int f5580d;
            public boolean e;

            /* renamed from: f */
            public final /* synthetic */ b f5581f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0095a(b bVar, File file) {
                super(file);
                h.f(file, "rootDir");
                this.f5581f = bVar;
            }

            @Override // p5.a.c
            public final File a() {
                if (!this.e && this.f5579c == null) {
                    a.this.getClass();
                    File[] listFiles = this.f5586a.listFiles();
                    this.f5579c = listFiles;
                    if (listFiles == null) {
                        a.this.getClass();
                        this.e = true;
                    }
                }
                File[] fileArr = this.f5579c;
                if (fileArr != null) {
                    int i7 = this.f5580d;
                    h.c(fileArr);
                    if (i7 < fileArr.length) {
                        File[] fileArr2 = this.f5579c;
                        h.c(fileArr2);
                        int i8 = this.f5580d;
                        this.f5580d = i8 + 1;
                        return fileArr2[i8];
                    }
                }
                if (this.f5578b) {
                    a.this.getClass();
                    return null;
                }
                this.f5578b = true;
                return this.f5586a;
            }
        }

        /* renamed from: p5.a$b$b */
        /* loaded from: classes.dex */
        public final class C0096b extends c {

            /* renamed from: b */
            public boolean f5582b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0096b(File file) {
                super(file);
                h.f(file, "rootFile");
            }

            @Override // p5.a.c
            public final File a() {
                if (this.f5582b) {
                    return null;
                }
                this.f5582b = true;
                return this.f5586a;
            }
        }

        /* loaded from: classes.dex */
        public final class c extends AbstractC0094a {

            /* renamed from: b */
            public boolean f5583b;

            /* renamed from: c */
            public File[] f5584c;

            /* renamed from: d */
            public int f5585d;
            public final /* synthetic */ b e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, File file) {
                super(file);
                h.f(file, "rootDir");
                this.e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:47:0x0044, code lost:
                if (r0.length == 0) goto L21;
             */
            @Override // p5.a.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.io.File a() {
                /*
                    r3 = this;
                    boolean r0 = r3.f5583b
                    if (r0 != 0) goto L11
                    p5.a$b r0 = r3.e
                    p5.a r0 = p5.a.this
                    r0.getClass()
                    r0 = 1
                    r3.f5583b = r0
                    java.io.File r3 = r3.f5586a
                    return r3
                L11:
                    java.io.File[] r0 = r3.f5584c
                    r1 = 0
                    if (r0 == 0) goto L27
                    int r2 = r3.f5585d
                    r5.h.c(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L1f
                    goto L27
                L1f:
                    p5.a$b r3 = r3.e
                    p5.a r3 = p5.a.this
                    r3.getClass()
                    return r1
                L27:
                    java.io.File[] r0 = r3.f5584c
                    if (r0 != 0) goto L4e
                    java.io.File r0 = r3.f5586a
                    java.io.File[] r0 = r0.listFiles()
                    r3.f5584c = r0
                    if (r0 != 0) goto L3c
                    p5.a$b r0 = r3.e
                    p5.a r0 = p5.a.this
                    r0.getClass()
                L3c:
                    java.io.File[] r0 = r3.f5584c
                    if (r0 == 0) goto L46
                    r5.h.c(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L4e
                L46:
                    p5.a$b r3 = r3.e
                    p5.a r3 = p5.a.this
                    r3.getClass()
                    return r1
                L4e:
                    java.io.File[] r0 = r3.f5584c
                    r5.h.c(r0)
                    int r1 = r3.f5585d
                    int r2 = r1 + 1
                    r3.f5585d = r2
                    r3 = r0[r1]
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: p5.a.b.c.a():java.io.File");
            }
        }

        public b() {
            c c0096b;
            a.this = r3;
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f5576h = arrayDeque;
            if (r3.f5573a.isDirectory()) {
                c0096b = a(r3.f5573a);
            } else if (!r3.f5573a.isFile()) {
                this.f4268f = v.f4289h;
                return;
            } else {
                c0096b = new C0096b(r3.f5573a);
            }
            arrayDeque.push(c0096b);
        }

        public final AbstractC0094a a(File file) {
            int ordinal = a.this.f5574b.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    return new C0095a(this, file);
                }
                throw new f5.b();
            }
            return new c(this, file);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a */
        public final File f5586a;

        public c(File file) {
            h.f(file, "root");
            this.f5586a = file;
        }

        public abstract File a();
    }

    public a(File file) {
        p5.b bVar = p5.b.f5587f;
        this.f5573a = file;
        this.f5574b = bVar;
        this.f5575c = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    @Override // y5.d
    public final Iterator<File> iterator() {
        return new b();
    }
}
