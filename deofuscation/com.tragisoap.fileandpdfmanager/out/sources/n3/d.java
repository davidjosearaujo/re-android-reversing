package n3;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends Property<Drawable, Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5167a = new d();

    public d() {
        super(Integer.class, "drawableAlphaCompat");
        new WeakHashMap();
    }

    @Override // android.util.Property
    public final Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public final void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
