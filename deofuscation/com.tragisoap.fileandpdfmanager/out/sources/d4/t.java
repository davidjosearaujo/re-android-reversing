package d4;

import android.annotation.SuppressLint;
import android.widget.ImageButton;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class t extends ImageButton {

    /* renamed from: f  reason: collision with root package name */
    public int f3640f;

    public final void b(int i7, boolean z6) {
        super.setVisibility(i7);
        if (z6) {
            this.f3640f = i7;
        }
    }

    public final int getUserSetVisibility() {
        return this.f3640f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i7) {
        b(i7, true);
    }
}
