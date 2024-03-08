package x4;

import l5.a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends Enum<b> {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ b[] f6470g;

    /* renamed from: f  reason: collision with root package name */
    public final int f6471f;

    static {
        b[] bVarArr = {new b(0, 100, "INTERNAL"), new b(1, 200, "GOOGLE")};
        f6470g = bVarArr;
        new a(bVarArr);
    }

    public b(int i7, int i8, String str) {
        this.f6471f = i8;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f6470g.clone();
    }
}
