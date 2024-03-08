package linc.com.amplituda;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class Compress {
    public static final int AVERAGE = 4;
    public static final int NONE = 1;
    public static final int PEEK = 3;
    public static final int SKIP = 2;
    private final int preferredSamplesPerSecond;
    private final int type;

    private Compress(int i7, int i8) {
        this.type = i7;
        this.preferredSamplesPerSecond = i8;
    }

    public static Compress getDefault() {
        return withParams(1, 1);
    }

    public static Compress withParams(int i7, int i8) {
        return (i7 <= 1 || i8 > 0) ? new Compress(i7, i8) : getDefault();
    }

    public int getPreferredSamplesPerSecond() {
        return this.preferredSamplesPerSecond;
    }

    public int getType() {
        return this.type;
    }
}
