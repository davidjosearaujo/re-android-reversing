package com.bumptech.glide;

import com.bumptech.glide.o;
import i3.a;

/* loaded from: classes.dex */
public abstract class o<CHILD extends o<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: f */
    public a.C0068a f2750f = i3.a.f4476a;

    /* renamed from: a */
    public final CHILD m0clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            return k3.l.b(this.f2750f, ((o) obj).f2750f);
        }
        return false;
    }

    public int hashCode() {
        a.C0068a c0068a = this.f2750f;
        if (c0068a != null) {
            return c0068a.hashCode();
        }
        return 0;
    }
}
