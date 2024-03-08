package androidx.compose.ui.platform;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import u.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u.a f1236a;

    public r(b bVar) {
        this.f1236a = bVar;
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        Map<String, List<Object>> a7 = this.f1236a.a();
        Bundle bundle = new Bundle();
        for (Map.Entry<String, List<Object>> entry : a7.entrySet()) {
            String key = entry.getKey();
            List<Object> value = entry.getValue();
            bundle.putParcelableArrayList(key, value instanceof ArrayList ? (ArrayList) value : new ArrayList<>(value));
        }
        return bundle;
    }
}
