package x4;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: g */
    public static final /* synthetic */ b[] f6470g;

    /* renamed from: f */
    public final int f6471f;

    static {
        b[] bVarArr = {new b(0, 100, "INTERNAL"), new b(1, 200, "GOOGLE")};
        f6470g = bVarArr;
        new l5.a(bVarArr);
    }

    public b(int i7, int i8, String str) {
        super(str, i7);
        this.f6471f = i8;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f6470g.clone();
    }
}
