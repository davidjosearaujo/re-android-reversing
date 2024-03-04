package d;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import d.a;
import g5.j;
import g5.q;
import g5.t;
import g5.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import r5.h;

/* loaded from: classes.dex */
public final class b extends a<String[], Map<String, Boolean>> {
    @Override // d.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        h.f(componentActivity, "context");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) obj);
        h.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    @Override // d.a
    public final a.C0043a b(ComponentActivity componentActivity, Object obj) {
        String[] strArr = (String[]) obj;
        h.f(componentActivity, "context");
        boolean z6 = true;
        if (strArr.length == 0) {
            return new a.C0043a(q.f4285f);
        }
        int length = strArr.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                break;
            }
            if (!(g1.a.a(componentActivity, strArr[i7]) == 0)) {
                z6 = false;
                break;
            }
            i7++;
        }
        if (z6) {
            int V = t.V(strArr.length);
            if (V < 16) {
                V = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(V);
            for (String str : strArr) {
                linkedHashMap.put(str, Boolean.TRUE);
            }
            return new a.C0043a(linkedHashMap);
        }
        return null;
    }

    @Override // d.a
    public final Object c(Intent intent, int i7) {
        if (i7 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i8 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i8 == 0));
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str : stringArrayExtra) {
                    if (str != null) {
                        arrayList2.add(str);
                    }
                }
                Iterator it = arrayList2.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList3 = new ArrayList(Math.min(j.V(arrayList2), j.V(arrayList)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList3.add(new f5.c(it.next(), it2.next()));
                }
                return u.X(arrayList3);
            }
        }
        return q.f4285f;
    }
}
