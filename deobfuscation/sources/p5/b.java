package p5;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: f */
    public static final b f5587f;

    /* renamed from: g */
    public static final /* synthetic */ b[] f5588g;

    static {
        b bVar = new b("TOP_DOWN", 0);
        b bVar2 = new b("BOTTOM_UP", 1);
        f5587f = bVar2;
        b[] bVarArr = {bVar, bVar2};
        f5588g = bVarArr;
        new l5.a(bVarArr);
    }

    public b(String str, int i7) {
        super(str, i7);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f5588g.clone();
    }
}
