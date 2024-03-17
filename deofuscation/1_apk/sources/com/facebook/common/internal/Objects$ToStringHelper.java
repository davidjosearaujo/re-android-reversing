package com.facebook.common.internal;

import com.alipay.sdk.encrypt.a;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Objects$ToStringHelper {
    private final String className;
    private ValueHolder holderHead;
    private ValueHolder holderTail;
    private boolean omitNullValues;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class ValueHolder {
        @Nullable
        public String name;
        public ValueHolder next;
        @Nullable
        public Object value;

        private ValueHolder() {
        }
    }

    private ValueHolder addHolder() {
        ValueHolder valueHolder = new ValueHolder();
        this.holderTail.next = valueHolder;
        this.holderTail = valueHolder;
        return valueHolder;
    }

    public Objects$ToStringHelper add(String str, @Nullable Object obj) {
        return addHolder(str, obj);
    }

    public Objects$ToStringHelper addValue(@Nullable Object obj) {
        return addHolder(obj);
    }

    public Objects$ToStringHelper omitNullValues() {
        this.omitNullValues = true;
        return this;
    }

    public String toString() {
        boolean z = this.omitNullValues;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        String str = "";
        for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
            if (!z || valueHolder.value != null) {
                sb.append(str);
                String str2 = valueHolder.name;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append(a.h);
                }
                sb.append(valueHolder.value);
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private Objects$ToStringHelper(String str) {
        ValueHolder valueHolder = new ValueHolder();
        this.holderHead = valueHolder;
        this.holderTail = valueHolder;
        this.omitNullValues = false;
        this.className = (String) Preconditions.checkNotNull(str);
    }

    public Objects$ToStringHelper add(String str, boolean z) {
        return addHolder(str, String.valueOf(z));
    }

    public Objects$ToStringHelper addValue(boolean z) {
        return addHolder(String.valueOf(z));
    }

    private Objects$ToStringHelper addHolder(@Nullable Object obj) {
        addHolder().value = obj;
        return this;
    }

    public Objects$ToStringHelper add(String str, char c) {
        return addHolder(str, String.valueOf(c));
    }

    public Objects$ToStringHelper addValue(char c) {
        return addHolder(String.valueOf(c));
    }

    public Objects$ToStringHelper add(String str, double d) {
        return addHolder(str, String.valueOf(d));
    }

    public Objects$ToStringHelper addValue(double d) {
        return addHolder(String.valueOf(d));
    }

    private Objects$ToStringHelper addHolder(String str, @Nullable Object obj) {
        ValueHolder addHolder = addHolder();
        addHolder.value = obj;
        addHolder.name = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public Objects$ToStringHelper add(String str, float f) {
        return addHolder(str, String.valueOf(f));
    }

    public Objects$ToStringHelper addValue(float f) {
        return addHolder(String.valueOf(f));
    }

    public Objects$ToStringHelper add(String str, int i) {
        return addHolder(str, String.valueOf(i));
    }

    public Objects$ToStringHelper addValue(int i) {
        return addHolder(String.valueOf(i));
    }

    public Objects$ToStringHelper add(String str, long j) {
        return addHolder(str, String.valueOf(j));
    }

    public Objects$ToStringHelper addValue(long j) {
        return addHolder(String.valueOf(j));
    }
}
