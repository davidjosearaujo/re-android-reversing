package s2;

import android.graphics.Bitmap;
import androidx.activity.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m implements k {

    /* renamed from: d  reason: collision with root package name */
    public static final Bitmap.Config[] f5957d;
    public static final Bitmap.Config[] e;

    /* renamed from: f  reason: collision with root package name */
    public static final Bitmap.Config[] f5958f = {Bitmap.Config.RGB_565};

    /* renamed from: g  reason: collision with root package name */
    public static final Bitmap.Config[] f5959g = {Bitmap.Config.ARGB_4444};

    /* renamed from: h  reason: collision with root package name */
    public static final Bitmap.Config[] f5960h = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    public final c f5961a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final g<b, Bitmap> f5962b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f5963c = new HashMap();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5964a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f5964a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5964a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5964a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5964a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b implements l {

        /* renamed from: a  reason: collision with root package name */
        public final c f5965a;

        /* renamed from: b  reason: collision with root package name */
        public int f5966b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap.Config f5967c;

        public b(c cVar) {
            this.f5965a = cVar;
        }

        @Override // s2.l
        public final void a() {
            this.f5965a.c(this);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f5966b == bVar.f5966b && l.b(this.f5967c, bVar.f5967c);
        }

        public final int hashCode() {
            int i7 = this.f5966b * 31;
            Bitmap.Config config = this.f5967c;
            return i7 + (config != null ? config.hashCode() : 0);
        }

        public final String toString() {
            return m.c(this.f5966b, this.f5967c);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends c<b> {
        @Override // s2.c
        public final b a() {
            return new b(this);
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        f5957d = configArr;
        e = configArr;
    }

    public static String c(int i7, Bitmap.Config config) {
        return "[" + i7 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> d7 = d(bitmap.getConfig());
        Integer num2 = d7.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            d7.remove(num);
        } else {
            d7.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public final Bitmap b(int i7, int i8, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int d7 = l.d(config) * i7 * i8;
        b b2 = this.f5961a.b();
        b2.f5966b = d7;
        b2.f5967c = config;
        int i9 = 0;
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            configArr = e;
        } else {
            int i10 = a.f5964a[config.ordinal()];
            configArr = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new Bitmap.Config[]{config} : f5960h : f5959g : f5958f : f5957d;
        }
        int length = configArr.length;
        while (true) {
            if (i9 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i9];
            Integer ceilingKey = d(config2).ceilingKey(Integer.valueOf(d7));
            if (ceilingKey == null || ceilingKey.intValue() > d7 * 8) {
                i9++;
            } else if (ceilingKey.intValue() != d7 || (config2 != null ? !config2.equals(config) : config != null)) {
                this.f5961a.c(b2);
                c cVar = this.f5961a;
                int intValue = ceilingKey.intValue();
                b2 = cVar.b();
                b2.f5966b = intValue;
                b2.f5967c = config2;
            }
        }
        Bitmap a7 = this.f5962b.a(b2);
        if (a7 != null) {
            a(Integer.valueOf(b2.f5966b), a7);
            a7.reconfigure(i7, i8, config);
        }
        return a7;
    }

    public final NavigableMap<Integer, Integer> d(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f5963c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5963c.put(config, treeMap);
        return treeMap;
    }

    public final String e(Bitmap bitmap) {
        return c(l.c(bitmap), bitmap.getConfig());
    }

    public final void f(Bitmap bitmap) {
        int c7 = l.c(bitmap);
        c cVar = this.f5961a;
        Bitmap.Config config = bitmap.getConfig();
        b b2 = cVar.b();
        b2.f5966b = c7;
        b2.f5967c = config;
        this.f5962b.b(b2, bitmap);
        NavigableMap<Integer, Integer> d7 = d(bitmap.getConfig());
        Integer num = d7.get(Integer.valueOf(b2.f5966b));
        Integer valueOf = Integer.valueOf(b2.f5966b);
        int i7 = 1;
        if (num != null) {
            i7 = 1 + num.intValue();
        }
        d7.put(valueOf, Integer.valueOf(i7));
    }

    public final String toString() {
        StringBuilder d7 = h.d("SizeConfigStrategy{groupedMap=");
        d7.append(this.f5962b);
        d7.append(", sortedSizes=(");
        for (Map.Entry entry : this.f5963c.entrySet()) {
            d7.append(entry.getKey());
            d7.append('[');
            d7.append(entry.getValue());
            d7.append("], ");
        }
        if (!this.f5963c.isEmpty()) {
            d7.replace(d7.length() - 2, d7.length(), "");
        }
        d7.append(")}");
        return d7.toString();
    }
}
