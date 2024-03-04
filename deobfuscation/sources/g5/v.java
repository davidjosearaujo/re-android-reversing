package g5;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: f */
    public static final v f4287f;

    /* renamed from: g */
    public static final v f4288g;

    /* renamed from: h */
    public static final v f4289h;

    /* renamed from: i */
    public static final v f4290i;

    /* renamed from: j */
    public static final /* synthetic */ v[] f4291j;

    static {
        v vVar = new v("Ready", 0);
        f4287f = vVar;
        v vVar2 = new v("NotReady", 1);
        f4288g = vVar2;
        v vVar3 = new v("Done", 2);
        f4289h = vVar3;
        v vVar4 = new v("Failed", 3);
        f4290i = vVar4;
        v[] vVarArr = {vVar, vVar2, vVar3, vVar4};
        f4291j = vVarArr;
        new l5.a(vVarArr);
    }

    public v(String str, int i7) {
        super(str, i7);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f4291j.clone();
    }
}
