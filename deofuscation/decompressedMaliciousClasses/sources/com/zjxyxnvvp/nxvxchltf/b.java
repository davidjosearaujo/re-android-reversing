package com.zjxyxnvvp.nxvxchltf;

import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f310a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f311b;
    private boolean c;

    public synchronized List<a> a() {
        return this.f311b;
    }

    public synchronized List<c> b() {
        return this.f310a;
    }

    public synchronized boolean c() {
        return this.c;
    }

    public synchronized void d(List<a> list) {
        this.f311b = list;
    }

    public synchronized void e(boolean z) {
        this.c = z;
    }

    public synchronized void f(List<c> list) {
        this.f310a = list;
    }
}
