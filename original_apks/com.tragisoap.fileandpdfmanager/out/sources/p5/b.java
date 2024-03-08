package p5;

import l5.a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends Enum<b> {

    /* renamed from: f  reason: collision with root package name */
    public static final b f5587f;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ b[] f5588g;

    static {
        b bVar = new b("TOP_DOWN", 0);
        b bVar2 = new b("BOTTOM_UP", 1);
        f5587f = bVar2;
        b[] bVarArr = {bVar, bVar2};
        f5588g = bVarArr;
        new a(bVarArr);
    }

    public b(String str, int i7) {
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f5588g.clone();
    }
}
