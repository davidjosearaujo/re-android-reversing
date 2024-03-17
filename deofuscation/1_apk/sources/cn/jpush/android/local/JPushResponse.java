package cn.jpush.android.local;

import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JPushResponse {
    public ByteBuffer body;
    public int cmd;
    public long rid;
    public long rquestId;

    public JPushResponse(int i, long j, long j2, ByteBuffer byteBuffer) {
        this.cmd = i;
        this.rid = j;
        this.body = byteBuffer;
        this.rquestId = j2;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCmd() {
        return this.cmd;
    }

    public long getRid() {
        return this.rid;
    }

    public long getRquestId() {
        return this.rquestId;
    }

    public void parseBody() {
    }

    public void setBody(ByteBuffer byteBuffer) {
        this.body = byteBuffer;
    }

    public void setCmd(int i) {
        this.cmd = i;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    public void setRquestId(long j) {
        this.rquestId = j;
    }

    public String toString() {
        return "JPushResponse{cmd=" + this.cmd + ", rid=" + this.rid + ", rquestId=" + this.rquestId + '}';
    }
}
