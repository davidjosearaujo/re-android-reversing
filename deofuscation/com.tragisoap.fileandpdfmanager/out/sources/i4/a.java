package i4;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.davemorrissey.labs.subscaleview.R;
import e5.g;
import e5.k;
import e5.p;
import e5.v;
import java.util.HashMap;
import java.util.List;
import o4.f;
import o4.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ int f4477f;

    /* renamed from: g */
    public final /* synthetic */ Object f4478g;

    public /* synthetic */ a(int i7, Object obj) {
        this.f4477f = i7;
        this.f4478g = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4477f) {
            case 1:
                f fVar = (f) this.f4478g;
                EditText editText = fVar.f5344i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    fVar.q();
                    return;
                }
                return;
            case 2:
                ((l) this.f4478g).u();
                return;
            case 3:
                List<HashMap<String, String>> list = g.f3796i;
                ((g.a) this.f4478g).A.performClick();
                return;
            case 4:
                ((k.a) this.f4478g).C.performClick();
                return;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                ((p.a) this.f4478g).D.performClick();
                return;
            case 6:
                ((v.a) this.f4478g).D.performClick();
                return;
            default:
                int i7 = j6.a.f4599s0;
                ((j6.a) this.f4478g).getClass();
                throw null;
        }
    }
}
