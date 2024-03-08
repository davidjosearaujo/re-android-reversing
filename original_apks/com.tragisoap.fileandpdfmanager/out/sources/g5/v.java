package g5;

import l5.a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v extends Enum<v> {

    /* renamed from: f  reason: collision with root package name */
    public static final v f4287f;

    /* renamed from: g  reason: collision with root package name */
    public static final v f4288g;

    /* renamed from: h  reason: collision with root package name */
    public static final v f4289h;

    /* renamed from: i  reason: collision with root package name */
    public static final v f4290i;

    /* renamed from: j  reason: collision with root package name */
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
        new a(vVarArr);
    }

    public v(String str, int i7) {
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f4291j.clone();
    }
}
