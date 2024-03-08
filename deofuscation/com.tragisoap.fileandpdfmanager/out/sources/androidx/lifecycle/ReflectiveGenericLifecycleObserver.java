package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.g;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ReflectiveGenericLifecycleObserver implements l {

    /* renamed from: f  reason: collision with root package name */
    public final Object f1836f;

    /* renamed from: g  reason: collision with root package name */
    public final a.C0017a f1837g;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1836f = obj;
        this.f1837g = a.f1841c.b(obj.getClass());
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        a.C0017a aVar2 = this.f1837g;
        Object obj = this.f1836f;
        a.C0017a.a((List) aVar2.f1844a.get(aVar), nVar, aVar, obj);
        a.C0017a.a((List) aVar2.f1844a.get(g.a.ON_ANY), nVar, aVar, obj);
    }
}
