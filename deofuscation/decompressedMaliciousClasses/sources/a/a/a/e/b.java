package a.a.a.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
@TargetApi(9)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class b {

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class a implements LayoutInflater.Factory {
        private static short[] $ = {21955, 21265};

        /* renamed from: a  reason: collision with root package name */
        final e f109a;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(e eVar) {
            this.f109a = eVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f109a.onCreateView(null, str, context, attributeSet);
        }

        @Override // java.lang.Object
        public String toString() {
            return getClass().getName() + $(0, 1, 21944) + this.f109a + $(1, 2, 21356);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LayoutInflater layoutInflater, e eVar) {
        layoutInflater.setFactory(eVar != null ? new a(eVar) : null);
    }
}
