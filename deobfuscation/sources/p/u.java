package p;

/* loaded from: classes.dex */
public interface u extends o0, v<Float> {
    @Override // p.o0
    default Float getValue() {
        return Float.valueOf(n());
    }

    void j(float f7);

    float n();

    default void o(float f7) {
        j(f7);
    }

    @Override // p.v
    /* bridge */ /* synthetic */ default void setValue(Float f7) {
        o(f7.floatValue());
    }
}
