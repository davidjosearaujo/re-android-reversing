package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.widget.z;
import j.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class y extends k0 {

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ z.g f1070o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ z f1071p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, View view, z.g gVar) {
        super(view);
        this.f1071p = zVar;
        this.f1070o = gVar;
    }

    @Override // androidx.appcompat.widget.k0
    public final f b() {
        return this.f1070o;
    }

    @Override // androidx.appcompat.widget.k0
    @SuppressLint({"SyntheticAccessor"})
    public final boolean c() {
        if (this.f1071p.getInternalPopup().b()) {
            return true;
        }
        z zVar = this.f1071p;
        zVar.f1082k.m(z.c.b(zVar), z.c.a(zVar));
        return true;
    }
}