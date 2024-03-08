package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1504a;

    public /* synthetic */ a(String str) {
        this.f1504a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f1504a);
        thread.setPriority(10);
        return thread;
    }
}
