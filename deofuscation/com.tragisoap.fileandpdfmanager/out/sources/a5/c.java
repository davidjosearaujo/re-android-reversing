package a5;

import i6.d;
import java.io.Closeable;
import java.util.ArrayList;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface c extends Closeable {
    void A(boolean z6, boolean z7, int i7, ArrayList arrayList);

    void H(boolean z6, int i7, d dVar, int i8);

    void I(int i7, a aVar, byte[] bArr);

    void L(int i7, long j7);

    void M(int i7, int i8, boolean z6);

    int O();

    void flush();

    void r(t tVar);

    void v(int i7, a aVar);

    void w(t tVar);

    void y();
}