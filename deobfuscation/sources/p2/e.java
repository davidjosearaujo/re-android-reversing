package p2;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e extends IOException {
    public e(String str, int i7, IOException iOException) {
        super(str + ", status code: " + i7, iOException);
    }
}
