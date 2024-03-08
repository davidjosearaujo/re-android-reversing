package v3;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.a;
import linc.com.amplituda.ErrorCode;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f6265a;

    public b(Chip chip) {
        this.f6265a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(ErrorCode.FILE_NOT_FOUND_IO_CODE)
    public final void getOutline(View view, Outline outline) {
        a aVar = this.f6265a.f2991j;
        if (aVar != null) {
            aVar.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
