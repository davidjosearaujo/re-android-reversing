package i6;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a */
    public static final Logger f4522a = Logger.getLogger(p.class.getName());

    public static r a(v vVar) {
        if (vVar != null) {
            return new r(vVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static a b(Socket socket) {
        if (socket != null) {
            o oVar = new o(socket);
            OutputStream outputStream = socket.getOutputStream();
            if (outputStream != null) {
                return new a(oVar, new m(outputStream, oVar));
            }
            throw new IllegalArgumentException("out == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static b c(Socket socket) {
        if (socket != null) {
            o oVar = new o(socket);
            InputStream inputStream = socket.getInputStream();
            if (inputStream != null) {
                return new b(oVar, new n(inputStream, oVar));
            }
            throw new IllegalArgumentException("in == null");
        }
        throw new IllegalArgumentException("socket == null");
    }
}
