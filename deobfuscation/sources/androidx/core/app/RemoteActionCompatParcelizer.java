package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import m2.a;
import m2.c;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVar = remoteActionCompat.f1459a;
        if (aVar.h(1)) {
            cVar = aVar.l();
        }
        remoteActionCompat.f1459a = (IconCompat) cVar;
        CharSequence charSequence = remoteActionCompat.f1460b;
        if (aVar.h(2)) {
            charSequence = aVar.g();
        }
        remoteActionCompat.f1460b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f1461c;
        if (aVar.h(3)) {
            charSequence2 = aVar.g();
        }
        remoteActionCompat.f1461c = charSequence2;
        Parcelable parcelable = remoteActionCompat.f1462d;
        if (aVar.h(4)) {
            parcelable = aVar.j();
        }
        remoteActionCompat.f1462d = (PendingIntent) parcelable;
        boolean z6 = remoteActionCompat.e;
        if (aVar.h(5)) {
            z6 = aVar.e();
        }
        remoteActionCompat.e = z6;
        boolean z7 = remoteActionCompat.f1463f;
        if (aVar.h(6)) {
            z7 = aVar.e();
        }
        remoteActionCompat.f1463f = z7;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1459a;
        aVar.m(1);
        aVar.t(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1460b;
        aVar.m(2);
        aVar.p(charSequence);
        CharSequence charSequence2 = remoteActionCompat.f1461c;
        aVar.m(3);
        aVar.p(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.f1462d;
        aVar.m(4);
        aVar.r(pendingIntent);
        boolean z6 = remoteActionCompat.e;
        aVar.m(5);
        aVar.n(z6);
        boolean z7 = remoteActionCompat.f1463f;
        aVar.m(6);
        aVar.n(z7);
    }
}
