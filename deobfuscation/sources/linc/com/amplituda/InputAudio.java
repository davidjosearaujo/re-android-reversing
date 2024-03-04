package linc.com.amplituda;

/* loaded from: classes.dex */
public final class InputAudio<T> {
    private long duration;
    private final T source;
    private Type type;

    /* loaded from: classes.dex */
    public enum Type {
        FILE,
        PATH,
        URL,
        RESOURCE,
        INPUT_STREAM,
        BYTE_ARRAY
    }

    public InputAudio(T t5) {
        this.source = t5;
    }

    public InputAudio(T t5, long j5) {
        this.source = t5;
        this.duration = j5;
    }

    public InputAudio(T t5, long j5, Type type) {
        this.source = t5;
        this.type = type;
        this.duration = j5;
    }

    public InputAudio(T t5, Type type) {
        this.source = t5;
        this.type = type;
    }

    public long getDuration() {
        return this.duration;
    }

    public T getSource() {
        return this.source;
    }

    public Type getType() {
        return this.type;
    }

    public void setDuration(long j5) {
        this.duration = j5;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
