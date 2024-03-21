package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a1 extends z0 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Intent f247a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ Activity f248b;
    private /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(Intent intent, Activity activity, int i) {
        this.f247a = intent;
        this.f248b = activity;
        this.c = i;
    }

    @Override // com.google.android.gms.common.internal.z0
    public final void b() {
        Intent intent = this.f247a;
        if (intent != null) {
            this.f248b.startActivityForResult(intent, this.c);
        }
    }
}
