package a5;

import a5.d;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class j extends z4.d {

    /* renamed from: g */
    public final /* synthetic */ l f190g;

    /* renamed from: h */
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
            Logger logger = z4.b.f6934a;
            Level level = Level.INFO;
            StringBuilder d7 = androidx.activity.h.d("FramedConnection.Listener failure for ");
            d7.append(d.this.f149j);
            logger.log(level, d7.toString(), (Throwable) e);
            try {
                this.f190g.c(a.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
