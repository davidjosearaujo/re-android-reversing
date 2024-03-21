package b.a.a.a.e;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class d extends b {
    private static short[] $ = {6372, 6367, 6339, 6356, 6358, 6360, 6338, 6341, 6356, 6339, 6397, 6360, 6338, 6341, 6356, 6367, 6356, 6339, 6373, 6352, 6338, 6362, 1252, 1235, 1237, 1235, 1247, 1216, 1235, 1234, 1174, 1237, 1239, 1242, 1242, 1174, 1218, 1241, 1174, 1219, 1240, 1220, 1235, 1233, 1247, 1221, 1218, 1235, 1220, 1174, 1239, 1174, 1242, 1247, 1221, 1218, 1235, 1240, 1235, 1220, 1174, 1217, 1247, 1218, 1246, 1241, 1219, 1218, 1174, 1239, 1174, 1243, 1239, 1218, 1237, 1246, 1247, 1240, 1233, 1174, 1220, 1235, 1233, 1247, 1221, 1218, 1220, 1239, 1218, 1247, 1241, 1240, 1174, 1237, 1239, 1242, 1242, 1176};

    /* renamed from: b  reason: collision with root package name */
    private c0<?> f142b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public d(c0<?> c0Var, b.a.a.a.g.d<Void> dVar) {
        super(4, dVar);
        this.f142b = c0Var;
    }

    @Override // b.a.a.a.e.a
    public final /* bridge */ /* synthetic */ void b(p pVar, boolean z) {
    }

    @Override // b.a.a.a.e.b
    public final void f(v<?> vVar) {
        f0 remove = vVar.u().remove(this.f142b);
        if (remove == null) {
            Log.wtf($(0, 22, 6321), $(22, 98, 1206), new Exception());
            this.f137a.d(new b(Status.g));
            return;
        }
        remove.f150b.a(vVar.q(), this.f137a);
        remove.f149a.b();
        throw null;
    }
}
