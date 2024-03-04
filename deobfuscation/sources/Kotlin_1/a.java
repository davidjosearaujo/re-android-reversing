package Kotlin_1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: j5.a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f */
    public static final a f4591f;

    /* renamed from: g */
    public static final /* synthetic */ a[] f4592g;

    static {
        a aVar = new a("COROUTINE_SUSPENDED", 0);
        f4591f = aVar;
        a[] aVarArr = {aVar, new a("UNDECIDED", 1), new a("RESUMED", 2)};
        f4592g = aVarArr;
        new l5.a(aVarArr);
    }

    public a(String str, int i7) {
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f4592g.clone();
    }
}
