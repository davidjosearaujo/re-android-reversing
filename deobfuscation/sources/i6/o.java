package i6;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class o extends c {

    /* renamed from: i */
    public final /* synthetic */ Socket f4521i;

    public o(Socket socket) {
        this.f4521i = socket;
    }

    @Override // i6.c
    public final IOException m(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // i6.c
    public final void n() {
        Logger logger;
        Level level;
        StringBuilder sb;
        try {
            this.f4521i.close();
        } catch (AssertionError e) {
            e = e;
            if (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) {
                throw e;
            }
            logger = p.f4522a;
            level = Level.WARNING;
            sb = new StringBuilder();
            sb.append("Failed to close timed out socket ");
            sb.append(this.f4521i);
            logger.log(level, sb.toString(), e);
        } catch (Exception e7) {
            e = e7;
            logger = p.f4522a;
            level = Level.WARNING;
            sb = new StringBuilder();
            sb.append("Failed to close timed out socket ");
            sb.append(this.f4521i);
            logger.log(level, sb.toString(), e);
        }
    }
}
