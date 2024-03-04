package linc.com.amplituda;

/* loaded from: classes.dex */
public class Cache {
    public static final String DEFAULT_KEY = "";
    public static final int NONE = 1;
    public static final int REFRESH = 3;
    public static final int REUSE = 2;
    private final String key;
    private final int state;

    private Cache(int i7, String str) {
        this.state = i7;
        this.key = str;
    }

    public static Cache getDefault() {
        return withParams(1);
    }

    public static Cache withParams(int i7) {
        return withParams(i7, "");
    }

    public static Cache withParams(int i7, String str) {
        return (i7 < 1 || i7 > 3) ? withParams(1) : str == null ? withParams(i7, "") : new Cache(i7, str);
    }

    public String getKey() {
        return this.key;
    }

    public int getState() {
        return this.state;
    }

    public boolean isEnabled() {
        return getState() != 1;
    }
}
