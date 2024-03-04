package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.inputmethod.EditorInfo;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: i */
    public static final Object f1508i = new Object();

    /* renamed from: j */
    public static volatile f f1509j;

    /* renamed from: a */
    public final ReentrantReadWriteLock f1510a;

    /* renamed from: b */
    public final o.d f1511b;

    /* renamed from: c */
    public volatile int f1512c;

    /* renamed from: d */
    public final Handler f1513d;
    public final a e;

    /* renamed from: f */
    public final g f1514f;

    /* renamed from: g */
    public final int f1515g;

    /* renamed from: h */
    public final androidx.emoji2.text.d f1516h;

    /* loaded from: classes.dex */
    public static final class a extends b {

        /* renamed from: b */
        public volatile j f1517b;

        /* renamed from: c */
        public volatile n f1518c;

        public a(f fVar) {
            super(fVar);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final f f1519a;

        public b(f fVar) {
            this.f1519a = fVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a */
        public final g f1520a;

        /* renamed from: b */
        public int f1521b = 0;

        /* renamed from: c */
        public androidx.emoji2.text.d f1522c = new androidx.emoji2.text.d();

        public c(g gVar) {
            this.f1520a = gVar;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public void a() {
        }
    }

    /* renamed from: androidx.emoji2.text.f$f */
    /* loaded from: classes.dex */
    public static class RunnableC0016f implements Runnable {

        /* renamed from: f */
        public final ArrayList f1523f;

        /* renamed from: g */
        public final int f1524g;

        public RunnableC0016f(List list, int i7, Throwable th) {
            if (list == null) {
                throw new NullPointerException("initCallbacks cannot be null");
            }
            this.f1523f = new ArrayList(list);
            this.f1524g = i7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int size = this.f1523f.size();
            int i7 = 0;
            if (this.f1524g != 1) {
                while (i7 < size) {
                    ((e) this.f1523f.get(i7)).getClass();
                    i7++;
                }
                return;
            }
            while (i7 < size) {
                ((e) this.f1523f.get(i7)).a();
                i7++;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(h hVar);
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(n nVar);
    }

    /* loaded from: classes.dex */
    public static class i {
    }

    public f(EmojiCompatInitializer.a aVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f1510a = reentrantReadWriteLock;
        this.f1512c = 3;
        g gVar = aVar.f1520a;
        this.f1514f = gVar;
        int i7 = aVar.f1521b;
        this.f1515g = i7;
        this.f1516h = aVar.f1522c;
        this.f1513d = new Handler(Looper.getMainLooper());
        this.f1511b = new o.d();
        a aVar2 = new a(this);
        this.e = aVar2;
        reentrantReadWriteLock.writeLock().lock();
        if (i7 == 0) {
            try {
                this.f1512c = 0;
            } catch (Throwable th) {
                this.f1510a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                gVar.a(new androidx.emoji2.text.e(aVar2));
            } catch (Throwable th2) {
                aVar2.f1519a.d(th2);
            }
        }
    }

    public static f a() {
        f fVar;
        synchronized (f1508i) {
            fVar = f1509j;
            if (!(fVar != null)) {
                throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            }
        }
        return fVar;
    }

    public final int b() {
        this.f1510a.readLock().lock();
        try {
            return this.f1512c;
        } finally {
            this.f1510a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f1515g == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f1510a.writeLock().lock();
        try {
            if (this.f1512c == 0) {
                return;
            }
            this.f1512c = 0;
            this.f1510a.writeLock().unlock();
            a aVar = this.e;
            aVar.getClass();
            try {
                aVar.f1519a.f1514f.a(new androidx.emoji2.text.e(aVar));
            } catch (Throwable th) {
                aVar.f1519a.d(th);
            }
        } finally {
            this.f1510a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1510a.writeLock().lock();
        try {
            this.f1512c = 2;
            arrayList.addAll(this.f1511b);
            this.f1511b.clear();
            this.f1510a.writeLock().unlock();
            this.f1513d.post(new RunnableC0016f(arrayList, this.f1512c, th));
        } catch (Throwable th2) {
            this.f1510a.writeLock().unlock();
            throw th2;
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f1510a.writeLock().lock();
        try {
            this.f1512c = 1;
            arrayList.addAll(this.f1511b);
            this.f1511b.clear();
            this.f1510a.writeLock().unlock();
            this.f1513d.post(new RunnableC0016f(arrayList, this.f1512c, null));
        } catch (Throwable th) {
            this.f1510a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:464:0x0091 A[Catch: all -> 0x0178, TryCatch #0 {all -> 0x0178, blocks: (B:448:0x0058, B:451:0x005d, B:453:0x0061, B:455:0x0070, B:458:0x0080, B:460:0x008a, B:462:0x008d, B:464:0x0091, B:466:0x009d, B:467:0x00a0, B:469:0x00ad, B:472:0x00b5, B:477:0x00cf, B:483:0x00db, B:486:0x00e7, B:487:0x00f1, B:489:0x0106, B:491:0x010d, B:492:0x0112, B:494:0x011d, B:496:0x0123, B:498:0x0127, B:500:0x012d, B:502:0x0131, B:507:0x013c, B:510:0x0148, B:511:0x014e, B:513:0x0161, B:456:0x0076), top: B:533:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0148 A[Catch: all -> 0x0178, TryCatch #0 {all -> 0x0178, blocks: (B:448:0x0058, B:451:0x005d, B:453:0x0061, B:455:0x0070, B:458:0x0080, B:460:0x008a, B:462:0x008d, B:464:0x0091, B:466:0x009d, B:467:0x00a0, B:469:0x00ad, B:472:0x00b5, B:477:0x00cf, B:483:0x00db, B:486:0x00e7, B:487:0x00f1, B:489:0x0106, B:491:0x010d, B:492:0x0112, B:494:0x011d, B:496:0x0123, B:498:0x0127, B:500:0x012d, B:502:0x0131, B:507:0x013c, B:510:0x0148, B:511:0x014e, B:513:0x0161, B:456:0x0076), top: B:533:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0161 A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #0 {all -> 0x0178, blocks: (B:448:0x0058, B:451:0x005d, B:453:0x0061, B:455:0x0070, B:458:0x0080, B:460:0x008a, B:462:0x008d, B:464:0x0091, B:466:0x009d, B:467:0x00a0, B:469:0x00ad, B:472:0x00b5, B:477:0x00cf, B:483:0x00db, B:486:0x00e7, B:487:0x00f1, B:489:0x0106, B:491:0x010d, B:492:0x0112, B:494:0x011d, B:496:0x0123, B:498:0x0127, B:500:0x012d, B:502:0x0131, B:507:0x013c, B:510:0x0148, B:511:0x014e, B:513:0x0161, B:456:0x0076), top: B:533:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:517:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:547:0x00d5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.CharSequence f(int r13, int r14, java.lang.CharSequence r15) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.f.f(int, int, java.lang.CharSequence):java.lang.CharSequence");
    }

    public final void g(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("initCallback cannot be null");
        }
        this.f1510a.writeLock().lock();
        try {
            if (this.f1512c != 1 && this.f1512c != 2) {
                this.f1511b.add(eVar);
            }
            this.f1513d.post(new RunnableC0016f(Arrays.asList(eVar), this.f1512c, null));
        } finally {
            this.f1510a.writeLock().unlock();
        }
    }

    public final void h(EditorInfo editorInfo) {
        if (!(b() == 1) || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        a aVar = this.e;
        aVar.getClass();
        Bundle bundle = editorInfo.extras;
        y1.b bVar = aVar.f1518c.f1554a;
        int a7 = bVar.a(4);
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", a7 != 0 ? bVar.f6593b.getInt(a7 + bVar.f6592a) : 0);
        Bundle bundle2 = editorInfo.extras;
        aVar.f1519a.getClass();
        bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }
}
