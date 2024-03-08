package com.bumptech.glide;

import com.bumptech.glide.o;
import i3.a;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class o<CHILD extends o<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public a.C0068a f2750f = a.f4476a;

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) ((o) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof o) {
            return l.b(this.f2750f, ((o) obj).f2750f);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        a.C0068a aVar = this.f2750f;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }
}
