package com.bumptech.glide.load.data;

import com.bumptech.glide.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface d<T> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a<T> {
        void c(Exception exc);

        void d(T t5);
    }

    Class<T> a();

    void b();

    void cancel();

    p2.a e();

    void f(i iVar, a<? super T> aVar);
}
