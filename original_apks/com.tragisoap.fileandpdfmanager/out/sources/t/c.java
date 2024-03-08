package t;

import p.f;
import p.h;
import p.o0;
import r.b;
import r.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends b<f<Object>, o0<? extends Object>> implements h {

    /* renamed from: h  reason: collision with root package name */
    public static final c f5993h;

    static {
        i iVar = i.f5682d;
        r5.h.d(iVar, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>");
        f5993h = new c(iVar, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(i<f<Object>, o0<Object>> iVar, int i7) {
        super(iVar, i7);
        r5.h.f(iVar, "node");
    }

    @Override // r.b, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return super.containsKey((f) obj);
    }

    @Override // g5.d, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        return super.containsValue((o0) obj);
    }

    @Override // r.b, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (!(obj instanceof f)) {
            return null;
        }
        return (o0) super.get((f) obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof f) ? obj2 : (o0) super.getOrDefault((f) obj, (o0) obj2);
    }
}
