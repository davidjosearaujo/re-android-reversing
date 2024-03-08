package a5;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public enum a {
    NO_ERROR(0, -1, 0),
    PROTOCOL_ERROR(1, 1, 1),
    INVALID_STREAM(1, 2, -1),
    /* JADX INFO: Fake field, exist only in values array */
    UNSUPPORTED_VERSION(1, 4, -1),
    STREAM_IN_USE(1, 8, -1),
    /* JADX INFO: Fake field, exist only in values array */
    STREAM_ALREADY_CLOSED(1, 9, -1),
    INTERNAL_ERROR(2, 6, 2),
    FLOW_CONTROL_ERROR(3, 7, -1),
    /* JADX INFO: Fake field, exist only in values array */
    STREAM_CLOSED(5, -1, -1),
    /* JADX INFO: Fake field, exist only in values array */
    FRAME_TOO_LARGE(6, 11, -1),
    REFUSED_STREAM(7, 3, -1),
    CANCEL(8, 5, -1),
    /* JADX INFO: Fake field, exist only in values array */
    COMPRESSION_ERROR(9, -1, -1),
    /* JADX INFO: Fake field, exist only in values array */
    CONNECT_ERROR(10, -1, -1),
    /* JADX INFO: Fake field, exist only in values array */
    ENHANCE_YOUR_CALM(11, -1, -1),
    /* JADX INFO: Fake field, exist only in values array */
    INADEQUATE_SECURITY(12, -1, -1),
    /* JADX INFO: Fake field, exist only in values array */
    HTTP_1_1_REQUIRED(13, -1, -1),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_CREDENTIALS(-1, 10, -1);
    

    /* renamed from: f  reason: collision with root package name */
    public final int f141f;

    /* renamed from: g  reason: collision with root package name */
    public final int f142g;

    /* renamed from: h  reason: collision with root package name */
    public final int f143h;

    a(int i7, int i8, int i9) {
        this.f141f = i7;
        this.f142g = i8;
        this.f143h = i9;
    }
}
