package n3;

import android.util.Property;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class c extends Property<ViewGroup, Float> {

    /* renamed from: a */
    public static final c f5166a = new c();

    public c() {
        super(Float.class, "childrenAlpha");
    }

    @Override // android.util.Property
    public final Float get(ViewGroup viewGroup) {
        Float f7 = (Float) viewGroup.getTag(2131296640);
        return f7 != null ? f7 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public final void set(ViewGroup viewGroup, Float f7) {
        ViewGroup viewGroup2 = viewGroup;
        float floatValue = f7.floatValue();
        viewGroup2.setTag(2131296640, Float.valueOf(floatValue));
        int childCount = viewGroup2.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            viewGroup2.getChildAt(i7).setAlpha(floatValue);
        }
    }
}
