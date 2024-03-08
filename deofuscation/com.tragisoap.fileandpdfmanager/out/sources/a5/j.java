package a5;

import a5.d;
import androidx.activity.h;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import z4.b;
import z4.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends d {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f190g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ d.e f191h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d.e eVar, Object[] objArr, l lVar) {
        super("OkHttp %s stream %d", objArr);
        this.f191h = eVar;
        this.f190g = lVar;
    }

    @Override // z4.d
    public final void a() {
        try {
            d.AbstractC0004d.a aVar = d.this.f147h;
            l lVar = this.f190g;
            aVar.getClass();
            lVar.c(a.REFUSED_STREAM);
        } catch (IOException e) {
            Logger logger = b.f6934a;
            Level level = Level.INFO;
            StringBuilder d7 = h.d("FramedConnection.Listener failure for ");
            d7.append(d.this.f149j);
            logger.log(level, d7.toString(), (Throwable) e);
            try {
                this.f190g.c(a.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
