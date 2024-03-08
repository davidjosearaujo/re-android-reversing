package s1;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import c0.l;
import p1.c;
import p1.y;
import s1.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f5930a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InputConnection inputConnection, l lVar) {
        super(inputConnection, false);
        this.f5930a = lVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i7, Bundle bundle) {
        Bundle bundle2;
        b bVar = this.f5930a;
        c cVar = inputContentInfo == null ? null : new c(new c.a(inputContentInfo));
        View view = (View) ((l) bVar).f2486a;
        boolean z6 = false;
        if ((i7 & 1) != 0) {
            try {
                ((c.a) cVar.f5931a).b();
                Parcelable parcelable = (Parcelable) ((c.a) cVar.f5931a).a();
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
            }
        } else {
            bundle2 = bundle;
        }
        ClipData clipData = new ClipData(((c.a) cVar.f5931a).f5932a.getDescription(), new ClipData.Item(((c.a) cVar.f5931a).f5932a.getContentUri()));
        c.b aVar = Build.VERSION.SDK_INT >= 31 ? new c.a(clipData, 2) : new c.C0093c(clipData, 2);
        aVar.a(((c.a) cVar.f5931a).f5932a.getLinkUri());
        aVar.setExtras(bundle2);
        if (y.f(view, aVar.build()) == null) {
            z6 = true;
        }
        if (z6) {
            return true;
        }
        return super.commitContent(inputContentInfo, i7, bundle);
    }
}
