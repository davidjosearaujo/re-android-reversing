package com.hunantv.oversea.channel.dynamic.data;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;
import java.io.Serializable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelFeedbackEntity extends JsonEntity implements Serializable, JsonInterface {
    private static final long serialVersionUID = -2498712796762225835L;
    public String content;
    public String type;
    public String url;
}
