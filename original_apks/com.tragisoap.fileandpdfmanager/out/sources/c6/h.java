package c6;

import c6.e;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h {
    public static b a(int i7, a aVar, int i8) {
        b bVar;
        a aVar2 = a.SUSPEND;
        boolean z6 = false;
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        if ((i8 & 2) != 0) {
            aVar = aVar2;
        }
        if (i7 != -2) {
            if (i7 == -1) {
                if (aVar == aVar2) {
                    z6 = true;
                }
                if (z6) {
                    return new m(1, a.DROP_OLDEST, null);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            } else if (i7 != 0) {
                return i7 != Integer.MAX_VALUE ? aVar == aVar2 ? new b(i7, null) : new m(i7, aVar, null) : new b(SubsamplingScaleImageView.TILE_SIZE_AUTO, null);
            } else {
                bVar = aVar == aVar2 ? new b(0, null) : new m(1, aVar, null);
            }
        } else if (aVar == aVar2) {
            e.f2611b.getClass();
            bVar = new b(e.a.f2613b, null);
        } else {
            bVar = new m(1, aVar, null);
        }
        return bVar;
    }
}
