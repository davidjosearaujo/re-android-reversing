package com.hunantv.media.player;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvByteBufferPlayerDataSource extends MgtvPlayerDataSource {
    private Map<String, byte[]> mBufferMap = new HashMap();
    private byte[] mM3u8;
    private String mM3u8Path;
    private Map<String, byte[]> mSegments;

    public MgtvByteBufferPlayerDataSource(byte[] bArr) {
        this.mM3u8 = bArr;
        init();
    }

    public MgtvByteBufferPlayerDataSource(byte[] bArr, Map<String, byte[]> map) {
        this.mM3u8 = bArr;
        this.mSegments = map;
        init();
    }

    private void fillMap() {
        this.mBufferMap.put(this.mM3u8Path, this.mM3u8);
        Map<String, byte[]> map = this.mSegments;
        if (map != null) {
            for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                this.mBufferMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void genData() {
        this.mM3u8Path = "iobuff://" + hashCode() + ".m3u8";
    }

    private void init() {
        genData();
        fillMap();
    }

    public Map<String, byte[]> getBufferMap() {
        return this.mBufferMap;
    }

    @Override // com.hunantv.media.player.MgtvPlayerDataSource
    public String getPath() {
        return this.mM3u8Path;
    }
}
