package p1;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f5535f;

    public /* synthetic */ t(View view) {
        this.f5535f = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f5535f;
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }
}
