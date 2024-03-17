package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class FeedListValue implements JsonInterface {
    private static final long serialVersionUID = -7366650428156483915L;
    public List<FeedValue> value;

    public FeedListValue() {
        ArrayList arrayList = new ArrayList();
        this.value = arrayList;
        arrayList.clear();
    }
}
